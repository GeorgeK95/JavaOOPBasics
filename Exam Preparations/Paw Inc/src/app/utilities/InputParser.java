package app.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String DELIMITER = " | ";

    public InputParser() {
    }

    public List<String> parseInput(String inputLine) {
        return new ArrayList<>(Arrays.stream(inputLine.split(DELIMITER)).filter(x -> !x.equals("|"))
                .collect(Collectors.toList()));
    }

}
