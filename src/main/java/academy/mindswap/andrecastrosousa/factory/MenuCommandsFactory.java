package academy.mindswap.andrecastrosousa.factory;

import academy.mindswap.andrecastrosousa.command.menu.*;
import academy.mindswap.andrecastrosousa.command.menu.navigate.GoToHousekeeperMenu;
import academy.mindswap.andrecastrosousa.domain.Character;
import academy.mindswap.andrecastrosousa.exceptions.UnknownCommandException;
import academy.mindswap.andrecastrosousa.command.menu.navigate.ExitCommand;
import academy.mindswap.andrecastrosousa.command.menu.navigate.GoToActionCommand;
import academy.mindswap.andrecastrosousa.domain.enums.SimMenuOption;
import academy.mindswap.andrecastrosousa.domain.enums.StarterMenuOption;

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
            case NEEDS -> new OpenNeedsCommand(character.getNeeds());
            case SKILLS -> new OpenSkillsCommand(character.getSkills());
            case FINANCIAL -> new OpenFinancialCommand(character.getAccount());
            case CAREER -> new OpenCarrerCommand();
            case CALL_HOUSEKEEPER -> new GoToHousekeeperMenu();
            case UNKNOWN -> throw new UnknownCommandException();
        };
    }
}
