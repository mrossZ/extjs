package taglib;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsException;
import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class ExtLib extends Component {

	String contextPath;
	List<String> instanceList = new ArrayList<String>();

	public ExtLib(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		super(stack);
		contextPath = req.getContextPath();
	}

	public boolean start(Writer writer) {
		try {

			StringBuilder str = new StringBuilder();
			str.append("<script trype=\"text/javascript\">\n");
			str.append("Ext.BLANK_IMAGE_URL=\"" + contextPath + "/images/s.gif\";\n");
			str.append("Ext.onReady(function(){\n");
			writer.write(str.toString());
		} catch (IOException e) {
			throw new StrutsException("IOError:" + e.getMessage(), e);
		}
		return super.start(writer);
	}

	public boolean end(Writer writer, String body) {
		try {
			StringBuilder str = new StringBuilder();
			str.append("});\n");
			str.append("</script>");
			writer.write(str.toString());
		} catch (IOException e) {
			throw new StrutsException("IOError:" + e.getMessage(), e);
		}
		
		return super.end(writer, body);
		
	}

}
