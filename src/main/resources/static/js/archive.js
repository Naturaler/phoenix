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
            var yearList = [];
            for (var index in archiveList) {
                var yearValue = archiveList[index].year;
                if (yearList.indexOf(yearValue) === -1) {
                    yearList.push(yearValue);
                }
            }
            console.log("year list:" + yearList);
            for (var yearIndex in yearList) {
                var year = document.createElement("h1");
                year.textContent = yearList[yearIndex];
                var yearLi = document.createElement("li");
                yearLi.appendChild(year);
                var archiveUl = undefined;
                for (var i in archiveList) {
                    if (archiveUl === undefined) {
                        archiveUl = document.createElement("ul");
                    }
                    if (archiveList[i].year === yearList[yearIndex]) {
                        var archive = document.createElement("li");
                        archive.innerHTML = "<span>" + archiveList[i].insertTime + " " + archiveList[i].title + "</span>";
                        archiveUl.appendChild(archive);
                    }
                }
                yearLi.appendChild(archiveUl);
                archives.appendChild(yearLi);
                archiveUl = undefined;
            }
        }
    })
}