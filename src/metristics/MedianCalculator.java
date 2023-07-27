package metristics;

import java.util.List;

class MedianCalculator {

    // utility method to calculate median
    double calculateMedian(List<Double> data) {
        int n = data.size();
        data.sort(null);

        if (n % 2 == 0) {
            int mid = n / 2;
            return (data.get(mid - 1) + data.get(mid)) / 2.0;
        } else {
            return data.get(n / 2);
        }
    }
}
