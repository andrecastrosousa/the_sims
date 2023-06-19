package academy.mindswap.andrecastrosousa.menu.state;

import academy.mindswap.andrecastrosousa.game.Game;
import academy.mindswap.andrecastrosousa.menu.MenuType;

public class ActionMenuState extends MenuState {
    @Override
    public void back() {
        Game.setMenuType(MenuType.BUY_HOUSE_MENU);
    }
}
