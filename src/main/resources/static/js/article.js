function getArticleId() {
    var indexUrl = location.search;
    if (indexUrl.indexOf("?") != -1) {
        var str = indexUrl.substr(1);
        console.log(str);
        var url = "http://localhost:8080/article/getById?" + str;
        hpptGet(url, null, function (result) {
            console.log("get http result" + result);
        });
    }

}