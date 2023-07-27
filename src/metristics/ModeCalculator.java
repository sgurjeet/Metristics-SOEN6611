package metristics;

import java.util.List;

class ModeCalculator {


    // utility method to calculate mode
    double calculateMode(List<Double> data) {
        double mode = data.get(0);
        int maxFrequency = 1;

        for (int i = 0; i < data.size(); i++) {
            double currentNumber = data.get(i);
            int currentFrequency = 1;

            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j) == currentNumber) {
                    currentFrequency++;
                }
            }

            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                mode = currentNumber;
            }
        }

        return mode;
    }
    
}
