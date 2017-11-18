package com.daniel.demo;

import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.trimou.Mustache;
import org.trimou.engine.MustacheEngine;

@Component
public class DanielContentBuilder {

  @Autowired
  private MustacheEngine mustacheEngine;

  public String buildContent(String templateName, Object data)
      throws FileNotFoundException {
    mustacheEngine.invalidateTemplateCache(); //Only in development
    Mustache mustache = mustacheEngine.getMustache(templateName);
    if (mustache == null) {
      throw new FileNotFoundException(templateName + " template not found");
    }
    return mustache.render(data);
  }
}
