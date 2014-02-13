package ru.ifmo.ctdev.mazin;

import java.util.HashMap;

public interface Evaluable<T> {
	public T evaluate(HashMap<String, T> vars);
}
