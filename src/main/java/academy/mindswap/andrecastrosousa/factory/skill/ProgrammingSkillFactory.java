package academy.mindswap.andrecastrosousa.factory.skill;

import academy.mindswap.andrecastrosousa.template.skill.ProgrammingSkill;
import academy.mindswap.andrecastrosousa.template.skill.Skill;

public class ProgrammingSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new ProgrammingSkill();
    }
}
