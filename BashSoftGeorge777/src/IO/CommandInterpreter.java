package IO; /**
 * Created by George-Lenovo on 6/29/2017.
 */

import Judge.Tester;
import Network.DownloadManager;
import Repository.RepositoryFilter;
import Repository.RepositorySorter;
import Repository.StudentsRepository;
import StaticData.SessionData;

import java.awt.*;
import java.io.File;
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
        String command = data[0];
        try {
            parseCommand(line, data, command);
        } catch (IllegalArgumentException iae) {
            OutputWriter.writeException(iae.getMessage());
        } catch (StringIndexOutOfBoundsException sioobe) {
            OutputWriter.writeException(sioobe.getMessage());
        } catch (IOException ioe) {
            OutputWriter.writeException(ioe.getMessage());
        } catch (Throwable t) {
            OutputWriter.writeException(t.getMessage());
        }
    }

    private void parseCommand(String line, String[] data, String command) throws IOException {
        switch (command) {
            case "mkdir":
                tryCreateDirectory(line, data);
                break;
            case "Is":
                tryTraverseFolder(line, data);
                break;
            case "cmp":
                tryCompareFiles(line, data);
                break;
            case "changeDirRel":
                tryChangeRelativePath(line, data);
                break;
            case "changeDirAbs":
                tryChangeAbsolutePath(line, data);
                break;
            case "readDb":
                tryReadDbFromFile(line, data);
                break;
            case "download":
                tryDownloadFile(line, data);
                break;
            case "downloadAsync":
                tryDownloadFileOnNewThread(line, data);
                break;
            case "help":
                getHelp();
                break;
            case "open":
                tryOpenFile(line, data);
                break;
            case "show":
                tryShowCourse(line, data);
                break;
            case "filter":
                tryPrintFilteredStudents(line, data);
                break;
            case "order":
                tryPrintOrderedStudents(line, data);
                break;
            case "dropdb":
                tryDropDb(line, data);
                break;
            default:
                displayInvalidCommand(line);
                break;
        }
    }

    private void tryDropDb(String line, String[] data) {
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
    }
}
