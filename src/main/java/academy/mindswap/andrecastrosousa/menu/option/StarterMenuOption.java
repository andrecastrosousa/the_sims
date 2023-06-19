package academy.mindswap.andrecastrosousa.menu.option;

import academy.mindswap.andrecastrosousa.exceptions.UnknownCommandException;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.command.navigate.ExitCommand;
import academy.mindswap.andrecastrosousa.menu.command.navigate.GoToBuyHouseCommand;
import academy.mindswap.andrecastrosousa.menu.command.StartCommand;

import java.util.Arrays;
import java.util.List;

public enum StarterMenuOption {
    EXIT(0, Messages.EXIT_COMMAND),
    START(1, Messages.START_GAME_COMMAND),
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

    public int getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }
}
