package academy.mindswap.andrecastrosousa.character.skills.level;

import academy.mindswap.andrecastrosousa.character.skills.Skill;

public class LevelSix extends SkillLevelState {
    @Override
    public void levelUp(Skill skill) {
        skill.levelUp(SkillLevel.LEVEL_7);
    }
}
