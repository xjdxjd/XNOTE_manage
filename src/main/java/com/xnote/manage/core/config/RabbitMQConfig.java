package com.xnote.manage.core.config;

import com.xnote.manage.common.constant.system.ProjectConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    /**
     * 创建自定义消息转换器
     * @return
     */
    @Bean
    public MessageConverter messageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean("systemExchange")
    public Exchange systemExchange()
    {
        return ExchangeBuilder.topicExchange(ProjectConstant.XNOTE_SYSTEM_EXCHANGE.getString()).durable(true).build();
    }

    /**
     * 声明队列
     * @return
     */
    @Bean("clientCfgQueue")
    public Queue systemQueue(){return QueueBuilder.durable(ProjectConstant.XNOTE_SYSTEM_QUEUE.getString()).build();}

    /**
     * 声明队列
     * @return
     */
    @Bean("clientFuncQueue")
    public Queue clientQueue(){return QueueBuilder.durable(ProjectConstant.XNOTE_CLIFUNC_QUEUE.getString()).build();}

    /**
     * 绑定队列和交换机
     * @return
     */
    @Bean
    public Binding systemQueueExchange(@Qualifier("clientCfgQueue") Queue queue,
                                     @Qualifier("systemExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ProjectConstant.XNOTE_CLIENT_CONFIG_MESSAGE_KEY.getString()).noargs();
    }

    /**
     * 绑定队列和交换机
     * @return
     */
    @Bean
    public Binding clientQueueExchange(@Qualifier("clientFuncQueue") Queue queue,
                                     @Qualifier("systemExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ProjectConstant.XNOTE_CLIENT_FUNC_MESSAGE_KEY.getString()).noargs();
    }
}
