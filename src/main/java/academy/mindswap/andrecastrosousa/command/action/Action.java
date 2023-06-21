package academy.mindswap.andrecastrosousa.command.action;

import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Division;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.template.need.NeedStatus;
import academy.mindswap.andrecastrosousa.template.skill.SkillType;

public abstract class Action implements ActionCommand {

    protected final ActionType type;

    public Action(ActionType type) {
        this.type = type;
    };

    @Override
    public void perform(Division division) throws CharacterNoEnergyException, CharacterFullBladderException, HouseTooDirtyException {
        Game.getSim().goTo(division);
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
