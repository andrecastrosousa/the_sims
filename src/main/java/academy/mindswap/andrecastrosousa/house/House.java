package academy.mindswap.andrecastrosousa.house;

import academy.mindswap.andrecastrosousa.exceptions.HouseAlreadyCleanException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.house.state.DirtyLevel;
import academy.mindswap.andrecastrosousa.house.state.DirtyState;

import java.util.List;

public class House {

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
                '}';
    }


}
