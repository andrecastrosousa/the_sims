package academy.mindswap.andrecastrosousa.server.models;

import academy.mindswap.andrecastrosousa.server.Database;
import academy.mindswap.andrecastrosousa.client.character.needs.status.NeedStatus;
import academy.mindswap.andrecastrosousa.client.character.skills.factory.SkillFactoryImpl;
import academy.mindswap.andrecastrosousa.client.house.HouseComponent;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.client.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.client.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.client.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.client.character.skills.Skill;

import java.io.Serializable;
import java.util.List;

public class Sim extends Entity implements Serializable {
    private String name;

    private Gender gender;

    private Account account;

    private House house;

    private List<NeedStatus> needs;

    private final List<Skill> skills;

    private Division currentDivision;

    public Sim(String name, Gender gender, Account account, House house) {
        this.name = name;
        this.gender = gender;
        this.account = account;
        this.house = house;
        skills = SkillFactoryImpl.createBaseSkills();
    }

    public Sim() {
        skills = SkillFactoryImpl.createBaseSkills();
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public double getBalance() {
        return account.getBalance();
    }

    public void setNeeds(List<NeedStatus> needs) {
        this.needs = needs;
    }

    public List<NeedStatus> getNeeds() {
        return needs;
    }

    public Account getAccount() {
        return account;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Division> getHouseDivisions() {
        return house.getDivisions();
    }

    public Division getHouseDivision(int index) {
        return house.getDivision(index);
    }

    public int getNumberOfDivisions() {
        return house.getNumberOfDivisions();
    }

    public void interactWith(HouseComponent houseComponent) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException {
        houseComponent.interact();

        house.increaseDirtyLevel();
    }

    public void pay(double amount) throws NoFundsEnoughtException {
        account.pay(amount);
    }

    public void goToDivision(Division currentDivision) {
        this.currentDivision = currentDivision;
    }

    public List<HouseComponent> getFurnitureFromCurrentDivision() {
        return currentDivision.getDivisionComponents();
    }

    public int getQuantityOfFurnitureInCurrentDivision() {
        return currentDivision.getQuantityOfFurniture();
    }

    public HouseComponent getFurnitureInCurrentDivision(int index) {
        return currentDivision.getFurniture(index);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", account=" + account +
                ", house=" + house +
                ", needs=" + needs +
                ", skills=" + skills +
                '}';
    }
}
