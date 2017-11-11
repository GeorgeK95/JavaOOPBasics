package app;

import app.core.AnimalCenterManager;
import app.engines.Engine;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        InputParser inputParser = new InputParser();
        AnimalCenterManager manager = new AnimalCenterManager();
        Engine engine = new Engine(inputReader/*, outputWriter*/, inputParser, manager);

        engine.run();
    }
}
