package academy.mindswap.andrecastrosousa.DB;

import academy.mindswap.andrecastrosousa.action.command.CookAction;
import academy.mindswap.andrecastrosousa.action.command.PeeAction;
import academy.mindswap.andrecastrosousa.action.command.SleepAction;
import academy.mindswap.andrecastrosousa.character.needs.*;
import academy.mindswap.andrecastrosousa.house.Division;
import academy.mindswap.andrecastrosousa.house.House;

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
               new Division("Bedroom", new SleepAction(),  10, 20),
               new Division("Bathroom", new PeeAction(), 10, 20),
               new Division("Cousine", new CookAction(), 10, 20)
       )), 10000),
       new House(new ArrayList<>(List.of(
               new Division("Bedroom", new SleepAction(),  10, 20),
               new Division("Bathroom", new PeeAction(), 10, 20),
               new Division("Cousine", new CookAction(), 10, 20)
       )), 100000),
       new House(new ArrayList<>(List.of(
               new Division("Bedroom", new SleepAction(), 10, 20),
               new Division("Bathroom", new PeeAction(), 10, 20),
               new Division("Cousine", new CookAction(), 10, 20)
       )), 1000000)
    ));

    private Database() {};
}
