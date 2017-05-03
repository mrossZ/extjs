
/***
 * 	使用标签片段进行 增加元素
 */
function appendAsTag(){
	var str = '<ul><li>玉带桥边袅袅风</li>';
	str+='<li>牧童横笛过</li>';
	str+='</ul>';
	
	Ext.DomHelper.append('myDiv',str);
	
}

/***
 * 使用JS对象的方式 进行增加
 */

function appendAsObj(){
	
	var obj={
		tag:'ul',
		children:[
			{ tag:'li',html:'少年听雨歌楼上,红烛昏罗账。' }
		]
	};
	
	Ext.DomHelper.append('myDiv',obj);
}