package com.First_Spring_Project_0323.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("redis")
public class RedisDetailsConfig {

    private String host;
    private int port;
    private long ttl;

    public RedisDetailsConfig() {
    }

    public RedisDetailsConfig(String host, int port, long ttl) {
        this.host = host;
        this.port = port;
        this.ttl = ttl;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }
}
