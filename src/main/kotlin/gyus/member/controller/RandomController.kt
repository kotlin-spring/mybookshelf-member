package gyus.member.controller

import gyus.member.service.KafkaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/random")
class RandomController(
    private val kafkaService: KafkaService
) {

    @GetMapping
    fun randomNumber(): String {
        return kafkaService.produceNumber()
    }
}