package com.root.log;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class HelloLog {

	static Logger logger;

	public static void main(String[] args) {
		// Logger logger = LoggerFactory.getLogger(HelloLog.class);
		logger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
		logger.trace("Trace log");
		logger.debug("Debug log");
		logger.info("Info log");
		logger.warn("Warn log");
		logger.error("Error log");

		// Logger logger = LoggerFactory.getLogger(HelloLog.class);
		Logger logger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
		if (logger.isInfoEnabled()) {
			logger.info("Info log");
		}
		Object entry = new Object();
		logger.debug("The new entry is {}.", entry);// 30 fois plus performant
													// que de concaténer la
													// chaine à la main!
		Object[] paramArray = { entry, entry, entry };
		logger.debug("Value {} was inserted between {} and {}.", paramArray);

		try {
			ArrayList<String> list = new ArrayList<String>();
			list.get(1);

		} catch (Exception e) {
			logger.error("An error had been thrown! That's bad my friend...", e);
		}
		// ch.qos.logback.classic.Level
		// print internal state
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);

		// ************************ LOGGERS LEVELS

		// get a logger instance named "com.foo". Let us further assume that the
		// logger is of type ch.qos.logback.classic.Logger so that we can
		// set its level
		ch.qos.logback.classic.Logger logger2 = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");
		// set its Level to INFO. The setLevel() method requires a logback
		// logger
		logger2.setLevel(Level.INFO);
		// Logger's level Additivity : The level of a logger is reused for all
		// logger's children with no specified level
		Logger barlogger = LoggerFactory.getLogger("com.foo.Bar");

		// This request is enabled, because WARN >= INFO
		logger.warn("Low fuel level.");

		// This request is disabled, because DEBUG < INFO.
		logger.debug("Starting search for nearest gas station.");

		// The logger instance barlogger, named "com.foo.Bar",
		// will inherit its level from the logger named
		// "com.foo" Thus, the following request is enabled
		// because INFO >= INFO.
		barlogger.info("Located nearest gas station.");

		// This request is disabled, because DEBUG < INFO.
		barlogger.debug("Exiting gas station search");

		// ************************ CONFIGURED LOGGER
		ch.qos.logback.classic.Logger loggerTest = (ch.qos.logback.classic.Logger) LoggerFactory
				.getLogger("logger.test");
		loggerTest.info("log de test ");
		// ************************ APPENDERS
		// (output destination > console, files, remote socket servers, to
		// MySQL, PostgreSQL, Oracle and other databases, JMS, and remote UNIX
		// Syslog daemons)
		// Appender Additivity : The appender set to the root logger will be use
		// for all children (if additivity flag is set to true)

	}
	
	public int somme(int a, int b){
		
		return a + b;
	}

}
