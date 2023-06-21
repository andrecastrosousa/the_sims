package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SaveCommand implements Command {

    @Override
    public void execute() {
        Sim sim = Game.getSim();

        File dir = new File("./saves");
        if(!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(dir.getPath() + "/" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + ".json");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Couldn't save the game.");
        }

        try(FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(sim);
            objectOut.close();
            System.out.println("The game was successfully saved.");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
