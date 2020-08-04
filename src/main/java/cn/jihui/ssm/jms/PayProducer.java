package cn.jihui.ssm.jms;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;


@Component
public class PayProducer {
    private  String group = "pay_jihui_producer_group";

    private DefaultMQProducer  producer;

    public DefaultMQProducer getProducer() {
        return this.producer;
    }

    public PayProducer() {
        producer = new  DefaultMQProducer(group);
        producer.setNamesrvAddr(JmsConstant.namesrvaddr);
        start();
    }

    public void start(){
        try {
            this.producer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void shutdown(){
        this.producer.shutdown();
    }

}
