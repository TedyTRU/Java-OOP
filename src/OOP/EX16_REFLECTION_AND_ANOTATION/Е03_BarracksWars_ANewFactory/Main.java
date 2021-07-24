package OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory;

import OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory.core.Engine;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory.core.factories.UnitFactoryImpl;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory.data.UnitRepository;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory.interfaces.Repository;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory.interfaces.Runnable;
import OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
