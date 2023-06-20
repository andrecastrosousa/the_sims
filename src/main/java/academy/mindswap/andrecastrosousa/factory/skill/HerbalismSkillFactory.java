package academy.mindswap.andrecastrosousa.factory.skill;

import academy.mindswap.andrecastrosousa.template.skill.HerbalismSkill;
import academy.mindswap.andrecastrosousa.template.skill.Skill;

public class HerbalismSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new HerbalismSkill();
    }
}
