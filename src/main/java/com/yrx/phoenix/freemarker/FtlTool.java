package com.yrx.phoenix.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by r.x on 2019/4/13.
 */
public class FtlTool {
    public static void main(String[] args) {
        Instant instant = Instant.parse("2019-04-14T12:04:00");
        System.out.println(instant.toString());
    }

    @Test
    public void testFreeMarker() throws Exception {
        Map<String, Object> root = new HashMap<>();
        root.put("id", "10086");
        root.put("name", "张三");
        root.put("age", 18);
        root.put("salary", 12306.98765);
        root.put("score", "90");
        StringWriter stringWriter = process(root);
        System.out.println(stringWriter.toString());
        //关闭writer对象。
        stringWriter.flush();
        stringWriter.close();
    }

    private StringWriter process(Map<String, Object> data) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "ftl");
        configuration.setDefaultEncoding("utf-8");
        // 添加自定义函数
        configuration.setSharedVariable(Score2GradeMethod.METHOD_NAME, new Score2GradeMethod());
        Template template = configuration.getTemplate("test.ftl");
        StringWriter writer = new StringWriter();
        template.process(data, writer);
        return writer;
    }
}
