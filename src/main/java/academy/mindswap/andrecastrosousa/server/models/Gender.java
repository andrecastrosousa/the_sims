package academy.mindswap.andrecastrosousa.server.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum Gender implements Serializable {
    MALE(0, "Male"),
    FEMALE(1, "Female"),
    UNDEFINED(2, "Undefiend"),
    UNKNOWN;

    private int option;

    private String message;

    Gender() {
    }

    Gender(int option, String message) {
        this.option = option;
        this.message = message;
    }

    public static Gender getEnumByOption(int option) {
        return Arrays.stream(Gender.values())
                .filter(o -> o.option == option)
                .findFirst()
                .orElse(UNKNOWN);
    }

    public static List<String> getMenuOptions() {
        return Arrays.stream(Gender.values())
                .filter(o -> o != Gender.UNKNOWN)
                .map(Gender::getMessage)
                .toList();
    }

    public String getMessage() {
        return message;
    }
}
