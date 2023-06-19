package academy.mindswap.andrecastrosousa.character;

import academy.mindswap.andrecastrosousa.bank.Account;
import academy.mindswap.andrecastrosousa.character.needs.*;
import academy.mindswap.andrecastrosousa.house.House;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;

    private Gender gender;

    private Account account;

    private House house;

    private final List<NeedStatus> actions;

    public Character() {
        actions = new ArrayList<>(List.of(
                new BladderStatusImpl(),
                new EnergyStatusImpl(),
                new FunStatusImpl(),
                new HungerStatusImpl(),
                new HygieneStatusImpl()
        ));
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
        List<NeedStatus> filteredActions = actions.stream()
                .filter(a -> !this.actions.contains(a))
                .toList();
        this.actions.addAll(filteredActions);
    }

    public List<NeedStatus> getNeeds() {
        return actions;
    }
}
