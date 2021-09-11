package org.stroganov.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FilePathBuilderTest {

    @InjectMocks
    FilePathBuilder filePathBuilder;

    @Test
    void getAbsolutePathFile() throws IOException {
        // GIVEN
        String rootPath = new File("").getAbsolutePath();
        String expectedAbsolutePath = rootPath + "\\src\\test\\resources";
        // WHEN
        String actualAbsolutePath = filePathBuilder.getAbsolutePathFile(rootPath + "\\src\\test\\resources\\fileForTest").toString();
        // THEN
        assertEquals(expectedAbsolutePath, actualAbsolutePath);
    }
}