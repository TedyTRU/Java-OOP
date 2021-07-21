package OOP.EX14_SOLID.Models.Layouts;

import OOP.EX14_SOLID.Interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
