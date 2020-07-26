package com.xnote.manage.core.redis.service.impl;

import com.xnote.manage.core.redis.service.RedisService;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

public class RedisServiceImpl implements RedisService
{
    @Resource
    private StringRedisTemplate stringRedisTemplate;
}
