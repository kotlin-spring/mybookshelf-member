package gyus.member.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MailServiceTest {

    @Autowired
    private lateinit var mailService: MailService

    @Test
    fun send() {
        val result = mailService.send("TEST 입니다.", mapOf("data" to "테스트입니다. "), "andy.kotlin.spring@gmail.com")
        println(result)
    }
}