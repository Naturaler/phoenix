// 加载标签
function listTags() {
    var url = "http://localhost:8080/tag/list";
    var data = null;
    httpGet(url, data, function (httpResult) {
        var json = JSON.parse(httpResult);
        if (!json.code === 200) {
            console.log("http get tag error!" + json);
        } else {
            var tags = document.getElementById("tags");
            var tagList = json.result.tagList;
            var s = "";
            var min = tagList[0].count;
            var max = tagList[0].count;
            for (var i in tagList) {
                if (min > tagList[i].count) {
                    min = tagList[i].count;
                }
                if (max < tagList[i].count) {
                    max = tagList[i].count;
                }
            }
            var perSize = 20 / (max - min);
            for (var index in tagList) {
                s += "<span class='tag' style='font-size: " + (20 + (tagList[index].count - min) * perSize) + "px;' onclick='getArticleByTypeNParam(\"tag\", \"" + tagList[index].tag + "\")'>" + tagList[index].tag + "</span>";
            }
            tags.innerHTML = s;
        }
    })
}