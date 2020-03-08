
layui.use('element', function(){
});
var app= new Vue({
    el:'#app',
    methods:{
        menuOpen:function (url) {
            document.getElementById('iframeSrc').src=url;
        }
    }
})