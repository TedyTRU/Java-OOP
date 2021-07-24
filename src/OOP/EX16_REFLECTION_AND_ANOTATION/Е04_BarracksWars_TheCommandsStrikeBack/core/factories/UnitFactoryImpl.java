package OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.core.factories;

import OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.interfaces.Unit;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit unit = null;

        try {
            Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            unit = (Unit) clazz.getDeclaredConstructor().newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException |
                InvocationTargetException | InstantiationException |
                IllegalAccessException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
