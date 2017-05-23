package taglib;

import java.util.Iterator;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

import utitlity.StringUtil;

public class BoxComponent extends ExtComponent {
	protected String id;

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

	protected String margins;

	protected Integer x;
	protected Integer y;

	public BoxComponent(ValueStack stack) {
		super(stack);
	}

	@Override
	public void buildProperties(Component component, StringBuilder str) {

		if (autoHeight)
			str.append("autoHeight:true,\n");

		if (autoScroll)
			str.append("autoScroll:true,\n");

		if (autoShow)
			str.append("autoShow:true,\n");

		if (autoWidth)
			str.append("autoWidth:true,\n");

		if (!StringUtil.isNull(region))
			str.append("region:'" + StringUtil.encodeJs(region) + "',\n");

		if (!StringUtil.isNull(cls))
			str.append("cls:'" + StringUtil.encodeJs(cls) + "',\n");

		if (disabled)
			str.append("disabled:true,\n");

		if (!StringUtil.isNull(disabledClass))
			str.append("disabledClass:'" + StringUtil.encodeJs(disabledClass) + "',\n");

		if (!StringUtil.isNull(fieldLabel)) {
			// str.append("fieldLabel:'" + StringUtil.encodeJs(fieldLabel) +
			// "',\n");
			str.append("fieldLabel:'<b>" + StringUtil.encodeJs(findString(fieldLabel)) + "</b>',\n");
		}

		if (height != null)
			str.append("height:" + height + ",\n");

		if (hidden)
			str.append("hidden:true,\n");

		if (hideLabel)
			str.append("hideLabel:true,\n");

		if (!StringUtil.isNull(html))
			str.append("html:'" + StringUtil.encodeJs(html) + "',\n");

		if (!StringUtil.isNull(id))
			str.append("id:'" + StringUtil.encodeJs(id) + "',\n");

		if (!StringUtil.isNull(renderTo))
			str.append("renderTo:'" + StringUtil.encodeJs(renderTo) + "',\n");

		if (!StringUtil.isNull(style))
			str.append("style:'" + StringUtil.encodeJs(style) + "',\n");

		if (!StringUtil.isNull(margins))
			str.append("margins:'" + StringUtil.encodeJs(margins) + "',\n");

		if (width != null)
			str.append("width:" + width + ",\n");

		if (x != null)
			str.append("x:" + x + ",\n");

		if (y != null)
			str.append("y:" + y + ",\n");

		if (!StringUtil.isNull(xtype))
			str.append("xtype:'" + StringUtil.encodeJs(xtype) + "',\n");

		if (plugins.size() > 0) {
			str.append("plugins:[\n");
			Iterator<Plugin> iterator = plugins.iterator();
			while (iterator.hasNext()) {
				Plugin plugin = iterator.next();
				str.append(plugin.toHtml());
				str.append(",\n");
			}
			str.deleteCharAt(str.length() - 2);
			str.append("],\n");

		}

	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
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

	public void setRegion(String region) {
		this.region = region;
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
