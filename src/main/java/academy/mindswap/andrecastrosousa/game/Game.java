package academy.mindswap.andrecastrosousa.game;

import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.state.MenuState;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.bank.Account;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.character.Gender;
import academy.mindswap.andrecastrosousa.menu.strategy.MenuChecker;
import academy.mindswap.andrecastrosousa.menu.MenuType;

import java.io.IOException;

public class Game {

    private static MenuType menuType;

    public Game() {
        menuType = MenuType.STARTER_MENU;
    }

    public void start() {
        Character character = new Character();

        character.setName("André");
        character.setGender(Gender.MALE);
        character.setAccount(new Account(1, 1000000));

        MenuChecker menu = new MenuChecker();

        while(true) {
            try {
                menu.showMenu(menuType, character);
            } catch (IOException | HouseTooDirtyException e) {
                System.out.println(e.getMessage());
            } catch (ExitApplication e) {
                System.exit(0);
            } catch (CharacterNoHouseException | NoFundsEnoughtException e) {
                System.out.println(Messages.SEPARATOR);
                System.out.println(e.getMessage() + "\n");
                menuType = MenuType.BUY_HOUSE_MENU;
            } catch (BackApplication e) {
                MenuState.buildMenuState(menuType).back();
            }
        }
    }

    public static void setMenuType(MenuType menuType) {
        Game.menuType = menuType;
    }
}
