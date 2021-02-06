$.ajaxSetup({
    dataType:'json',
    cache: false,
    dataFilter: function (data, type){
       var result= JSON.parse(data);
       if (result.message=='not login') {
           top.location.href="../pages/login.html"
       }
    },
    complete: function (request, textStatus){
        var i=1;
    }
});