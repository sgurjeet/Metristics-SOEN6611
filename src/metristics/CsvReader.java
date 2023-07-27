package metristics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	String path;
	
	public CsvReader(String path) {
		this.path = path;
	}
	
	 // helper method to read and process csv file
    List<Double> readDataFromCSV() throws IOException {
        List<Double> csvData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    try {
                        double num = Double.parseDouble(value);
                        csvData.add(num);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid value: " + value);
                    }
                }
            }
        }

        return csvData;
    }
}
