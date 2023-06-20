package academy.mindswap.andrecastrosousa.factory;

import academy.mindswap.andrecastrosousa.command.menu.*;
import academy.mindswap.andrecastrosousa.command.menu.navigate.GoToHousekeeperMenu;
import academy.mindswap.andrecastrosousa.command.menu.navigate.GoToLoadGameCommand;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
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

    public static Command fromStarterMenu(int option) throws UnknownCommandException {
        StarterMenuOption starterMenuOption = StarterMenuOption.getEnumByOption(option);

        return switch (starterMenuOption) {
            case START -> new StartCommand();
            case LOAD_GAME -> new GoToLoadGameCommand();
            case EXIT -> new ExitCommand();
            case UNKNOWN -> throw new UnknownCommandException();
        };
    }

    public static Command fromSimMenu(int option) throws UnknownCommandException {
        SimMenuOption starterMenuOption = SimMenuOption.getEnumByOption(option);

        Sim sim = Game.getSim();

        return switch (starterMenuOption) {
            case ACTIONS -> new GoToActionCommand();
            case NEEDS -> new OpenNeedsCommand(sim.getNeeds());
            case SKILLS -> new OpenSkillsCommand(sim.getSkills());
            case FINANCIAL -> new OpenFinancialCommand(sim.getAccount());
            case CAREER -> new OpenCarrerCommand();
            case CALL_HOUSEKEEPER -> new GoToHousekeeperMenu();
            case SAVE_GAME -> new SaveCommand();
            case UNKNOWN -> throw new UnknownCommandException();
        };
    }
}
