package academy.mindswap.andrecastrosousa.client.character.skills.factory;

import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

import java.util.ArrayList;
import java.util.List;

public abstract class SkillFactoryImpl implements SkillFactory {

    @Override
    public abstract Skill createSkill();

    public static List<Skill> createBaseSkills() {
        return new ArrayList<>(List.of(
                new CookingSkillFactory().createSkill(),
                new FitnessSkillFactory().createSkill(),
                new HerbalismSkillFactory().createSkill(),
                new LogicSkillFactory().createSkill(),
                new PaintSkillFactory().createSkill(),
                new ProgrammingSkillFactory().createSkill()
        ));
    }
}
