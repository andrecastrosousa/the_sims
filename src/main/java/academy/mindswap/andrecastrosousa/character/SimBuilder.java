package academy.mindswap.andrecastrosousa.character;

import academy.mindswap.andrecastrosousa.house.House;

public class SimBuilder {

    private String name;

    private Gender gender;

    private Account account;

    private House house;

    public SimBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SimBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public SimBuilder setAccount(Account account) {
        this.account = account;
        return this;
    }

    public SimBuilder setHouse(House house) {
        this.house = house;
        return this;
    }

    public Sim build() {
        return new Sim(name, gender, account, house);
    }
}
