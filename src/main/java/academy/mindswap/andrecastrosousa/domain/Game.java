package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.builder.SimBuilder;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.strategy.menu.MenuBase;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.strategy.menu.MenuChecker;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

import java.io.IOException;

public class Game {

    private static MenuType menuType;

    private static Sim sim;

    public Game() {
        menuType = MenuType.STARTER_MENU;
    }

    public void start() {

        sim = new SimBuilder()
                .setName("")
                .setAccount(new Account(1, 1000000))
                .setGender(Gender.MALE)
                .build();

        MenuChecker menu = new MenuChecker();

        while(true) {
            try {
                menu.showMenu(menuType, sim);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ExitApplication e) {
                System.exit(0);
            } catch (CharacterNoHouseException e) {
                System.out.println(Messages.SEPARATOR);
                System.out.println(e.getMessage() + "\n");
                menuType = MenuType.BUY_HOUSE_MENU;
            } catch (BackApplication e) {
                MenuBase.buildMenu(menuType).back();
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
