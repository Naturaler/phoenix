function getArticleId() {
    var indexUrl = location.search;
    if (indexUrl.indexOf("?") !== -1) {
        var str = indexUrl.substr(1);
        console.log(str);
        var url = "http://localhost:8080/article/getById?" + str;
        httpGet(url, null, function showArticle(json) {
            console.log("getById result:" + json);
            var dto = JSON.parse(json);
            if (dto.code !== 200) {
                console.log("list article error!" + json);
                return;
            }
            var articleObj = dto.result;
            var articles = document.getElementById("articles");

            var article = document.createElement("div");
            article.className = "article";

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
            article.appendChild(article_title);
            article.appendChild(article_info);
            article.appendChild(article_desc);
            articles.appendChild(article);
        });
    }

}