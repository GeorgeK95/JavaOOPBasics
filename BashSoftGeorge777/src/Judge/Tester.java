package Judge;

import IO.OutputWriter;
import exceptions.InvalidPathException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Tester {
    public void compareContent(String userOutput, String expectedOutput) {
        try {
            OutputWriter.writeMessageOnNewLine("Reading files...");
            String mismatchFilePath = getMismatchPath(expectedOutput);
            List<String> actualOutputString = readTextFile(userOutput);
            List<String> expectedOutputString = readTextFile(expectedOutput);
            boolean mismatch = compareStrings(actualOutputString, expectedOutputString, mismatchFilePath);
            if (mismatch) {
                List<String> mismatchLines = readTextFile(mismatchFilePath);
                mismatchLines.forEach(OutputWriter::writeMessageOnNewLine);
            } else {
                OutputWriter.writeMessageOnNewLine("No mismatches.");
            }
        } catch (IOException iae) {
            throw new InvalidPathException();
        }
    }

    private String getMismatchPath(String expectedOutput) {
        int lastSlash = expectedOutput.lastIndexOf("\\");
        String folder = expectedOutput.substring(0, lastSlash);
        return folder + "\\mismatch.txt";
    }

    private List<String> readTextFile(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        try (BufferedReader br = new BufferedReader(fileReader)) {
            String line = br.readLine();
            while (!line.equals("")) {
                lines.add(line);
                line = br.readLine();
            }
        }

        return lines;
    }

    private boolean compareStrings(List<String> userOutput, List<String> expectedOutput, String mismatchPath) throws IOException {
        OutputWriter.writeMessageOnNewLine("Comparing files...");
        String output = "";
        boolean isMismatch = false;
        try (FileWriter fileWriter = new FileWriter(mismatchPath); BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < expectedOutput.size(); i++) {
                String userLine = userOutput.get(i);
                String expectedLine = expectedOutput.get(i);
                if (!userLine.equals(expectedLine)) {
                    output = String.format("mismatch -> expected(%s), actual(%s)%n", userLine, expectedLine);
                    isMismatch = true;
                } else {
                    output = String.format("line match -> %s%n", userLine);
                }
                writer.write(output);
            }
        }

        return isMismatch;
    }

    private void writeOutputToFile(String output, String mismatchPath) {
        File f = new File(mismatchPath);

    }
}
