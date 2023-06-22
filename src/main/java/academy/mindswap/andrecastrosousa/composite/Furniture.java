package academy.mindswap.andrecastrosousa.composite;

import academy.mindswap.andrecastrosousa.command.action.Action;
import academy.mindswap.andrecastrosousa.command.action.ActionCommand;
import academy.mindswap.andrecastrosousa.domain.enums.ActionType;
import academy.mindswap.andrecastrosousa.domain.Game;
import academy.mindswap.andrecastrosousa.domain.Sim;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.strategy.needs.NeedStaminaChecker;
import academy.mindswap.andrecastrosousa.template.need.NeedStatus;
import academy.mindswap.andrecastrosousa.template.skill.SkillType;

public class Furniture implements HouseComponent {

    private final String name;

    private final ActionCommand action;

    private final int exp;

    public Furniture(String name, ActionCommand action, int exp) {
        this.name = name;
        this.action = action;
        this.exp = exp;
    }

    @Override
    public String getName() {
        return name;
    }

    public ActionCommand getAction() {
        return action;
    }

    public ActionType getActionType() {
        return action.getType();
    }

    public SkillType getSkillType() {
        return ((Action) action).getSkillType();
    }

    public int getStaminaCost(NeedStatus need) {
        return ((Action) action).getStaminaCost(need);
    }

    @Override
    public void interact() throws CharacterNoEnergyException, CharacterFullBladderException {
        Sim sim = Game.getSim();

        NeedStaminaChecker checker = new NeedStaminaChecker(sim.getNeeds());
        checker.checkStamina(action.getType());



        sim.getSkills().stream()
                .filter(s -> s.getType() == ((Action)action).getSkillType())
                .findFirst()
                .ifPresent(skill -> skill.improve(30));

        for(NeedStatus needStatus: sim.getNeeds()) {
            int staminaCost = ((Action)action).getStaminaCost(needStatus);
            needStatus.update(staminaCost);
        }
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", action=" + action +
                ", exp=" + exp +
                '}';
    }
}
