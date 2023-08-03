package academy.mindswap.andrecastrosousa.server.models;

import academy.mindswap.andrecastrosousa.client.exceptions.HouseAlreadyCleanException;
import academy.mindswap.andrecastrosousa.client.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.client.house.dirty.DirtyLevel;
import academy.mindswap.andrecastrosousa.client.house.dirty.DirtyState;

import java.io.Serializable;
import java.util.List;

public class House extends Entity implements Serializable {

    private final List<Division> divisions;
    private final double cost;
    private DirtyLevel dirtyLevel;

    public House(List<Division> divisions, double cost) {
        this.divisions = divisions;
        this.cost = cost;
        this.dirtyLevel = DirtyLevel.CLEAN;
    }

    public double getCost() {
        return cost;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public DirtyLevel getDirtyLevel() {
        return dirtyLevel;
    }

    public void setDirtyLevel(DirtyLevel dirtyLevel) {
        this.dirtyLevel = dirtyLevel;
    }

    public Division getDivision(int index) {
        return divisions.get(index);
    }

    public int getNumberOfDivisions() {
        return divisions.size();
    }

    public void increaseDirtyLevel() throws HouseTooDirtyException {
        DirtyState.buildState(this).mess();
    }

    public void decreaseDirtyLevel() throws HouseAlreadyCleanException {
        DirtyState.buildState(this).clean();
    }

    @Override
    public String toString() {
        return "House{" +
                "divisions=" + divisions +
                ", cost=" + cost +
                ", dirtyLevel=" + dirtyLevel +
                '}';
    }


}
