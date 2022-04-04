package com.blup0plup.sourcestreamkafka.suppliers;

import com.blup0plup.sourcestreamkafka.models.UsageDetail;
import com.google.gson.Gson;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsageDetailSender {

  private static final Logger logger = LoggerFactory.getLogger(UsageDetailSender.class);

  private static final Gson gson = new Gson();

  private static final Random random = new Random();

  @Bean
  public Supplier<UsageDetail> sendEvents() {
    return () -> {
      var usageDetail = new UsageDetail();
      usageDetail.setSugarId(UUID.randomUUID().toString());
      usageDetail.setDuration(random.nextInt(300));
      usageDetail.setData(random.nextInt(700));
      var jsonDetails = gson.toJson(usageDetail);
      logger.info("Generated Detail: {}",jsonDetails);
      return usageDetail;
    };
  }
}
