package academy.mindswap.andrecastrosousa.menu.option;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.character.Character;
import academy.mindswap.andrecastrosousa.house.House;
import academy.mindswap.andrecastrosousa.menu.command.BuyHouseCommand;
import academy.mindswap.andrecastrosousa.menu.command.Command;
import academy.mindswap.andrecastrosousa.menu.command.ExitCommand;

import java.util.Arrays;

public enum BuyHouseMenuOption {
    FIRST_HOUSE(1, null),
    SECOND_HOUSE(2, null),
    THIRD_HOUSE(3, null),
    UNKNOWN_HOUSE;

    private final int option;

    private final House house;

    BuyHouseMenuOption() {
        option = 0;
        house = null;
    }

    BuyHouseMenuOption(int option, House house) {
        this.option = option;
        this.house = Database.houses.get(option - 1);
    }

    public static BuyHouseMenuOption getEnumByOption(int option) {
        return Arrays.stream(BuyHouseMenuOption.values())
                .filter(o -> o.option == option)
                .findFirst().orElse(UNKNOWN_HOUSE);
    }

    public static Command execute(int option, Character character) {
        BuyHouseMenuOption houseMenu = getEnumByOption(option);

        return switch (houseMenu) {
            case FIRST_HOUSE, SECOND_HOUSE, THIRD_HOUSE -> new BuyHouseCommand(character, houseMenu.house);
            default -> new ExitCommand();
        };
    }

    public int getOption() {
        return option;
    }

    public House getHouse() {
        return house;
    }
}
