package net.namrats.helloworld;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

import java.util.Locale;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import net.namrats.helloworld.Greeter;

@RunWith(Theories.class)
public class GreeterTest {
	@DataPoints
	public static final String[] names = {
		"world",
		"dzqmokdzq",
		"",
		null
	};

	@Theory
	public void testGreeter_containsName(String name) {
		assumeThat(name, not(isEmptyOrNullString()));
		
		Greeter greeter = new Greeter();
		
		String result = greeter.greet(name);
		
		assertThat(result, containsString(name));
	}
	
	@Theory
	public void testGreeter_nullDefaultName(String name) {
		assumeThat(name, isEmptyOrNullString());
		
		Locale.setDefault(Locale.ENGLISH);
		Greeter greeter = new Greeter();
		
		String result = greeter.greet(name);
		
		assertThat(result, containsString("nobody"));
	}
}
