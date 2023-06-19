package academy.mindswap.andrecastrosousa.DB;

import academy.mindswap.andrecastrosousa.action.command.ActionType;
import academy.mindswap.andrecastrosousa.action.command.CookAction;
import academy.mindswap.andrecastrosousa.action.command.PeeAction;
import academy.mindswap.andrecastrosousa.action.command.SleepAction;
import academy.mindswap.andrecastrosousa.character.needs.*;
import academy.mindswap.andrecastrosousa.house.Division;
import academy.mindswap.andrecastrosousa.house.House;

import java.util.ArrayList;
import java.util.List;

public class Database {

    /*public static List<Action> actions = new ArrayList<>(List.of(
            new Action(ActionType.COOK),
            new Action(ActionType.PAINT),
            new Action(ActionType.EAT),
            new Action(ActionType.PEE),
            new Action(ActionType.SLEEP),
            new Action(ActionType.WORK),
            new Action(ActionType.WATCH_TV)
    ));*/

    public static List<NeedStatus> needs = new ArrayList<>(List.of(
            new BladderStatusImpl(),
            new EnergyStatusImpl(),
            new FunStatusImpl(),
            new HungerStatusImpl(),
            new HygieneStatusImpl()
    ));

    public static List<House> houses = new ArrayList<>(List.of(
       new House(new ArrayList<>(List.of(
               new Division("Bedroom", new SleepAction(needs),  10, 20),
               new Division("Bathroom", new PeeAction(needs), 10, 20),
               new Division("Cousine", new CookAction(needs), 10, 20)
       )), 10000),
       new House(new ArrayList<>(List.of(
               new Division("Bedroom", new SleepAction(needs),  10, 20),
               new Division("Bathroom", new PeeAction(needs), 10, 20),
               new Division("Cousine", new CookAction(needs), 10, 20)
       )), 100000),
       new House(new ArrayList<>(List.of(
               new Division("Bedroom", new SleepAction(needs), 10, 20),
               new Division("Bathroom", new PeeAction(needs), 10, 20),
               new Division("Cousine", new CookAction(needs), 10, 20)
       )), 1000000)
    ));

    private Database() {};
}
