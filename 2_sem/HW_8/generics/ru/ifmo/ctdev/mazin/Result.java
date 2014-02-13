package ru.ifmo.ctdev.mazin;

public class Result<T> {

    public Evaluable<T> exp;
    public String rest;

    public Result(Evaluable<T> exp, String rest) {
        this.exp = exp;
        this.rest = rest;
    }
}
