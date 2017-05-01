Ext.onReady(init);

function init() {
	
	var menu = Ext.create('Ext.tree.Panel');
		menu.setRootNode({
			text:'Root',
			expanded:true,
			children:[{
				text:'Child 1',
				leaf:true
			},{
				text:'Child 2',
				leaf:true
			}]
		});
	
	var root =menu.getRootNode();
	var parent=root.appendChild({
		text:'Parent 1'
	});

	
	
	parent.appendChild({
		text:'Child 3',
		leaf:true
	});
	
	parent.expand();
	
	
	
		
	var parent2=root.appendChild({
		text:'Parent 2',
		expanded:true,
		children:[{
			text:'Child 3',
			leaf:true
		}]
	});
	
	var child = parent2.insertChild(0,{
		text:'Child 2.5',
		leaf:true
	});
	parent2.insertBefore({
		text:'Child 2.75',
		leaf:true
	},child.nextSibling);
	
	
	
	
	//Viewport
	Ext.create('Ext.container.Viewport',{
		items:[menu]
	});
	
};