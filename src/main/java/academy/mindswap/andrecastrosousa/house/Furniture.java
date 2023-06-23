package academy.mindswap.andrecastrosousa.house;

import academy.mindswap.andrecastrosousa.action.Action;
import academy.mindswap.andrecastrosousa.action.ActionCommand;
import academy.mindswap.andrecastrosousa.menu.enums.ActionType;
import academy.mindswap.andrecastrosousa.Game;
import academy.mindswap.andrecastrosousa.character.Sim;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.character.needs.NeedStaminaChecker;
import academy.mindswap.andrecastrosousa.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.character.skills.SkillType;

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
