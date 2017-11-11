package app.engines;

import app.core.CarManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import java.util.List;

import static app.utilities.Constants.INPUT_TERMINATING_COMMAND;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CarManager manager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, CarManager carManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.manager = carManager;
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
            case "register":
                int id = Integer.parseInt(commandParams.get(0));
                String type = commandParams.get(1);
                String brand = commandParams.get(2);
                String model = commandParams.get(3);
                int year = Integer.parseInt(commandParams.get(4));
                int hp = Integer.parseInt(commandParams.get(5));
                int acc = Integer.parseInt(commandParams.get(6));
                int susp = Integer.parseInt(commandParams.get(7));
                int dur = Integer.parseInt(commandParams.get(8));

                this.manager.register(id, type, brand, model, year, hp, acc, susp, dur);
                break;
            case "check":
                id = Integer.parseInt(commandParams.get(0));

                this.outputWriter.writeLine(this.manager.check(id));
                break;
            case "open":
                id = Integer.parseInt(commandParams.get(0));
                type = commandParams.get(1);
                int length = Integer.parseInt(commandParams.get(2));
                String route = commandParams.get(3);
                int prizePool = Integer.parseInt(commandParams.get(4));
                try {
                    int bonusParam = Integer.parseInt(commandParams.get(5));
                    this.manager.open(id, type, length, route, prizePool,bonusParam);
                } catch (IndexOutOfBoundsException ioobe) {
                    this.manager.open(id, type, length, route, prizePool);
                }

                break;
            case "participate":
                int carId = Integer.parseInt(commandParams.get(0));
                int raceId = Integer.parseInt(commandParams.get(1));

                this.manager.participate(carId, raceId);
                break;
            case "start":
                int startRaceId = Integer.parseInt(commandParams.get(0));

                this.outputWriter.writeLine(this.manager.start(startRaceId));
                break;
            case "park":
                int parkCarId = Integer.parseInt(commandParams.get(0));

                this.manager.park(parkCarId);
                break;
            case "unpark":
                int unparkCarId = Integer.parseInt(commandParams.get(0));

                this.manager.unpark(unparkCarId);
                break;
            case "tune":
                int tuneIndex = Integer.parseInt(commandParams.get(0));
                String tuneAddOn = commandParams.get(1);

                this.manager.tune(tuneIndex, tuneAddOn);
                break;
        }
    }
}
