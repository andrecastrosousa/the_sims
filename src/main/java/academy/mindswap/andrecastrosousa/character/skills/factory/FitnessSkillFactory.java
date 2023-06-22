package academy.mindswap.andrecastrosousa.character.skills.factory;

import academy.mindswap.andrecastrosousa.character.skills.FitnessSkill;
import academy.mindswap.andrecastrosousa.character.skills.Skill;

public class FitnessSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new FitnessSkill();
    }
}
