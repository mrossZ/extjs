
function extGet(){
	var elDom=Ext.getDom('myDiv');//直接获取html 层元素
	console.info(elDom);
	
	var el=Ext.get('myDiv');//先根据元素Id 获取一个Ext.Element对象
	var elDom2=Ext.getDom(el);//然后再从Ext.Element中获取底层元素
	console.info(elDom2);
}

function extFly(){
	var el=Ext.fly('myDiv');
	console.info(el);
}

