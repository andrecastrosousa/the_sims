package academy.mindswap.andrecastrosousa.template.skill;

import academy.mindswap.andrecastrosousa.state.skill.SkillLevel;

import java.io.Serializable;

public interface Skill extends Serializable {
    void improve(int exp);

    void levelUp(SkillLevel level);

    SkillLevel getLevel();

    int getExp();

    SkillType getType();
}
