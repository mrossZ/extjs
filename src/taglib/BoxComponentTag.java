package taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class BoxComponentTag extends ComponentTagSupport {

	protected boolean autoHeight;
	protected boolean autoWidth;
	protected boolean autoScroll;
	protected boolean autoShow;
	protected Integer height;
	protected Integer width;
	protected String region;

	protected String cls;
	protected boolean disabled;
	protected String disabledClass;
	protected String style;
	protected String xtype;

	protected String fieldLabel;

	protected boolean hidden;
	protected boolean hideLabel;
	protected String html;
	protected String renderTo;

	protected boolean fitParentWidth;
	protected boolean fitParentHeight;

	protected String margins;

	protected Integer x;
	protected Integer y;

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest arg1, HttpServletResponse arg2) {
		return new BoxComponent(stack);
	}

	protected void populateParams() {
		super.populateParams();
		BoxComponent boxComponent = (BoxComponent) component;
		boxComponent.setAutoHeight(autoHeight);
		boxComponent.setAutoScroll(autoScroll);
		boxComponent.setAutoShow(autoShow);
		boxComponent.setCls(cls);
		boxComponent.setDisabled(disabled);
		boxComponent.setDisabledClass(disabledClass);
		boxComponent.setFieldLabel(fieldLabel);
		boxComponent.setHeight(height);
		boxComponent.setHidden(hidden);
		boxComponent.setHideLabel(hideLabel);
		boxComponent.setHtml(html);
		boxComponent.setId(id);
		boxComponent.setRenderTo(renderTo);
		boxComponent.setWidth(width);
		boxComponent.setXtype(xtype);
		boxComponent.setRegion(region);
		boxComponent.setMargins(margins);
		boxComponent.setStyle(style);
		boxComponent.setX(x);
		boxComponent.setY(y);

		ContainerTag container = (ContainerTag) findAncestorWithClass(this, ContainerTag.class);
		if (container != null) {
			Container parentContainer = (Container) ((ContainerTag) container).getComponent();
			boxComponent.setParentContainer(parentContainer);
			parentContainer.addItem(boxComponent);
		}

	}

	public void setAutoHeight(boolean autoHeight) {
		this.autoHeight = autoHeight;
	}

	public void setAutoWidth(boolean autoWidth) {
		this.autoWidth = autoWidth;
	}

	public void setAutoScroll(boolean autoScroll) {
		this.autoScroll = autoScroll;
	}

	public void setAutoShow(boolean autoShow) {
		this.autoShow = autoShow;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public void setDisabledClass(String disabledClass) {
		this.disabledClass = disabledClass;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setXtype(String xtype) {
		this.xtype = xtype;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public void setHideLabel(boolean hideLabel) {
		this.hideLabel = hideLabel;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public void setRenderTo(String renderTo) {
		this.renderTo = renderTo;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setFitParentWidth(boolean fitParentWidth) {
		this.fitParentWidth = fitParentWidth;
	}

	public void setFitParentHeight(boolean fitParentHeight) {
		this.fitParentHeight = fitParentHeight;
	}

	public void setMargins(String margins) {
		this.margins = margins;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

}
