package academy.mindswap.andrecastrosousa.menu.option;

import academy.mindswap.andrecastrosousa.exceptions.UnknownCommandException;
import academy.mindswap.andrecastrosousa.menu.strategy.StarterMenu;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.command.ExitCommand;
import academy.mindswap.andrecastrosousa.menu.command.GoToBuyHouseMenuCommand;
import academy.mindswap.andrecastrosousa.menu.command.StartCommand;

import java.util.Arrays;

public enum StarterMenuOption {
    EXIT(0, Messages.EXIT_COMMAND),
    ENTER(1, Messages.ENTER_GAME_COMMAND),
    BUY_HOUSE(2, Messages.BUY_HOUSE_COMMAND),
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
                .findFirst().orElse(UNKNOWN);
    }

    public static Command execute(int option, Character character) throws UnknownCommandException {
        StarterMenuOption starterMenuOption = getEnumByOption(option);

        return switch (starterMenuOption) {
            case ENTER -> new StartCommand(character);
            case BUY_HOUSE -> new GoToBuyHouseMenuCommand();
            case EXIT -> new ExitCommand();
            case UNKNOWN -> throw new UnknownCommandException();
        };
    }

    public int getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }
}
