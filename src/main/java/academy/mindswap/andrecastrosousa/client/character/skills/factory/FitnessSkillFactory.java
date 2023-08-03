package academy.mindswap.andrecastrosousa.client.character.skills.factory;

import academy.mindswap.andrecastrosousa.client.character.skills.FitnessSkill;
import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

public class FitnessSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new FitnessSkill();
    }
}
