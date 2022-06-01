package com.foelep.flowable;

import com.foelep.common.security.annotation.EnableCustomConfig;
import com.foelep.common.security.annotation.EnableRyFeignClients;
import com.foelep.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author：chad
 * @mail：2319315514@qq.com
 * @date：2022/6/1-14:40
 * @description：
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class FoelepFlowableApplication {
  public static void main(String[] args) {
    SpringApplication.run(FoelepFlowableApplication.class, args);
  }
}
