package taglib;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.StrutsException;
import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

import instance.BaseInstance;
import utitlity.StringUtil;

public class Panel extends Container {

	protected boolean animCollapse;
	protected String baseCls;
	protected String layout;
	protected boolean bodyBorder;
	protected String bodyCls;
	protected String bodyStyle;
	protected boolean border;
	protected String buttonAlign;
	protected boolean closable;
	protected boolean collapseFirst;
	protected boolean collapsed;
	protected String collapsedCls;
	protected boolean collapsible;
	protected boolean disabled;
	protected boolean draggable;
	protected String elements;
	protected List fbar;
	protected String floating;
	protected boolean footer;
	protected boolean frame;
	protected boolean header;
	protected boolean headerAsText;
	protected boolean hideCollapseTool;
	protected String iconCls;
	protected List keys;
	protected boolean maskDisabled;
	protected Integer minButtonWidth;
	protected Integer padding;
	protected boolean preventBodyReset;
	protected String resizeEvent;
	protected boolean shadow;
	protected Integer shadowOffset;
	protected boolean shim;
	protected String title;
	protected boolean titleCollapse;
	// toolTemplate
	protected List tools;
	protected boolean unstyled;
	protected String loader;
	protected boolean split;

	protected String jvTabPanelId;
	protected String jvParentWinId;
	protected String jvContainerId;
	protected String jvLovField;
	/*
	 * protected Toolbar tbar; protected Toolbar bbar;
	 * 
	 * protected List<Button> buttons = new ArrayList<Button>();
	 */
	protected Integer flex;

	// 定义Panel Render后运行的函数
	protected String afterRender;

	public Panel(ValueStack stack) {
		super(stack);
	}

	public boolean start(Writer writer) {

		boolean bOk = super.start(writer);

		if (!StringUtil.isNull(renderTo)) {
			setRenderTo(renderTo);
		} else {
			jvTabPanelId = (String) getStack().findValue("jvTabPanelId");
			getStack().set("jvTabPanelId", "");

			jvParentWinId = (String) getStack().findValue("jvParentWinId");
			getStack().set("jvParentWinId", "");
		}

		jvContainerId = (String) getStack().findValue("");
		getStack().set("jvContainerId", "");

		jvLovField = (String) getStack().findValue("jvLovField");
		getStack().set("jvLovField", "");

		return bOk;
	}

	public boolean end(Writer writer, String body) {

		try {
			StringBuilder str = new StringBuilder();
			buildInstance(str);
			str.append("var _panel_" + id + "=new Ext.Panel({\n");
			buildProperties(parentContainer, str);

			str.deleteCharAt(str.length() - 2);
			str.append("});\n");
			
			
			if(!StringUtil.isNull(jvTabPanelId)){
				str.append("Ext.getCmp('"+jvTabPanelId+"').setContainedPanel(Ext.getCmp('"+this.id+"'));\n");
			}
			if(!StringUtil.isNull(jvContainerId)){
				str.append("Ext.getCmp('"+jvContainerId+"').containedPanel=Ext.getCmp('"+this.id+"');\n");
				str.append("Ext.getCmp('"+jvContainerId+"').add*Ext.getCmp('"+this.id+"'));\n");
				
				str.append("Ext.getBody().unmask();\n");
			}
			

			writer.write(str.toString());

		} catch (IOException e) {
			throw new StrutsException("IOErro" + e.getMessage(), e);
		}

		return super.end(writer, body);
	}
	
