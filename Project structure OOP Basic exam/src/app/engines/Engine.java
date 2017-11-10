package app.engines;

import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.Constants;
import app.utilities.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
    }

    public void run() {
        String inputLine;

        while(!(inputLine = this.inputReader.readLine()).equals(Constants.INPUT_TERMINATING_COMMAND)) {
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch(command) {

        }
    }
}
