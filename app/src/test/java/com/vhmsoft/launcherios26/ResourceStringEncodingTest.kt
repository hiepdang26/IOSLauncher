package com.vhmsoft.launcherios26

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

class ResourceStringEncodingTest {
    @Test
    fun valuesStrings_keepVietnameseUtf8TextReadable() {
        val strings = loadStrings()

        assertEquals("Màn hình khóa", strings["settings_lock_screen"])
        assertEquals("Trung tâm điều khiển", strings["settings_control_center"])
        assertEquals("Hình nền", strings["settings_wallpaper"])
        assertEquals("Đổi tên", strings["settings_rename"])
        assertEquals("Thư mục", strings["folder_default_name"])
        assertEquals("Đế mờ", strings["settings_blur_dock"])
        assertEquals("‹ Thay đổi biểu tượng", strings["home_widget_photo_crop_back"])
        assertEquals("Use metric (°C)", strings["weather_use_metric"])
    }

    private fun loadStrings(): Map<String, String> {
        val document = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(stringsFile())
        val nodes = document.documentElement.getElementsByTagName("string")
        return buildMap {
            for (index in 0 until nodes.length) {
                val node = nodes.item(index)
                val name = node.attributes.getNamedItem("name")?.nodeValue ?: continue
                put(name, node.textContent)
            }
        }
    }

    private fun stringsFile(): File {
        return listOf(
            File("app/src/main/res/values/strings.xml"),
            File("src/main/res/values/strings.xml")
        ).first { it.exists() }
    }
}
