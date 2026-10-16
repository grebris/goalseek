package com.goalseek;

public class Main {
    public static void main(String[] args) {
        GoalSeekParams gsParams = new GoalSeekParams();
        
        gsParams.setFunction(n -> 5 / n);
        gsParams.setMin(0.0d);
        gsParams.setMax(120.0d);
        gsParams.setTarget(0.75d);
        gsParams.setTolerance(0.001d);
        gsParams.setMaxIterations(20);

        double result = GoalSeeker.seek(gsParams);
        System.out.println(gsParams.getResult().toString() + " : " + result);
    }
}