package utitlity;

public class StringUtil {

	public static boolean isNull(String str) {
		if (str == null || str == "")
			return true;
		else
			return false;
	}

	static public String encodeJs(String str) {
		str = str.replaceAll("\\\\", "\\\\\\\\");
		str = str.replaceAll("\r", "\\\\r");
		str = str.replaceAll("\n", "\\\\n");
		str = str.replaceAll("\"", "\\\\\"");
		str = str.replaceAll("'", "\\\\'");
		return str;
	}

}
