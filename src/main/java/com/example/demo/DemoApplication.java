package com.example.demo;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.lettuce.core.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://redis-main/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set("key", "Hello, Redis!");

        connection.close();
        redisClient.shutdown();
        SpringApplication.run(DemoApplication.class, args);
    }

}
