package metristics;

import java.util.List;

class MeanCalculator {

	// utility method to calculate mean
    double calculateMean(List<Double> data) {
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.size();
    }
    
}
