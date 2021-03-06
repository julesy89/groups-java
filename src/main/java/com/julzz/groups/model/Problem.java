package com.julzz.groups.model;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.julzz.groups.evaluator.PreferenceEvaluator;
import com.julzz.groups.evaluator.RejectionEvaluator;
import com.julzz.groups.evolutionary.GroupVariable;
import com.msu.moo.model.ASingleObjectiveProblem;

public class Problem extends ASingleObjectiveProblem<GroupVariable> {

	// ! object that contains all the preferences, rejections and constrains
	protected ProblemDescription desc;

	public Problem(ProblemDescription desc) {
		super();
		this.desc = desc;
	}

	
	@Override
	public int getNumberOfConstraints() {
		return 1;
	}


	@Override
	protected void evaluate_(GroupVariable var, List<Double> objectives, List<Double> constraintViolations) {


		// all subgroups created from the decoded List
		Set<Set<Member>> subgroups = var.decode();

		// check for hard constraints
		int violatedIsInGroup = desc.inOneGroup.size() - calcPresentSubsetGroups(subgroups, desc.inOneGroup);
		int violatedNotInGroup = calcPresentSubsetGroups(subgroups, desc.notInOneGroup);
		constraintViolations.add((double) violatedIsInGroup + violatedNotInGroup);
		
		// calculate preferences and rejections satisfaction of each member
		Map<Member, Double> prefs = new PreferenceEvaluator().evaluate(var, desc);
		Map<Member, Double> rejs = new RejectionEvaluator().evaluate(var, desc);

		// calculate the individual satisfaction of each member
		DoubleSummaryStatistics statistics = new DoubleSummaryStatistics();
		for (Member m : desc.getMembers()) {
			double satisfaction = 2 * prefs.get(m) + rejs.get(m);
			statistics.accept(satisfaction);		
		}
		
		//objectives.add(-statistics.getAverage());
		objectives.add(-statistics.getSum());
		//objectives.add(-statistics.getMin());
		
	}
	

	public static int calcPresentSubsetGroups(Collection<Set<Member>> subgroups, Set<Set<Member>> subset) {
		int counter = 0;
		for (Set<Member> subsetGroup : subset) {
			boolean isPresent = false;
			for (Set<Member> group : subgroups) {
				if (group.containsAll(subsetGroup)) {
					isPresent = true;
					break;
				}
			}
			if (isPresent)
				counter++;
		}
		return counter;
	}

	
	
	public ProblemDescription getDescription() {
		return desc;
	}


}
