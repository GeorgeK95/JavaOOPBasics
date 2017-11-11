package app;

import app.core.TheSystem;
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
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        TheSystem system = new TheSystem();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, system);

        //task_2 16/20
        engine.run();
    }
}
