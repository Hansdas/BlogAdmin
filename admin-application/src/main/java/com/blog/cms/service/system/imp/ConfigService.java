package com.blog.cms.service.system.imp;

import com.alibaba.fastjson.JSON;
import com.blog.cms.dao.b.system.ConfigMapper;
import com.blog.cms.domain.system.config.Config;
import com.blog.cms.service.system.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class ConfigService implements IConfigService {
    @Autowired
    private ConfigMapper configMapper;
    @Override
    public <T> void Save(String key, T value) {
        if (value.equals(null))
            throw new NullPointerException("value为null");
        String json= JSON.toJSONString(value);
        Save(key,json);
    }

    @Override
    public void Save(String key, String value) {
        Config config=new Config();
        config.setKey(key);
        config.setValue(value);
        Map<String,Object> condition=new HashMap<>();
        condition.put("key",key);
        int count=configMapper.selectCount(condition);
        if (count>0)
            configMapper.update(config);
        else
            configMapper.insert(config);
    }

    @Override
    public <T> T SelectByKey(String key,Class<T> t) {
        String value=configMapper.selectByKey(key);
        T object =JSON.parseObject(value,t);
        return object;
    }
}
