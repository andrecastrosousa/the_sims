package academy.mindswap.andrecastrosousa.menu;

import java.util.Arrays;

public enum StartMenu implements Menu {
    ENTER(1),
    BUY_HOUSE(2),
    EXIT;

    private final int option;

    StartMenu() {
        option = 0;
    }

    StartMenu(int option) {
        this.option = option;
    }

    @Override
    public Command execute(int option) {
        StartMenu startMenuOption = Arrays.stream(StartMenu.values())
                .filter(o -> o.option == option)
                .findFirst().orElse(EXIT);

        return switch (startMenuOption) {
            case ENTER -> new StartCommand();
            case BUY_HOUSE -> new BuyHouseCommand();
            default -> new ExitCommand();
        };
    }
}
