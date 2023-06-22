package academy.mindswap.andrecastrosousa.character.skills;

import academy.mindswap.andrecastrosousa.character.skills.level.SkillLevel;

import java.io.Serializable;

public interface Skill extends Serializable {
    void improve(int exp);

    void levelUp(SkillLevel level);

    SkillLevel getLevel();

    SkillType getType();
}
