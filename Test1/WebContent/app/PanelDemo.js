 Ext.onReady(function () {
            Ext.create('Ext.Viewport',({
                title: "Viewport",
                layout: "border", //这里是（border）边界布局
                defaults: {
                    bodyStyle: "background-color: #FFFFFF;",
                    frame: true
                },
                items: [
                             //accordion, //这里是（accordion）手风琴布局
                {
                title: "west",
                layout: "accordion",  //设置为手风琴布局
                layoutConfig: {
                    animate: true
                },
                width: 250,
                minWidth: 90,
                region: "west", //设置方位
                split: true,
                collapsible: true,
                items: [
                            { title: "嵌套面板一", html: "嵌套面板一", iconCls: "save" },
                            { title: "嵌套面板二", html: "嵌套面板二", iconCls: "search" },
                            { title: "嵌套面板三", html: "嵌套面板三", iconCls: "back" },
                            { title: "嵌套面板四", html: "嵌套面板四", iconCls: "12" }
                       ]
            },
                            {region: "east", width: 90, title: 'north', collapsible: true },
                            { region: "north", height: 100, title: 'north', collapsible: true },
                            { region: "center", split: true, border: true, collapsible: true, title: 'center' },
                            { region: "south", title: "south", split: true, border: true, collapsible: true, height: 100 }
                        ]
            }));
        });