package ru.ifmo.ctdev.mazin;

public class Result {

    public Evaluable exp;
    public String rest;

    public Result(Evaluable exp, String rest) {
        this.exp = exp;
        this.rest = rest;
    }
}
