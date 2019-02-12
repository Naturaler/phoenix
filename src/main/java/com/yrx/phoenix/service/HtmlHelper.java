package com.yrx.phoenix.service;

/**
 * Created by r.x on 2019/2/11.
 */
public class HtmlHelper {
    private HtmlHelper() {

    }

    public static String generateHtml(String title, String body) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>").append(title).append("</title>\n" +
                "</head>\n" +
                "<body>\n")
                .append(body)
                .append("</body></html>");
        return html.toString();
    }
}
