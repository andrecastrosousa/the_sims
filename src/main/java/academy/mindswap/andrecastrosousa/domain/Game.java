package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.state.menu.MenuState;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.strategy.MenuChecker;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

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
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ExitApplication e) {
                System.exit(0);
            } catch (CharacterNoHouseException | NoFundsEnoughtException e) {
                System.out.println(Messages.SEPARATOR);
                System.out.println(e.getMessage() + "\n");
                menuType = MenuType.BUY_HOUSE_MENU;
            } catch (BackApplication e) {
                MenuState.buildMenuState(menuType).back();
            } catch (HouseTooDirtyException e) {
                System.out.println(Messages.SEPARATOR);
                System.out.println(e.getMessage());
                System.out.println(Messages.SEPARATOR+ "\n");

                menuType = MenuType.HOUSEKEEPER_MENU;
            }
        }
    }

    public static void setMenuType(MenuType menuType) {
        Game.menuType = menuType;
    }
}
