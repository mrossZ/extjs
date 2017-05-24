package taglib;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.StrutsException;

import com.opensymphony.xwork2.util.ValueStack;

import utitlity.StringUtil;

public class FormPanel extends Panel {
	protected String formId;
	protected boolean hideLabels;
	protected String itemCls;
	protected String labelAlign;
	protected Integer labelPad;
	protected Integer labelWidth;
	protected String layout;
	protected Integer monitorPoll;
	protected boolean monitorValid;
	protected boolean fileUpload;
	protected boolean saveRefresh;
	protected boolean defaultNewAction;

	protected String dataSourceName;
	// protected List<Field> fieldList = new ArrayList<Field>();
	// protected Map<String,Field> dataFields = new HashMap<String,Field>();

	protected boolean paging;
	protected int pageSize;

	// 存放菜单项
	// protected List<Menu> menus = new ArrayList<Menu>();

	// 定义是否支持OJBID和版本(只适用于统计或只读页面)
	protected boolean supportVersion = true;

	//
	protected String dataUrl;
	protected String newUrl;
	protected String newJs;
	protected String saveUrl;
	protected String saveJs;
	protected String deleteUrl;
	protected String deleteJs;

	protected boolean searchable;

	// 记录选择控件
	// protected RecordSelect recordSelect;

	// 定义是否支持状态机
	protected boolean supportState;

	// 定义加载数据后执行的事件函数
	protected String afterLoadRecord;
	// 定义新建按钮执行后的事件函数
	protected String afterNewRecord;
	// 定义复制按钮执行后的事件函数
	protected String afterCopyRecord;
	// 定义保存按钮执行后的事件函数
	protected String afterSaveRecord;
	// 定义删除按钮执行后的事件函数
	protected String afterDeleteRecord;

	// 设置窗口不必要做状态控制,默认为true
	protected boolean initFieldState;

	protected boolean hideLoadData;

	public FormPanel(ValueStack stack) {
		super(stack);
	}

	public boolean start(Writer writer) {
		return super.start(writer);
	}

	public boolean end(Writer writer, String body) {
		try {
			StringBuilder str = new StringBuilder();
			str.append("Ext.define('" + id.substring(0, 1).toUpperCase() + id.substring(1) + "Model',{\n");
			str.append("extend:'Ext.data.Model',\n");
			str.append("fields:[\n");

			if (supportVersion) {
				str.append("{name:'id'},\n");
				str.append("{name:'version'},\n");
				str.append("{name:'lu'},\n");
				str.append("{name:'key'},\n");
			}

			if (supportState) {
				str.append("{name:'stateEvents'},\n");
			}

			str.deleteCharAt(str.length() - 2);
			str.append("]\n");
			str.append("});\n");

			if (!StringUtil.isNull(dataUrl)) {
				str.append("var _ds_" + id + " = Ext.create('Ext.data.JovenStore',{\n");
				str.append("remoteSort:true,\n");
				if (paging) {
					str.append("pageSize:" + pageSize + ",\n");
				}
				str.append("model:'" + id.substring(0, 1).toUpperCase() + id.substring(1) + "model',\n");
				str.append("proxy:{\n");
				str.append("type:'ajax',\n");
				str.append("url:'" + dataUrl + "',\n");
				str.append("actionMethods:{read:'POST'},\n");
				str.append("reader:{\n");
				str.append("type:'json',\n");
				str.append("totalProperty:'recordData.totalCount',\n");
				str.append("root:'recordData.records'\n");
				str.append("}\n");
				str.append("},\n");
				str.deleteCharAt(str.length() - 2);
				str.append("});\n");

				/*
				 * if (recordSelect!=null) { //str.append("var _rec_" + id +
				 * " = new Ext.form.ComboBox({\n"); str.append("var _rec_" + id
				 * + " = Ext.create('Ext.form.field.RecordSelecter', {\n");
				 * recordSelect.buildProperties(this,str);
				 * str.deleteCharAt(str.length() - 2); str.append("});\n");
				 * 
				 * }
				 */
			}

			str.append("var _panel_" + id + " = Ext.create('Ext.form.JovenFormPanel', {\n");
			buildProperties(parentContainer, str);

			str.deleteCharAt(str.length() - 2);

			str.append("});\n");

			if (!StringUtil.isNull(jvTabPanelId)) {
				str.append("Ext.getCmp('" + jvTabPanelId + "').setContainedPanel(Ext.getCmp('" + this.id + "'));\n");
				str.append("Ext.getCmp('" + jvTabPanelId + "').add(Ext.getCmp('" + this.id + "'));\n");
			}

			if (!StringUtil.isNull(jvContainerId)) {
				str.append("Ext.getCmp('" + jvContainerId + "').containedPanel = Ext.getCmp('" + this.id + "');\n");
				str.append("Ext.getCmp('" + jvContainerId + "').add(Ext.getCmp('" + this.id + "'));\n");
			}

			writer.write(str.toString());

		} catch (IOException e) {
			throw new StrutsException("IOError: " + e.getMessage(), e);
		}

		// buildFitSize(writer);
		/*
		 * if (tbar!=null) tbar.clear();
		 * 
		 * if (bbar!=null) bbar.clear();
		 */
		return true;

	}

}
