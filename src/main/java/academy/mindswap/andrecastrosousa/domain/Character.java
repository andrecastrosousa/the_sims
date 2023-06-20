package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.command.action.ActionCommand;
import academy.mindswap.andrecastrosousa.command.action.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.strategy.needs.NeedStaminaChecker;
import academy.mindswap.andrecastrosousa.template.NeedStatus;
import academy.mindswap.andrecastrosousa.template.NeedsType;

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

    public Account getAccount() {
        return account;
    }

    public void goTo(Division division) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException {

        NeedStaminaChecker checker = new NeedStaminaChecker(needs);
        checker.checkStamina(division.getAction().getType());

        house.increaseDirtyLevel();

        for(NeedStatus needStatus: needs) {
            int staminaCost = division.getAction().getType().getStaminaCost(needStatus);
            needStatus.update(staminaCost);
        }
    }

    public void pay(double amount) throws NoFundsEnoughtException {
        account.pay(amount);
    }
}
