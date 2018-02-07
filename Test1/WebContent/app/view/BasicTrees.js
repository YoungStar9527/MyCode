Ext.define('STAR.view.BasicTrees', {
    extend: 'Ext.Container',
    xtype: 'basic-trees',
    width: 640,

    layout: {
        type: 'table',
        columns: 2,
        tdAttrs: { style: 'padding: 10px;' }
    },

    defaults: {
        xtype: 'treepanel',
        width: 300,
        height: 200,
        rootVisible: false,
        // Sharing the store synchronizes the views:
        store: 'Files'
    },
    
    initComponent: function() {
        this.items = [
            {
                title: 'Tree'
            },
            {
                title: 'Tree with No Lines',
                lines: false
            },
            {
                title: 'Tree with Arrows',
                useArrows: true,
                colspan: 2
            }
        ];

        this.callParent();
    }
});