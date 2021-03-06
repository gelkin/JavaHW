package ru.ifmo.ctdev.mazin;

public enum OperDouble implements Operation<Double> {
    PLUS { Double apply(Double x, Double y)
        { return x + y; } },
    MINUS { Double apply(Double x, Double y)
        { return x - y; } },
    TIMES { Double apply(Double x, Double y)
        { return x * y; } },
    DIVIDE { Double apply(Double x, Double y)
        { return x / y; } }
}
