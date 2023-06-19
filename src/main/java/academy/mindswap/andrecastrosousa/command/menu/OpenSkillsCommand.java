package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

public class OpenSkillsCommand implements Command {
    @Override
    public void execute() {
        Game.setMenuType(MenuType.BUY_HOUSE_MENU);
    }
}
