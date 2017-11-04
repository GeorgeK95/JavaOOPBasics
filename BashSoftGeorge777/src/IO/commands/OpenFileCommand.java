package IO.commands;

import IO.IOManager;
import Judge.Tester;
import Network.DownloadManager;
import Repository.StudentsRepository;
import StaticData.SessionData;
import exceptions.InvalidInputException;

import java.io.File;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class OpenFileCommand extends Command {


    public OpenFileCommand(String line, String[] data, IOManager ioManager, Tester tester, DownloadManager downloadManager, StudentsRepository studentsRepository) {
        super(line, data, ioManager, tester, downloadManager, studentsRepository);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getLine());
        }
        String fullFilePath = SessionData.currentPath + "\\" + data[1];
        File f = new File(fullFilePath);

    }
}
