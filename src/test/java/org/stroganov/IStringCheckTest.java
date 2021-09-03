package org.stroganov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganov.exeptions.StringCheckerException;
import org.stroganov.impl.StringChecker;

@ExtendWith(MockitoExtension.class)
class IStringCheckTest {

    String testString;

    @BeforeEach
    void setUp() {

    }

    @InjectMocks
    StringChecker stringChecker;

    @Test
    void isStringDirectoryPathTest_Mast_Return_True() throws StringCheckerException {
        //given
        testString = "C:\\fgh12";
        //when
        boolean actual = stringChecker.isStringDirectoryPath(testString);
        //then
        Assertions.assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"C:\\fgh*12", ":\\fgh[]67!12"})
    void isStringDirectoryPathTest_Mast_Throw_StringCheckException(String argument) throws StringCheckerException {
        //given
        testString = argument;
        //when
        //then
        Assertions.assertThrows(StringCheckerException.class, () -> stringChecker.isStringDirectoryPath(testString));
    }

    @Test
    void isStringValidPartFileName_Mast_Return_True() throws StringCheckerException {
        //given
        testString = "stringTest";
        //when
        boolean actual = stringChecker.isStringValidPartFileName(testString);
        //then
        Assertions.assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"C:\\fgh*12", ":\\fgh[]67!12"})
    void isStringValidPartFileName_Mast_Throw_StringCheckerException(String argument) {
        //given
        testString = argument;
        //when
        //then
        Assertions.assertThrows(StringCheckerException.class, () -> stringChecker.isStringDirectoryPath(testString));

    }


}