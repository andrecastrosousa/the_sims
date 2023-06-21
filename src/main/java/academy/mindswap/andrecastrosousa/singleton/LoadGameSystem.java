package academy.mindswap.andrecastrosousa.singleton;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadGameSystem {

    private static LoadGameSystem instance;

    private File[] games;

    private LoadGameSystem() {
        games = getGames();
    }

    public static LoadGameSystem getInstance() {
        if(instance == null) {
            synchronized (LoadGameSystem.class) {
                if(instance == null) {
                    instance = new LoadGameSystem();
                }
            }
        }

        return instance;
    }

    private File[] getGames() {
        File dir = new File("./saves");

        File[] files = dir.listFiles();

        if(files == null) {
            return new File[0];
        }

        return files;
    }

    public List<String> getLoadGameOptions() {
        return Arrays.stream(games).map(file -> file.getName() +
                " | last modified: " + LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(file.lastModified()),
                ZoneId.systemDefault())
        ).toList();
    }

    public File getSavedFile(int index) {
        return games[index];
    }
}
