package academy.mindswap.andrecastrosousa.character;

import academy.mindswap.andrecastrosousa.bank.Account;
import academy.mindswap.andrecastrosousa.house.House;

public class Character {
    private String name;

    private Gender gender;

    private Account account;

    private House house;

    public Account getAccount() {
        return account;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
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
}
