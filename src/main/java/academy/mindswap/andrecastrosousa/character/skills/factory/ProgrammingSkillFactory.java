package academy.mindswap.andrecastrosousa.character.skills.factory;

import academy.mindswap.andrecastrosousa.character.skills.ProgrammingSkill;
import academy.mindswap.andrecastrosousa.character.skills.Skill;

public class ProgrammingSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new ProgrammingSkill();
    }
}
