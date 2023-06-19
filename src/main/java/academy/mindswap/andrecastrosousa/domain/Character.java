package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.command.action.ActionCommand;
import academy.mindswap.andrecastrosousa.command.action.ActionType;
import academy.mindswap.andrecastrosousa.state.needs.NeedStatus;

import java.util.List;

public class Character {
    private String name;

    private Gender gender;

    private Account account;

    private House house;

    private List<NeedStatus> needs;

    public Character() {
        needs = Database.needs;
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

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<ActionCommand> getActions (){
        List<ActionCommand> commands = new java.util.ArrayList<>(house.getDivisions().stream()
                .map(Division::getAction)
                .toList());

        commands.addAll(ActionType.getActionsWithoutDivisions().stream()
                .map(a -> a.getAction(needs))
                .toList()
        );

        return commands;
    }
}
