package OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.core.commands;

import OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

public class Retire extends Command {
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}
