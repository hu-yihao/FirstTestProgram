/*
 * @Author: 霍格沃兹测试开发学社-盖盖
 * @Desc: '更多测试开发技术探讨，请访问：https://ceshiren.com/t/topic/15860'
 */
package com.ceshiren;

import org.slf4j.Logger;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class MySUT {
    //获得具有所需名称的记录器
    static final Logger logger = getLogger(lookup().lookupClass());

    //用例名
    String name;
    //唯一ID标识
    String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MySUT(String name) {
        this.name = name;
        logger.info("Open {} ", name);
    }


    public void initId(){
        id = UUID.randomUUID().toString();
        logger.info("Generate ID：{} ", id);

    }

    public void destroyId() {
        if (id == null) {
            throw new IllegalArgumentException(name + " failed to initialize ID");
        }
        logger.info("Release ID: {} ", id);
        id = null;
    }


    public void close() {
        logger.info("Close {} ", name);
    }

    //连续添加
    public int sum(int... numbers) {
        if(Arrays.stream(numbers).anyMatch(u -> u == 100)){
            logger.warn("integer is 100！");
            throw new NumberFormatException("integer is 100！");
        }else  if(Arrays.stream(numbers).anyMatch(u -> u > 99) | Arrays.stream(numbers).anyMatch(u -> u < -99)){
            // 请输入范围内的整数
            logger.warn("Please enter an integer in the range");
            throw new IllegalArgumentException("Please enter an integer in the range！");
        }else {
            return IntStream.of(numbers).sum();
        }

    }
}