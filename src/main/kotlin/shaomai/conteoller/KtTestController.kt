package shaomai.conteoller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class KtTestController {

    @RequestMapping(value = "/kttest")
    fun kotlinTest() : String {
        return "hello, kotlin"
    }

}