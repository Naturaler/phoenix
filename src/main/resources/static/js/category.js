// 加载标签
function listCategories() {
    var url = "http://localhost:8080/category/list";
    var data = null;
    httpGet(url, data, function (httpResult) {
        var json = JSON.parse(httpResult);
        if (!json.code === 200) {
            console.log("http get tag error!" + json);
        } else {
            // document.getElementsByTagName得到的是数组，数组元素的顺序是element在文档中定义的顺序
            var categories = document.getElementsByTagName("ul")[0];
            var categoryList = json.result.categoryList;
            for (var index in categoryList) {
                var category = document.createElement("li");
                category.innerHTML = "<span onclick='getArticleByTypeNParam(\"category\", \"" + categoryList[index].category + "\")'>" + categoryList[index].category + "(" + categoryList[index].count + ")</span>";
                console.log("category:" + category);
                categories.appendChild(category);
            }
        }
    })
}