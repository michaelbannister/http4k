package org.http4k.stream

import org.http4k.client.ApacheClient
import org.http4k.core.BodyMode.Stream
import org.http4k.server.KtorCIO
import org.http4k.streaming.StreamingContract
import org.http4k.streaming.StreamingTestConfiguration
import org.junit.Ignore
import org.junit.jupiter.api.BeforeEach
import java.util.*

class KtorCIOStreamingTest : StreamingContract(
    StreamingTestConfiguration(multiplier = 4)
) {
    @BeforeEach
    fun sleepForABitBecauseStartupIsCrushinglySlow() {
        Thread.sleep(1000)
    }

    override fun serverConfig() = KtorCIO(Random().nextInt(1000) + 10000)

    override fun createClient() = ApacheClient(requestBodyMode = Stream, responseBodyMode = Stream)

    @Ignore("New ApacheClient is missing streaming support")
    override fun `can stream response`() {
    }
}