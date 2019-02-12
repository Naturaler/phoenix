function editArticle() {
    var title = document.getElementById("title").value;
    var note = document.getElementById("note").value;
    var url = "http://localhost:8080/edit/article";
    var data = JSON.stringify({"title": title, "content": note});
    post(url, data/*, new function (msg) {
        alert("req result:" + msg);
    }*/);
}

/**
 *post请求
 *
 */
function post(url, data/*, success*/) {
    console.log("data:" + data);
    var xmlhttp = null;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");//www-form-urlencoded
    xmlhttp.timeout = 4000;
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 504) {
                console.log("服务器请求超时..");
                error();
                xmlhttp.abort();
            } else if (xmlhttp.status == 200) {
                console.log(xmlhttp.responseText);
                // success(xmlhttp.responseText);
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