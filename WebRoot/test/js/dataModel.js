
function dataModel(){
	
	Ext.data.validations.lengthMessage="长度错误";
	
	//自定义验证规则
	Ext.apply(Ext.data.validations,{
		ageMessage:'必须在0到150之间',
		age:function(config,value){
			if(value==undefined || value==null){
				return false;
			}
			
			if(value<0 || value>150){
				return false;
			}
			
			return true;
		}
	});
	
	
	Ext.define('MyApp.User', {
		extend : 'Ext.data.Model',
		fields : [
				{
					name : 'name',
					type : 'string'
				}, {
					name : 'age',
					type : 'int'
				}, {
					name : 'phone',
					type : 'string'
				},{
					name:'birthday',
					type:'date',
					convert:function(value,record){
						if(Ext.isDate(value)){
							return value;
						}
						else if(Ext.isString(value)){
							return Ext.Date.parse(value,"Y-m-d");
						}
					}
				}
		 ],
		 validations:[
		 	{	field:'phone',type:'length',min:8,max:15 },
		 	{	field:'age',type:'age',min:8,max:15 }
		 ]						
	});
	
	var Tom = Ext.create("MyApp.User",{
		name:'Tom',
		age:200,
		phone:'123456',
		birthday:'2000-10-15'
	});
	
	var errors=Tom.validate();
	var errorMsg=[];
	if(!errors.isValid()){
		errors.each(function(error){
			errorMsg.push(error.field+"  "+ error.message);
		});
		Ext.Msg.alert("错误",errorMsg.join('<br />'));
	}
	
	
//	Tom.set('age',20);
//	Ext.MessageBox.alert('提示',Tom.get('birthday'));
	
}

Ext.onReady(dataModel);
