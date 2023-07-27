package metristics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Metristics extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
	private JButton uploadButton;
    private JButton calculateMinButton;
    private JButton calculateMaxButton;
    private JButton calculateModeButton;
    private JButton calculateMedianButton;
    private JButton calculateMeanButton;
    private JButton calculateMADButton;
    private JButton calculateStdDevButton;

    private JLabel resultLabel;

    private List<Double> data;

    
    // main method to show UI dialog on the screen
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Metristics().setVisible(true));
    }
    
    // create the UI elements/actions for the application
    public Metristics() {
        this.setTitle("METRISTICS");
        this.setSize(400, 200);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        uploadButton = new JButton("Upload CSV");
        calculateMinButton = new JButton("Calculate Minimum");
        calculateMaxButton = new JButton("Calculate Maximum");
        calculateModeButton = new JButton("Calculate Mode");
        calculateMedianButton = new JButton("Calculate Median");
        calculateMeanButton = new JButton("Calculate Mean");
        calculateMADButton = new JButton("Calculate MAD");
        calculateStdDevButton = new JButton("Calculate Standard Deviation");

        uploadButton.addActionListener(this);
        calculateMinButton.addActionListener(this);
        calculateMaxButton.addActionListener(this);
        calculateModeButton.addActionListener(this);
        calculateMedianButton.addActionListener(this);
        calculateMeanButton.addActionListener(this);
        calculateMADButton.addActionListener(this);
        calculateStdDevButton.addActionListener(this);

        resultLabel = new JLabel("Upload a CSV file to start.");

        this.add(uploadButton);
        this.add(calculateMinButton);
        this.add(calculateMaxButton);
        this.add(calculateModeButton);
        this.add(calculateMedianButton);
        this.add(calculateMeanButton);
        this.add(calculateMADButton);
        this.add(calculateStdDevButton);
        this.add(resultLabel);

        data = new ArrayList<>();
    }
    
    // handle all the buttons in the dialog to perform actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uploadButton) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String csvFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                CsvReader reader = new CsvReader(csvFilePath);
                try {
                    data = reader.readDataFromCSV();
                    resultLabel.setText("CSV file uploaded successfully.");
                } catch (IOException ex) {
                    resultLabel.setText("Error reading the CSV file: " + ex.getMessage());
                }
            }
        } else if (!data.isEmpty()) {
            handleActions(e);
        } else {
            displayResult("Please upload a CSV file first.");
        }
    }

    // helper method to handle different statistics calculation
    private void handleActions(ActionEvent e) {
    	if (e.getSource() == calculateMinButton) {
            double minimum = HelperUtils.calculateMinimum(data);
            displayResult("Minimum: " + minimum);
        } else if (e.getSource() == calculateMaxButton) {
            double maximum = HelperUtils.calculateMaximum(data);
            displayResult("Maximum: " + maximum);
        } else if (e.getSource() == calculateModeButton) {
        	ModeCalculator modeCalc = new ModeCalculator();
            double mode = modeCalc.calculateMode(data);
            displayResult("Mode: " + mode);
        } else if (e.getSource() == calculateMedianButton) {
        	MedianCalculator medianCalc = new MedianCalculator();
            double median = medianCalc.calculateMedian(data);
            displayResult("Median: " + median);
        } else {
        	MeanCalculator meanCalc = new MeanCalculator();
        	double mean = meanCalc.calculateMean(data);
        	if (e.getSource() == calculateMeanButton) {
        		displayResult("Mean: " + mean);
        	} else if (e.getSource() == calculateMADButton) {
        		MADCalculator madCalc = new MADCalculator();
        		double mad = madCalc.calculateMeanAbsoluteDeviation(data, mean);
        		displayResult("MAD: " + mad);
        	} else if (e.getSource() == calculateStdDevButton) {
        		StandardDeviationCalculator stdCalc = new StandardDeviationCalculator();
        		double standardDeviation = stdCalc.calculateStandardDeviation(data, mean);
        		displayResult("Standard Deviation: " + standardDeviation);
        	}
        }
    }
    
    // helper method to show the file upload status or calculation result in the dialog
    private void displayResult(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
}