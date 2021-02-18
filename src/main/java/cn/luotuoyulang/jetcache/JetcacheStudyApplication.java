package cn.luotuoyulang.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMethodCache(basePackages = "cn.luotuoyulang")
@EnableCreateCacheAnnotation
@SpringBootApplication
public class JetcacheStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetcacheStudyApplication.class, args);
    }

}
