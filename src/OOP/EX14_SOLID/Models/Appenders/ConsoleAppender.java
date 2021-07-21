package OOP.EX14_SOLID.Models.Appenders;

import OOP.EX14_SOLID.Interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    protected void append(String text) {
        System.out.println(text);
    }
}
