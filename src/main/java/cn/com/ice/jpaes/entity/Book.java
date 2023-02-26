package cn.com.ice.jpaes.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "book", type = "novel", shards = 1, replicas = 0)
public class Book {
    @Id
    private String id;
    private String name;
    private String author;
    private Double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }





}

class Test {
    /*
     * SerializerFeature
     *
     * QuoteFieldNames          输出key时是否使用双引号,默认为true
     * WriteMapNullValue        是否输出值为null的字段,默认为false
     * WriteNullNumberAsZero    数值字段如果为null,输出为0,而非null
     * WriteNullListAsEmpty     List字段如果为null,输出为[],而非null
     * WriteNullStringAsEmpty   字符类型字段如果为null,输出为"",而非null
     * WriteNullBooleanAsFalse  Boolean字段如果为null,输出为false,而非null
     */
    public static String serialize(Object src) {
        return JSON.toJSONString(src, SerializerFeature.PrettyFormat);
    }

    public static String serializeWithNulls(Object obj) {
        return JSON.toJSONString(obj,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.PrettyFormat);
    }

    public static void main(String[] args) {
        String str = serializeWithNulls(new Book());
        System.out.println(str);
        Book baseGisBranchParkInfo = new Book();
        System.out.println(serializeWithNulls(baseGisBranchParkInfo));
    }
}