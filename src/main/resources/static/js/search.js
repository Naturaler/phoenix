function search(event) {
    var keyCode = event.which;
    console.log("realkey:" + keyCode);
    if (keyCode === 13) {
        var keyword = document.getElementById("mysearch").value;
        console.log("value:" + keyword);
        var url = "http://localhost:8080/article/search?keyword=" + keyword;
        httpGet(url, null, function (httpResult) {
            var json = JSON.parse(httpResult);
            if (!json.code === 200) {
                console.log("http get tag error!" + json);
            } else {
                var ul = document.getElementsByTagName("ul")[0];
                // 循环删除子节点
                while (ul.hasChildNodes()) {
                    ul.removeChild(ul.firstChild);
                }
                var articleDescList = json.result.articleDescList;
                for (var index in articleDescList) {
                    var span = document.createElement("span");
                    span.textContent = articleDescList[index].title;
                    span.className = "title";
                    span.setAttribute("onclick", "refreshArticle('" + articleDescList[index].id + "')")
                    var p = document.createElement("p");
                    p.textContent = articleDescList[index].insertTime + " " + articleDescList[index].outline;
                    var li = document.createElement("li");
                    li.appendChild(span);
                    li.appendChild(p);
                    ul.appendChild(li);
                }

            }
        })
    }
}

function refreshArticle(id) {
    var url = "http://localhost:8080/article/getById?id=" + id;
    httpGet(url, null, function (httpResult) {
        var json = JSON.parse(httpResult);
        if (!json.code === 200) {
            console.log("http get by id error!" + json);
        } else {
            var articleObj = json.result;

            var article_title = document.createElement("span");
            article_title.className = "article_title";

            var article_info = document.createElement("div");
            article_info.className = "article_info";

            var article_info_detail_crete_time = document.createElement("span");
            article_info_detail_crete_time.className = "article_info_detail";
            article_info_detail_crete_time.textContent = articleObj.updateTime;
            var article_info_detail_line = document.createElement("span");
            article_info_detail_line.className = "article_info_detail";
            article_info_detail_line.textContent = " | ";
            var article_info_detail_category = document.createElement("span");
            article_info_detail_category.className = "article_info_detail";
            article_info_detail_category.textContent = articleObj.category;

            var article_desc = document.createElement("div");
            article_desc.className = "article_desc";

            var content = document.createElement("p");
            content.innerHTML = articleObj.content;
            article_desc.appendChild(content);
            article_info.appendChild(article_info_detail_crete_time);
            article_info.appendChild(article_info_detail_line);
            article_info.appendChild(article_info_detail_category);
            article_title.textContent = articleObj.title;
            article_title.id = articleObj.id;
            // article_title.onclick = getArticleById(1);
            var article = document.createElement("div");
            article.className = "article";
            article.appendChild(article_title);
            article.appendChild(article_info);
            article.appendChild(article_desc);
            var articles = document.getElementById("articles");
            while (articles.hasChildNodes()) {
                articles.removeChild(articles.firstChild);
            }
            articles.appendChild(article);
        }
    })
}
