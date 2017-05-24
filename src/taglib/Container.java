package taglib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

import instance.BaseInstance;
import utitlity.StringUtil;

public class Container extends BoxComponent {
	protected String activeItem;
	protected boolean autoDestroy = true;
	protected Integer bufferResize;
	protected String defaultType;
	protected String defaults;
	protected boolean forceLayout;
	protected boolean hideBorders;
	protected String layout;
	protected String layoutConfig;
	protected boolean monitorResize;
	protected String resizeEvent;

	protected List<ExtComponent> items = new ArrayList<ExtComponent>();

	protected List<BaseInstance> instanceObjs = new ArrayList<BaseInstance>();

	public Container(ValueStack stack) {
		super(stack);
	}

	public void addItem(ExtComponent componentItem) {
		items.add(componentItem);
	}

	public void removeItem(ExtComponent componentItem) {
		items.remove(componentItem);
	}

	public void buildProperties(Component component, StringBuilder str) {
		super.buildProperties(component, str);

		if (!StringUtil.isNull(activeItem))
			str.append("activeItem:'" + StringUtil.encodeJs(activeItem) + "',\n");

		if (!autoDestroy)
			str.append("autoDestroy:false,\n");

		if (bufferResize != null)
			str.append("bufferResize:" + bufferResize + ",\n");

		if (!StringUtil.isNull(defaultType))
			str.append("defaultType:'" + StringUtil.encodeJs(defaultType) + "',\n");

		if (forceLayout)
			str.append("forceLayout:true,\n");

		if (hideBorders)
			str.append("hideBorders:true,\n");

		if (!StringUtil.isNull(layout))
			str.append("layout:" + layout + ",\n");

		if (!StringUtil.isNull(layoutConfig))
			str.append("layoutConfig:" + layoutConfig + ",\n");

		if (!StringUtil.isNull(defaults))
			str.append("defaults:" + defaults + ",\n");

		if (monitorResize)
			str.append("monitorResize:true,\n");

		if (!StringUtil.isNull(resizeEvent))
			str.append("resizeEvent:'" + StringUtil.encodeJs(resizeEvent) + "',\n");

		if (items.size() > 0) {
			str.append("items: [\n");
			Iterator<ExtComponent> it = items.iterator();
			while (it.hasNext()) {
				ExtComponent extItem = it.next();
				if (extItem instanceof Panel) {
					str.append("_panel_" + extItem.getId() + ",\n");
				}
				/*
				if (extItem instanceof LabelText) {
					extItem.buildProperties(this, str);
				} else if (extItem instanceof Panel) {
					str.append("_panel_" + extItem.getId() + ",\n");
				} else if (extItem instanceof RecordSelect) {
					str.append("_rec_" + ((RecordSelect) extItem).getParentPanel().getId() + ",\n");
				} 
				*/
				else {
					str.append("{\n");

					extItem.buildProperties(this, str);

					str.deleteCharAt(str.length() - 2);
					str.append("},\n");
				}
				
			}
			if (items.size() > 0)
				str.deleteCharAt(str.length() - 2);
			str.append("],\n");

			items.clear();
		}
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

	public int getItemCount() {
		return items.size();
	}

	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}

	public void addInstanceObj(BaseInstance instanceObj) {
		ExtLib extlib = (ExtLib) findAncestor(ExtLib.class);
		if (extlib.regInstance(instanceObj))
			instanceObjs.add(instanceObj);
	}

}
