package academy.mindswap.andrecastrosousa.client.action;

import academy.mindswap.andrecastrosousa.server.models.Furniture;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.client.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.client.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.client.character.skills.SkillType;
import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

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
