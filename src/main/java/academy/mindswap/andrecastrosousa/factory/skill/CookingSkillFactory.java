package academy.mindswap.andrecastrosousa.factory.skill;

import academy.mindswap.andrecastrosousa.template.skill.CookingSkill;
import academy.mindswap.andrecastrosousa.template.skill.Skill;

public class CookingSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new CookingSkill();
    }
}
