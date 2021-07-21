package OOP.EX14_SOLID.Interfaces;

import OOP.EX14_SOLID.Enums.ReportLevel;

public interface Appender {

    void appendMessage(String dateTime, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);
}
