package com.goalseek;

public class Main {
    public static void main(String[] args) {
        GoalSeekParams gsParams = new GoalSeekParams();

        gsParams.setFunction(n -> Math.pow(n, 2.0) + (2 * n) + 3);
        gsParams.setMin(0.0d);
        gsParams.setMax(1000.0d);
        gsParams.setTarget(40.0d);
        gsParams.setTolerance(0.01d);
        gsParams.setMaxIterations(20);

        double result = GoalSeeker.seek(gsParams);

        System.out.println
        (
            gsParams.getResult().toString() + ": " + 
            result + " in " + 
            gsParams.getActIterations() + " iterations"
        );
    }
}