package app.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    public InputParser() {
    }

    public String[] parseInputAsArray(String inputLine) {
        inputLine = inputLine.replaceAll(", ", ",");
        return inputLine.split("\\s+");
    }

    public List<String> parseInput(String inputLine) {
        return new ArrayList<>(Arrays.asList(inputLine.split("\\s+")));
    }
}
