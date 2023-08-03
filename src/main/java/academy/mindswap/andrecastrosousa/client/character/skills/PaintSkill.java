package academy.mindswap.andrecastrosousa.client.character.skills;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.stream.Stream;

public class PaintSkill extends SkillImpl {
    public PaintSkill() {
        super(SkillType.PAINT);
    }

    @Override
    public String toString() {
        int progress = 10 * currentExp / level.getExpToLevelUp();

        return "Paint: " +
                Stream.generate(() -> Messages.PROGRESS_BAR)
                        .limit(progress)
                        .reduce("", (acc, next) -> acc + next) +
                " at " + level;
    }
}
