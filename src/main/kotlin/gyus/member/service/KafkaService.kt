package gyus.member.service

import gyus.member.model.MemberDTO
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {

    @Async
    fun produceNumber():String {
        val message = (3000.. 10000).random().toString()
        kafkaTemplate.send("random-number", message)
        println("produce : $message")
        return message
    }

    @KafkaListener(topics = ["random-number"])
    fun consumeNumber(message:String) {
        println(">>> check $message")
    }

    @Async
    fun produceMemberEmailData(memberDTO: MemberDTO) {
        kafkaTemplate.send("send-mail", memberDTO.email)
        println("send-mail 토픽에 편지를 보냅니다. ${memberDTO.email}")
    }

}