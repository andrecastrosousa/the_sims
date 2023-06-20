package academy.mindswap.andrecastrosousa.factory.skill;

import academy.mindswap.andrecastrosousa.template.skill.LogicSkill;
import academy.mindswap.andrecastrosousa.template.skill.Skill;

public class LogicSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new LogicSkill();
    }
}
