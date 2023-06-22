package academy.mindswap.andrecastrosousa.character.skills.level;

import academy.mindswap.andrecastrosousa.character.skills.Skill;

public class LevelNine extends SkillLevelState {
    @Override
    public void levelUp(Skill skill) {
        skill.levelUp(SkillLevel.LEVEL_10);
    }
}
