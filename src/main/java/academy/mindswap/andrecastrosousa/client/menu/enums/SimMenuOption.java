package academy.mindswap.andrecastrosousa.client.menu.enums;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.Arrays;
import java.util.List;

public enum SimMenuOption {
    DIVISIONS(1, Messages.ACTIONS_COMMAND),
    NEEDS(2, Messages.NEEDS_COMMAND),
    SKILLS(3, Messages.SKILLS_COMMAND),
    FINANCIAL(4, Messages.FINANCIAL_COMMAND),
    CAREER(5, Messages.CAREER_COMMAND),
    CALL_HOUSEKEEPER(6, Messages.CALL_HOUSEKEEPER_COMMAND),
    SAVE_GAME(7, "Save game"),
    UNKNOWN;

    private int option;

    private String message;

    SimMenuOption() {}

    SimMenuOption(int option, String message) {
        this.option = option;
        this.message = message;
    }

    public static SimMenuOption getEnumByOption(int option) {
        return Arrays.stream(SimMenuOption.values())
                .filter(o -> o.option == option)
                .findFirst()
                .orElse(UNKNOWN);
    }

    public static List<String> getMenuOptions() {
        return Arrays.stream(SimMenuOption.values())
                .filter(o -> o != SimMenuOption.UNKNOWN)
                .map(SimMenuOption::getMessage)
                .toList();
    }

    public static int getNumberOfOptions() {
        return SimMenuOption.values().length - 1;
    }

    public String getMessage() {
        return message;
    }
}
