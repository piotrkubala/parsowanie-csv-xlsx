package pl.edu.agh.kis.pz1.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Logger aplikacji.
 */
public class CustomLogger extends Logger {
    /**
     * Formatter loggera.
     */
    static class CustomRecordFormatter extends Formatter {
        @Override
        public String format(final LogRecord r) {
            StringBuilder sb = new StringBuilder();
            sb.append(formatMessage(r)).append(System.getProperty("line.separator"));
            if (null != r.getThrown()) {
                sb.append("Throwable occurred: ");
                Throwable t = r.getThrown();
                try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
                    t.printStackTrace(pw);
                    sb.append(sw);
                } catch (Exception ex) {
                    // ignore all exceptions here
                }
            }
            return sb.toString();
        }
    }

    /**
     * Konstruktor.
     */
    public CustomLogger(String name) {
        super(name, null);

        setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new CustomRecordFormatter());
        addHandler(consoleHandler);
    }
}
