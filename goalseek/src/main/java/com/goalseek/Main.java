package com.goalseek;

public class Main {
    public static void main(String[] args) {
        GoalSeekParams gsParams = 
            new GoalSeekParams
            (
                n -> Math.pow(n, 2.0) + (2 * n) + 3,
                0.0d,
                1000.0d,
                40.0d
            );

        double result = GoalSeeker.seek(gsParams);

        System.out.println
        (
            gsParams.getResult().toString() + ": " + 
            result + " in " + 
            gsParams.getActIterations() + " iterations"
        );
    }
}