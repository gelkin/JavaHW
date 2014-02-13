package ru.ifmo.ctdev.mazin;

import java.util.Map;

public interface Evaluable {
	public int evaluate(Map<String, Integer> vars) throws NumException;
}
