package engine;

import java.util.Arrays;

public enum Commands {
    EXIT,
    HELP;

    public static boolean contains (String command) {
        return Arrays.stream(Commands.values())
            .anyMatch(cmd -> command.toUpperCase().equals(cmd.name()));
    }
}
