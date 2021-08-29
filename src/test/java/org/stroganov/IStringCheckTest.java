package org.stroganov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganov.exeptions.StringCheckerException;
import org.stroganov.impl.StringChecker;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class IStringCheckTest {

    String testString;

    @BeforeEach
    void setUp() {

    }
    @InjectMocks
    StringChecker stringChecker = new StringChecker();

    @Test
    void isStringDirectoryPathTest_Mast_Return_True() throws StringCheckerException {
        //given
        testString = "C:\\fgh12";
        //when
        boolean actual = stringChecker.isStringDirectoryPath(testString);
        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void isStringDirectoryPathTest_Mast_Throw_StringCheckException() throws StringCheckerException {
        //given
        testString = "C:\\fgh*12";
        //when
        //then
        Assertions.assertThrows(StringCheckerException.class, () -> stringChecker.isStringDirectoryPath(testString));
    }



    @Test
    void isStringValidPartFileName() {

    }
}