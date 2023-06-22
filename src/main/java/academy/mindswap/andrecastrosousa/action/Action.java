package academy.mindswap.andrecastrosousa.action;

import academy.mindswap.andrecastrosousa.house.Furniture;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.menu.enums.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.character.skills.SkillType;

public abstract class Action implements ActionCommand {

    protected final ActionType type;

    public Action(ActionType type) {
        this.type = type;
    };

    @Override
    public void interact(Furniture furniture) throws CharacterNoEnergyException, CharacterFullBladderException, HouseTooDirtyException {
        Game.getSim().interactWith(furniture);
    }

    @Override
    public ActionType getType() {
        return type;
    }

    public SkillType getSkillType() {
        return type.getSkillType();
    }

    public int getStaminaCost(NeedStatus need) {
        return type.getStaminaCost(need);
    }
}
