package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.command.action.ActionCommand;
import academy.mindswap.andrecastrosousa.command.action.ActionType;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
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

    public List<ActionCommand> getActions (){
        List<ActionCommand> commands = new java.util.ArrayList<>(house.getDivisions().stream()
                .map(Division::getAction)
                .toList());

        commands.addAll(ActionType.getActionsWithoutDivisions().stream()
                .map(ActionType::getAction)
                .toList()
        );

        return commands;
    }

    public Account getAccount() {
        return account;
    }

    public void goTo(Division division) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException {
        NeedStatus peeStatus = needs.stream()
                .filter(n -> n.getType() == NeedsType.BLADDER)
                .findFirst()
                .orElse(null);

        if(peeStatus != null && peeStatus.getStamina() == 0 && division.getAction().getType() != ActionType.PEE) {
            throw new CharacterFullBladderException();
        }

        NeedStatus energyStatus = needs.stream()
                .filter(n -> n.getType() == NeedsType.ENERGY)
                .findFirst()
                .orElse(null);

        if(energyStatus != null && energyStatus.getStamina() == 0 && division.getAction().getType() != ActionType.SLEEP) {
            throw new CharacterNoEnergyException();
        }

        house.increaseDirtyLevel();

        for(NeedStatus needStatus: needs) {
            int staminaCost = division.getAction().getType().getStaminaCost(needStatus);
            needStatus.update(staminaCost);
        }
    }

    public void pay(int amount) throws NoFundsEnoughtException {
        account.pay(amount);
    }
}
