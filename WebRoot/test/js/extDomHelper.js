
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

function testInsert(){
	var str='<ul><li>人生若只如初见,</li>';
	str +='<li>何事秋风悲画扇。</li></ul>';
	Ext.DomHelper.insertHtml('afterBegin',Ext.getDom('myDiv'),str);
}
/***
 * 标签覆盖
 */
function testOverwrite(){
	var str ='<ul><li>吟诗作赋是骚客,<li>';
	str+='<li>武枪弄炮一剑人。</li></ul>';
	Ext.DomHelper.overwrite('myDiv',str);
}

/**
 * 使用模板
 */
function testTemplate(){
	var tpl=Ext.DomHelper.createTemplate("<li>{content}</li>");
	tpl.overwrite('myDiv',{content:'劝君莫作独醒人，烂醉花间应有数。'});
}













