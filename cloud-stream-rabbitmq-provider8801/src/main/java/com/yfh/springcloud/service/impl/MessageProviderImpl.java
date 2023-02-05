package com.yfh.springcloud.service.impl;

import com.yfh.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wangfei
 * @data 2023/1/27 - 4:27
 */
@EnableBinding(Source.class)//定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    /**
     *  @Autowired
        @Qualifier(Source.OUTPUT)

        @Resource根据先类型注入，其次根据名字，但是有三个MessageChannel类型bean,
        所以这个变量名就要定义成某个MessageChannel类型bean（output），否则会报错，
        也可以用上面那个@Autowired和@Qualifier(Source.OUTPUT)，对变量名就没有要求。
     */
    @Resource
    private MessageChannel output;// 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*****serial: "+serial);
        return null;
    }
}
