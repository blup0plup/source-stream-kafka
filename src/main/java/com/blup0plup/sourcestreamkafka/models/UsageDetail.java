package com.blup0plup.sourcestreamkafka.models;

import lombok.Data;

@Data
public class UsageDetail {
  private long duration;
  private long data;
  private String sugarId;
}
