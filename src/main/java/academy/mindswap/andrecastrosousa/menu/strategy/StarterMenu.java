package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.option.StarterMenuOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarterMenu implements Menu {

    CommandInvoker commandInvoker;

    public StarterMenu(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }
    @Override
    public boolean canHandle(MenuType menuFlow) {
        return menuFlow == MenuType.STARTER_MENU;
    }

    @Override
    public void handle(Character character) throws IOException, ExitApplication, CharacterNoHouseException, NoFundsEnoughtException, HouseTooDirtyException, BackApplication {
        System.out.println(Messages.SEPARATOR);
        for (StarterMenuOption starterMenu: StarterMenuOption.values()) {
            System.out.println(starterMenu.getOption() + " -> " + starterMenu.getMessage());
        }
        System.out.println(Messages.SEPARATOR);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = reader.readLine();

        Command command = null;

        try {
            commandInvoker.setCommand(StarterMenuOption.execute(Integer.parseInt(message), character));
        } catch (UnknownCommandException e) {
            handle(character);
        }

        commandInvoker.invoke();
    }
}
