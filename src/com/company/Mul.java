package com.company;

public class Mul extends BinaryExpression {

    public Mul(BinaryExpression left, BinaryExpression right, int value) {
        super("*", 3, left, right, left.getValue() * right.getValue());
    }
}