	public void buildProperties(Component component, StringBuilder str) {
		super.buildProperties(component, str);

		if (!animCollapse)
			str.append("animCollapse:false,\n");

		if (!StringUtil.isNull(loader)) {
			str.append("loader:" + loader + ",\n");
		}

		if (!StringUtil.isNull(baseCls))
			str.append("baseCls:'" + StringUtil.encodeJs(baseCls) + "',\n");

		if (!bodyBorder)
			str.append("bodyBorder:false,\n");

		if (!StringUtil.isNull(bodyCls))
			str.append("bodyCls:'" + StringUtil.encodeJs(bodyCls) + "',\n");

		if (!StringUtil.isNull(bodyStyle))
			str.append("bodyStyle:'" + StringUtil.encodeJs(bodyStyle) + "',\n");

		if (!border)
			str.append("border:false,\n");

		if (!StringUtil.isNull(buttonAlign))
			str.append("buttonAlign:'" + StringUtil.encodeJs(buttonAlign) + "',\n");

		if (closable)
			str.append("closable:true,\n");

		if (!collapseFirst)
			str.append("collapseFirst:false,\n");

		if (collapsed)
			str.append("collapsed:true,\n");

		if (!StringUtil.isNull(collapsedCls))
			str.append("collapsedCls:'" + StringUtil.encodeJs(collapsedCls) + "',\n");

		if (!StringUtil.isNull(layout)) {
			if (layout.startsWith("{"))
				str.append("layout:" + layout + ",\n");
			else
				str.append("layout:'" + StringUtil.encodeJs(layout) + "',\n");
			str.append("viewConfig: {forceFit: true},\n");
		}
		
		if (flex!=null)
			str.append("flex:" + flex + ",\n");

		if (collapsible)
			str.append("collapsible:true,\n");

		if (disabled)
			str.append("disabled:true,\n");

		if (draggable)
			str.append("draggable:true,\n");

		if (!StringUtil.isNull(elements))
			str.append("elements:'" + StringUtil.encodeJs(elements) + "',\n");

		if (!StringUtil.isNull(floating))
			str.append("floating:'" + StringUtil.encodeJs(floating) + "',\n");

		if (footer)
			str.append("footer:true,\n");

		if (frame)
			str.append("frame:true,\n");

		if (!header)
			str.append("header:false,\n");

		if (!headerAsText)
			str.append("headerAsText:false,\n");

		if (hideCollapseTool)
			str.append("hideCollapseTool:true,\n");

		if (!maskDisabled)
			str.append("maskDisabled:false,\n");

		if (minButtonWidth != null)
			str.append("minButtonWidth:" + minButtonWidth + ",\n");

		if (padding != null)
			str.append("padding:" + padding + ",\n");

		if (preventBodyReset)
			str.append("preventBodyReset:true,\n");

		if (!StringUtil.isNull(resizeEvent))
			str.append("resizeEvent:'" + StringUtil.encodeJs(resizeEvent) + "',\n");

		if (shadow)
			str.append("shadow:true,\n");

		if (shadowOffset != null)
			str.append("shadowOffset:" + shadowOffset + ",\n");

		if (!shim)
			str.append("shim:false,\n");

		if (!StringUtil.isNull(title)) {
			str.append("title:'" + StringUtil.encodeJs(findString(title)) + "',\n");
			// str.append("title:'" + StringUtil.encodeJs(title) + "',\n");
		}

		if (titleCollapse)
			str.append("titleCollapse:true,\n");

		if (!StringUtil.isNull(jvLovField)) {
			str.append("lovField:'" + jvLovField + "',\n");
		}
		
		if (split)
			str.append("split:" + split + ",\n");
		
		if (unstyled)
			str.append("unstyled:true,\n");

		/*
		if (buttons.size() > 0) {
			str.append("buttons: [\n");
			Iterator<Button> it = buttons.iterator();
			while (it.hasNext()) {
				str.append("{\n");
				Button button = it.next();
				button.buildProperties(this, str);
				str.deleteCharAt(str.length() - 2);
				str.append("},\n");
			}
			str.deleteCharAt(str.length() - 2);
			str.append("],\n");

			buttons.clear();
		}
		*/
		
		if (!StringUtil.isNull(jvTabPanelId)) {
			str.append("jvTabPanelId:'" + jvTabPanelId + "',\n");
		}
		
		if (!StringUtil.isNull(jvParentWinId)) {
			str.append("jvParentWinId:'" + jvParentWinId + "',\n");
		}
		
		if (!StringUtil.isNull(jvContainerId)) {
			str.append("jvContainerId:'" + jvContainerId + "',\n");
			//str.append("listeners: {\n");
    		//str.append("afterrender:function() {\n");
    		//str.append("Ext.getCmp('" + this.id + "').onResizeByContainer(Ext.getCmp('" + jvContainerId + "'))");
    		//str.append("}\n");
    		//str.append("},\n");
		}
		
		if (!StringUtil.isNull(afterRender)) {
			str.append("listeners: {\n");
    		str.append("render:function() {\n");
    		str.append(afterRender + "();\n");
    		str.append("}\n");
    		str.append("},\n");
		}
		
		/*
		//tbar
				if (tbar!=null&&tbar.items.size()>0) {
					str.append("tbar: ");
					tbar.buildToolbar(this, str);
				}
				//bbar
				if (bbar!=null&&bbar.items.size()>0) {
					str.append("bbar: ");
					bbar.buildToolbar(this, str);
				} 
		*/
	}
	

	protected void buildInstance(StringBuilder str) {
		if (instanceObjs.size() > 0) {
			for (Iterator<BaseInstance> it = instanceObjs.iterator(); it.hasNext();) {
				BaseInstance obj = it.next();
				str.append("var _ds_" + obj.getClass().getSimpleName() + "Class = new Ext.data.ArrayStore({\n" + "fields:['name','value'],\n" + "data:[" + obj.toStore() + "]\n" + "});\n");
			}
		}
	}

	/*
	 * public void addButton(Button button){ buttons.add(button); }
	 */

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

	/*
	 * public void setButtons(List buttons) { this.buttons = buttons; }
	 */
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

	/*
	 * public void setTbar(Toolbar tbar) { this.tbar = tbar; }
	 * 
	 * public void setBbar(Toolbar bbar) { this.bbar = bbar; }
	 */
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
