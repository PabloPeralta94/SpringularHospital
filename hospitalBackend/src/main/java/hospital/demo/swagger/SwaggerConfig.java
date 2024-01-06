package hospital.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey(){
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Hospital Springular",
                "Esta es mi primera documentacion en swagger \n Sigue los siguientes pasos para habilitar el testeo de todos los controladores \n paso 1: Selecciona el controlador auth controller en la opcion de login a continuacion selecciona el boton try it out edita el contenido del nombre de usuario y la contraseña(remplazando la palabra String por la palabra admin en ambos casos) y luego presiona el boton Execute \n paso 2: Obtendras un response body con la palabra token seguido de un codigo entre comillas, copia ese codigo(sin las comillas) \n paso 3: Una vez copiado el codigo podras observar un boton encima de todos los controladores con la palabra Authorize, seleccionalo e ingresa la palabra bearer seguida del token copiado EJEMPLO: bearer eyJhbGciOiJIUzUxMiJ9.eyJzdW.....etc...etc \n Listo ya puedes utilzar el resto de controladores sin problema.",
                "1.0",
                "Términos y Condiciones",
                new Contact("Pablo Andres Peralta", "www.hospitalspringular.com.ar", "pablo.peralta94@gmail.com"),
                "Licencia",
                "www.licencia.com",
                Collections.emptyList()
        );
    }
}
