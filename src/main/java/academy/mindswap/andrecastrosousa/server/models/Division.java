package academy.mindswap.andrecastrosousa.server.models;

import academy.mindswap.andrecastrosousa.client.house.HouseComponent;

import java.util.ArrayList;
import java.util.List;

public class Division extends Entity implements HouseComponent {
    private final String name;

    private final List<HouseComponent> houseComponents;

    public Division (String name) {
        this.name = name;
        this.houseComponents = new ArrayList<>();
    }

    public void addHouseComponent(HouseComponent houseComponent) {
        houseComponents.add(houseComponent);
    }

    public void removeHouseComponent(HouseComponent houseComponent) {
        houseComponents.add(houseComponent);
    }

    @Override
    public void interact() {

    }

    public String getName() {
        return name;
    }

    public List<HouseComponent> getDivisionComponents() {
        return houseComponents;
    }

    public int getQuantityOfFurniture() {
        return houseComponents.size();
    }

    public HouseComponent getFurniture(int index) {
        return houseComponents.get(index);
    }
}
