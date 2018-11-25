package com.company.expression;

public class Sub extends BinaryExpression {

    public Sub(AbstractExpression left, AbstractExpression right) {
        super("-", 1, left, right, left.getValue() - right.getValue());
    }

    @Override
    public boolean isNormalizedSub(AbstractExpression expression) {
        return this.getValue() >= expression.getValue();
    }
}
