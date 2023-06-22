package academy.mindswap.andrecastrosousa.character.skills;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.stream.Stream;

public class CookingSkill extends SkillImpl {
    public CookingSkill() {
        super(SkillType.COOKING);
    }

    @Override
    public String toString() {
        int progress = 10 * currentExp / level.getExpToLevelUp();

        return "Cooking: " +
                Stream.generate(() -> Messages.PROGRESS_BAR)
                        .limit(progress)
                        .reduce("", (acc, next) -> acc + next) +
                " at " + level;
    }
}
