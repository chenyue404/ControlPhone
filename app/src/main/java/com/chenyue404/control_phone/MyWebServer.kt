package com.chenyue404.control_phone

import fi.iki.elonen.NanoHTTPD

class MyWebServer(port: Int) : NanoHTTPD(port) {
    override fun serve(session: IHTTPSession?): Response {
        val sb = StringBuilder().apply {
            append("<!DOCTYPE html><html><body>")
            append("<p>Hello! This Android HTTP Server.</p>")
            append("<h1>:)</h1>")
            append("</body></html>")
        }
        return newFixedLengthResponse(sb.toString())
    }
}