package academy.mindswap.andrecastrosousa.template.skill;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.stream.Stream;

public class LogicSkill extends SkillImpl {
    public LogicSkill() {
        super(SkillType.LOGIC);
    }

    @Override
    public String toString() {
        int progress = 10 * currentExp / level.getExpToLevelUp();

        return "Logic: " +
                Stream.generate(() -> Messages.PROGRESS_BAR)
                        .limit(progress)
                        .reduce("", (acc, next) -> acc + next) +
                " at " + level;
    }
}
