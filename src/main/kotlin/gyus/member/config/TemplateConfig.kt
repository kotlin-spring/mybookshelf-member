package gyus.member.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.spring6.SpringTemplateEngine
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver

@Configuration
class TemplateConfig {

    @Bean
    fun htmlTemplateEngin(springResourceTemplateResolver: SpringResourceTemplateResolver): SpringTemplateEngine {
        val templateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(springResourceTemplateResolver)
        return templateEngine
    }

}