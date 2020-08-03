package com.malygos.gnemes.exception.exception

class MemePostUpdateNotFoundException : RuntimeException {
    constructor(message: String) : super(message) {}
    constructor(message: String, cause: Throwable) : super(message, cause) {}
}