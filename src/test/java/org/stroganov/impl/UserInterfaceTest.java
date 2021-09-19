package org.stroganov.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserInterfaceTest {

    @InjectMocks
    UserInterface userInterface;

    @Test
    void getStringFromUser_Return_TestString() throws IOException {
        // GIVEN
        String expectedString = "test";
        BufferedReader reader = Mockito.mock(BufferedReader.class);
        Mockito.when(reader.readLine()).thenReturn("test");
        // WHEN
        String actualString = userInterface.getStringFromUser(reader);
        // THEN
        assertEquals(expectedString, actualString);

    }

    @Test
    void showInputMessage_System_out_PrintLn_Used() {
        // GIVEN
        byte[] expected = "Введите в терминале".getBytes();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showInputMessage("");
        byte[] actualString = "Введите в терминале".toString().getBytes();
        // THEN
        assertArrayEquals(expected, actualString);
        System.setOut(oldStream);

    }

    @Test
    void showOutputMessage_System_out_PrintLn_Used() {
        // GIVEN
        byte[] expected = "Результат поиска файлов".getBytes();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showOutputMessage("");
        byte[] actualString = "Результат поиска файлов".toString().getBytes();
        // THEN
        assertArrayEquals(expected, actualString);
        System.setOut(oldStream);
    }

    @Test
    void showErrorMessage_System_out_PrintLn_Used() {
        // GIVEN
        byte[] expected = "Произошла ошибка".getBytes();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        // WHEN
        userInterface.showErrorMessage("");
        byte[] actualString = "Произошла ошибка".toString().getBytes();
        // THEN
        assertArrayEquals(expected, actualString);
        System.setOut(oldStream);
    }
}