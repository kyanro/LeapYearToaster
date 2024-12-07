package com.kyanro.leapyeartoaster

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.jupiter.api.extension.ExtendWith
import tech.apter.junit.jupiter.robolectric.RobolectricExtension
import kotlin.test.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExtendWith(RobolectricExtension::class)
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assert(4 == 2 + 2)
    }

    @Test
    fun パッケージ名が取得できる() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        assert("com.kyanro.leapyeartoaster" == context.packageName)
    }
}
