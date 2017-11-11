package app.engines;

import app.core.TheSystem;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import static app.utilities.Constants.INPUT_TERMINATING_COMMAND;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private TheSystem system;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, TheSystem system) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.system = system;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            if (inputLine.equals(INPUT_TERMINATING_COMMAND)) {
                outputWriter.writeLine(this.system.split());
                break;
            }

            String[] commandParams = this.inputParser.parseInputAsArray(inputLine);
            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(String[] commandParams) {
        String command = commandParams[0];
        String name;
        int capacity;
        int memory;
        String hardwareComponentName;

        switch (command) {
            case "RegisterPowerHardware":
                name = commandParams[1];
                capacity = Integer.parseInt(commandParams[2]);
                memory = Integer.parseInt(commandParams[3]);

                this.system.registerPowerHardware(name, capacity, memory);
                break;
            case "RegisterHeavyHardware":
                name = commandParams[1];
                capacity = Integer.parseInt(commandParams[2]);
                memory = Integer.parseInt(commandParams[3]);

                this.system.registerHeavyHardware(name, capacity, memory);
                break;
            case "RegisterExpressSoftware":
                hardwareComponentName = commandParams[1];
                name = commandParams[2];
                capacity = Integer.parseInt(commandParams[3]);
                memory = Integer.parseInt(commandParams[4]);

                this.system.registerExpressSoftware(hardwareComponentName, name, capacity, memory);
                break;
            case "RegisterLightSoftware":
                hardwareComponentName = commandParams[1];
                name = commandParams[2];
                capacity = Integer.parseInt(commandParams[3]);
                memory = Integer.parseInt(commandParams[4]);

                this.system.registerLightSoftware(hardwareComponentName, name, capacity, memory);
                break;
            case "ReleaseSoftwareComponent":
                hardwareComponentName = commandParams[1];
                String softwareComponentName = commandParams[2];

                this.system.releaseSoftwareComponent(hardwareComponentName, softwareComponentName);
                break;
            case "Analyze":
                outputWriter.writeLine(this.system.analyze());
                break;

            case "Dump":
                this.system.dumpSoftware(commandParams[1]);
                break;
            case "Restore":
                this.system.restoreSoftware(commandParams[1]);
                break;
            case "Destroy":
                this.system.destroySoftware(commandParams[1]);
                break;
            case "DumpAnalyze":
                outputWriter.writeLine(this.system.dumpAnalyze());
                break;
        }
    }
}
