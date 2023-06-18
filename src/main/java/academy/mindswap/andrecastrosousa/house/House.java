package academy.mindswap.andrecastrosousa.house;

import java.util.List;

public class House {

    private final List<Division> divisions;
    private final double cost;

    public House(List<Division> divisions, double cost) {
        this.divisions = divisions;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public List<Division> getDivisions() {
        return divisions;
    }
}
