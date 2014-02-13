package ru.ifmo.ctdev.mazin;

import java.util.List;

public interface Evaluable {
	public int evaluate(List<Evaluable> elements, List<Integer> result) throws NumException;
}
