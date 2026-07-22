package audiologymodel;

import java.lang.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

public enum Days implements Enumerator {
	
	 MONDAY(0, "MONDAY", "MONDAY"), TUESDAY(1, "TUESDAY", "TUESDAY"), WEDNESDAY(2, "WEDNESDAY", "WEDNESDAY"), THURSDAY(3, "THURSDAY", "THURSDAY"), FRIDAY(4, "FRIDAY", "FRIDAY");
	
	public static final int MONDAY_VALUE = 0;
	public static final int TUESDAY_VALUE = 1;
	public static final int WEDNESDAY_VALUE = 2;
	public static final int THURSDAY_VALUE = 3;
	public static final int FRIDAY_VALUE = 4;
	
	private static final Days[] VALUES_ARRAY = new Days[] {MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY};

	public static final List<Days> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static Days get(String literal) {
	for (int i = 0; i < VALUES_ARRAY.length; ++i) {
		Days result = VALUES_ARRAY[i];
		if (result.toString().equals(literal)) {
			return result;
		}
	}
	return null;
	}

	public static Days getByName(String name) {
	for (int i = 0; i < VALUES_ARRAY.length; ++i) {
		Days result = VALUES_ARRAY[i];
		if (result.getName().equals(name)) {
			return result;
		}
	}
	return null;
	}

	public static Days get(int value) {
		switch (value) {
		case MONDAY_VALUE:
			return MONDAY;
		case TUESDAY_VALUE:
			return TUESDAY;
		case WEDNESDAY_VALUE:
			return WEDNESDAY;
		case THURSDAY_VALUE:
			return THURSDAY;
		case FRIDAY_VALUE:
			return FRIDAY;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private Days(int value, String name, String literal) {
	this.value = value;
	this.name = name;
	this.literal = literal;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public String getName() {
	return name;
	}

	@Override
	public String getLiteral() {
		return literal;
	}

	@Override
	public String toString() {
	return literal;
	}

}

