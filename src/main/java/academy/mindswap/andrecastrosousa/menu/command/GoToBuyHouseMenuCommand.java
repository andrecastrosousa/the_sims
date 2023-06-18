package academy.mindswap.andrecastrosousa.menu.command;

import academy.mindswap.andrecastrosousa.game.Game;
import academy.mindswap.andrecastrosousa.menu.TerminalInteraction;

public class GoToBuyHouseMenuCommand implements Command {
    @Override
    public void execute() {
        Game.setTerminalInteraction(TerminalInteraction.BUY_HOUSE_MENU);
    }
}
