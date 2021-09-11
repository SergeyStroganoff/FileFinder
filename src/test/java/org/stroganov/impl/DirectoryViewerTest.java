package org.stroganov.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DirectoryViewerTest {

    public static final String NAME_OF_EXISTING_SEARCH_FILE = "fileForTest";
    public static final String DIRECTORY_IN_PROJECT_FOR_TEST = "\\src\\test\\resources";
    @InjectMocks
    FileFinder fileFinder;

    @Test
    void getDirectoryListTest_Return_ListOfFiles_In_ResourcesDirectory() throws IOException {

        // GIVEN
        String rootPath = new File("").getAbsolutePath();
        String pathToResourcesDirectory = rootPath + "\\" + DIRECTORY_IN_PROJECT_FOR_TEST + "\\" + NAME_OF_EXISTING_SEARCH_FILE;
        Path expectedPath = Paths.get(pathToResourcesDirectory);
        List<Path> expectedList = new ArrayList<>(Arrays.asList(expectedPath));
        // WHEN
        List<Path> actual = fileFinder.getFilesPathListByPartName(null, rootPath + DIRECTORY_IN_PROJECT_FOR_TEST);
        // THEN
        assertEquals(expectedList, actual);

    }
}