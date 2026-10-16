package com.goalseek;

public class Main {
    public static void main(String[] args) {
        GoalSeekParams gsParams = new GoalSeekParams();
        gsParams.setFunction(n -> n / 3);
        gsParams.setMin(3.0d);
        gsParams.setMax(5.0d);
        gsParams.setTarget(1.2d);
        gsParams.setTolerance(0.01d);
        gsParams.setMaxIterations(20);

        double result = GoalSeeker.seek(gsParams);
        System.out.println(gsParams.getResult().toString() + " - " + result);
    }
}