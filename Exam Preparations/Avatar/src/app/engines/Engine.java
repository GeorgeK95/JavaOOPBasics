package app.engines;

import app.core.BusinessManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import static app.utilities.Constants.*;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private BusinessManager manager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, BusinessManager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.manager = manager;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            String[] commandParams = this.inputParser.parseInputAsArray(inputLine);

            this.dispatchCommand(commandParams);
            if (inputLine.equals(INPUT_TERMINATING_COMMAND)) {
                this.manager.printIssuedWars();
                break;
            }
        }
    }

    private void dispatchCommand(String[] commandParams) {
        String command = commandParams[0];
        String type;
        String name;
        String nation;

        switch (command) {
            case BENDER_COMMAND:
                type = commandParams[1];
                name = commandParams[2];
                int power = Integer.parseInt(commandParams[3]);
                double parameter = Double.parseDouble(commandParams[4]);

                manager.createBender(type, name, power, parameter);
                break;
            case MONUMENT_COMMAND:
                type = commandParams[1];
                name = commandParams[2];
                int affinity = Integer.parseInt(commandParams[3]);

                manager.createMonument(type, name, affinity);
                break;
            case STATUS_COMMAND:
                nation = commandParams[1];

                manager.printStatus(nation);
                break;
            case WAR_COMMAND:
                nation = commandParams[1];

                manager.startWar(nation);
                break;
        }
    }
}
