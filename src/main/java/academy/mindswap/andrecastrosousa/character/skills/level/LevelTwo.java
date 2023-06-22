package academy.mindswap.andrecastrosousa.character.skills.level;

import academy.mindswap.andrecastrosousa.character.skills.Skill;

public class LevelTwo extends SkillLevelState {
    @Override
    public void levelUp(Skill skill) {
        skill.levelUp(SkillLevel.LEVEL_3);
    }
}
