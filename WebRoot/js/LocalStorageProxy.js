
function init(){

	//定义一个数据模型类
	Ext.define('Person',{
		extend:'Ext.data.Model',
		fields:['name','age']
	});
	
	//定义一个数据仓库,对应数据库中的表 ,Store包含的记录则是数据库中的，每一行记录。
	var personStore=Ext.create('Ext.data.Store',{
		model:'Person'
	});
	
	//使用LocalStorageProxy
	var personProxy = new Ext.data.proxy.LocalStorage({
		id:'Person_LocalStorage',
		model:'Person'
	});
	
	//将代理和Store联系起来
	personStore.setProxy(personProxy);
	
	//保存数据到LocalStorage中
	personStore.add({name:'user1',age :25});
	personStore.add({name:'user2',age:24});
	personStore.add({name:'user3',age:36});
	personStore.sync();
	
	
	//将数据从LocalStorage中加载到Store中,然后对Store进行遍历
	personStore.load();
	var msg=[];
	
	personStore.each(function(person){
		msg.push(person.get('name')+'  '+person.get('age'));
	});
	
	Ext.MessageBox.alert('提示',msg.join('<br/>'));
	
}




Ext.onReady(init);

