package academy.mindswap.andrecastrosousa.menu;

import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.character.Sim;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.commands.Command;
import academy.mindswap.andrecastrosousa.menu.commands.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.menu.enums.MenuType;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.menu.factory.MenuCommandsFactory;

import java.io.IOException;
import java.util.List;

public class DivisionMenu extends MenuBase {
    public DivisionMenu() {
        super(MenuType.DIVISION_MENU);
    }

    @Override
    public void handle() throws IOException, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException {
        Sim sim = Game.getSim();

        List<String> options = sim.getHouseDivisions().stream()
                .map(division -> String.format(Messages.GO_TO_COMMAND, division.getName()))
                .toList();

        System.out.println("Level of cleanness: " + sim.getHouse().getDirtyLevel());

        MenuTerminal menuTerminal = new MenuTerminal.Builder()
                .setOptions(options)
                .hasBackButton()
                .build();

        menuTerminal.print();

        String message = menuTerminal.selectOption();

        try {
            Command command = getValidCommand(message);
            commandInvoker.setCommand(command);
        } catch (UnknownCommandException e) {
            handle();
        }

        commandInvoker.invoke();
    }

    @Override
    protected Command getValidCommand(String message) throws UnknownCommandException {
        Sim sim = Game.getSim();

        int selectedOption = Integer.parseInt(message);

        if(selectedOption == sim.getNumberOfDivisions()) {
            return new BackCommand(type);
        }

        return MenuCommandsFactory.fromDivisionMenu(selectedOption, sim.getHouseDivision(selectedOption));
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.SIM_MENU);
    }
}
