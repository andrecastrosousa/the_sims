package academy.mindswap.andrecastrosousa.menu.factory;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.LoadGameSystem;
import academy.mindswap.andrecastrosousa.house.Division;
import academy.mindswap.andrecastrosousa.house.Furniture;
import academy.mindswap.andrecastrosousa.character.Sim;
import academy.mindswap.andrecastrosousa.menu.enums.SimMenuOption;
import academy.mindswap.andrecastrosousa.menu.enums.StarterMenuOption;
import academy.mindswap.andrecastrosousa.exceptions.UnknownCommandException;
import academy.mindswap.andrecastrosousa.menu.commands.*;
import academy.mindswap.andrecastrosousa.menu.commands.navigate.*;

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
        if(option == 1) {
            return new CallHousekeeperCommand(hoursToPay);
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
