package com.foelep.flowable;

import com.foelep.common.security.annotation.EnableCustomConfig;
import com.foelep.common.security.annotation.EnableRyFeignClients;
import com.foelep.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 工作流模块
 *
 * @author chad
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RuoYiFlowableApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RuoYiFlowableApplication.class, args);
    }
}