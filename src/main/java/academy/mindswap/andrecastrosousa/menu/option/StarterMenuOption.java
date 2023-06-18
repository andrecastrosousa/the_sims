package academy.mindswap.andrecastrosousa.menu.option;

import academy.mindswap.andrecastrosousa.Messages;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.menu.Menu;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.command.ExitCommand;
import academy.mindswap.andrecastrosousa.menu.command.GoToBuyHouseMenuCommand;
import academy.mindswap.andrecastrosousa.menu.command.StartCommand;

import java.util.Arrays;

public enum StarterMenuOption implements Menu {
    ENTER(1, Messages.ENTER_GAME_COMMAND),
    BUY_HOUSE(2, Messages.BUY_HOUSE_COMMAND),
    EXIT;

    private final int option;

    private final String message;

    StarterMenuOption() {
        option = 0;
        message = Messages.EXIT_COMMAND;
    }

    StarterMenuOption(int option, String message) {
        this.option = option;
        this.message = message;
    }

    @Override
    public StarterMenuOption getEnumByOption(int option) {
        return Arrays.stream(StarterMenuOption.values())
                .filter(o -> o.option == option)
                .findFirst().orElse(EXIT);
    }

    @Override
    public Command execute(int option, Character character) {
        StarterMenuOption starterMenuOption = getEnumByOption(option);

        return switch (starterMenuOption) {
            case ENTER -> new StartCommand(character);
            case BUY_HOUSE -> new GoToBuyHouseMenuCommand();
            default -> new ExitCommand();
        };
    }

    public int getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }
}
