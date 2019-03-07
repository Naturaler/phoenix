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

// 根据文章id跳转到文章页面
function getArticleById(articleId) {
    window.location.href = "http://localhost:8080/html/article.html?id=" + articleId;
}