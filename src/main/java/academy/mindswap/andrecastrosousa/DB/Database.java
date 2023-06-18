package academy.mindswap.andrecastrosousa.DB;

import academy.mindswap.andrecastrosousa.action.Action;
import academy.mindswap.andrecastrosousa.action.ActionType;
import academy.mindswap.andrecastrosousa.action.Skill;
import academy.mindswap.andrecastrosousa.house.House;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Action> actions = new ArrayList<>(List.of(
            new Action(ActionType.COOK),
            new Action(ActionType.PAINT),
            new Action(ActionType.EAT),
            new Action(ActionType.PEE),
            new Action(ActionType.SLEEP),
            new Action(ActionType.WORK),
            new Action(ActionType.WATCH_TV)
    ));

    private Database() {};
}
