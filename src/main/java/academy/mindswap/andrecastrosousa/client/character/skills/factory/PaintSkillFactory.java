package academy.mindswap.andrecastrosousa.client.character.skills.factory;

import academy.mindswap.andrecastrosousa.client.character.skills.PaintSkill;
import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

public class PaintSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new PaintSkill();
    }
}
