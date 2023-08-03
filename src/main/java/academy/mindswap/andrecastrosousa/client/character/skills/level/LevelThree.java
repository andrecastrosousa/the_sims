package academy.mindswap.andrecastrosousa.client.character.skills.level;

import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

public class LevelThree extends SkillLevelState {
    @Override
    public void levelUp(Skill skill) {
        skill.levelUp(SkillLevel.LEVEL_4);
    }
}
