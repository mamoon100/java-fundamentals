package linter;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            int[][] testingWeather = {{66, 64, 58, 65, 71, 57, 60}, {57, 65, 65, 70, 72, 65, 51},
                    {55, 54, 60, 53, 59, 57, 61}, {65, 56, 55, 52, 55, 62, 57}};
            System.out.println(analyzingWeatherData(testingWeather));

            List<String> votes = new ArrayList<>();
            votes.add("Bush");
            votes.add("Bush");
            votes.add("Bush");
            votes.add("Shrub");
            votes.add("Hedge");
            votes.add("Shrub");
            votes.add("Bush");
            votes.add("Hedge");
            votes.add("Bush");
            System.out.println(tally(votes) + " received the most votes!");
            Path filePath = Paths.get("src/main/resources/gates.js");
            String testingString = "Line 3: Missing semicolon.\n" + "Line 5: Missing semicolon.\n"
                    + "Line 11: Missing semicolon.\n" + "Line 13: Missing semicolon.\n"
                    + "Line 15: Missing semicolon.\n" + "Line 26: Missing semicolon.\n"
                    + "Line 28: Missing semicolon.\n" + "Line 32: Missing semicolon.\n"
                    + "Line 36: Missing semicolon.\n" + "Line 40: Missing semicolon.\n"
                    + "Line 41: Missing semicolon.\n" + "Line 42: Missing semicolon.\n"
                    + "Line 50: Missing semicolon.\n" + "Line 51: Missing semicolon.\n"
                    + "Line 53: use double quotation instead of single quotation\n" + "Line 64: Missing semicolon.\n"
                    + "Line 70: Missing semicolon.\n" + "Line 70: use double quotation instead of single quotation\n"
                    + "Line 71: Missing semicolon.\n" + "Line 71: use double quotation instead of single quotation\n"
                    + "Line 72: Missing semicolon.\n" + "Line 72: use double quotation instead of single quotation\n"
                    + "Line 73: Missing semicolon.\n" + "Line 73: use double quotation instead of single quotation\n"
                    + "Line 74: Missing semicolon.\n" + "Line 76: Missing semicolon.\n"
                    + "Line 76: use double quotation instead of single quotation\n" + "Line 77: Missing semicolon.\n"
                    + "Line 77: use double quotation instead of single quotation\n" + "Line 78: Missing semicolon.\n"
                    + "Line 78: use double quotation instead of single quotation\n" + "Line 79: Missing semicolon.\n"
                    + "Line 79: use double quotation instead of single quotation\n" + "Line 80: Missing semicolon.\n"
                    + "Line 82: Missing semicolon.\n" + "Line 82: use double quotation instead of single quotation\n"
                    + "Line 83: Missing semicolon.\n" + "Line 83: use double quotation instead of single quotation\n"
                    + "Line 84: Missing semicolon.\n" + "Line 84: use double quotation instead of single quotation\n"
                    + "Line 85: Missing semicolon.\n" + "Line 85: use double quotation instead of single quotation\n"
                    + "Line 86: Missing semicolon.\n" + "Line 88: Missing semicolon.\n"
                    + "Line 88: use double quotation instead of single quotation\n" + "Line 89: Missing semicolon.\n"
                    + "Line 89: use double quotation instead of single quotation\n" + "Line 90: Missing semicolon.\n"
                    + "Line 90: use double quotation instead of single quotation\n" + "Line 91: Missing semicolon.\n"
                    + "Line 91: use double quotation instead of single quotation\n" + "Line 92: Missing semicolon.\n"
                    + "Line 94: Missing semicolon.\n" + "Line 94: use double quotation instead of single quotation\n"
                    + "Line 95: Missing semicolon.\n" + "Line 95: use double quotation instead of single quotation\n"
                    + "Line 96: Missing semicolon.\n" + "Line 96: use double quotation instead of single quotation\n"
                    + "Line 97: Missing semicolon.\n" + "Line 97: use double quotation instead of single quotation\n"
                    + "Line 98: Missing semicolon.\n" + "Line 98: use double quotation instead of single quotation\n"
                    + "Line 99: Missing semicolon.\n" + "Line 99: use double quotation instead of single quotation\n"
                    + "Line 100: Missing semicolon.\n" + "Line 100: use double quotation instead of single quotation\n"
                    + "Line 101: Missing semicolon.\n" + "Line 101: use double quotation instead of single quotation\n";
            System.out.println(javaScriptLinter(filePath));
            
        } else {
            System.out.println(javaScriptLinter(Path.of(args[0])));
        }

    }

    public static String analyzingWeatherData(int[][] arr) {
        HashSet<Integer> uniqueData = new HashSet<Integer>();
        for (int[] innerArray : arr)
            for (int number : innerArray)
                uniqueData.add(number);
        int max = Collections.max(uniqueData);
        int min = Collections.min(uniqueData);
        String formedString = "High: " + max + "\nLow: " + min;
        for (int i = min + 1; i < max; i++)
            if (!uniqueData.contains(i))
                formedString += "\nNever saw temperature: " + i;
        return (formedString);
    }

    public static String tally(List<String> votes) {
        Map<String, Integer> votesAndName = new HashMap<>();
        int max = 0;
        String maxName = "";
        for (String name : votes) {
            if (votesAndName.containsKey(name))
                votesAndName.put(name, votesAndName.get(name) + 1);
            else
                votesAndName.put(name, 0);
            if (votesAndName.get(name) > max) {
                max = votesAndName.get(name);
                maxName = name;
            }
        }
        return (maxName);
    }

    public static String javaScriptLinter(Path filePath) {
        String error = "";
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String line = br.readLine();
            int numberOfLines = 0;
            while (line != null) {
                numberOfLines++;
                if (( // start of what will give an error if it was shown in the code
                        line.contains("return") || line.contains("=") || line.contains("var") || line.contains("let")
                                || line.contains("const") || line.contains("console")
                        // end of what will give an error if it was shown in the code
                )
                        // start of the exception (what to skip)
                        && !line.contains("//") && !line.contains("if") && !line.contains("else")
                        && !line.contains("for") && !line.contains("function") && !line.contains(";")
                    // end of exception
                ) {
                    // System.out.println(line);
                    error += ("Line " + numberOfLines + ": Missing semicolon.\n");
                }
                if (line.contains("\"")) { // check if the string uses double quotation and not single
                    error += ("Line " + numberOfLines + ": use double quotation instead of single quotation\n");
                }

                line = br.readLine();

            }
            // System.out.println(numberOfLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (error.length() == 0 ? "All Perfect No Error in your js file" : error);
    }

}
