Ext.onReady(init);

function init() {
 new Ext.Component({
        renderTo: document.body,
        html: Ext.BLANK_IMAGE_URL+'<br/>'+
        Ext.SSL_SECURE_URL+'<br/>'+
        Ext.USE_NATIVE_JSON+'<br/>'+
        Ext.chromeVersion+'<br/>'+
        Ext.enableFx+'<br/>'+
        Ext.enableGarbageCollector+'<br/>'+
        Ext.name
    });
};