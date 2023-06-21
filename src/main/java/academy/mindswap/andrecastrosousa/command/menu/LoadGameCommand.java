package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;
import academy.mindswap.andrecastrosousa.exceptions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadGameCommand implements Command {

    private final File loadGameFile;

    public LoadGameCommand(File loadGameFile) {
        this.loadGameFile = loadGameFile;
    }


    @Override
    public void execute() {
        try (FileInputStream fileIn = new FileInputStream(loadGameFile);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            // Read the object from the file
            Sim sim = (Sim) objectIn.readObject();

            Game.setSim(sim);
            Game.setMenuType(MenuType.SIM_MENU);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
