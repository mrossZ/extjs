
/**
 * Using a Proxy
 */

Ext.onReady(init);

function init() {

	Ext.define('Person',{
		extend:'Ext.data.Model',
		fields:[
			{ name:'id', type:'int' },
			{ name:'name', type:'string' }
		],
		proxy:{
			type:'ajax',
			api:{
				create:'createPersons',
				read:'readPersons',
				update:'updatePersons',
				destory:'destoryPersons'
			}
		}
		
	});

	var store=Ext.create('Ext.data.TreeStore',{
		model:'Person',
		root:{
			name:'people',
			expanded:true
		}
	});
	
	Ext.create('Ext.tree.Panel',{
		renderTo:Ext.getBody(),
		width:300,
		height:200,
		title:People,
		store:store,
		columns:[
			{ xtype:'treecolumn',header:'Name',dataIndex:'name',flex:1}
		]
	});

	
	
};