package OOP.EX14_SOLID.Interfaces;

public interface Logger {

    void logInfo(String dateTime, String message);

    void logWarning(String dateTime, String message);

    void logError(String dateTime, String message);

    void logCritical(String dateTime, String message);

    void logFatal(String dateTime, String message);


    String getLogInfo();


}
