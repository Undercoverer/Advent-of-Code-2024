package util

import java.io.File

fun sessionCookie(): String = File("session.txt").readText()