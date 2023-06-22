package academy.mindswap.andrecastrosousa.character.skills.factory;

import academy.mindswap.andrecastrosousa.character.skills.PaintSkill;
import academy.mindswap.andrecastrosousa.character.skills.Skill;

public class PaintSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new PaintSkill();
    }
}
