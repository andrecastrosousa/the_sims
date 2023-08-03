package academy.mindswap.andrecastrosousa.client.character.needs.status;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.stream.Stream;

public class HygieneStatus extends NeedStatusImpl {

    public HygieneStatus() {
        super(NeedsType.HYGIENE);
    }

    @Override
    public String toString() {
        int progress = stamina / 10;

        return "Hygiene: " +
                Stream.generate(() -> Messages.PROGRESS_BAR)
                        .limit(progress)
                        .reduce("", (acc, next) -> acc + next) +
                "  " + stamina + "%";
    }
}
