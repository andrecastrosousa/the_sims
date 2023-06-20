package academy.mindswap.andrecastrosousa.state.skill;

import academy.mindswap.andrecastrosousa.template.skill.Skill;

public class LevelEight extends SkillLevelState {
    @Override
    public void levelUp(Skill skill) {
        skill.levelUp(SkillLevel.LEVEL_8);
    }
}
