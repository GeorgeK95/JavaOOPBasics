package app.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public InputParser() {
    }

    private List<String> parseInput(String inputLine) {
        return new ArrayList<>(Arrays.asList(inputLine.split("\\s+")));
    }

    private List<String> getInputAsArray(String inputLine) {
        String command = inputLine.substring(0, inputLine.indexOf("("));
        List<String> params = Arrays.stream(inputLine.substring(inputLine.indexOf("(") + 1, inputLine.lastIndexOf(")")).split(", ")).collect(Collectors.toList());
        params.add(0, command);
        return params;
    }

    public String[] parseInputAsArray(String inputLine) {
        return this.getInputAsArray(inputLine).toArray(new String[0]);
    }
}
