package academy.mindswap.andrecastrosousa.template.skill;

import academy.mindswap.andrecastrosousa.state.skill.SkillLevel;
import academy.mindswap.andrecastrosousa.state.skill.SkillLevelState;

public abstract class SkillImpl implements Skill {

    private SkillLevel level;

    private int currentExp;

    @Override
    public void improve(int exp) {
        if(currentExp + exp > level.getExpToLevelUp()) {
            SkillLevelState.buildState(level).levelUp(this);
            return;
        }
        currentExp += exp;
    }

    @Override
    public void levelUp(SkillLevel level) {
        this.level = level;
    }

    @Override
    public SkillLevel getLevel() {
        return level;
    }
}
