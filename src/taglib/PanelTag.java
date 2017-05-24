package taglib;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class PanelTag extends ContainerTag{

	protected boolean animCollapse = true;
	protected boolean autoScripts = true;
	protected String baseCls;
	protected String layout;
	
	//protected Object bbarCfg;
	protected boolean bodyBorder = true;
	//protected Object bodyCfg;
	protected String bodyCls;
	protected String bodyStyle;
	protected boolean border = true;
	protected String buttonAlign;
	//protected Object bwrapCfg;
	protected boolean closable;
	protected boolean collapseFirst = true;
	protected boolean collapsed;
	protected String collapsedCls;
	protected boolean collapsible;
	protected boolean disabled;
	protected boolean draggable;
	protected String elements;
	protected List fbar = new ArrayList();
	protected String floating;
	protected boolean footer;
	//protected Object footerCfg;
	protected boolean frame;
	protected boolean header = true;
	protected boolean headerAsText = true;
	//protected Object headerCfg;
	protected boolean hideCollapseTool;
	protected String iconCls;
	protected List keys = new ArrayList();
	protected boolean maskDisabled = true;
	protected Integer minButtonWidth;
	protected Integer padding;
	protected boolean preventBodyReset;
	protected String resizeEvent;
	protected boolean shadow;
	protected Integer shadowOffset;
	protected boolean shim = true;
	//protected Object tbarCfg;
	protected String title;
	protected boolean titleCollapse;
	//toolTemplate 
	protected List tools = new ArrayList();
	protected boolean unstyled;
	protected String loader;
	
	protected boolean split;
	
	protected String afterRender;
	protected Integer flex;
	
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Panel(stack);
    }
	protected void populateParams() {
        super.populateParams();
        Panel panel = (Panel) component;
        
        panel.setAnimCollapse(animCollapse);
        panel.setBaseCls(baseCls);
        panel.setBodyBorder(bodyBorder);
        panel.setBodyCls(bodyCls);
        panel.setBodyStyle(bodyStyle);
        panel.setBorder(border);
        panel.setButtonAlign(buttonAlign);
        panel.setClosable(closable);
        panel.setCollapseFirst(collapseFirst);
        panel.setCollapsed(collapsed);
        panel.setCollapsedCls(collapsedCls);
        panel.setCollapsible(collapsible);
        panel.setDisabled(disabled);
        panel.setDraggable(draggable);
        panel.setElements(elements);
        panel.setFbar(fbar);
        panel.setFloating(floating);
        panel.setFooter(footer);
        panel.setFrame(frame);
        panel.setHeader(header);
        panel.setHeaderAsText(headerAsText);
        panel.setHideCollapseTool(hideCollapseTool);
        panel.setIconCls(iconCls);
        panel.setKeys(keys);
        panel.setMaskDisabled(maskDisabled);
        panel.setMinButtonWidth(minButtonWidth);
        panel.setPadding(padding);
        panel.setPreventBodyReset(preventBodyReset);
        panel.setResizeEvent(resizeEvent);
        panel.setShadow(shadow);
        panel.setShadowOffset(shadowOffset);
        panel.setShim(shim);
        panel.setTitle(title);
        panel.setTitleCollapse(titleCollapse);
        panel.setTools(tools);
        panel.setUnstyled(unstyled);
        panel.setLayout(layout);
        panel.setAfterRender(afterRender);
        panel.setFlex(flex);
        panel.setLoader(loader);
        panel.setSplit(split);

	}
	

	public void setAnimCollapse(boolean animCollapse) {
		this.animCollapse = animCollapse;
	}

	public void setBaseCls(String baseCls) {
		this.baseCls = baseCls;
	}

	public void setBodyBorder(boolean bodyBorder) {
		this.bodyBorder = bodyBorder;
	}

	public void setBodyCls(String bodyCls) {
		this.bodyCls = bodyCls;
	}

	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public void setButtonAlign(String buttonAlign) {
		this.buttonAlign = buttonAlign;
	}

	public void setClosable(boolean closable) {
		this.closable = closable;
	}

	public void setCollapseFirst(boolean collapseFirst) {
		this.collapseFirst = collapseFirst;
	}

	public void setCollapsed(boolean collapsed) {
		this.collapsed = collapsed;
	}

	public void setCollapsedCls(String collapsedCls) {
		this.collapsedCls = collapsedCls;
	}

	public void setCollapsible(boolean collapsible) {
		this.collapsible = collapsible;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public void setDraggable(boolean draggable) {
		this.draggable = draggable;
	}

	public void setElements(String elements) {
		this.elements = elements;
	}

	public void setFbar(List fbar) {
		this.fbar = fbar;
	}

	public void setFloating(String floating) {
		this.floating = floating;
	}

	public void setFooter(boolean footer) {
		this.footer = footer;
	}

	public void setFrame(boolean frame) {
		this.frame = frame;
	}

	public void setHeader(boolean header) {
		this.header = header;
	}

	public void setHeaderAsText(boolean headerAsText) {
		this.headerAsText = headerAsText;
	}

	public void setHideCollapseTool(boolean hideCollapseTool) {
		this.hideCollapseTool = hideCollapseTool;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public void setKeys(List keys) {
		this.keys = keys;
	}

	public void setMaskDisabled(boolean maskDisabled) {
		this.maskDisabled = maskDisabled;
	}

	public void setMinButtonWidth(Integer minButtonWidth) {
		this.minButtonWidth = minButtonWidth;
	}

	public void setPadding(Integer padding) {
		this.padding = padding;
	}

	public void setPreventBodyReset(boolean preventBodyReset) {
		this.preventBodyReset = preventBodyReset;
	}

	public void setResizeEvent(String resizeEvent) {
		this.resizeEvent = resizeEvent;
	}

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
	}

	public void setShadowOffset(Integer shadowOffset) {
		this.shadowOffset = shadowOffset;
	}

	public void setShim(boolean shim) {
		this.shim = shim;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitleCollapse(boolean titleCollapse) {
		this.titleCollapse = titleCollapse;
	}

	public void setTools(List tools) {
		this.tools = tools;
	}

	public void setUnstyled(boolean unstyled) {
		this.unstyled = unstyled;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}
	

	public void setAutoScripts(boolean autoScripts) {
		this.autoScripts = autoScripts;
	}

	public void setAfterRender(String afterRender) {
		this.afterRender = afterRender;
	}

	public void setFlex(Integer flex) {
		this.flex = flex;
	}
	
	public void setLoader(String loader) {
		this.loader = loader;
	}
	
	public void setSplit(boolean split) {
		this.split = split;
	}
}
