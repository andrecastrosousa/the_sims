package academy.mindswap.andrecastrosousa.factory.skill;

import academy.mindswap.andrecastrosousa.template.skill.PaintSkill;
import academy.mindswap.andrecastrosousa.template.skill.Skill;

public class PaintSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new PaintSkill();
    }
}
