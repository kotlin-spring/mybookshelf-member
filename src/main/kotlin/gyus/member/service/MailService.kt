package gyus.member.service

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.model.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine
import java.nio.charset.StandardCharsets

class MailService(
    private val templateEngine: SpringTemplateEngine,
    @Value("\${aws.ses.from}")
    private val from:String
) {

    fun send(subject:String, variables: Map<String, Any>, vararg to: String) {
        val context = Context()
        context.setVariables(variables)
        val content = templateEngine.process("mail", context)

        val sendMailRequest = SendEmailRequest()
            .withDestination(Destination().withToAddresses(*to))
            .withSource(from)
            .withMessage(
                Message()
                    .withSubject(
                        Content().withCharset(StandardCharsets.UTF_8.name()).withData(subject)
                    )
                    .withBody(Body()
                        .withHtml(Content().withCharset(StandardCharsets.UTF_8.name()).withData(content))
                    )
            )

    }

}