package academy.mindswap.andrecastrosousa.factory.skill;

import academy.mindswap.andrecastrosousa.template.skill.FitnessSkill;
import academy.mindswap.andrecastrosousa.template.skill.Skill;

public class FitnessSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new FitnessSkill();
    }
}
