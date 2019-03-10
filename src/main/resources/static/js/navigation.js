// 跳转到index页面
function jump2Home() {
    window.location.href = "http://localhost:8080/html/index.html";
}

// 跳转到category页面
function jump2Category() {
    window.location.href = "http://localhost:8080/html/category.html";
}

// 跳转到tags页面
function jump2Tags() {
    window.location.href = "http://localhost:8080/html/tags.html";
}

// 跳转到archive页面
function jump2Archive() {
    window.location.href = "http://localhost:8080/html/archive.html";
}

// 跳转到search页面
function jump2Search() {
    window.location.href = "http://localhost:8080/html/search.html";
}

// 根据文章id跳转到文章页面
function getArticleById(articleId) {
    window.location.href = "http://localhost:8080/html/article.html?id=" + articleId;
}

// 根据标签或分类跳转到文章列表页面
function getArticleByTypeNParam(type, param) {
    window.location.href = "http://localhost:8080/html/articleList.html?type=" + type + "&param=" + param;
}