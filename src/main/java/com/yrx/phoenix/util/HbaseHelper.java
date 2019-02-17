package com.yrx.phoenix.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by r.x on 2019/2/12.
 */
@Slf4j
public class HbaseHelper {

    public static void createTable() {
        Admin admin = null;
        try {
            //创建配置文件
            Configuration config = HBaseConfiguration.create();
            //设置配置文件信息
            // config.set("hbase.zookeeper.quorum", "117.48.201.248:2181"); // 京东云
            config.set("hbase.zookeeper.quorum", "192.168.163.144:2181");
            //创建数据库对象
            Connection connection = ConnectionFactory.createConnection(config);
            admin = connection.getAdmin();
            // HBaseAdmin admin = new HBaseAdmin(configuration);
            //创建表对象
            HTableDescriptor hd = new HTableDescriptor(TableName.valueOf("phoenix".getBytes()));
            //创建列族对象
            HColumnDescriptor article = new HColumnDescriptor("article".getBytes());
            //设置列族保存最大历史版本
            article.setMaxVersions(3);
            // HColumnDescriptor hc2 = new HColumnDescriptor("cf02".getBytes());
            // hc2.setMaxVersions(3);
            hd.addFamily(article);
            // hd.addFamily(hc2);
            //创建表
            admin.createTable(hd);
        } catch (IOException e) {
            log.error("hbase create table error!", e);
        } finally {
            //关闭连接
            if (admin != null) {
                try {
                    admin.close();
                } catch (IOException e) {
                    log.error("close hbase admin error!", e);
                }
            }
        }
    }

    public static void main(String[] args) {
        createTable();
    }
}
