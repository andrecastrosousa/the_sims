package academy.mindswap.andrecastrosousa.template.need;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.stream.Stream;

public class BladderStatus extends NeedStatusImpl {
    public BladderStatus() {
        super(NeedsType.BLADDER);
    }

    @Override
    public String toString() {
        int progress = stamina / 10;

        return "Bladder: " +
                Stream.generate(() -> Messages.PROGRESS_BAR)
                    .limit(progress)
                    .reduce("", (acc, next) -> acc + next) +
                "  " + stamina + "%";
    }
}
