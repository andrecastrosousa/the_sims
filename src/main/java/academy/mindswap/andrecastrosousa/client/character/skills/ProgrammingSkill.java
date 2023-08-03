package academy.mindswap.andrecastrosousa.client.character.skills;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.stream.Stream;

public class ProgrammingSkill extends SkillImpl {
    public ProgrammingSkill() {
        super(SkillType.PROGRAMMING);
    }

    @Override
    public String toString() {
        int progress = 10 * currentExp / level.getExpToLevelUp();

        return "Programming: " +
                Stream.generate(() -> Messages.PROGRESS_BAR)
                    .limit(progress)
                    .reduce("", (acc, next) -> acc + next) +
                " at " + level;
    }
}
