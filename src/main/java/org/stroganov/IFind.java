package org.stroganov;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface IFind {
    List<Path> getFilesPathListByPartName(String partFileName, String directoryPath) throws IOException;
}
