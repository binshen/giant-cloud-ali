package com.giant.cloud.stream.api;

import com.giant.cloud.stream.provider.RocketMqProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rocket")
public class RocketMqApi {

    @Autowired
    RocketMqProducer rocketmqProducer;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        rocketmqProducer.send("test rocketmq message");
        return "success";
    }
}
