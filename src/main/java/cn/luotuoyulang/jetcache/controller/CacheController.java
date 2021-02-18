package cn.luotuoyulang.jetcache.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CacheController {

    @Autowired
    private RedisTemplate redisTemplate;

    @CreateCache(name = "cacheOne", cacheType = CacheType.BOTH)
    public Cache<String, String> lettuceCache;

    @Cached(name = "cacheOne",key = "#cacheKey",cacheType = CacheType.BOTH)
    @GetMapping("/cache")
    public String cache (String cacheKey) {
        log.info("123123 cache !!!!!!" + cacheKey);
        return "Hello World !!!";
    }

    @GetMapping("/redisCache")
    public String redisCache () {
        log.info("123123 cache !!!!!!");
        redisTemplate.opsForValue().set("11111","我的老家就住在那个屯");
        Object o = redisTemplate.opsForValue().get("11111");
        System.out.println("o = " + o);
        return "Hello World !!!";
    }

    @GetMapping("/removeCache")
    public String removeCache (String cacheKey) {
        log.info("123123 cache !!!!!!" + cacheKey);
        boolean remove = lettuceCache.remove(cacheKey);
        return String.valueOf(remove);
    }
}
