package academy.mindswap.andrecastrosousa.factory;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.UnknownCommandException;
import academy.mindswap.andrecastrosousa.menu.command.*;
import academy.mindswap.andrecastrosousa.menu.command.navigate.ExitCommand;
import academy.mindswap.andrecastrosousa.menu.command.navigate.GoToActionCommand;
import academy.mindswap.andrecastrosousa.menu.command.navigate.GoToBuyHouseCommand;
import academy.mindswap.andrecastrosousa.menu.option.SimMenuOption;
import academy.mindswap.andrecastrosousa.menu.option.StarterMenuOption;

/**
 * Design pattern: Abstract Factory
 */
public abstract class MenuCommandsFactory {

    private MenuCommandsFactory() {}

    public static Command fromStarterMenu(int option, Character character) throws UnknownCommandException {
        StarterMenuOption starterMenuOption = StarterMenuOption.getEnumByOption(option);

        return switch (starterMenuOption) {
            case START -> new StartCommand(character);
            case EXIT -> new ExitCommand();
            case UNKNOWN -> throw new UnknownCommandException();
        };
    }

    public static Command fromSimMenu(int option, Character character) throws UnknownCommandException {
        SimMenuOption starterMenuOption = SimMenuOption.getEnumByOption(option);

        return switch (starterMenuOption) {
            case ACTIONS -> new GoToActionCommand();
            case NEEDS -> new OpenNeedsCommand();
            case SKILLS -> new OpenSkillsCommand();
            case FINANCIAL_PERSONAL -> new OpenFinancialPersonalCommand();
            case CAREER -> new OpenCarrerCommand();
            case UNKNOWN -> throw new UnknownCommandException();
        };
    }
}
