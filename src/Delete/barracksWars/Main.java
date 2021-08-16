package Delete.barracksWars;

import Delete.barracksWars.interfaces.Repository;
import Delete.barracksWars.interfaces.Runnable;
import Delete.barracksWars.interfaces.UnitFactory;
import Delete.barracksWars.core.Engine;
import Delete.barracksWars.core.factories.UnitFactoryImpl;
import Delete.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
