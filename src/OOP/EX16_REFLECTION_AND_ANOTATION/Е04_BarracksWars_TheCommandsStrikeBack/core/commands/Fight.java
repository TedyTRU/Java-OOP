package OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.core.commands;

import OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

public class Fight extends Command {
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
