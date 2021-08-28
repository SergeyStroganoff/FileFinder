package org.stroganov;

import org.stroganov.exeptions.StringCheckerException;
import org.stroganov.impl.FileFinder;
import org.stroganov.impl.StringChecker;
import org.stroganov.impl.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    public static final String ERROR_MESSAGE_PATH = "Вы ввели путь к несуществующей директории";
    public static final String FULL_FILE_PATH_MESSAGE = "Полный путь к каталогу поиска";
    public static final String FILE_NAME_MESSAGE = "Часть имени файла или полное имя файла";

    public static void main(String[] args) throws StringCheckerException {
        IUserInterface userInterface = new UserInterface();
        StringChecker stringChecker = new StringChecker();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        userInterface.showInputMessage(FULL_FILE_PATH_MESSAGE);
        String pathFromUser = userInterface.getStringFromUser(reader);
        userInterface.showInputMessage(FILE_NAME_MESSAGE);
        String fileNameFromUser = userInterface.getStringFromUser(reader);
        List<Path> resultFileList = new ArrayList<>();
        if (stringChecker.isStringDirectoryPath(pathFromUser) && stringChecker.isStringValidPartFileNAme(fileNameFromUser) && Files.isDirectory(Path.of(pathFromUser))) {
            IFind fileFinder = new FileFinder();
            try {
                resultFileList = new ArrayList<>(fileFinder.getFilesPathListByPartName(fileNameFromUser, pathFromUser));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else userInterface.showErrorMessage(ERROR_MESSAGE_PATH);

        if (!resultFileList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            resultFileList.forEach(x -> stringBuilder.append(x).append("\n"));
            userInterface.showOutputMessage(stringBuilder.toString());
        }
    }
}
