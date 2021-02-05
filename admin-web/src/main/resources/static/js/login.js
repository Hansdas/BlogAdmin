var app=new Vue({
    el:'#LAY-user-login',
    data:{
        captchCode:''
    },
    mounted: function () {
        var that=this;
        $.ajax({
            type: 'get',
            dataType: 'json',
            url: '/api/config/captch',
            success: function (res) {
                that.captchCode=res.data;
            },
            error:function (res) {
                var v=res;
            }
        });
        //vueDom.totalCount=total;
    },
});