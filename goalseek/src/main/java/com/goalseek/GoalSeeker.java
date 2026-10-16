package com.goalseek;

public class GoalSeeker {
    public static double seek(GoalSeekParams _gsParams) {
        // Check for a null function
        if(_gsParams.getFunction() == null) {
            _gsParams.setResult(GoalSeekResult.NULL_FUNCTION);
            return 0.0d;
        }

        // Ensure minimum initial value is less than maximum
        if(_gsParams.getMax() <= _gsParams.getMin()) {
            _gsParams.setResult(GoalSeekResult.BOUNDARY_ERROR);
            return 0.0d;
        }

        double x0 = _gsParams.getMin();
        double x1 = _gsParams.getMax();
        double target = _gsParams.getTarget();
        double tolerance = _gsParams.getTolerance();

        int maxIterations = _gsParams.getMaxIterations();

        for(int i = 0; i < maxIterations; i++) {
            double mid = (x0 + x1) / 2.0d;
            double result = _gsParams.getFunction().applyAsDouble(mid);

            // Check if current result is close enough to the target
            if(Math.abs(result - target) <= tolerance) {
                _gsParams.setResult(GoalSeekResult.SUCCESS);
                _gsParams.setActIterations(i);

                return mid;
            }

            // Adjust the boundary values
            if(_gsParams.getFunction().applyAsDouble(x0) < target) {
                if(result < target)
                    x0 = mid;
                else
                    x1 = mid;
            }
            else {
                if(result > target)
                    x0 = mid;
                else
                    x1 = mid;
            }
        }

        // Maximum iterations was reached without finding a solution
        _gsParams.setResult(GoalSeekResult.MAX_ITERATIONS);
        return 0.0d;
    }
}
