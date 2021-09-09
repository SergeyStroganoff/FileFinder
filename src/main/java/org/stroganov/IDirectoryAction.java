package org.stroganov;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface IDirectoryAction {

    List<Path> getDirectoryList(Path directoryPath) throws IOException;
}
