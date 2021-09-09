package org.stroganov;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private boolean condition;
    private String partOfName;
    private final List<Path> foundedFilesList = new ArrayList<>();
    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }
    public List<Path> getFoundedFilesList() {
        return foundedFilesList;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // check if file name contains search string
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) return FileVisitResult.CONTINUE;
        foundedFilesList.add(file);
        return super.visitFile(file, attrs);
    }
}
