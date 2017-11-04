package IO.commands;

import IO.IOManager;
import IO.OutputWriter;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;
import exceptions.InvalidInputException;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class DropDatabaseCommand extends Command {

    public DropDatabaseCommand(String line, String[] data, IOManager ioManager, Tester tester, DownloadManager downloadManager, StudentsRepository studentsRepository) {
        super(line, data, ioManager, tester, downloadManager, studentsRepository);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1) {
            throw new InvalidInputException(this.getLine());
        }
        this.getStudentsRepository().unloadData();
        OutputWriter.writeMessageOnNewLine("Database dropped.");
    }
}
