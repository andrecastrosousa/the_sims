package academy.mindswap.andrecastrosousa.command.action;

public class PaintAction extends Action {

    public PaintAction() {
        super(ActionType.PAINT);
    }

    @Override
    public String toString() {
        return "Paint";
    }
}
