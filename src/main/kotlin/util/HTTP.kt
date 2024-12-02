package util

import java.io.InputStream
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun getDayInput(day: Int): InputStream = HttpClient.newHttpClient().send(
    HttpRequest.newBuilder(URI("https://adventofcode.com/2024/day/$day/input"))
        .header("Accept", "text/plain")
        .header("Cookie", sessionCookie())
        .build(), HttpResponse.BodyHandlers.ofInputStream()
).body()