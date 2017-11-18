package com.daniel.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.trimou.engine.locator.FileSystemTemplateLocator;
import org.trimou.engine.locator.TemplateLocator;
import org.trimou.engine.MustacheEngine;
import org.trimou.engine.MustacheEngineBuilder;

@Configuration
public class DanielConfig {

  @Bean
  public MustacheEngine mustacheEngine() {
    return MustacheEngineBuilder
      .newBuilder()
      .addTemplateLocator(templateLocator())
      .build();
  }

  @Bean
  public TemplateLocator templateLocator() {
    return FileSystemTemplateLocator
      .builder()
      .setRootPath(System.getProperty("user.dir") + "/templates")
      .setSuffix("html")
      .build();
  }
}
