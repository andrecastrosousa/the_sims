package academy.mindswap.andrecastrosousa.strategy.menu;

import academy.mindswap.andrecastrosousa.command.menu.DoActionCommand;
import academy.mindswap.andrecastrosousa.command.menu.navigate.BackCommand;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.command.menu.Command;
import academy.mindswap.andrecastrosousa.builder.MenuTerminal;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.io.IOException;
import java.util.List;

public class ActionMenu extends MenuBase {

    public ActionMenu() {
        super(MenuType.ACTIONS_MENU);
    }

    @Override
    public void handle() throws IOException, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, CharacterFullBladderException, CharacterNoEnergyException {
        Sim sim = Game.getSim();

        List<String> options = sim.getHouseDivisions().stream()
                .map(division -> String.format(Messages.GO_TO_COMMAND, division.getName(), division.getAction().toString()))
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
        } else if(selectedOption >= 0 && selectedOption < sim.getNumberOfDivisions()) {
            return new DoActionCommand(sim, sim.getHouseDivision(selectedOption));
        }

        throw new UnknownCommandException();
    }

    @Override
    public void back() {
        Game.setMenuType(MenuType.SIM_MENU);
    }
}
