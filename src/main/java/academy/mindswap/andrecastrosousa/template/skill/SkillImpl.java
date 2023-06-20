package academy.mindswap.andrecastrosousa.template.skill;

import academy.mindswap.andrecastrosousa.state.skill.SkillLevel;
import academy.mindswap.andrecastrosousa.state.skill.SkillLevelState;

public abstract class SkillImpl implements Skill {

    protected SkillLevel level;

    protected int currentExp;

    protected SkillType type;

    public SkillImpl(SkillType type) {
        level = SkillLevel.LEVEL_1;
        currentExp = 0;
        this.type = type;
    }

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

    @Override
    public abstract String toString();

    @Override
    public SkillType getType() {
        return type;
    }
}
