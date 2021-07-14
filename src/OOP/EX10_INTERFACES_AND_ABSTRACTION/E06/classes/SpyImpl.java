package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s%nCode Number: %s"
                , super.toString(), getCodeNumber());
    }
}
