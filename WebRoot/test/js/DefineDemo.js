function Developer() {

	Ext.define("Person", {
				Name : '',
				Age : 0,
				Say : function(msg) {
					Ext.Msg.alert(this.Name + "Says:", msg);
				},
				constructor : function(name, age) {
					this.Name = name;
					this.Age = age;
				}
			});

	Ext.define("Animate", {
				config : {
					Name : '',
					Age : 0

				},
				Say : function(msg) {
					Ext.Msg.alert(this.Name + "Says:", msg);
				},
				constructor : function(config) {
					this.initConfig(config);
				}
			});

	Ext.define("Developer", {
				extend : 'Person',
				Coding : function(code) {
					Ext.Msg.alert(this.Name + " 正在编码", code);
				},
				constructor : function() {
					this.callParent(arguments);
				}

			});

	//var Bill = new Developer("Bill", 26);
	//Bill.Coding("Java");
	
	var dog = Ext.create("Animate",{
		Name:'Dog',
		Age:2
	});
	
	dog.Say("汪汪~~");
}

Ext.onReady(Developer);
