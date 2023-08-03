package academy.mindswap.andrecastrosousa.client.character.skills.factory;

import academy.mindswap.andrecastrosousa.client.character.skills.ProgrammingSkill;
import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

public class ProgrammingSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new ProgrammingSkill();
    }
}
