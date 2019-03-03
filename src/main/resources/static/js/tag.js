// 加载标签
function listTags() {
    var url = "http://localhost:8080/tag/list";
    var data = null;
    hpptGet(url, data, function (httpResult) {
        var json = JSON.parse(httpResult);
        if (!json.code === 200) {
            console.log("http get tag error!" + json);
        } else {
            var tags = document.getElementById("tags");
            var tagList = json.result.tagList;
            for (var index in tagList) {
                var tag = document.createElement("span");
                tag.className = "tag";
                tag.textContent = tagList[index].tag;
                tags.appendChild(tag);
            }
        }
    })
}