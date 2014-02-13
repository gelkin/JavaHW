package ru.ifmo.ctdev.mazin;

import java.util.HashMap;

public class Const<T> implements Evaluable<T> {
	private T value;
	
	public Const(T value) {
		this.value = value;
	}
	
	public T evaluate(HashMap<String, T> vars) {
		return value;
	}
}
