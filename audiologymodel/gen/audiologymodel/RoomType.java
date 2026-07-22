package audiologymodel;

import java.lang.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

public enum RoomType implements Enumerator {
	
	 ROOM(0, "ROOM", "ROOM"), BOOTH(1, "BOOTH", "BOOTH");
	
	public static final int ROOM_VALUE = 0;
	public static final int BOOTH_VALUE = 1;
	
	private static final RoomType[] VALUES_ARRAY = new RoomType[] {ROOM,BOOTH};

	public static final List<RoomType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static RoomType get(String literal) {
	for (int i = 0; i < VALUES_ARRAY.length; ++i) {
		RoomType result = VALUES_ARRAY[i];
		if (result.toString().equals(literal)) {
			return result;
		}
	}
	return null;
	}

	public static RoomType getByName(String name) {
	for (int i = 0; i < VALUES_ARRAY.length; ++i) {
		RoomType result = VALUES_ARRAY[i];
		if (result.getName().equals(name)) {
			return result;
		}
	}
	return null;
	}

	public static RoomType get(int value) {
		switch (value) {
		case ROOM_VALUE:
			return ROOM;
		case BOOTH_VALUE:
			return BOOTH;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private RoomType(int value, String name, String literal) {
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

