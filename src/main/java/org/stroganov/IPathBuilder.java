package org.stroganov;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface IPathBuilder {

    Path getAbsolutePathFile(String fullFileName) throws IOException;

}
