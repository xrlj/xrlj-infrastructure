package com.xrlj.infrastructure.feign;

import com.xrlj.framework.spring.mvc.api.APIs;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@Component
public class GenidClientFallbackFactory implements FallbackFactory<GenidClient> {

    @Override
    public GenidClient create(Throwable throwable) {
        log.error("》》》请求服务降级",throwable);
        return new GenidClient() {

            @Override
            public long genId() {
                throw APIs.error(1000, "生成id服务不可用", null);
            }

            @Override
            public Serializable expId(long id) {
                return -1;
            }
        };
    }
}
