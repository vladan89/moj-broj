package com.company.expression;

public class Add extends BinaryExpression {

    public Add(AbstractExpression left, AbstractExpression right) {
        super("+", 0, left, right, left.getValue() + right.getValue());
    }

    @Override
    public boolean isNormalizedAdd(AbstractExpression expression) {
        return this.getValue() <= expression.getValue();
    }
}
