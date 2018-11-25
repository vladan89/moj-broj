package com.company;

import com.company.exception.BaseException;
import com.company.expression.AbstractExpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyNumberMain {

    public static final int TOTAL_ARGS = 7;
    public static final int TARGET_INDEX = 0;

    public static void main (String[] args) throws BaseException {

        if (args.length != TOTAL_ARGS) {
            throw new BaseException("There are insufficient arguments, should be 7!");
        }

        try {
            int target = Integer.parseInt(args[TARGET_INDEX]);

            List<Integer> numbers= Arrays.asList(args).subList(1, TOTAL_ARGS).stream().map(num-> Integer.parseInt(num)).collect(Collectors.toList());
            ProblemSolver solver = new ProblemSolver();
            List<AbstractExpression> result = solver.findExpressions(target, numbers);

            System.out.println("Result has " + result.size() + " records");

        } catch (NumberFormatException e) {
            throw new BaseException("Target result not well defined! It should be a positive whole number.");
        }



    }

}
