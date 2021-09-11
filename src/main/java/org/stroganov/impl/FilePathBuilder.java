package org.stroganov.impl;

import org.stroganov.IPathBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathBuilder implements IPathBuilder {

    @Override
    public Path getAbsolutePathFile(String fullFileName) throws IOException {
        File file = new File(fullFileName);
        return Paths.get(file.getParent());
    }
}
