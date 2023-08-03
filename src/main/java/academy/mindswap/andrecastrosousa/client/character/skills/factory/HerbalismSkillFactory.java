package academy.mindswap.andrecastrosousa.client.character.skills.factory;

import academy.mindswap.andrecastrosousa.client.character.skills.HerbalismSkill;
import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

public class HerbalismSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new HerbalismSkill();
    }
}
