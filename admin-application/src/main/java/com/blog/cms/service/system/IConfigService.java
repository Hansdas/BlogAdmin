package com.blog.cms.service.system;


public interface IConfigService {
    /**
     * 存入value，如果key存在，则更新
     * @param key
     * @param value
     * @param <T>
     */
    <T> void  Save(String key, T value);

    /**
     * 存入value，如果key存在，则更新
     * @param key
     * @param value
     */
     void  Save(String key, String value);

    /**
     * 根据key查找配置
     * @param key
     * @param <T>
     * @return
     */
     <T> T SelectByKey(String key,Class<T> t);
}
