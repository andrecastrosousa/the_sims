package academy.mindswap.andrecastrosousa.client.character.skills.factory;

import academy.mindswap.andrecastrosousa.client.character.skills.CookingSkill;
import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

public class CookingSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new CookingSkill();
    }
}
