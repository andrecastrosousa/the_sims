package academy.mindswap.andrecastrosousa.command.action;

public class CookAction extends Action {

    public CookAction() {
        super(ActionType.COOK);
    }

    @Override
    public String toString() {
        return "Cook";
    }
}