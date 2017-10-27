package IO;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class OutputWriter {
    public static void writeMessage(String message) {
        System.out.print(message);
    }

    public static void writeMessageOnNewLine(String message) {
        System.out.println(message);
    }

    public static void writeEmptyLine() {
        System.out.println();
    }

    public static void writeException(String message) {
        System.err.println(message);
    }

    public static void printStudent(String name, Double grade) {
        String output = String.format("%s - %.6f", name, grade);
        OutputWriter.writeMessageOnNewLine(output);
    }

}
