package IO;

import StaticData.SessionData;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InputReader {
    private static final String END_COMMAND = "quit";

    private CommandInterpreter commandInterpreter;

    public InputReader(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    public void readCommands() throws IOException, InterruptedException {
        OutputWriter.writeMessageOnNewLine(SessionData.currentPath + " >");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();
        while (!line.equals(END_COMMAND)) {
            commandInterpreter.interpretCommand(line);
            OutputWriter.writeMessageOnNewLine(SessionData.currentPath + " >");
            line = in.nextLine().trim();
        }

        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for (Thread thread : threads) {
            if (!thread.getName().equals("main") && thread.isDaemon()) {
                thread.join();
            }
        }
    }

}
