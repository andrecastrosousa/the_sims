package academy.mindswap.andrecastrosousa.DB;

import academy.mindswap.andrecastrosousa.command.action.CookAction;
import academy.mindswap.andrecastrosousa.command.action.PeeAction;
import academy.mindswap.andrecastrosousa.command.action.SleepAction;
import academy.mindswap.andrecastrosousa.domain.Division;
import academy.mindswap.andrecastrosousa.domain.House;
import academy.mindswap.andrecastrosousa.template.*;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<NeedStatus> needs = new ArrayList<>(List.of(
            new BladderStatus(),
            new EnergyStatus(),
            new FunStatus(),
            new HungerStatus(),
            new HygieneStatus()
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
