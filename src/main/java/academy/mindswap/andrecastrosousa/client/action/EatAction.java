package academy.mindswap.andrecastrosousa.client.action;


import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

public class EatAction extends Action {

    public EatAction() {
        super(ActionType.EAT);
    }

    @Override
    public String toString() {
        return "Eat";
    }
}
