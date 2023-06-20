package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SaveCommand implements Command {

    @Override
    public void execute() throws NoFundsEnoughtException, CharacterNoHouseException, ExitApplication, HouseTooDirtyException, BackApplication, CharacterFullBladderException, CharacterNoEnergyException {
        Sim sim = Game.getSim();

        File file = new File("./saves/" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + ".json");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Couldn't save the game.");
        }

        try(FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(sim);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
