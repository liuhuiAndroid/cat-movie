
package com.stylefeng.sso.client.cache;

import com.stylefeng.sso.plugin.cache.ClientCache;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * 默认sso客户断缓存
 *
 * @author fengshuonan
 * @date 2018-02-04 14:24
 */
@Service
public class DefaultClientCache implements ClientCache {

    private Set<String> cache = new HashSet<>();

    @Override
    public synchronized boolean containsInvalidKey(String key) {
        if (cache.contains(key)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized void addInvalidKey(String key) {
        cache.add(key);
    }

    @Override
    public void removeInvalidKey(String key) {
        cache.remove(key);
    }
}
