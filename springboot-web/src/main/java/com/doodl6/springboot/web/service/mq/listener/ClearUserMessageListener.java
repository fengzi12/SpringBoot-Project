package com.doodl6.springboot.web.service.mq.listener;

import com.doodl6.springboot.dao.api.UserLoginLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 清除用户消息监听
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.clearUser.group}", topic = "${rocketmq.consumer.clearUser.topic}")
public class ClearUserMessageListener implements RocketMQListener<Long> {

    @Resource
    private UserLoginLogMapper userLoginLogMapper;

    @Override
    public void onMessage(Long userId) {
        log.info("收到清除用户消息 | {}", userId);
        userLoginLogMapper.deleteAllByUserId(userId);
        log.info("删除用户登录记录完成 | {}", userId);
    }

}
