package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadGameCommand implements Command {

    private final String loadGameFile;

    public LoadGameCommand(String loadGameFile) {
        this.loadGameFile = loadGameFile;
    }


    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, ExitApplication, HouseTooDirtyException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {
        try (FileInputStream fileIn = new FileInputStream(loadGameFile);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            // Read the object from the file
            Sim simJson = (Sim) objectIn.readObject();

            System.out.println(simJson);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
