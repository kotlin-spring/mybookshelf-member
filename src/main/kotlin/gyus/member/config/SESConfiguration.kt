package gyus.member.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SESConfiguration {

    @Value("\${aws.ses.access-key}")
    lateinit var accessKey: String

    @Value("\${aws.ses.secret-key}")
    lateinit var secretKey: String

    @Bean
    fun amazonSimpleEmailService(): AmazonSimpleEmailService {
        return AmazonSimpleEmailServiceClientBuilder
            .standard()
            .withCredentials(AWSStaticCredentialsProvider(
                BasicAWSCredentials(accessKey, secretKey)
            )).withRegion(Regions.US_EAST_1).build()
    }
}