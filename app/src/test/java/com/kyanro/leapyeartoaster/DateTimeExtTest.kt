package com.kyanro.leapyeartoaster

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtendWith
import tech.apter.junit.jupiter.robolectric.RobolectricExtension
import java.time.ZonedDateTime
import kotlin.test.Test

/**
 * BDDスタイルで検証する
 * Spek風に Nestedを使って階層化する
 * 階層化について
 * 　最上位は`対象のクラス名`Test というクラス名とする
 * 　次の階層は、`対象のメソッド名`Test というクラス名とする
 * 階層化されたメソッドの階層について
 * 　対象がクラスの場合、`対象のクラス名`Test というクラス名になっているので、`対象のクラス名` にあるメソッドを確認し、そのメソッドに対して検証を行う
 * 　対象がExtensionの場合、`対象のクラス名`ExtTest というクラス名になっているので、`対象のクラス名` で定義されているメソッドに対して検証を行う
 * 検証について
 * 　検証を行うメソッド名は、単純に `test1` 等でよいが、@DisplayNameで `対象のメソッド名`Test という名前にしてもよい
 * 　　検証を行う場合、期待する結果も明記する
 * 　検証を行う場合、条件ごとに記述した方がわかりやすくなるようであれば、条件をDisplayNameに記述し、さらに階層化してもよい
 */
@ExtendWith(RobolectricExtension::class)
class DateTimeExtTest {
    @Nested
    inner class isLeapYearTest {
        @Nested
        @DisplayName("100で割り切れる年") // 特別な判定がはいるので詳しくチェックする
        inner class class1 {
            @Test
            @DisplayName("400でも割り切れる年は閏年と判定される")
            fun test1() {
                val `2000年` = ZonedDateTime.parse("2000-01-01T00:00:00Z")
                assert(`2000年`.isLeapYear())
            }
            @Test
            @DisplayName("400で割り切れない年は閏年と判定されない")
            fun test2() {
                val `2100年` = ZonedDateTime.parse("2100-01-01T00:00:00Z")
                val `2200年` = ZonedDateTime.parse("2200-01-01T00:00:00Z")
                val `2300年` = ZonedDateTime.parse("2300-01-01T00:00:00Z")
                val `2400年` = ZonedDateTime.parse("2400-01-01T00:00:00Z")
                assert(false == `2100年`.isLeapYear())
                assert(false == `2200年`.isLeapYear())
                assert(false == `2300年`.isLeapYear())
                assert(true == `2400年`.isLeapYear())
            }
        }
        @Nested
        @DisplayName("100で割り切れない年")
        inner class class2 {
            @Test
            @DisplayName("閏年と判定されない")
            fun test1() {
                val `2024年` = ZonedDateTime.parse("2024-01-01T00:00:00Z")
                val `2025年` = ZonedDateTime.parse("2025-01-01T00:00:00Z")
                val `2026年` = ZonedDateTime.parse("2026-01-01T00:00:00Z")
                val `2027年` = ZonedDateTime.parse("2027-01-01T00:00:00Z")
                val `2028年` = ZonedDateTime.parse("2028-01-01T00:00:00Z")
                assert(true == `2024年`.isLeapYear())
                assert(false == `2025年`.isLeapYear())
                assert(false == `2026年`.isLeapYear())
                assert(false == `2027年`.isLeapYear())
                assert(true == `2028年`.isLeapYear())

            }
        }
    }

}