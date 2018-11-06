package com.company;

public class Add extends BinaryExpression {

    public Add(BinaryExpression left, BinaryExpression right, int value) {
        super("+", 0, left, right, left.getValue() + right.getValue());
    }

    @Override
    public boolean isNormalizedAdd(BinaryExpression expression) {
        return getLeft().getValue() <= getRight().getValue();
    }
}
