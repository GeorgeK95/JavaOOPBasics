package app.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = "\\s+";

    public InputParser() {
    }

    public List<String> parseInput(String inputLine) {
        return new ArrayList<>(Arrays.asList(inputLine.split(DELIMITER)));
    }

    public String[] parseInputAsArray(String inputLine) {
        return inputLine.split(DELIMITER);
    }

}
