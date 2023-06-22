package academy.mindswap.andrecastrosousa.character.skills.factory;

import academy.mindswap.andrecastrosousa.character.skills.CookingSkill;
import academy.mindswap.andrecastrosousa.character.skills.Skill;

public class CookingSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new CookingSkill();
    }
}
