package za.co.account.config;

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
public class AccountSwaggerConfig {

    private static final String ACCOUNT_API_BASE_PACKAGE = "za.co.account.controller";

    private static final String ACCOUNT_API_TITLE = "Account Service API";
    private static final String ACCOUNT_API_DESCRIPTION = "Account REST API";
    private static final String ACCOUNT_API_VERSION = "1.0";
    private static final String ACCOUNT_API_TERMS_OF_SERVICE = "Terms of service";
    private static final String ACCOUNT_API_OWNER_NAME = "Mayank Tantuway";
    private static final String ACCOUNT_API_OWNER_WEBSITE = "http://easemywork.in/";
    private static final String ACCOUNT_API_OWNER_EMAIL = "71mayank@gmail.com";
    private static final String ACCOUNT_API_LICENSE = "Prototype License Version 1.0";
    private static final String ACCOUNT_API_LICENSE_URL = "http://easemywork.in/licenses/LICENSE-1.0";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage(ACCOUNT_API_BASE_PACKAGE))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }


    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title(ACCOUNT_API_TITLE)
                .description(ACCOUNT_API_DESCRIPTION)
                .version(ACCOUNT_API_VERSION)
                .contact(new Contact(ACCOUNT_API_OWNER_NAME, ACCOUNT_API_OWNER_WEBSITE, ACCOUNT_API_OWNER_EMAIL))
                .termsOfServiceUrl(ACCOUNT_API_TERMS_OF_SERVICE)
                .license(ACCOUNT_API_LICENSE)
                .licenseUrl(ACCOUNT_API_LICENSE_URL)
                .build();
    }
}
