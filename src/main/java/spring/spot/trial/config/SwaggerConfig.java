package spring.spot.trial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spot.trial.SpotApplication;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private final String TITLE = "Ignite + Spotlight";
    private final String DESCRIPTION = "Employee Platform Recognition";
    private final String VERSION = "1.0";
    private final String REPO_NAME = "spotlight-api";
    private final String REPO_URL = "https://github.com/ignite-plus-spotlight/spotlight-api.git";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors
                        .basePackage(SpotApplication.class.getPackage().getName()))
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(Boolean.FALSE);
    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        return apiInfoBuilder
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(REPO_NAME,REPO_URL,"spotLight@ignite.com"))
                .build();
    }
}
