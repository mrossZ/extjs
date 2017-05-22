package taglib;

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
			//str.append("fieldLabel:'" + StringUtil.encodeJs(fieldLabel) + "',\n");
			str.append("fieldLabel:'<b>" + StringUtil.encodeJs(findString(fieldLabel)) + "</b>',\n");		
		}

		
		if (height!=null)
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
		
		if (width!=null)
			str.append("width:" + width + ",\n");
		
		if (x!=null)
			str.append("x:" + x + ",\n");

		if (y!=null)
			str.append("y:" + y + ",\n");

		if (!StringUtil.isNull(xtype))
			str.append("xtype:'" + StringUtil.encodeJs(xtype) + "',\n");
		
		if (plugins.size()>0) {
			str.append("plugins:[\n");
			Iterator<Plugin> iterator = plugins.iterator();
			while(iterator.hasNext())
			{
				Plugin plugin = iterator.next();
				str.append(plugin.toHtml());
				str.append(",\n");
			}
			str.deleteCharAt(str.length() - 2);
			str.append("],\n");
			
		}

		
	}

	@Override
	public String getId() {

		return null;
	}

}
