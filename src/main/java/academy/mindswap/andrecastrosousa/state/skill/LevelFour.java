package academy.mindswap.andrecastrosousa.state.skill;

import academy.mindswap.andrecastrosousa.template.skill.Skill;

public class LevelFour extends SkillLevelState {
    @Override
    public void levelUp(Skill skill) {
        skill.levelUp(SkillLevel.LEVEL_4);
    }
}
