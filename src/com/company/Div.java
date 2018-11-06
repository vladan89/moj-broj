package com.company;

public class Div extends BinaryExpression {

    public Div(BinaryExpression left, BinaryExpression right, int value) {
        super("/", 2, left, right, left.getValue() / right.getValue());
    }
}
