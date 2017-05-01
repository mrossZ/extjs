Ext.onReady(init);

function init() {

	var store=Ext.create('Ext.data.TreeStore',{
		root:{
			text:'Root',
			expanded:true,
			children:[
				{
					text:'Child 1',
					leaf:true
				},
				{
					text:'Child 2',
					leaf:true
				},
				
				{
					text:'Child 3',
					expanded:true,
					children:[
						{
							text:'GrandChild',
							leaf:true
						}
					]
				}				
			]
		}
	});
	
	var menu=Ext.create('Ext.tree.Panel',{
		readerTo:Ext.getBody(),
		store:store,
		title:'Simple Tree',
		width:300,
		height:150
	});
	
	//Viewport
	Ext.create('Ext.container.Viewport',{
		items:[menu]
	});
	
	
	
};