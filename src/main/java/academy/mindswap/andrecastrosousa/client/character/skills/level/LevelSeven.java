package academy.mindswap.andrecastrosousa.client.character.skills.level;

import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

public class LevelSeven extends SkillLevelState {
    @Override
    public void levelUp(Skill skill) {
        skill.levelUp(SkillLevel.LEVEL_8);
    }
}
