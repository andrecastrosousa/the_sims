package academy.mindswap.andrecastrosousa.character.needs.status;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.stream.Stream;

public class FunStatus extends NeedStatusImpl {
    public FunStatus() {
        super(NeedsType.FUN);
    }

    @Override
    public String toString() {
        int progress = stamina / 10;

        return "Fun: " +
                Stream.generate(() -> Messages.PROGRESS_BAR)
                        .limit(progress)
                        .reduce("", (acc, next) -> acc + next) +
                "  " + stamina + "%";
    }
}
