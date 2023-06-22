package academy.mindswap.andrecastrosousa.character.needs.status;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.util.stream.Stream;

public class EnergyStatus extends NeedStatusImpl {
    public EnergyStatus() {
        super(NeedsType.ENERGY);
    }

    @Override
    public String toString() {
        int progress = stamina / 10;

        return "Energy: " +
        Stream.generate(() -> Messages.PROGRESS_BAR)
                .limit(progress)
                .reduce("", (acc, next) -> acc + next) +
                "  " + stamina + "%";
    }
}
