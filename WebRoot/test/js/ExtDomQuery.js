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
		var el=Ext.DomQuery.selectNode("span[@id='myWin_header_hd-textEl']");
  		var arr=Ext.query("span");
  		Ext.DomHelper.insertHtml("afterBegin",Ext.getBody().dom,el.innerHTML);
  		
  		
  		
  		console.info(Ext.getBody().dom);
  		
}



function testQuery(){
	var el=Ext.DomQuery.selectNode("div[@class='my']");
	var el2=Ext.query("div[@class='my']");
	for(var i=0;i<el2.length;i++){
		console.info(el2[i].innerHTML);
	}
}












