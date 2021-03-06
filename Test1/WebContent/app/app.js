Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.Loader.setConfig({
		enabled:true
	});
	Ext.application({
		name : 'STAR',//应用的名字
		appFolder : "",//应用的目录
		launch:function(){//当前页面加载完成执行的函数
	        Ext.create('Ext.container.Viewport', { //简单创建一个试图
	        	layout:'auto',//自动填充布局
	            items: {
	            	xtype: 'panel',
	                title: 'Users',
	                html : 'List of users will go here'
	            }
	        });
		},
		controllers:[
			'BasicTrees'
		]
	});
})