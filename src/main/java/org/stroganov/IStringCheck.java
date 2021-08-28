package org.stroganov;

import org.stroganov.exeptions.StringCheckerException;

public interface IStringCheck {
    boolean isStringDirectoryPath(String directoryPath) throws StringCheckerException;
    boolean isStringValidPartFileNAme(String fileNamePart) throws StringCheckerException;
}
