package taglib;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public abstract class ExtComponent extends Component {

	protected Container parentContainer;
	protected List<Plugin> plugins = new ArrayList<Plugin>();

	public ExtComponent(ValueStack stack) {
		super(stack);
	}

	public boolean start(Writer writer) {
		return super.start(writer);
	}

	public abstract void buildProperties(Component component, StringBuilder str);

	public abstract String getId();

	public void setParentContainer(Container parentContainer) {
		this.parentContainer = parentContainer;
	}

	public Container getParentContainer() {
		return parentContainer;
	}
	
	public Container getContainer() {
		Object obj = this;
		
		if (parentContainer==null)
			if (obj instanceof Container)
				return (Container)obj;
			else
				return null;
		else
			return getContainer();
	}

}
