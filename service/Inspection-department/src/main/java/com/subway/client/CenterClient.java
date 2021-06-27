package com.subway.client;

import com.subway.config.FeignConfig;
import com.subway.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "control-center",fallback = CenterClientImpl.class)
public interface CenterClient {

    @GetMapping("/center/webSocket/{message}")
    public Result sendMessage(@PathVariable String message);
}
