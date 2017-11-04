package IO.commands;

import IO.IOManager;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;
import exceptions.InvalidInputException;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class PrintOrderedStudentsCommand extends Command {

    public PrintOrderedStudentsCommand(String line, String[] data, IOManager ioManager, Tester tester, DownloadManager downloadManager, StudentsRepository studentsRepository) {
        super(line, data, ioManager, tester, downloadManager, studentsRepository);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 3 && data.length != 4) {
            throw new InvalidInputException(this.getLine());
        }
        if (data.length == 3) {
            this.getStudentsRepository().orderAndTake(data[1], data[2]);
        }
        if (data.length == 4) {
            this.getStudentsRepository().orderAndTake(data[1], data[2], Integer.parseInt(data[3]));
        }
    }
}
