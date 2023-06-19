package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.house.Division;
import academy.mindswap.andrecastrosousa.house.House;
import academy.mindswap.andrecastrosousa.menu.TerminalInteraction;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import academy.mindswap.andrecastrosousa.menu.command.DoActionCommand;
import academy.mindswap.andrecastrosousa.menu.option.StarterMenuOption;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ActionMenu implements MenuStrategy {
    CommandInvoker commandInvoker;

    public ActionMenu(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    @Override
    public boolean canHandle(TerminalInteraction menuFlow) {
        return menuFlow == TerminalInteraction.ACTIONS_MENU;
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException {
        System.out.println(Messages.SEPARATOR);
        List<Division> divisions = character.getHouse().getDivisions();
        for (int i = 0; i < divisions.size(); i++) {
            System.out.println(i + " -> " + divisions.get(i).toString());
        }
        System.out.println(Messages.SEPARATOR);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = reader.readLine();

        commandInvoker.setCommand(new DoActionCommand(character, divisions.get(Integer.parseInt(message) - 1)));
        commandInvoker.invoke();
    }
}
