package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.character.SimBuilder;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.character.Account;
import academy.mindswap.andrecastrosousa.character.Sim;
import academy.mindswap.andrecastrosousa.character.Gender;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.commands.Command;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.io.IOException;

public class SimCreationMenu extends MenuBase {
    public SimCreationMenu() {
        super(MenuType.SIM_CREATION_MENU);
    }

    @Override
    public void handle() throws IOException, CharacterNoHouseException, HouseTooDirtyException, NoFundsEnoughtException, CharacterFullBladderException, CharacterNoEnergyException {
        SimBuilder simBuilder = new SimBuilder();
        MenuTerminal menuTerminal = new MenuTerminal.Builder()
                .setOptions(Gender.getMenuOptions())
                .build();


        System.out.println(Messages.SEPARATOR);
        System.out.println("Insert name for your sim: ");
        System.out.println(Messages.SEPARATOR);

        String name = menuTerminal.selectOption();
        simBuilder.setName(name);

        menuTerminal.print();

        String message = menuTerminal.selectOption();
        simBuilder.setGender(Gender.getEnumByOption(Integer.parseInt(message)))
                .setAccount(new Account(2, 100000));

        Sim sim = simBuilder.build();

        Game.setSim(sim);

        if(sim.getHouse() == null) {
            throw new CharacterNoHouseException();
        }

        Game.setMenuType(MenuType.SIM_MENU);
    }

    @Override
    protected Command getValidCommand(String message) {
        return null;
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
