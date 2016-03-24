package com.julzz.groups.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class defines the problem and could be read or parsed from a file.
 *
 */
public class ProblemDescription {
	
	//! persons in a group for the final result
	protected List<Integer> groupLimits;

	//! all members that exist in the search space
	protected List<Member> members = new ArrayList<>();
	
	//! hard constraint which constellation in one group is not allowed
	protected Set<Set<Member>> notInOneGroup = new HashSet<>();

	//! hard constraint which constellation in one group should always hold
	protected Set<Set<Member>> inOneGroup = new HashSet<>();
	
        
        public ProblemDescription() {
            super();
	}
	
	public ProblemDescription(List<Integer> groupLimits, List<Member> members, Set<Set<Member>> notInOneGroup, Set<Set<Member>> inOneGroup) {
		super();
		this.groupLimits = groupLimits;
		this.members = members;
		this.notInOneGroup = notInOneGroup;
		this.inOneGroup = inOneGroup;
	}

	public Set<Set<Member>> getNotInGroup() {
		return notInOneGroup;
	}
        
        public Set<Set<Member>> getInGroup() {
		return inOneGroup;
	}

	public List<Member> getMembers() {
		return members;
	}

	public int getNumOfPersonsInGroup() {
		return groupLimits.stream().mapToInt(i -> i.intValue()).sum();
	}

	public int numOfMembers() {
		return members.size();
	}
        
        public List<Integer> getGroupLimits() {
            return groupLimits;
        }
	
}
