package com.company;

import com.company.expression.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemSolver {

    private static final int FULL_USAGE = ~(~0 << MyNumberMain.TOTAL_ARGS);

    public List<AbstractExpression> findExpressions(Integer target, List<Integer> numbers) {
        List<AbstractExpression> result =  new ArrayList<>();
        List<AbstractExpression> expressions = new ArrayList<>();
        List<AbstractExpression> initialExpressions = numbers.stream().map(x -> new Val(numbers.indexOf(x), x)).collect(Collectors.toList());

        checkForAnyMatch(expressions, initialExpressions, target, result);

        int lower = 0;
        int upper = numbers.size();
        while (lower < upper) {

            for (int b = lower; b < upper; b++) {
                AbstractExpression bExpr = expressions.get(b);
                for( int a = 0; a < b; a++) {
                    AbstractExpression aExpr = expressions.get(a);

                    if ((aExpr.getUsed() & bExpr.getUsed()) == 0) {
                        List<AbstractExpression> newExpressions = composeNormalizedExpressions(aExpr, bExpr);
                        checkForAnyMatch(expressions, newExpressions, target, result);
                        expressions.addAll(newExpressions);
                    }
                }
            }
            lower = upper;
            upper = expressions.size();
        }
        return result;
    }

    private void checkForAnyMatch(List<AbstractExpression> expressions, List<AbstractExpression> expressionsForCheck, Integer target, List<AbstractExpression> result) {
        expressionsForCheck.stream().forEach( expression -> {
            if(expression.getValue() == target) {
                result.add(expression);
            } else if(expression.getUsed() != FULL_USAGE) {
                expressions.add(expression);
            }
        });
    }

    private List<AbstractExpression> composeNormalizedExpressions(AbstractExpression a, AbstractExpression b) {

        List<AbstractExpression> newExpressions = new ArrayList<>();

        if(a.isNormalizedAdd(b))
            newExpressions.add(new Add(a,b));
        else if (b.isNormalizedAdd(a))
            newExpressions.add(new Add(b,a));

        if (a.isNormalizedSub(b))
            newExpressions.add(new Sub(a,b));
        else if (b.isNormalizedSub(a))
            newExpressions.add(new Sub(b,a));

        if (a.isNormalizedMul(b))
            newExpressions.add(new Mul(a,b));
        else if (b.isNormalizedMul(a))
            newExpressions.add(new Mul(b,a));

        if (a.isNormalizedDiv(b))
            newExpressions.add(new Div(a,b));
        else if (b.isNormalizedDiv(a))
            newExpressions.add(new Div(b,a));

        return newExpressions;
    }
}
