package academy.mindswap.andrecastrosousa.character.skills.level;

import academy.mindswap.andrecastrosousa.character.skills.Skill;

public abstract class SkillLevelState implements SkillState {

    public static SkillState buildState(SkillLevel level) {
        return switch (level) {
            case LEVEL_1 -> new LevelOne();
            case LEVEL_2 -> new LevelTwo();
            case LEVEL_3 -> new LevelThree();
            case LEVEL_4 -> new LevelFour();
            case LEVEL_5 -> new LevelFive();
            case LEVEL_6 -> new LevelSix();
            case LEVEL_7 -> new LevelSeven();
            case LEVEL_8 -> new LevelEight();
            case LEVEL_9 -> new LevelNine();
            case LEVEL_10 -> new LevelTen();
        };
    }

    @Override
    public abstract void levelUp(Skill skill);
}
