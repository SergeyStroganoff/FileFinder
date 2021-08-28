package org.stroganov.impl;

import org.stroganov.IFind;
import org.stroganov.SearchFileVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileFinder implements IFind {

    SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

    @Override
    public List<Path> getFilesPathListByPartName(String partFileName, String directoryPath) throws IOException {
        searchFileVisitor.setPartOfName(partFileName);
        Files.walkFileTree(Paths.get(directoryPath), searchFileVisitor);
        return searchFileVisitor.getFoundedFilesList();
    }
}
