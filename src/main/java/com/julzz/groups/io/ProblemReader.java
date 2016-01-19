package com.julzz.groups.io;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.julzz.groups.model.Problem;
import com.msu.moo.util.io.AReader;

public class ProblemReader extends AReader<Problem> {

	@Override
	protected Problem read_(String path) throws IOException{
		ProblemBuilder b = null;
		try {
			BufferedReader br = createBufferedReader(path);
			Gson gson = new Gson();
			b = gson.fromJson(br, ProblemBuilder.class);
			br.close();
			
		} catch (JsonSyntaxException e) {
			System.err.println("Input file contains errors and could not be read!");
			return null;
		}
		return b.build();
	}

}
