package academy.mindswap.andrecastrosousa.menu.state;

import academy.mindswap.andrecastrosousa.game.Game;
import academy.mindswap.andrecastrosousa.menu.MenuType;

public class SimMenuState extends MenuState {
    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
