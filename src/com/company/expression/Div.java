package com.company.expression;

public class Div extends BinaryExpression {

    public Div(AbstractExpression left, AbstractExpression right) {
        super("/", 2, left, right, left.getValue() / right.getValue());
    }

    @Override
    public boolean isNormalizedDiv(AbstractExpression expression) {
        return this.getValue() >= expression.getValue() && expression.getValue() != 0 && expression.getValue() != 1 && this.getValue() % expression.getValue() == 0;
    }
}
