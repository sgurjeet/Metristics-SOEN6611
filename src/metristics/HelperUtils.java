package metristics;

import java.util.List;

class HelperUtils {
	
    // helper utility method to calculate absolute difference between two positive numbers 
    static double getAbsolute(double num1, double num2) {
    	if (num1 - num2 > 0) {
    		return num1 - num2;
    	}
    	return num2 - num1;
    }

    // helper utility method to find square root of a number
    static double findSquareRoot(double number) {
	    double g1;
	    if(number == 0) {
	        return 0;
	    }
	    double squareRoot = number / 2;
	    do {
	        g1 = squareRoot;
	        squareRoot = (g1 + (number / g1)) / 2;
	    } while((g1 - squareRoot)!= 0);

	    return squareRoot;
	}
    
    
    // utility method to calculate minimum number
    static double calculateMinimum(List<Double> data) {
        double min = Double.POSITIVE_INFINITY;
        for (double num : data) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // utility method to calculate maximum number
    static double calculateMaximum(List<Double> data) {
        double max = Double.NEGATIVE_INFINITY;
        for (double num : data) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
