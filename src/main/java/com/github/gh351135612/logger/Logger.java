package com.github.gh351135612.logger;

import com.github.gh351135612.logger.inter.LogAdapter;
import com.github.gh351135612.logger.impl.LoggerPrinter;
import com.github.gh351135612.logger.inter.Printer;
import org.apache.log4j.Priority;

/**
 * But more pretty, simple and powerful
 */
public final class Logger {

  public static final int VERBOSE = Priority.ALL_INT;
  public static final int DEBUG = Priority.DEBUG_INT;
  public static final int INFO = Priority.INFO_INT;
  public static final int WARN = Priority.WARN_INT;
  public static final int ERROR = Priority.ERROR_INT;

  private static Printer printer = new LoggerPrinter();

  private Logger() {
    //no instance
  }

  public static void printer(Printer printer) {
    Logger.printer = printer;
  }

  public static void addLogAdapter(LogAdapter adapter) {
    printer.addAdapter(adapter);
  }

  public static void clearLogAdapters() {
    printer.clearLogAdapters();
  }

  /**
   * General log function that accepts all configurations as parameter
   */
  public static void log(int priority, String message, Throwable throwable) {
    printer.log(priority, message, throwable);
  }

  public static void d(String message, Object... args) {
    printer.d(message, args);
  }

  public static void d(Object object) {
    printer.d(object);
  }

  public static void e(String message, Object... args) {
    printer.e(null, message, args);
  }

  public static void e(Throwable throwable, String message, Object... args) {
    printer.e(throwable, message, args);
  }

  public static void i(String message, Object... args) {
    printer.i(message, args);
  }

  public static void w(String message, Object... args) {
    printer.w(message, args);
  }

}
