package com.kyanro.leapyeartoaster

import java.time.LocalDateTime
import java.time.ZonedDateTime

val date = LocalDateTime.now()


/**
 * 閏年かどうかを判定する
 * @return true: 閏年, false: 平年
 * */
fun ZonedDateTime.isLeapYear(): Boolean {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)

}

/** 閏日かどうかを判定する */
fun ZonedDateTime.isLeapDay(): Boolean {
    return monthValue == 2 && dayOfMonth == 29
}
