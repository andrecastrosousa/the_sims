package academy.mindswap.andrecastrosousa.menu.state;

import academy.mindswap.andrecastrosousa.game.Game;
import academy.mindswap.andrecastrosousa.menu.MenuType;

public class HouseMenuState extends MenuState {
    @Override
    public void back() {
        Game.setMenuType(MenuType.STARTER_MENU);
    }
}
