package academy.mindswap.andrecastrosousa;

import academy.mindswap.andrecastrosousa.character.Sim;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.menu.MenuChecker;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.io.IOException;

public class Game {

    private static MenuType menuType;

    private static Sim sim;

    public Game() {
        menuType = MenuType.STARTER_MENU;
    }

    public void start() {

        MenuChecker menu = new MenuChecker();

        while(true) {
            try {
                menu.showMenu(menuType);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (CharacterNoHouseException e) {
                System.out.println(Messages.SEPARATOR);
                System.out.println(e.getMessage() + "\n");
                menuType = MenuType.BUY_HOUSE_MENU;
            } catch (HouseTooDirtyException e) {
                System.out.println(Messages.SEPARATOR);
                System.out.println(e.getMessage());
                System.out.println(Messages.SEPARATOR+ "\n");

                menuType = MenuType.HOUSEKEEPER_MENU;
            } catch (CharacterFullBladderException | CharacterNoEnergyException | NoFundsEnoughtException e) {
                System.out.println(Messages.SEPARATOR);
                System.out.println(e.getMessage());
                System.out.println(Messages.SEPARATOR+ "\n");
            }
        }
    }

    public static void setMenuType(MenuType menuType) {
        Game.menuType = menuType;
    }

    public static Sim getSim() {
        return sim;
    }

    public static void setSim(Sim sim) {
        Game.sim = sim;
    }
}
