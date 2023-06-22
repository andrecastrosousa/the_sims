package academy.mindswap.andrecastrosousa.character.skills.factory;

import academy.mindswap.andrecastrosousa.character.skills.LogicSkill;
import academy.mindswap.andrecastrosousa.character.skills.Skill;

public class LogicSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new LogicSkill();
    }
}
