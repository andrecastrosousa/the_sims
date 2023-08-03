package academy.mindswap.andrecastrosousa.client.character.skills.factory;

import academy.mindswap.andrecastrosousa.client.character.skills.LogicSkill;
import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

public class LogicSkillFactory extends SkillFactoryImpl {
    @Override
    public Skill createSkill() {
        return new LogicSkill();
    }
}
