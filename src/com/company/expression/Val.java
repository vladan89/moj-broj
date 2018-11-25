package com.company.expression;

public class Val extends AbstractExpression {

    public Val(int index, int value) {
        super("$", 4, value);
        this.setUsed(1<<index);
    }

    @Override
    public String getId() {
        return Integer.valueOf(getValue()).toString();
    }

    @Override
    public boolean isNormalizedAdd(AbstractExpression expression) {
        return this.getValue() <= expression.getValue();
    }

    @Override
    public boolean isNormalizedSub(AbstractExpression expression) {
        return this.getValue() >= expression.getValue();
    }

    @Override
    public boolean isNormalizedMul(AbstractExpression expression) {
        return this.getValue() != 1 && expression.getValue() != 1 && this.getValue() <= expression.getValue();
    }

    @Override
    public boolean isNormalizedDiv(AbstractExpression expression) {
        return this.getValue() >= expression.getValue() && expression.getValue() != 0 && expression.getValue() != 1 && this.getValue() % expression.getValue() == 0;
    }

}
