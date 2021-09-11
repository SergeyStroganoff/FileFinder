package org.stroganov.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FileFinderTest {

    public static final String SRC_TEST_RESOURCES_FILE_FOR_TEST = "\\src\\test\\resources\\fileForTest";
    List<Path> pathList;
    String rootPath = new File("").getAbsolutePath();
    @InjectMocks
    FileFinder fileFinder;

    @BeforeEach
    void initPathList() {
        String pathToResourcesDirectory = rootPath + SRC_TEST_RESOURCES_FILE_FOR_TEST;
        Path expectedPath = Paths.get(pathToResourcesDirectory);
        pathList = new ArrayList<>();
        pathList.add(expectedPath);
    }

    @DisplayName("Testing searching all files with given part of name")
    @Test
    void getFilesPathListByPartName_RealPathReturnTest() throws IOException {
        //GIVEN
        List<Path> expected = pathList;
        //WHEN
        List<Path> actual = fileFinder.getFilesPathListByPartName("file", rootPath + SRC_TEST_RESOURCES_FILE_FOR_TEST);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getFilesListContainedTextAsParameter_ReturnListOfPaths() {
        // GIVEN
        List<Path> expected = pathList;
        fileFinder = Mockito.mock(FileFinder.class);
        Mockito.when(fileFinder.getFilesContainedText("fg")).thenReturn(expected);
        // WHEN
        List<Path> actual = fileFinder.getFilesContainedText("fg");
        // THEN
        assertEquals(expected, actual);
    }
}