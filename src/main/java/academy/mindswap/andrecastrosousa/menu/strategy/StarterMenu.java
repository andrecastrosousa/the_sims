package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.menu.TerminalInteraction;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import academy.mindswap.andrecastrosousa.menu.strategy.MenuStrategy;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoHouseException;
import academy.mindswap.andrecastrosousa.exceptions.ExitApplication;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.option.StarterMenuOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarterMenu implements MenuStrategy {

    CommandInvoker commandInvoker;

    public StarterMenu(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }
    @Override
    public boolean canHandle(TerminalInteraction menuFlow) {
        return menuFlow == TerminalInteraction.STARTER_MENU;
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException {
        System.out.println(Messages.SEPARATOR);
        for (StarterMenuOption starterMenu: StarterMenuOption.values()) {
            System.out.println(starterMenu.getOption() + " -> " + starterMenu.getMessage());
        }
        System.out.println(Messages.SEPARATOR);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = reader.readLine();

        Command command = StarterMenuOption.execute(Integer.parseInt(message), character);
        commandInvoker.setCommand(command);
        commandInvoker.invoke();

    }
}
