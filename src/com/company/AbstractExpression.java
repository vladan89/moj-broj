package com.company;

public abstract class AbstractExpression {

    private int precedence = 0;

    public String toStringUnder(AbstractExpression expression) {
        if (expression.precedence > this.precedence)
            return "(" + this.toString() + ")";
        else
            return this.toString();
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }
}
