package com.company;

public abstract class BinaryExpression extends AbstractExpression {

    private String op;
    private String id;
    private BinaryExpression left;
    private BinaryExpression right;
    private int value;
    private boolean used;

    public BinaryExpression(String op, int precedence, BinaryExpression left, BinaryExpression right, int value) {
        this.op = op;
        setPrecedence(precedence);
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public String toString() {
        return left.toStringUnder(this) + " " + right.toStringUnder(this);
    }

    public  String toId() {
        return "(" + left.toId() + op + right.toId() + ")";
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryExpression getLeft() {
        return left;
    }

    public BinaryExpression getRight() {
        return right;
    }

    public boolean isNormalizedAdd(BinaryExpression expression) {
        return false;
    }
    public boolean isNormalizedSub(BinaryExpression expression) {
        return false;
    }
    public boolean isNormalizedMul(BinaryExpression expression) {
        return false;
    }
    public boolean isNormalizedDiv(BinaryExpression expression) {
        return false;
    }
}
