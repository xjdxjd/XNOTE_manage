package com.xnote.manage.core.redis;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class RedisCacheKeyGenerator implements KeyGenerator
{

    @Override
    public Object generate(Object target, Method method, Object... params) {
        /*// 这里可用HashMap
        ModelContainer<String,Object> container = ModelContainer.newModelContainer();
        Class<?> targetClassClass = targetClass.getClass();
        // 类地址
        container.put("class",targetClassClass.toGenericString());
        // 方法名称
        container.put("methodName",method.getName());
        // 包名称
        container.put("package",targetClassClass.getPackage());
        // 参数列表
        for (int i = 0; i < params.length; i++) {
            container.put(String.valueOf(i),params[i]);
        }
        // 转为JSON字符串
        String jsonString = JSON.toJSONString(container);
        // 做SHA256 Hash计算，得到一个SHA256摘要作为Key
        return DigestUtils.sha256Hex(jsonString);*/
        return null;
    }
}
