package io;

public interface Output {
    void printHelp();
    void printIllegalOperatorError();
    void printIllegalNumberError();
    void printIllegalInputFormatError();
    void printResult(int num);
    void printExit();
}
