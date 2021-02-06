var app=new Vue({
    el:'#LAY-user-login',
    data:{
        captchCode:'',
        account:'',
        password:'',
        code:''
    },
    mounted: function () {
        layui.use(['layer'], function () {
            var layer = layui.layer
        })
        var that=this;
        $.ajax({
            type: 'get',
            dataType: 'json',
            url: '/api/config/captch',
            success: function (res) {
                that.captchCode=res.data;
            }
        });
    },
    methods:{
        login:function () {
            var that=this;
            if (that.account==''){
                layer.msg('请输入账号', {icon: 5});
                return;
            }
            if (that.password==''){
                layer.msg('请输入密码', {icon: 5});
                return;
            }
            if (that.code==''){
                layer.msg('请输入验证码', {icon: 5});
                return;
            }
            if (that.code.toUpperCase()!=that.captchCode.toUpperCase()){
                layer.msg('验证码错误', {icon: 5});
                return;
            }
            $.ajax({
                type: 'post',
                dataType: 'json',
                url: '/api/login',
                data:{
                    account:that.account,
                    password:that.password
                },
                success: function (res) {
                    that.captchCode=res.data;
                }
            });
        },
        refreshCode:function () {
            var that=this;
            $.ajax({
                type: 'get',
                dataType: 'json',
                url: '/api/config/captch',
                success: function (res) {
                    that.captchCode=res.data;
                }
            });
        }
    }
});