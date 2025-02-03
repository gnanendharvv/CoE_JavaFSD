import java.io.*;
import java.util.*;

public class LogAnalyzer {
    private List<String> keywords;

    public LogAnalyzer(List<String> keywords) {
        this.keywords = keywords;
    }

    public void processLogFile(String inputFilePath, String outputFilePath) {
        Map<String, Integer> keywordCounts = new HashMap<>();

        for (String keyword : keywords) {
            keywordCounts.put(keyword, 0);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        keywordCounts.put(keyword, keywordCounts.get(keyword) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Integer> entry : keywordCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + " occurrences\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<String> keywords = Arrays.asList("ERROR", "WARNING", "INFO");
        LogAnalyzer analyzer = new LogAnalyzer(keywords);

        String inputFilePath = "input.log";
        String outputFilePath = "output.txt";

        analyzer.processLogFile(inputFilePath, outputFilePath);

        System.out.println("Log file analysis complete. Results saved in " + outputFilePath);
    }
}
