package metristics;

import java.util.List;

class StandardDeviationCalculator {

    // utility method to calculate standard deviation
    double calculateStandardDeviation(List<Double> data, double mean) {
        double sumOfSquaredDifferences = 0;
        for (double num : data) {
            sumOfSquaredDifferences += (num - mean) * (num - mean);
        }
        return HelperUtils.findSquareRoot(sumOfSquaredDifferences / data.size());
    }
    
}
