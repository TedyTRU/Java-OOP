package OOP.EX14_SOLID.Models.Appenders;

import OOP.EX14_SOLID.Interfaces.File;
import OOP.EX14_SOLID.Interfaces.Layout;
import OOP.EX14_SOLID.Models.Files.LogFile;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    @Override
    protected void append(String text) {
        this.file.write(text);
    }

    @Override
    public String toString() {
        return String.format("%s, File size: %d", super.toString(), this.file.getSize());
    }
}
