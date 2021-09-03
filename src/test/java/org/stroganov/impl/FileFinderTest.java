package org.stroganov.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FileFinderTest {

    List<Path> pathList;

    @InjectMocks
    FileFinder fileFinder;

    @BeforeEach
    void initPathList() {
        Path expectedPath = Paths.get("/home/sever/WorkingEPAM/FileFinderUnit5/src/main/resources/projectResources");
        pathList = new ArrayList<>();
        pathList.add(expectedPath);
    }

    @DisplayName("Testing searching all files with given part of name")
    @Test
    void getFilesPathListByPartName_RealPathReturnTest() throws IOException {
        //GIVEN
        List<Path> expected = pathList;
        //WHEN
        List<Path> actual = fileFinder.getFilesPathListByPartName("project", "/home/sever/WorkingEPAM/FileFinderUnit5/src/main/resources/projectResources");
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getFilesListContainedTextAsParameter_ReturnListOfPaths() {
        //GIVEN
        List<Path> expected = pathList;
        fileFinder = Mockito.mock(FileFinder.class);
        Mockito.when(fileFinder.getFilesContainedText("fg")).thenReturn(expected);
        //WHEN
        List<Path> actual = fileFinder.getFilesContainedText("fg");
        assertEquals(expected, actual);
    }
}