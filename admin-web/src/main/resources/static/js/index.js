
var app= new Vue({
    el:'#app',
    data:{
        menuHtml:''
    },
    mounted: function () {
        var that=this;
        $.ajax({
            type: 'get',
            dataType: 'text',
            url: '/api/menu/html',
            success: function (res) {
                that.menuHtml=res;
                layui.use('element', function(){
                });
            },
            error:function (res) {
                var v=res;
            }
        });
        //vueDom.totalCount=total;
    },
    methods:{
        menuOpen:function (url) {
            document.getElementById('iframeSrc').src=url;
        }
    }
})