package org.stroganov.impl;

import org.stroganov.IDirectoryAction;
import org.stroganov.SearchFileVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DirectoryViewer implements IDirectoryAction {
    @Override

    public List<Path> getDirectoryList(Path directoryPath) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
        Files.walkFileTree(directoryPath, searchFileVisitor);
        return searchFileVisitor.getFoundedFilesList();
    }
}
