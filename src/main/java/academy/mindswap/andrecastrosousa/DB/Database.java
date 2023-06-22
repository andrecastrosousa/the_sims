package academy.mindswap.andrecastrosousa.DB;

import academy.mindswap.andrecastrosousa.character.needs.status.*;
import academy.mindswap.andrecastrosousa.command.action.*;
import academy.mindswap.andrecastrosousa.house.Division;
import academy.mindswap.andrecastrosousa.house.Furniture;
import academy.mindswap.andrecastrosousa.house.House;
import academy.mindswap.andrecastrosousa.action.*;

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
            generateDivisionsPerHouse(10000),
            generateDivisionsPerHouse(100000),
            generateDivisionsPerHouse(1000000)
    ));


    private static House generateDivisionsPerHouse(int cost) {
        Division bedroom = new Division("Bedroom");
        Division bathroom = new Division("Bathroom");
        Division kitchen = new Division("Kitchen");

        Furniture table = new Furniture("Table", new EatAction(), 20);
        Furniture stove = new Furniture("Stove", new CookAction(), 30);

        kitchen.addHouseComponent(table);
        kitchen.addHouseComponent(stove);

        Furniture toilet = new Furniture("Toilet", new PeeAction(), 40);
        Furniture shower = new Furniture("Shower", new HygieneAction(), 0);

        bathroom.addHouseComponent(toilet);
        bathroom.addHouseComponent(shower);

        Furniture bed = new Furniture("Bed", new SleepAction(), 20);
        Furniture desk = new Furniture("Desk", new WorkAction(), 20);

        bedroom.addHouseComponent(bed);
        bedroom.addHouseComponent(desk);

        return new House(new ArrayList<>(List.of(bedroom, bathroom, kitchen)), cost);
    }

    private Database() {};
}
