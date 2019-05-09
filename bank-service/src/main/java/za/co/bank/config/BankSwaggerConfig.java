package za.co.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class BankSwaggerConfig {

    private static final String BANK_API_BASE_PACKAGE = "za.co.bank.controller";

    private static final String BANK_API_TITLE = "Bank Information Service API";
    private static final String BANK_API_DESCRIPTION = "Bank REST API";
    private static final String BANK_API_VERSION = "1.0";
    private static final String BANK_API_TERMS_OF_SERVICE = "Terms of service";
    private static final String BANK_API_OWNER_NAME = "Mayank Tantuway";
    private static final String BANK_API_OWNER_WEBSITE = "http://easemywork.in/";
    private static final String BANK_API_OWNER_EMAIL = "71mayank@gmail.com";
    private static final String BANK_API_LICENSE = "Prototype License Version 1.0";
    private static final String BANK_API_LICENSE_URL = "http://easemywork.in/licenses/LICENSE-1.0";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage(BANK_API_BASE_PACKAGE))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }


    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title(BANK_API_TITLE)
                .description(BANK_API_DESCRIPTION)
                .version(BANK_API_VERSION)
                .contact(new Contact(BANK_API_OWNER_NAME, BANK_API_OWNER_WEBSITE, BANK_API_OWNER_EMAIL))
                .termsOfServiceUrl(BANK_API_TERMS_OF_SERVICE)
                .license(BANK_API_LICENSE)
                .licenseUrl(BANK_API_LICENSE_URL)
                .build();
    }
}
