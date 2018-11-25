package com.company.expression;

public abstract class BinaryExpression extends AbstractExpression {

    private AbstractExpression left;
    private AbstractExpression right;

    public BinaryExpression(String op, int precedence, AbstractExpression left, AbstractExpression right, int value) {
        super(op, precedence, value);
        this.left = left;
        this.right = right;
        setUsed(this.left.getUsed() | this.right.getUsed());
        setId(this.toId());
    }

    @Override
    public String toString() {
        return left.toStringUnder(this) + " " + right.toStringUnder(this);
    }

    public  String toId() {
        return "(" + left.getId() + getOp() + right.getId() + ")";
    }

    public AbstractExpression getLeft() {
        return left;
    }

    public AbstractExpression getRight() {
        return right;
    }
}
