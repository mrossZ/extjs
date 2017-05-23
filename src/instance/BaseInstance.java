package instance;

import java.util.Locale;

import javax.servlet.jsp.PageContext;

import com.opensymphony.xwork2.util.LocalizedTextUtil;
import com.opensymphony.xwork2.util.ValueStack;

import utitlity.StringUtil;
import utitlity.TaglibUtil;

public abstract class BaseInstance {
	String value = "";
	String values[];
	String texts[];

	public abstract void initailize(PageContext pageContext);

	public void initailize(PageContext pageContext, String value) {

		this.value = value;

	}

	public void initialze(ValueStack stack, String vlaue) {

		this.value = value;

	}

	public void initValues() {
		values = value.split(",");
	}

	public void initTexts(String localName) {

		String className = getClass().getName();
		String textKey = "Text.Instance." + className.substring(className.lastIndexOf(".") + 1);
		String strText = LocalizedTextUtil.findDefaultText(textKey, new Locale(localName));
		if (StringUtil.isNull(strText)) {
			strText = value;
		}
		String t[] = strText.split(",");
		if (t.length == values.length)
			texts = t;
		else
			texts = values;
	}

	public void initTexts(PageContext pageContext) {
		if (pageContext == null) {
			return;
		}
		String className = getClass().getName();
		String textKey = "Text.Instance." + className.substring(className.lastIndexOf(".") + 1);
		String strText = TaglibUtil.translateText(pageContext, textKey);
		if (strText.equals(textKey)) {
			strText = value;
		}
		String t[] = strText.split(",");
		if (t.length == values.length)
			texts = t;
		else
			texts = values;
	}

	public String toStore() {
		String str = "";
		if (value != null) {
			for (int i = 0; i < values.length; i++) {
				if (i > 0)
					str = str + ",";
				str = str + "['" + texts[i] + "','" + values[i] + "']";
			}
		}
		return str;
	}

}
