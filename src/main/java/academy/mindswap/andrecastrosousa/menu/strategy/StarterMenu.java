package academy.mindswap.andrecastrosousa.menu.strategy;

import academy.mindswap.andrecastrosousa.exceptions.*;
import academy.mindswap.andrecastrosousa.menu.MenuType;
import academy.mindswap.andrecastrosousa.menu.command.CommandInvoker;
import academy.mindswap.andrecastrosousa.utils.MenuTerminal;
import academy.mindswap.andrecastrosousa.utils.Messages;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.option.StarterMenuOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

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
        List<String> options = Arrays.stream(StarterMenuOption.values())
                .filter(o -> o != StarterMenuOption.UNKNOWN)
                .map(StarterMenuOption::getMessage)
                .toList();

        MenuTerminal menuTerminal = new MenuTerminal.MenuTerminalBuilder()
                .setOptions(options)
                .build();

        menuTerminal.print();

        String message = menuTerminal.selectOption();

        try {
            commandInvoker.setCommand(StarterMenuOption.execute(Integer.parseInt(message), character));
        } catch (UnknownCommandException e) {
            handle(character);
        }

        commandInvoker.invoke();
    }
}
