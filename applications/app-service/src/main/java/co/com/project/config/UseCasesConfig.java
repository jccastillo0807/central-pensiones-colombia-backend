package co.com.project.config;

import co.com.project.model.pension.gateways.PensionRepository;
import co.com.project.usecase.pensiones.PensionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.project.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public PensionUseCase getPensionUseCase(PensionRepository pensionRepository){
                return new PensionUseCase(pensionRepository);
        }
}
