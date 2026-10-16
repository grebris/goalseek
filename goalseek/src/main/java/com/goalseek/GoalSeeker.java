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

        // Set the initial values
        double x0 = _gsParams.getMin();
        double x1 = _gsParams.getMax();

        // Calculate the initial output and error
        double y0 = _gsParams.getFunction().applyAsDouble(x0);
        double e0 = y0 - _gsParams.getTarget();

        for(int i = 0; i < _gsParams.getMaxIterations(); i++) {
            double y1 = _gsParams.getFunction().applyAsDouble(x1);
            double e1 = y1 - _gsParams.getTarget();

            // Exit if the current guess is accurate enough
            if(Math.abs(e1) < _gsParams.getTolerance()) {
                _gsParams.setResult(GoalSeekResult.SUCCESS);
                return x1;
            }

            // Prevent division by zero
            if(Double.compare(e0, e1) == 0)
                break;

            // Calculate the next guess (secant formula)
            double xn = x1 - (e1 * (x1 - x0)) / (e1 - e0);

            // Update values for the next iteration
            x0 = x1;
            x1 = xn;                
            e0 = e1;
        }

        // Maximum iterations was reached without finding a solution
        _gsParams.setResult(GoalSeekResult.MAX_ITERATIONS);
        return 0.0d;
    }
}
