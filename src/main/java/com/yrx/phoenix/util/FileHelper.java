package com.yrx.phoenix.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by r.x on 2019/3/27.
 */
@Slf4j
public class FileHelper {

    public FileHelper() {
    }

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\picc");
        String downloadUrl = "https://mmtp1.com/jjtq/qingchun/829/06.jpg";
        downloadZip(downloadUrl, file);
    }

    private static void downloadZip(String downloadUrl, File file) {
        createNewFile(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            URL url = new URL(downloadUrl);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
            InputStream inputStream = connection.getInputStream();
            int length = 0;
            byte[] bytes = new byte[1024];
            while ((length = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, length);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            log.error("download error ! url :{}, file:{}, exception:{}", downloadUrl, file.getAbsolutePath(), e);
        }
        System.out.println("end");
    }

    @Test
    public void test() throws IOException {
        File file = new File("e:\\picccc\\fdasfad\\sss.txt");
        createNewFile(file);
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write("hello world".getBytes());
        outputStream.flush();
        outputStream.close();

    }

    /**
     * 当文件不存在时需创建文件
     * 1、父目录不存在：必须先创建父目录
     * 得根据不同的操作系统判断文件路径是文件还是目录
     * 2、父目录存在时，则可以不进行任何操作
     * @param file
     */
    private static void createNewFile(File file) {
        if (!file.exists()) {
            boolean result = false;
            try {
                result = file.createNewFile();
            } catch (IOException e) {
                log.error("file created error ! path:{}, exception:{}", file.getAbsolutePath(), e);
            }
            // boolean result = file.mkdir();
            System.out.println(result);
            // file.mkdirs();
            // try {
            //     file.createNewFile();
            // } catch (IOException e) {
            //     log.error("file created error ! path:{}, exception:{}", file.getAbsolutePath(), e);
            // }
        }
    }
}
