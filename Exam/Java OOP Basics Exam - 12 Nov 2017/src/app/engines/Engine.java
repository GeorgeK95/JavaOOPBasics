package app.engines;

import app.core.HealthManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import java.util.List;

import static app.utilities.Constants.INPUT_TERMINATING_COMMAND;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    HealthManager manager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, HealthManager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.manager = manager;
    }

    public void run() {
        String inputLine;

        while (!(inputLine = this.inputReader.readLine()).equals(INPUT_TERMINATING_COMMAND)) {
            List<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }

    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case "checkCondition":
                String checkConditionResult = this.manager.checkCondition(commandParams.get(0));
                if (checkConditionResult != null)
                    this.outputWriter.writeLine(checkConditionResult);
                break;
            case "createOrganism":
                String createOrganismResult = this.manager.createOrganism(commandParams.get(0));
                if (createOrganismResult != null)
                    this.outputWriter.writeLine(createOrganismResult);
                break;
            case "addCluster":
                String addClusterResult = this.manager.addCluster(commandParams.get(0), commandParams.get(1),
                        Integer.parseInt(commandParams.get(2)), Integer.parseInt(commandParams.get(3)));
                if (addClusterResult != null)
                    this.outputWriter.writeLine(addClusterResult);
                break;
            case "addCell":
                String returnedStr = this.manager.addCell(commandParams.get(0), commandParams.get(1),
                        commandParams.get(2), commandParams.get(3), Integer.parseInt(commandParams.get(4)),
                        Integer.parseInt(commandParams.get(5)), Integer.parseInt(commandParams.get(6)),
                        Integer.parseInt(commandParams.get(7)));
                if (returnedStr != null)
                    this.outputWriter.writeLine(returnedStr);
                break;
            case "activateCluster":
                String activateClusterResult = this.manager.activateCluster(commandParams.get(0));
                if (activateClusterResult != null)
                    this.outputWriter.writeLine(activateClusterResult);
                break;
        }
    }
}
