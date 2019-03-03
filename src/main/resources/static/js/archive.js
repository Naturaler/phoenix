function listArticleOrderByYear() {
    var url = "http://localhost:8080/archive/listArticleOrderByYear";
    var data = null;
    hpptGet(url, data, function (httpResult) {
        var json = JSON.parse(httpResult);
        if (!json.code === 200) {
            console.log("http get tag error!" + json);
        } else {
            var archives = document.getElementsByTagName("ul")[0];
            var archiveList = json.result.archiveList;
            for (var index in archiveList) {
                var archive = document.createElement("li");
                archive.innerHTML = "<span>" + archiveList[index].insertTime + " " + archiveList[index].title + "</span>";
                archives.appendChild(archive);
            }
        }
    })
}