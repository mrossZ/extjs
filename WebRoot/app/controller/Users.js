Ext.define('AM.controller.Users',{
	extend:'Ext.app.Controller',
	models:['User'],
	stores:['Users'],
	views:['user.List','user.Edit'],
	init:function(){
		this.control({
			'viewport > panel':{
				//render:this.onPanelRendered
				itemdblclick:this.editUser
			},
			'useredit button[action=save]':{
				click:this.updateUser
			}
		});
	},
	onPanelRendered: function(){
		console.log('The panel was rendered.');
	},
	editUser:function(grid,record){
		var view =Ext.widget('useredit');
		view.down('form').loadRecord(record);
	},
	updateUser:function(button){
		var win = button.up('window'),
			form = win.down('form'),
			record=form.getRecord(),
			values=form.getValues();
			record.set(values);
			
			win.close();
			this.getUsersStore().sync();
	}
});
