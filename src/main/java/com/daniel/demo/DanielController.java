package com.daniel.demo;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DanielController {

  @Autowired
  private DanielContentBuilder danielContentBuilder;

  @RequestMapping("/lanota/{titulo}")
  @ResponseBody
  public String buildContent(@PathVariable("titulo") String titulo)
    throws IOException {
    return danielContentBuilder.buildContent(titulo, new Objetito(titulo));
  }

  private class Objetito {
    private final String titulo;

    public Objetito(String titulo) {
      this.titulo = titulo;
    }

    public String getTitulo() {
      return titulo;
    }
  }
}
