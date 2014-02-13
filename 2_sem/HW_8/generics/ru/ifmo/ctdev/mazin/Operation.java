package ru.ifmo.ctdev.mazin;

public interface Operation<T> {
	T apply(T x, T y);
}
