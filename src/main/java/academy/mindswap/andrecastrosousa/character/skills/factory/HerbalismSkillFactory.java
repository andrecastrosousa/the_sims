package academy.mindswap.andrecastrosousa.character.skills.factory;

import academy.mindswap.andrecastrosousa.character.skills.HerbalismSkill;
import academy.mindswap.andrecastrosousa.character.skills.Skill;

public class HerbalismSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new HerbalismSkill();
    }
}
