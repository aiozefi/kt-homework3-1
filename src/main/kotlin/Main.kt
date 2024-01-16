fun main() {
    val secondsAgo = 47000 // Актуальное количество секунд

    val agoText = agoToText(secondsAgo)
    println(agoText)
}

fun agoToText(secondsAgo: Int): String {
    return when {
        secondsAgo in 0..60 -> "был(а) только что"
        secondsAgo in 61..60 * 60 -> formatMinutesAgo(secondsAgo)
        secondsAgo in 60 * 60 + 1..24 * 60 * 60 -> formatHoursAgo(secondsAgo)
        secondsAgo in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "был(а) вчера"
        secondsAgo in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun formatMinutesAgo(seconds: Int): String {
    val minutes = seconds / 60
    return when {
        minutes % 10 == 1 && minutes % 100 != 11 -> "был(а) $minutes минуту назад"
        minutes % 10 in 2..4 && minutes % 100 !in 12..14 -> "был(а) $minutes минуты назад"
        else -> "был(а) $minutes минут назад"
    }
}

fun formatHoursAgo(seconds: Int): String {
    val hours = seconds / (60 * 60)
    return when {
        hours % 10 == 1 && hours % 100 != 11 -> "был(а) $hours час назад"
        hours % 10 in 2..4 && hours % 100 !in 12..14 -> "был(а) $hours часа назад"
        else -> "был(а) $hours часов назад"
    }
}
