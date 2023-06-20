package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.command.menu.BuyHouseCommand;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.domain.House;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.builder.MenuTerminal;
import academy.mindswap.andrecastrosousa.domain.Sim;

import java.io.IOException;
import java.util.List;

public class HouseMenu extends MenuBase {
    public HouseMenu() {
        super(MenuType.BUY_HOUSE_MENU);
    }

    @Override
    public void handle(Sim sim) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {

        List<String> options = Database.houses.stream()
                .map(House::toString)
                .toList();

        MenuTerminal menuTerminal = new MenuTerminal.Builder()
                .setOptions(options)
                .hasBackButton()
                .build();

        menuTerminal.print();

        String message = menuTerminal.selectOption();

        try {
            Command command = getValidCommand(message, sim);
            commandInvoker.setCommand(command);
        } catch (UnknownCommandException e) {
            handle(sim);
        }

        commandInvoker.invoke();
    }

    @Override
    protected Command getValidCommand(String message, Sim sim) throws UnknownCommandException {
        int selectedOption = Integer.parseInt(message);

        if(selectedOption == Database.houses.size()) {
            return new BackCommand();
        } else if(selectedOption >= 0 && selectedOption < Database.houses.size()) {
            return new BuyHouseCommand(sim, Database.houses.get(selectedOption));
        } else {
            throw new UnknownCommandException();
        }
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
