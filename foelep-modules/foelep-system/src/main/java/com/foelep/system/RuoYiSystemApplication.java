package com.foelep.system;

import com.foelep.common.security.annotation.EnableCustomConfig;
import com.foelep.common.security.annotation.EnableRyFeignClients;
import com.foelep.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 系统模块
 *
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RuoYiSystemApplication {
  public static void main(String[] args) {
    SpringApplication.run(RuoYiSystemApplication.class, args);
  }
}
