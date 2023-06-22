package academy.mindswap.andrecastrosousa.factory;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.command.menu.*;
import academy.mindswap.andrecastrosousa.command.menu.navigate.*;
import academy.mindswap.andrecastrosousa.composite.Division;
import academy.mindswap.andrecastrosousa.composite.Furniture;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.UnknownCommandException;
import academy.mindswap.andrecastrosousa.domain.enums.SimMenuOption;
import academy.mindswap.andrecastrosousa.domain.enums.StarterMenuOption;
import academy.mindswap.andrecastrosousa.singleton.LoadGameSystem;

import java.io.File;

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
            case DIVISIONS -> new GoToDivisionMenuCommand();
            case NEEDS -> new OpenNeedsCommand(sim.getNeeds());
            case SKILLS -> new OpenSkillsCommand(sim.getSkills());
            case FINANCIAL -> new OpenFinancialCommand(sim.getAccount());
            case CAREER -> new OpenCarrerCommand();
            case CALL_HOUSEKEEPER -> new GoToHousekeeperMenu();
            case SAVE_GAME -> new SaveCommand();
            case UNKNOWN -> throw new UnknownCommandException();
        };
    }

    public static Command fromLoadGameMenu(int option) throws UnknownCommandException {
        LoadGameSystem loadGameMenu = LoadGameSystem.getInstance();
        File file = loadGameMenu.getSavedFile(option);

        if(file == null)
            throw new UnknownCommandException();

        return new LoadGameCommand(file);
    }

    public static Command fromHouseMenu(int option) throws UnknownCommandException {

        if(option >= 0 && option < Database.houses.size()) {
            return new BuyHouseCommand(Database.houses.get(option));
        }

        throw new UnknownCommandException();
    }

    public static Command fromHousekeeperMenu(int option, int hoursToPay) throws UnknownCommandException {
        Sim sim = Game.getSim();

        if(option == 1) {
            return new CallHousekeeperCommand(sim.getHouse(), hoursToPay);
        }

        throw new UnknownCommandException();
    }

    public static Command fromDivisionMenu(int option, Division division) throws UnknownCommandException {
        Sim sim = Game.getSim();

        if(option >= 0 && option < sim.getNumberOfDivisions()) {
            return new GoToDivisionCommand(division);
        }

        throw new UnknownCommandException();
    }

    public static Command fromActionMenu(int option) throws UnknownCommandException {

        Sim sim = Game.getSim();

        if(option >= 0 && option < sim.getQuantityOfFurnitureInCurrentDivision()) {
            return new DoActionCommand((Furniture) sim.getFurnitureInCurrentDivision(option));
        }

        throw new UnknownCommandException();
    }
}
