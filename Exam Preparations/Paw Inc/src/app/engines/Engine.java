package app.engines;

import app.core.AnimalCenterManager;
import app.io.ConsoleInputReader;
import app.utilities.InputParser;

import java.util.List;

import static app.utilities.Constants.INPUT_TERMINATING_COMMAND;

public class Engine {
    private ConsoleInputReader inputReader;
    private InputParser inputParser;
    private AnimalCenterManager manager;

    public Engine(ConsoleInputReader inputReader, InputParser inputParser, AnimalCenterManager manager) {
        this.inputReader = inputReader;
        this.inputParser = inputParser;
        this.manager = manager;
    }

    public void run() {
        String inputLine;

        while (!(inputLine = this.inputReader.readLine()).equals(INPUT_TERMINATING_COMMAND)) {
            List<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }

        this.manager.printStatistics();
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case "RegisterCleansingCenter":
                this.manager.registerCleansingCenter(commandParams.get(0));
                break;
            case "RegisterAdoptionCenter":
                this.manager.registerAdoptionCenter(commandParams.get(0));
                break;
            case "RegisterDog":
                this.manager.registerDog(commandParams.get(0), Integer.parseInt(commandParams.get(1)),
                        Integer.parseInt(commandParams.get(2)), commandParams.get(3));
                break;
            case "RegisterCat":
                this.manager.registerCat(commandParams.get(0), Integer.parseInt(commandParams.get(1)),
                        Integer.parseInt(commandParams.get(2)), commandParams.get(3));
                break;
            case "SendForCleansing":
                this.manager.sendForCleansing(commandParams.get(0), commandParams.get(1));
                break;
            case "Cleanse":
                this.manager.cleanse(commandParams.get(0));
                break;
            case "Adopt":
                this.manager.adopt(commandParams.get(0));
                break;
            //castration
            case "RegisterCastrationCenter":
                this.manager.registerCastrationCenter(commandParams.get(0));
                break;
            case "SendForCastration":
                this.manager.sendForCastration(commandParams.get(0), commandParams.get(1));
                break;
            case "Castrate":
                this.manager.castrate(commandParams.get(0));
                break;
            case "CastrationStatistics":
                this.manager.castrationStatistics();
                break;
        }
    }
}
