package ru.ifmo.ctdev.mazin;

import java.math.*;

public enum OperBigInt implements Operation<BigInteger> {
    PLUS { BigInteger apply(BigInteger x, BigInteger y)
        { return x.add(y); } },
    MINUS { BigInteger apply(BigInteger x, BigInteger y)
        { return x.subtract(y); } },
    TIMES { BigInteger apply(BigInteger x, BigInteger y)
        { return x.multiply(y); } },
    DIVIDE { BigInteger apply(BigInteger x, BigInteger y)
        { return x.divide(y); } }
}
