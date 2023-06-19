package academy.mindswap.andrecastrosousa.state.menu;

import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.enums.MenuType;

public class ActionMenuState extends MenuState {
    @Override
    public void back() {
        Game.setMenuType(MenuType.SIM_MENU);
    }
}
