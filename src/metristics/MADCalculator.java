package metristics;

import java.util.List;

class MADCalculator {


    // utility method to calculate mean absolute deviation(MAD)
    double calculateMeanAbsoluteDeviation(List<Double> data, double mean) {
        double madSum = 0;
        for (double num : data) {
            madSum += HelperUtils.getAbsolute(num, mean);
        }
        return madSum / data.size();
    }
    
}
