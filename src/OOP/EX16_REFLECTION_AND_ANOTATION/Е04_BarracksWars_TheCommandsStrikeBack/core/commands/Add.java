package OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.core.commands;

import OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.interfaces.Unit;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";

    }
}
