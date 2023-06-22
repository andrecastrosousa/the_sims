package academy.mindswap.andrecastrosousa.menu.enums;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.Arrays;
import java.util.List;

public enum StarterMenuOption {
    EXIT(0, Messages.EXIT_COMMAND),
    START(1, Messages.START_GAME_COMMAND),
    LOAD_GAME(2, Messages.LOAD_GAME_COMMAND),
    UNKNOWN;

    private int option;

    private String message;

    StarterMenuOption(int option, String message) {
        this.option = option;
        this.message =  message;
    }

    StarterMenuOption() {

    }

    public static StarterMenuOption getEnumByOption(int option) {
        return Arrays.stream(StarterMenuOption.values())
                .filter(o -> o.option == option)
                .findFirst()
                .orElse(UNKNOWN);
    }

    public static List<String> getMenuOptions() {
        return Arrays.stream(StarterMenuOption.values())
                .filter(o -> o != StarterMenuOption.UNKNOWN)
                .map(StarterMenuOption::getMessage)
                .toList();
    }

    public static int getNumberOfOptions() {
        return StarterMenuOption.values().length - 1;
    }

    public String getMessage() {
        return message;
    }
}
