package OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
