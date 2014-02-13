package ru.ifmo.ctdev.mazin;

public enum OperInt implements Operation<Integer> {
    PLUS { Integer apply(Integer x, Integer y)
        { return x + y; } },
    MINUS { Integer apply(Integer x, Integer y)
        { return x - y; } },
    TIMES { Integer apply(Integer x, Integer y)
        { return x * y; } },
    DIVIDE { Integer apply(Integer x, Integer y)
        { return x / y; } }
}
