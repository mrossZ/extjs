Ext.onReady(function () {
	
    Ext.create('Ext.container.Viewport', {
        layout: 'border',
        items: [{
            region: 'north',//上
            html: '<h1 class="x-panel-header">' + 'Hello World' + '</h1>',//标题
            border: false,//无边框
            height: 60,//高度
            margins: '0 0 0 0'//外边距
        }, {
            region: 'west',//左
            collapsible: true,//是否可伸缩隐藏
            split: true,//可拖拽
            id: 'MainMenu',//唯一标识
            title: '系统导航',//左边面板标题
            width: 150,
            layout: 'accordion'//子窗口为折叠
        }, {
            region: 'south',//下面
            collapsible: false,
            html: '状态栏',
            split: false,
            height: 20
        }, {
            region: 'east',//右面
            title: '在线用户',
            collapsible: true,
            split: true,
            width: 150
        }, {
            region: 'center',//右面
            xtype: 'tabpanel',
            id: 'MainTabPanel',
            activeTab: 0,
            items: {
                title: '首页',
                html: '<iframe style="overflow:auto;width:100%; height:100%;" src="' +'http://www.52chujiang.com' + '" frameborder="0"></iframe>'
            }
        }]
    });

    InitMenu("MainMenu", "MainTabPanel", _menu);
});

// 此Menu可以是后台生成，通过AJAX请求加载到页面中的。
var _menu = [		//定义三个菜单栏目录
    {
        id: "systemManage",
        name: "系统管理",
        children: [
            {
                id: "userManage",
                name: "用户管理",
                url: "http://www.baidu.com"
            },
            {
                id: "roleManage",
                name: "角色管理",
                url: "http://www.baidu.com"
            }
        ]
    },
    {
        id: "basicManage",
        name: "基础管理",
        children: [
            {
                id: "warehoseManage",
                name: "库房管理",
                //url: "http://www.baidu.com",
                children: [
                    {
                        id: "physicsWarehoseManage",
                        name: "物理库房管理",
                        url: "http://www.baidu.com"
                    },
                    {
                        id: "logicWarehoseManage",
                        name: "逻辑库房管理",
                        url: "http://www.baidu.com"
                    }
                ]
            }
        ]
    }
];

//递归创建树节点的配置
var buildTreeNodeConfig = function (m) {
    var nodeConfig = {
        text: m.name,
        itemId: m.id,
        leaf: true
    };
    if (m.url) nodeConfig.url = m.url;
    if (m.children) {
        nodeConfig.leaf = false;
        nodeConfig.children = [];
        Ext.Array.each(m.children, function (sub, index) {
            nodeConfig.children[index] = buildTreeNodeConfig(sub);
        });
    }

    return nodeConfig;
}

function InitMenu(accordionId, tabpanelId, menu) {
    var accordionPanel = Ext.getCmp(accordionId);//根据组件Id,获取组件
    if (!accordionPanel) return;

    if (menu) {
        Ext.Array.each(menu, function (item) {
        	
        	//创建面板
            var panel = Ext.create("Ext.panel.Panel", {
                layout: "fit",
                title: item.name,
                itemId: item.id
            });

            accordionPanel.add(panel);

            if (item.children) {
                var tree = Ext.create("Ext.tree.Panel", {
                    border: 0,
                    rootVisible: false,
                    root: {
                        expanded: true
                    },
                    listeners: {
                        itemclick: function (me, record) {
                            if (record.raw.url) {
                                //根据record创建tab标签
                                CreateIframeTab(tabpanelId, record.raw.itemId, record.raw.text, record.raw.url);
                            }
                        }
                    }
                });
                panel.add(tree);
                Ext.Array.each(item.children, function (child) {
                    // 向树中添加子节点（递归）
                    var root = tree.getRootNode();
                    root.appendChild(buildTreeNodeConfig(child));
                });
            }
        });
    }
}

function CreateIframeTab(tabpanelId, tabId, tabTitle, iframeSrc) {
    var tabpanel = Ext.getCmp(tabpanelId);
    if (!tabpanel) return;  //未找到tabpanel，返回

    //寻找id相同的tab
    var tab = Ext.getCmp(tabId);
    if (tab) { tabpanel.setActiveTab(tab); return; }

    //新建一个tab，并将其添加到tabpanel中
    //tab = Ext.create('Ext.tab.Tab', );
    tab = tabpanel.add({
        id: tabId,
        title: tabTitle,
        closable: true,
        html: '<iframe style="overflow:auto;width:100%; height:100%;" src="' + iframeSrc + '" frameborder="0"></iframe>'
    });
    tabpanel.setActiveTab(tab);
}