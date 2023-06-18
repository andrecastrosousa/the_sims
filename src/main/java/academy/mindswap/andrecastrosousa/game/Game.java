package academy.mindswap.andrecastrosousa.game;

import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.bank.Account;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.character.Gender;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.menu.strategy.MenuChecker;
import academy.mindswap.andrecastrosousa.menu.TerminalInteraction;

import java.io.IOException;

public class Game {

    private static TerminalInteraction terminalInteraction;

    public Game() {
        terminalInteraction = TerminalInteraction.STARTER_MENU;
    }

    public void start() {
        Character character = new Character();

        character.setName("André");
        character.setGender(Gender.MALE);
        character.setAccount(new Account(1, 1000000));

        MenuChecker menu = new MenuChecker();

        while(true) {
            try {
                menu.showMenu(terminalInteraction, character);
            } catch (IOException | HouseTooDirtyException e) {
                System.out.println(e.getMessage());
            } catch (ExitApplication e) {
                System.exit(0);
            } catch (CharacterNoHouseException | NoFundsEnoughtException e) {
                System.out.println(Messages.SEPARATOR);
                System.out.println(e.getMessage() + "\n");
                terminalInteraction = TerminalInteraction.BUY_HOUSE_MENU;
            }
        }
    }

    public static void setTerminalInteraction(TerminalInteraction terminalInteraction) {
        Game.terminalInteraction = terminalInteraction;
    }
}
