package app.engines;

import app.core.BusinessManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import static app.utilities.Constants.INPUT_TERMINATING_COMMAND;

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
        int counter = 0;

        while (true) {
            counter++;
            inputLine = this.inputReader.readLine();
            String[] commandParams = this.inputParser.parseInputAsArray(inputLine);


            this.dispatchCommand(commandParams, counter);
            if (inputLine.equals(INPUT_TERMINATING_COMMAND)) {
                manager.printPopulationCount();
                break;
            }


        }
    }

    private void dispatchCommand(String[] commandParams, int counter) {
        String roomType;
        try {
            roomType = commandParams[0].substring(0, commandParams[0].indexOf("("));
        } catch (StringIndexOutOfBoundsException sioobe) {
            try {
                roomType = commandParams[0] + " " + commandParams[1];
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                roomType = commandParams[0];
            }
        }

        boolean isHomeRegistrationCommand = false;
        if (counter % 3 == 0) {
            if (commandParams[0].equals("EVN bill") || commandParams[0].equals("EVN")) {
                manager.paySalaries();
            } else {
                isHomeRegistrationCommand = true;
            }
        }

        switch (roomType) {
            case "YoungCouple":
                manager.registerYoungCouple(commandParams);
                break;
            case "YoungCoupleWithChildren":
                manager.registerYoungCoupleWithChildren(commandParams);
                break;
            case "AloneYoung":
                manager.registerAloneYoung(commandParams);
                break;
            case "OldCouple":
                manager.registerOldCouple(commandParams);
                break;
            case "AloneOld":
                manager.registerAloneOld(commandParams);
                break;
            case "EVN":
                manager.printTotalConsumption();
                break;
            case "EVN bill":
                manager.payEvnBill();
                break;

        }

        if (isHomeRegistrationCommand) {
            manager.paySalaries();
        }
    }
}
