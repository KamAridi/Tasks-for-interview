import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> mapResult = readAndMatch(4, 3);
        System.out.println(mapResult);
        newReadAndMatch(4,3);
    }

    private static void newReadAndMatch(int i, int i1) throws IOException {
        Map<String, String> resultMap = new HashMap<>();

        try (Scanner input = new Scanner(Path.of("resources", "input.txt"));
        Scanner output = new Scanner(Path.of("resources", "output.txt"))) {
            String line = input.nextLine();
            resultMap.put(line, null);

        }
    }


    private static Map<String, String> readAndMatch(int val, int val2) throws IOException {
        List<String> firstFileText = new ArrayList<>();
        List<String> secondFileText = new ArrayList<>();
        Map<String, String> mapResult = new HashMap<>();

        File fileInput = Path.of("resources", "input.txt").toFile();
        File fileOutput = Path.of("resources", "output.txt").toFile();

        try (BufferedReader brInput = new BufferedReader(new FileReader(fileInput));
             BufferedReader brOutput = new BufferedReader(new FileReader(fileOutput))) {
            for (int i = 0; i < val; i++) {
                firstFileText.add(brInput.readLine());
            }
            for (int i = 0; i < val2; i++) {
                secondFileText.add(brOutput.readLine());
            }
        }

        for (String lineOfFirst : firstFileText) {
            mapResult.put(lineOfFirst, null);
            String[] lineOfStrings = lineOfFirst.split(" ");
            for (String subStr : lineOfStrings) {
                for (String lineOfSecond : secondFileText) {
                    if (lineOfSecond.contains(subStr)) {
                        mapResult.put(lineOfFirst, lineOfSecond);
                    }
                }
                if (mapResult.get(lineOfFirst) == null) {
                    mapResult.put(lineOfFirst, "?");
                }
            }
        } return mapResult;
    }
}
