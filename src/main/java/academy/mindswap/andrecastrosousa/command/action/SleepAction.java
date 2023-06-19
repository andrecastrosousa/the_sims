package academy.mindswap.andrecastrosousa.command.action;

public class SleepAction extends Action {

    public SleepAction() {
        super(ActionType.SLEEP);
    }

    @Override
    public String toString() {
        return "Sleep";
    }
}
