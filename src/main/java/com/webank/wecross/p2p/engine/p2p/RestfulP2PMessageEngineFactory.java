package com.webank.wecross.p2p.engine.p2p;

import com.webank.wecross.p2p.P2PMessageEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class RestfulP2PMessageEngineFactory {
    private Logger logger = LoggerFactory.getLogger(RestfulP2PMessageEngineFactory.class);
    private ThreadPoolTaskExecutor threadPool;

    public RestfulP2PMessageEngineFactory() {
        final int threadNum = 8;
        threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(threadNum);
        threadPool.setMaxPoolSize(threadNum);
        threadPool.setQueueCapacity(1000);
        threadPool.initialize();
    }

    @Bean
    public P2PMessageEngine newRestfulP2PMessageEngine() {
        logger.info("New RestfulP2PMessageEngine");
        RestfulP2PMessageEngine engine = new RestfulP2PMessageEngine();
        engine.setThreadPool(threadPool);
        return engine;
    }
}