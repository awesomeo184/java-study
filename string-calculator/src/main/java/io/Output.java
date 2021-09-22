package io;

import java.util.IllegalFormatException;

public interface Output {
    void printHelp();
    void printIllegalInputFormatError(IllegalArgumentException e);
    void printResult(int num);
    void printExit();
}
