/**
 * 初始化加载内容
 */
function init() {
    var url = "http://localhost:8080/article/list";
    var data = "";
    get(url, data);
}

/**
 *get请求
 */
function get(url, data/*, success*/) {
    console.log("data:" + data);
    var xmlhttp = null;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.timeout = 4000;
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 504) {
                console.log("服务器请求超时..");
                error();
                xmlhttp.abort();
            } else if (xmlhttp.status == 200) {
                console.log(xmlhttp.responseText);
                showArticle(xmlhttp.responseText);
            }
            xmlhttp = null;
        }
    }
    xmlhttp.ontimeout = function () {
        console.log("客户端请求超时..");
        error();
    }
    xmlhttp.send(data);//JSON.stringify({name:"小三"})
    /**
     *访问超时后处理
     */
    function error() {
        var body = document.querySelector("body");
        body.innerHTML = "";
        var errorHTML = document.createElement("div");
        errorHTML.innerHTML = "连接超时";
        body.appendChild(errorHTML);
        var refreshHtml = document.createElement("div");
        refreshHtml.innerHTML = '刷新';
        refreshHtml.id = "fresh";
        body.appendChild(refreshHtml);
        refreshHtml.addEventListener('click', function (e) {
            window.location.reload()
        }, false);
    }
}

/**
 * 将内容显示于页面
 * @param titleStr 文章标题
 * @param contentStr 文章简介
 */
function showArticle(json) {
    var articleObj = JSON.parse(json);

    var articles = document.getElementById("articles");

    var article = document.createElement("div");
    article.className = "article";

    var article_title = document.createElement("span");
    article_title.className = "article_title";

    var article_info = document.createElement("div");
    article_info.className = "article_info";

    var article_info_detail_crete_time = document.createElement("span");
    article_info_detail_crete_time.className = "article_info_detail";
    article_info_detail_crete_time.textContent = articleObj.createTime;
    var article_info_detail_line = document.createElement("span");
    article_info_detail_line.className = "article_info_detail";
    article_info_detail_line.textContent = " | ";
    var article_info_detail_category = document.createElement("span");
    article_info_detail_category.className = "article_info_detail";
    article_info_detail_category.textContent = articleObj.category;

    var article_desc = document.createElement("div");
    article_desc.className = "article_desc";

    var content = document.createElement("p");
    content.textContent = articleObj.content;
    article_desc.appendChild(content);
    article_info.appendChild(article_info_detail_crete_time);
    article_info.appendChild(article_info_detail_line);
    article_info.appendChild(article_info_detail_category);
    article_title.textContent = articleObj.title;
    article.appendChild(article_title);
    article.appendChild(article_info);
    article.appendChild(article_desc);
    articles.appendChild(article);
}