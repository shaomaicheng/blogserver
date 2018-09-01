import okhttp3.*
import java.io.IOException
import java.util.concurrent.CountDownLatch

fun main(args: Array<String>) {
    val countDownLatch = CountDownLatch(1000)
    generateSequence(1) {
        println(it)
        Thread(Runnable {
            val okhttp = OkHttpClient.Builder().build()
            val request = Request.Builder()
                    .url("http://localhost:8080")
                    .build()
            okhttp.newCall(request).enqueue(
                    object : Callback {
                        override fun onFailure(call: Call?, e: IOException?) {
                            e?.let {
                                println("fail: " + it.message)
                            }
                        }

                        override fun onResponse(call: Call?, response: Response?) {
                            println("ok")
                        }

                    }
            )
        }).start()
        countDownLatch.countDown()
        it
    }.takeWhile {
        it < 1000
    }.all { true }

    countDownLatch.await()
}