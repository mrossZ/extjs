package utitlity;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.PageContext;

import org.apache.struts2.views.jsp.TagUtils;

import com.opensymphony.xwork2.TextProvider;
import com.opensymphony.xwork2.util.ValueStack;

public class TaglibUtil {

	public static String translateText(PageContext pageContext, String textKey) {

		return translateText(pageContext, textKey, null);
	}

	public static String translateText(ValueStack stack, String textKey) {
		return translateText(stack, textKey, null);
	}

	public static String translateText(PageContext pageContext, String textKey, List<Object> values) {
		ValueStack stack = TagUtils.getStack(pageContext);
		return translateText(stack, textKey, values);
	}

	public static String translateText(ValueStack stack, String textKey, List<Object> values) {
		String sText = textKey;
		Iterator<Object> iterator = stack.getRoot().iterator();

		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof TextProvider) {
				TextProvider tp = (TextProvider) obj;
				sText = tp.getText(textKey, values);
				break;
			}
		}

		return sText;

	}

}
