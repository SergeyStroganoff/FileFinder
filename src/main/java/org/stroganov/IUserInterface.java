package org.stroganov;

import java.io.BufferedReader;

public interface IUserInterface {
    String getStringFromUser(BufferedReader reader);
    void showInputMessage(String inputMessage);
    void showOutputMessage(String resultString);
    void showErrorMessage(String errorExpression);
}
