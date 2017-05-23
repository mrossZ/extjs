package taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class ContainerTag extends BoxComponentTag{

	
	protected String activeItem;
	protected boolean autoDestroy = true;
	//protected List bubbleEvents;
	protected Integer bufferResize;
	protected String defaultType; 
	protected String defaults;
	protected boolean forceLayout;
	protected boolean hideBorders;
	protected String layout;
	protected String layoutConfig;
	protected boolean monitorResize;
	protected String resizeEvent;
	
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Container(stack);
    }
	
	protected void populateParams() {
        super.populateParams();
        Container container = (Container) component;
        
        container.setActiveItem(activeItem);
        container.setAutoDestroy(autoDestroy);
        container.setBufferResize(bufferResize);
        container.setDefaultType(defaultType);
        container.setForceLayout(forceLayout);
        container.setHideBorders(hideBorders);
        container.setLayout(layout);
        container.setLayoutConfig(layoutConfig);
        container.setMonitorResize(monitorResize);
        container.setResizeEvent(resizeEvent);
        container.setDefaults(defaults);
	}

	public void setActiveItem(String activeItem) {
		this.activeItem = activeItem;
	}

	public void setAutoDestroy(boolean autoDestroy) {
		this.autoDestroy = autoDestroy;
	}

	public void setBufferResize(Integer bufferResize) {
		this.bufferResize = bufferResize;
	}

	public void setDefaultType(String defaultType) {
		this.defaultType = defaultType;
	}

	public void setForceLayout(boolean forceLayout) {
		this.forceLayout = forceLayout;
	}

	public void setHideBorders(boolean hideBorders) {
		this.hideBorders = hideBorders;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public void setLayoutConfig(String layoutConfig) {
		this.layoutConfig = layoutConfig;
	}

	public void setMonitorResize(boolean monitorResize) {
		this.monitorResize = monitorResize;
	}

	public void setResizeEvent(String resizeEvent) {
		this.resizeEvent = resizeEvent;
	}

	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}
	
}
