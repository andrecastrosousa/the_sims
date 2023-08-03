package academy.mindswap.andrecastrosousa.client.character.needs.status;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.stream.Stream;

public class HungerStatus extends NeedStatusImpl {

    public HungerStatus() {
        super(NeedsType.HUNGER);
    }

    @Override
    public String toString() {
        int progress = stamina / 10;

        return "Hunger: " +
                Stream.generate(() -> Messages.PROGRESS_BAR)
                        .limit(progress)
                        .reduce("", (acc, next) -> acc + next) +
                "  " + stamina + "%";
    }
}
