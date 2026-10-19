package com.goalseek;

import java.util.function.DoubleUnaryOperator;

public class GoalSeekParams {
    private GoalSeekResult result;    
    private DoubleUnaryOperator function;

    private double min;
    private double max;

    private double target;
    private double tolerance;

    private int maxIterations;
    private int actIterations;

    public void setResult(GoalSeekResult _result) { result = _result; }
    public GoalSeekResult getResult() {return result; }

    public void setFunction(DoubleUnaryOperator _function) { function = _function; }
    public DoubleUnaryOperator getFunction() { return function; }

    public void setMin(double _min) { min = _min; }
    public double getMin() { return min; }

    public void setMax(double _max) { max = _max; }
    public double getMax() { return max; }

    public void setTarget(double _target) { target = _target; }
    public double getTarget() { return target; }

    public void setTolerance(double _tolerance) { tolerance = _tolerance; }
    public double getTolerance() { return tolerance; }

    public void setMaxIterations(int _maxIterations) { maxIterations = _maxIterations; }
    public int getMaxIterations() { return maxIterations; }

    public void setActIterations(int _actIterations) { actIterations = _actIterations; }
    public int getActIterations() { return actIterations; }
    
    public GoalSeekParams() {}

    public GoalSeekParams
    (
        DoubleUnaryOperator _function,
        double _min,
        double _max,
        double _target,
        double _tolerance,
        int _maxIterations
    ) {
        function = _function;
        min = _min;
        max = _max;
        target = _target;
        tolerance = _tolerance;
        maxIterations = _maxIterations;
    }

    public GoalSeekParams
    (
        DoubleUnaryOperator _function,
        double _min,
        double _max,
        double _target
    ) {
        this
        (
            _function, 
            _min, 
            _max, 
            _target, 
            0.01d, 
            1000
        );
    }

    public GoalSeekParams
    (
        DoubleUnaryOperator _function,
        double _min,
        double _max,
        double _target,
        double _tolerance
    ) {
        this
        (
            _function, 
            _min, 
            _max, 
            _target, 
            _tolerance, 
            1000
        );
    }    
}
