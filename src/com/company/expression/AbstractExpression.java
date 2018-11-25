package com.company.expression;

public abstract class AbstractExpression {

    private String id;
    private String op;
    private int precedence = 0;
    private int used;
    private int value;

    public AbstractExpression(String op, int precedence, int value) {
        this.op = op;
        this.precedence = precedence;
        this.value = value;
    }

    public String toStringUnder(AbstractExpression expression) {
        if (expression.precedence > this.precedence)
            return "(" + this.toString() + ")";
        else
            return this.toString();
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public boolean isNormalizedAdd(AbstractExpression expression) {
        return false;
    }
    public boolean isNormalizedSub(AbstractExpression expression) {
        return false;
    }
    public boolean isNormalizedMul(AbstractExpression expression) {
        return false;
    }
    public boolean isNormalizedDiv(AbstractExpression expression) {
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
