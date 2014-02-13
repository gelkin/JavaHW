package ru.ifmo.ctdev.mazin;

import java.util.Map;

public interface Evaluable<T> {
	public T evaluate(Map<String, T> vars);
}
