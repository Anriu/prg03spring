package br.com.ifba;

import br.com.ifba.curso.view.CursoListar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author anriu
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        
        // Inicializa o Spring Boot permitindo interface gráfica Swing
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(Application.class)
                        .headless(false)
                        .run(args);
        
        // Recupera a tela principal gerenciada pelo Spring
        CursoListar tela = context.getBean(CursoListar.class);
        
        // Exibe a tela principal
        tela.setVisible(true);
    }
}