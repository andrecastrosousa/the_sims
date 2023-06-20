package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.DB.Database;
import academy.mindswap.andrecastrosousa.exceptions.CharacterFullBladderException;
import academy.mindswap.andrecastrosousa.exceptions.CharacterNoEnergyException;
import academy.mindswap.andrecastrosousa.exceptions.HouseTooDirtyException;
import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;
import academy.mindswap.andrecastrosousa.factory.skill.SkillFactoryImpl;
import academy.mindswap.andrecastrosousa.strategy.needs.NeedStaminaChecker;
import academy.mindswap.andrecastrosousa.template.need.NeedStatus;
import academy.mindswap.andrecastrosousa.template.skill.Skill;

import java.util.List;

public class Character {
    private String name;

    private Gender gender;

    private Account account;

    private House house;

    private List<NeedStatus> needs;

    private final List<Skill> skills;

    public Character() {
        needs = Database.needs;
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

    public List<Skill> getSkills() {
        return skills;
    }

    public void goTo(Division division) throws CharacterFullBladderException, HouseTooDirtyException, CharacterNoEnergyException {

        NeedStaminaChecker checker = new NeedStaminaChecker(needs);
        checker.checkStamina(division.getAction().getType());

        house.increaseDirtyLevel();

        Skill skill = skills.stream()
                .filter(s -> s.getType() == division.getAction().getType().getSkillType())
                .findFirst()
                .orElse(null);

        if(skill != null) {
            skill.improve(30);
        }

        for(NeedStatus needStatus: needs) {
            int staminaCost = division.getAction().getType().getStaminaCost(needStatus);
            needStatus.update(staminaCost);
        }
    }

    public void pay(double amount) throws NoFundsEnoughtException {
        account.pay(amount);
    }
}
