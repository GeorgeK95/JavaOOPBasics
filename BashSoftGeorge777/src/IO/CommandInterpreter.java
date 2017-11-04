package IO; /**
 * Created by George-Lenovo on 6/29/2017.
 */

import IO.commands.*;
import Judge.Tester;
import Network.DownloadManager;
import Repository.RepositoryFilter;
import Repository.RepositorySorter;
import Repository.StudentsRepository;
import exceptions.InvalidInputException;

import java.io.IOException;

public class CommandInterpreter {

    private IOManager ioManager;
    private Tester tester;
    private DownloadManager downloadManager;
    private StudentsRepository studentsRepository;
    private RepositoryFilter repositoryFilter;
    private RepositorySorter repositorySorter;

    public CommandInterpreter(IOManager ioManager, Tester tester, DownloadManager downloadManager, StudentsRepository studentsRepository) {
        this.ioManager = ioManager;
        this.tester = tester;
        this.downloadManager = downloadManager;
        this.studentsRepository = studentsRepository;
    }

    public void interpretCommand(String line) throws IOException {
        String[] data = line.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Command command = parseCommand(line, data, commandName);
            command.execute();
        } catch (Throwable t) {
            OutputWriter.writeException(t.getMessage());
        }
    }

    private Command parseCommand(String line, String[] data, String command) throws IOException {
        switch (command) {
            case "mkdir":
                return new MakeDirectoryCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "Is":
                return new TraverseFoldersCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "cmp":
                return new CompareFilesCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "changeDirRel":
                return new ChangeRelativePathCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "changeDirAbs":
                return new ChangeAbsolutePathCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "readDb":
                return new ReadDatabaseCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "download":
                return new DownloadFileCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "downloadAsync":
                return new DownloadAsynchCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "open":
                return new OpenFileCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "help":
                return new GetHelpCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "show":
                return new ShowCourseCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "filter":
                return new PrintFilteredStudentsCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "order":
                return new PrintOrderedStudentsCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            case "dropdb":
                return new DropDatabaseCommand(line, data, this.ioManager, this.tester, this.downloadManager, this.studentsRepository);
            default:
                throw new InvalidInputException(line);
        }
    }

   /* private void tryDropDb(String line, String[] data) {
        if (data.length != 1) {
            displayInvalidCommand(line);
            return;
        }
        this.studentsRepository.unloadData();
        OutputWriter.writeMessageOnNewLine("Database dropped.");
    }

    private void tryDownloadFileOnNewThread(String line, String[] data) {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }
        downloadManager.downloadOnNewThread(data[1]);
    }

    private void tryDownloadFile(String line, String[] data) {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }

        downloadManager.downloadOnNewThread(data[1]);
    }

    private void tryPrintOrderedStudents(String line, String[] data) {
        if (data.length != 3 && data.length != 4) {
            displayInvalidCommand(line);
            return;
        }

        if (data.length == 3) {
            studentsRepository.orderAndTake(data[1], data[2]);
        }
        if (data.length == 4) {
            studentsRepository.orderAndTake(data[1], data[2], Integer.parseInt(data[3]));
        }
    }

    private void tryPrintFilteredStudents(String line, String[] data) {
        if (data.length != 3 && data.length != 4) {
            displayInvalidCommand(line);
            return;
        }

        if (data.length == 3) {
            studentsRepository.filterAndTake(data[1], data[2]);
        }
        if (data.length == 4) {
            studentsRepository.filterAndTake(data[1], data[2], Integer.parseInt(data[3]));
        }
    }

    private void tryShowCourse(String line, String[] data) {
        if (data.length != 2 && data.length != 3) {
            displayInvalidCommand(line);
            return;
        }
        if (data.length == 2) {
            studentsRepository.getStudentsByCourse(data[1]);
        }
        if (data.length == 3) {
            studentsRepository.getStudentMarkInCourse(data[1], data[2]);
        }
    }

    private void getHelp() {
        OutputWriter.writeMessageOnNewLine("mkdir path - make directory");
        OutputWriter.writeMessageOnNewLine("ls depth - traverse directory");
        OutputWriter.writeMessageOnNewLine("cmp path1 path2 - compare two files");
        OutputWriter.writeMessageOnNewLine("changeDirRel relativePath - change directory");
        OutputWriter.writeMessageOnNewLine("changeDir absolutePath - change directory");
        OutputWriter.writeMessageOnNewLine("readDb path - read students data base");
        OutputWriter.writeMessageOnNewLine("filterExcelent - filter excelent students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterExcelent path - filter excelent students (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("filterAverage - filter average students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterAverage path - filter average students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("filterPoor - filter low grade students (the output is on the console)");
        OutputWriter.writeMessageOnNewLine("filterPoor path - filter low grade students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("order - sort students in increasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("order path - sort students in increasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("decOrder - sort students in decreasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("decOrder path - sort students in decreasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("download pathOfFile - download file (saved in current directory)");
        OutputWriter.writeMessageOnNewLine("downloadAsync path - download file asynchronously (save in the current directory)");
        OutputWriter.writeMessageOnNewLine("help - get help");
        OutputWriter.writeEmptyLine();
    }

    private void tryReadDbFromFile(String line, String[] data) throws IOException {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }
        studentsRepository.loadData(data[1]);
    }

    private void tryChangeAbsolutePath(String line, String[] data) throws IOException {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }

        ioManager.changeCurrentDirAbsolute(data[1]);
    }

    private void tryChangeRelativePath(String line, String[] data) throws IOException {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }

        ioManager.changeCurrentDirRelativePath(data[1]);
    }

    private void tryCompareFiles(String line, String[] data) {
        if (data.length != 3) {
            displayInvalidCommand(line);
            return;
        }
        tester.compareContent(data[1], data[2]);
    }

    private void tryTraverseFolder(String line, String[] data) {
        if (data.length != 2 && data.length != 1) {
            displayInvalidCommand(line);
            return;
        }
        if (data.length == 2) {
            ioManager.traverseDirectory(Integer.parseInt(data[1]));
        }
        if (data.length == 1) {
            ioManager.traverseDirectory(0);
        }
    }

    private void tryCreateDirectory(String line, String[] data) {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }
        ioManager.createDirectoryInCurrentFolder(data[1]);
    }

    private void tryOpenFile(String line, String[] data) {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }
        String fullFilePath = SessionData.currentPath + "\\" + data[1];
        File f = new File(fullFilePath);
        try {
            Desktop.getDesktop().open(f);
        } catch (IOException e) {
            OutputWriter.writeException(String.format("Unable to open file %s.", fullFilePath));
        }
    }

    private void displayInvalidCommand(String line) {
        OutputWriter.writeMessageOnNewLine(String.format("The command %s is invalid.", line));
    }*/
}
