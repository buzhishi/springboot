package cn.jihui.ssm.web.controller;

import cn.jihui.ssm.jms.JmsConstant;
import cn.jihui.ssm.jms.PayProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.scope.Scope;

@Controller
public class PayController {
    @Autowired
//    @Qualifier(value = "PayProducer")
    private PayProducer producer;

    // http://localhost:8090/mq/paymsg/hehe
    @GetMapping("/mq/paymsg/{text}")
    @ResponseBody
    public Object payMsg(@PathVariable("text") String text) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Message message = new Message(JmsConstant.payMsg, "tagji", ("hello world rocketmq = " + text).getBytes());
        SendResult send = null;
        send = producer.getProducer().send(message);

        System.out.println(send);
        return null;
    }
}
