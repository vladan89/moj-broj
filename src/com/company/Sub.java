package com.company;

public class Sub extends BinaryExpression {

    public Sub(BinaryExpression left, BinaryExpression right, int value) {
        super("-", 1, left, right, left.getValue() - right.getValue());
    }
}
