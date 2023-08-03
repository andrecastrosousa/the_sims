package academy.mindswap.andrecastrosousa.client.action;


import academy.mindswap.andrecastrosousa.client.menu.enums.ActionType;

public class CookAction extends Action {

    public CookAction() {
        super(ActionType.COOK);
    }

    @Override
    public String toString() {
        return "Cook";
    }
}