package com.cloudx.ios17.core.utils

import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

object IOUtils {
    private const val BUF_SIZE = 0x1000

    @JvmStatic
    @Throws(IOException::class)
    fun toByteArray(file: File): ByteArray =
        FileInputStream(file).use { input -> toByteArray(input) }

    @JvmStatic
    @Throws(IOException::class)
    fun toByteArray(input: InputStream): ByteArray {
        val output = ByteArrayOutputStream()
        copy(input, output)
        return output.toByteArray()
    }

    @JvmStatic
    @Throws(IOException::class)
    fun copy(from: InputStream, to: OutputStream): Long {
        val buffer = ByteArray(BUF_SIZE)
        var total = 0L
        while (true) {
            val read = from.read(buffer)
            if (read == -1) {
                return total
            }
            to.write(buffer, 0, read)
            total += read.toLong()
        }
    }
}
