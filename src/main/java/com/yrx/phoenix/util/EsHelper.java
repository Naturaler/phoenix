package com.yrx.phoenix.util;

import com.yrx.phoenix.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by r.x on 2019/2/12.
 */
@Slf4j
public class EsHelper {
    private final static String ES_INDEX = "phoenix";

    public static void insert(Article article, String plainText, String tags) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        IndexRequest indexRequest = new IndexRequest("phoenix", "article", String.valueOf(article.getId()));
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject()
                    .field("id", article.getId())
                    .field("title", article.getTitle())
                    .field("category", article.getCategory())
                    .field("updateTime", article.getUpdateTime())
                    .field("insertTime", article.getInsertTime())
                    .field("plainText", plainText)
                    .field("tags", tags)
                    .endObject();
            indexRequest.source(builder);
            client.index(indexRequest, RequestOptions.DEFAULT);
            client.close();
        } catch (IOException e) {
            log.error("insert article error! article:{}, plainText:{}, tags:{}, exception:{}", article, plainText, tags, e);
        }
    }

    public static void update(Article article, String plainText, String tags) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        UpdateRequest request = new UpdateRequest("phoenix", "article", String.valueOf(article.getId()));
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject()
                    .field("title", article.getTitle())
                    .field("category", article.getCategory())
                    .field("updateTime", article.getUpdateTime())
                    .field("plainText", plainText)
                    .field("tags", tags)
                    .endObject();
            request.doc(builder);
            client.update(request, RequestOptions.DEFAULT);
            client.close();
        } catch (IOException e) {
            log.error("update article error! article:{}, plainText:{}, tags:{}, exception:{}", article, plainText, tags, e);
        }
    }

    public static void getById(Integer id) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        GetRequest request = new GetRequest("phoenix", "article", String.valueOf(id));
        try {
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
            response.getSource().entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
            client.close();
        } catch (IOException e) {
            log.error("get article error! id:{}, exception:{}", id, e);
        }
    }

    public static List<Map> search(String keyword) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        SearchRequest request = new SearchRequest("phoenix");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(keyword);
        queryStringQueryBuilder.defaultField("*");
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(queryStringQueryBuilder);
        sourceBuilder.query(boolQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        request.source(sourceBuilder);
        List<Map> list = new ArrayList<>();
        try {
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            SearchHit[] searchHits = hits.getHits();
            for (SearchHit searchHit : searchHits) {
                searchHit.getSourceAsMap().entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
                list.add(searchHit.getSourceAsMap());
            }
            client.close();
        } catch (IOException e) {
            log.error("get article error! keyword:{}, exception:{}", keyword, e);
        }
        return list;
    }
}
