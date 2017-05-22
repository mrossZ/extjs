package taglib;

import java.io.Writer;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public abstract class ExtComponent extends Component {

	protected Container parentContainer;

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

}
