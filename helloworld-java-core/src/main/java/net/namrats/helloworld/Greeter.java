package net.namrats.helloworld;

import java.text.MessageFormat;

public class Greeter {
	private static final String GREETING = Messages.getString("Greeter.GREETING"); //$NON-NLS-1$
	private static final String DEFAULT_NAME = Messages.getString("Greeter.DEFAULT_NAME"); //$NON-NLS-1$
	
	public String greet() {
		return greet(DEFAULT_NAME);
	}
	
	public String greet(String name) { 
		if (name == null || name.isEmpty()) {
			return greet();
		}
		return MessageFormat.format(GREETING, name);
	}
}
