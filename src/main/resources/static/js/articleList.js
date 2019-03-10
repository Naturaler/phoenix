function loadBaseLayout() {
    // head
    var headTitle = document.createElement("div");
    headTitle.textContent = "行走的鸡汤";
    headTitle.className = "title";
    var headSignature = document.createElement("div");
    headSignature.textContent = "看心情更新";
    headSignature.className = "signature";
    var head = document.createElement("div");
    head.id = "head";
    head.appendChild(headTitle);
    head.appendChild(headSignature);
    // navigations
    var navigationHome = document.createElement("span");
    navigationHome.textContent = "Home";
    navigationHome.className = "navigation";
    navigationHome.setAttribute("onclick", "jump2Home()");
    var navigationTags = document.createElement("span");
    navigationTags.textContent = "Tags";
    navigationTags.className = "navigation";
    navigationTags.setAttribute("onclick", "jump2Tags()");
    var navigationCategory = document.createElement("span");
    navigationCategory.textContent = "Categories";
    navigationCategory.className = "navigation";
    navigationCategory.setAttribute("onclick", "jump2Category()");
    var navigationArchive = document.createElement("span");
    navigationArchive.textContent = "Archives";
    navigationArchive.className = "navigation";
    navigationArchive.setAttribute("onclick", "jump2Archive()");
    var navigationSearch = document.createElement("span");
    navigationSearch.textContent = "Search";
    navigationSearch.className = "navigation";
    navigationSearch.setAttribute("onclick", "jump2Search()");
    var navigations = document.createElement("div");
    navigations.id = "navigations";
    navigations.appendChild(navigationHome);
    navigations.appendChild(navigationTags);
    navigations.appendChild(navigationCategory);
    navigations.appendChild(navigationArchive);
    navigations.appendChild(navigationSearch);
    var articleList = document.createElement("div");
    articleList.id = "archives";
    var ul = document.createElement("ul");
    articleList.appendChild(ul);
    // append head、navigation and article list
    var body = document.getElementsByTagName("body")[0];
    body.appendChild(head);
    body.appendChild(navigations);
    body.appendChild(articleList);
    // 根据要求加载文章列表
    listArticles();
}

function listArticles() {
    var indexUrl = location.search;
    if (indexUrl.indexOf("?") !== -1) {
        var str = indexUrl.substr(1);
        var typeNParam = str.split("&");
        var type = typeNParam[0].split("=")[1];
        var param = typeNParam[1].split("=")[1];
        var url = "";
        if (type === "tag") {
            url = "http://localhost:8080/article/listByTag?tag=" + param;
        }
        if (type === "category") {
            url = "http://localhost:8080/article/listByCategory?category=" + param;
        }
        console.log("listArticles url:" + url);
        httpGet(url, null, function (httpResult) {
            var json = JSON.parse(httpResult);
            if (!json.code === 200) {
                console.log("http get tag error!" + json);
            } else {
                var archives = document.getElementsByTagName("ul")[0];
                var articleDescList = json.result.articleDescList;
                var year = document.createElement("h1");
                year.textContent = json.result.content;
                var yearLi = document.createElement("li");
                yearLi.appendChild(year);
                var archiveUl = undefined;
                for (var i in articleDescList) {
                    if (archiveUl === undefined) {
                        archiveUl = document.createElement("ul");
                    }
                    var archive = document.createElement("li");
                    archive.innerHTML = "<span onclick='getArticleById(" + articleDescList[i].id + ")'>" + articleDescList[i].insertTime + " " + articleDescList[i].title + "</span>";
                    archiveUl.appendChild(archive);
                }
                yearLi.appendChild(archiveUl);
                archives.appendChild(yearLi);
                archiveUl = undefined;
            }
        })
    }
}