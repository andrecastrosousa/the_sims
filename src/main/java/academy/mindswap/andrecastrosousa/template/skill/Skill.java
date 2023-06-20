package academy.mindswap.andrecastrosousa.template.skill;

import academy.mindswap.andrecastrosousa.state.skill.SkillLevel;

public interface Skill {
    void improve(int exp);

    void levelUp(SkillLevel level);

    SkillLevel getLevel();
}
