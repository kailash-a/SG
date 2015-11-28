package in.sg.hackerearth.challenge.kailash.util;



import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum EthnicGroup {
	ASIAN(1), AFRICAN_AMERICAN(2), ASIAN_AMERICAN(3), EUROPEAN(4), BRITISH(
			5), JEWISH(6), LATINO(7), NATIVE_AMERICAN(8), ARABIC(9);

	private static final Map<Integer, EthnicGroup> lookup = new HashMap<Integer, EthnicGroup>();

	static {
		for (EthnicGroup s : EnumSet.allOf(EthnicGroup.class))
			lookup.put(s.getCode(), s);
	}

	private int code;

	private EthnicGroup(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static EthnicGroup get(int code) {
		return lookup.get(code);
	}
}
