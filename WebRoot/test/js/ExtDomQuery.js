/***
DomQuery 支持4种选择器

元素选择器
属性选择器
伪类
CSS选择器

*/

Ext.onReady(initWindow);

function initWindow(){
	var win = new Ext.Window({
		id:'myWin',
		title:'DomQuery',
		width:400,
		height:300,
		renderTo:Ext.getBody(),
		bbar:[
			{
				text:'元素选择器',
				handler:handler
						
			}
		]
	
	});
	
	win.show();
}
function handler(){
		var el=Ext.query("div:first-child");
		console.info(el);
}














