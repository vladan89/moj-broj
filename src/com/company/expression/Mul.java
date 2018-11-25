package com.company.expression;

public class Mul extends BinaryExpression {

    public Mul(AbstractExpression left, AbstractExpression right) {
        super("*", 3, left, right, left.getValue() * right.getValue());
    }

    @Override
    public boolean isNormalizedMul(AbstractExpression expression) {
        return this.getValue() != 1 && expression.getValue() != 1 && this.getValue() <= expression.getValue();
    }
}
