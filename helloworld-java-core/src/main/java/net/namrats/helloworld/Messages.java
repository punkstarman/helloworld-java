package net.namrats.helloworld;

import java.util.ResourceBundle;

public class Messages {
	private static final String DEFAULT_VALUE = "!%s!"; //$NON-NLS-1$
	
	private static final String BUNDLE_NAME = "net.namrats.helloworld.web.messages"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		if (!RESOURCE_BUNDLE.containsKey(key)) {
			return String.format(DEFAULT_VALUE, key);
		}
		
		return RESOURCE_BUNDLE.getString(key);
	}
}
