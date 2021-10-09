
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Quiz4_3_1 {

    private static void configureLogging() {
        Logger LOGGERA = Logger.getLogger( "org.stepic.java.logging.ClassA");
        Logger LOGGERB = Logger.getLogger( "org.stepic.java.logging.ClassB");
        Logger LOGGER = Logger.getLogger( "org.stepic.java");
        Logger LOGGERP = Logger.getLogger( "org.stepic");

        LOGGERA.setLevel(Level.ALL);
        LOGGERB.setLevel(Level.WARNING);
        //LOGGER.setLevel(Level.ALL);
        LOGGER.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        //consoleHandler.setFormatter(new XMLFormatter());
        LOGGER.addHandler(consoleHandler);
        LOGGER.getHandlers()[0].setLevel(Level.ALL);  // грязное решение. лучше consoleHandler.setLevel(Level.ALL)

        LOGGERA.info("LogA Info message");
        LOGGERB.info("LogB Info message");
        LOGGER.finest("Log Finest message");
    };

    public static void main(String[] args) {
        configureLogging();
    }

}
