package OOP.EX14_SOLID;

import OOP.EX14_SOLID.Enums.ReportLevel;
import OOP.EX14_SOLID.Interfaces.Appender;
import OOP.EX14_SOLID.Interfaces.Layout;
import OOP.EX14_SOLID.Models.Loggers.MessageLogger;
import OOP.EX14_SOLID.Interfaces.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Layout simpleLayout = new SimpleLayout();
//        //Layout simpleLayout = new XmlLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");


//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//        consoleAppender.setReportLevel(ReportLevel.ERROR);
//
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logInfo("3/31/2015 5:33:07 PM", "Everything seems fine");
//        logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
//        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
//        logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
//        logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");

        Scanner scanner = new Scanner(System.in);

        try {
            int appenderCount = Integer.parseInt(scanner.nextLine());
            Appender[] appenders = new Appender[appenderCount];

            for (int i = 0; i < appenderCount; i++) {
                String[] tokens = scanner.nextLine().split("\\s+");

                Layout layout = getLayout(tokens[1]);
                ReportLevel reportLevel = ReportLevel.INFO;

                if (tokens.length == 3) {
                    reportLevel = ReportLevel.valueOf(tokens[2]);
                }

                Appender appender = getAppender(layout, tokens[0]);
                appender.setReportLevel(reportLevel);
                appenders[i] = appender;
            }

            Logger logger = new MessageLogger(appenders);
            String input = scanner.nextLine();

            while (!"END".equals(input)) {
                String[] tokens = input.split("\\|");
                ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
                String dateTame = tokens[1];
                String message = tokens[2];

                logMessage(logger, reportLevel, dateTame, message);

                input = scanner.nextLine();
            }

            System.out.println(logger.getLogInfo());

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

    }

    private static void logMessage(Logger logger, ReportLevel reportLevel, String dateTame, String message)
            throws InvocationTargetException, IllegalAccessException {

        Class loggerClass = logger.getClass();
        Method method = Arrays.stream(loggerClass.getMethods())
                .filter(m -> m.getName().equalsIgnoreCase("log" + reportLevel))
                .findFirst().orElseThrow();

        method.invoke(logger, dateTame, message);
    }

    private static Appender getAppender(Layout layout, String appenderName)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clazz = Class.forName("OOP.EX14.Models.Appenders." + appenderName);
        return (Appender) clazz.getConstructor(Layout.class).newInstance(layout);

    }

    private static Layout getLayout(String layoutName)
            throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clazz = Class.forName("OOP.EX14.Models.Layouts." + layoutName);
        return (Layout) clazz.getConstructor().newInstance();

    }

}
