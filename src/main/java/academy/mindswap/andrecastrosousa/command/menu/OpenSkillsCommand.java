package academy.mindswap.andrecastrosousa.command.menu;

import academy.mindswap.andrecastrosousa.template.skill.Skill;
import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.List;

public class OpenSkillsCommand implements Command {

    private final List<Skill> skills;

    public OpenSkillsCommand(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public void execute() {
        // Game.setMenuType(MenuType.BUY_HOUSE_MENU);
        System.out.println("\n" + Messages.SEPARATOR);
        for (Skill skill: skills) {
            System.out.println(skill);
        }
        System.out.println(Messages.SEPARATOR + "\n");
    }
}
