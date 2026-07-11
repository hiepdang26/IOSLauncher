package com.vhmsoft.launcherios26.core.database.model

import android.content.ComponentName
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import com.vhmsoft.launcherios26.core.utils.Constants
import com.vhmsoft.launcherios26.core.utils.UserHandle
import java.net.URISyntaxException

@Entity(tableName = "launcher_items", indices = [Index(value = ["item_id"], unique = true)])
open class LauncherItem {

    @field:PrimaryKey(autoGenerate = true)
    @JvmField
    var keyId: Int = 0

    /**
     * The id in the database for this item.
     */
    @field:ColumnInfo(name = "item_id")
    @JvmField
    var id: String = ""

    /**
     * One of [Constants.ITEM_TYPE_APPLICATION], [Constants.ITEM_TYPE_SHORTCUT],
     * or [Constants.ITEM_TYPE_FOLDER].
     */
    @field:ColumnInfo(name = "item_type")
    @JvmField
    var itemType: Int = 0

    /**
     * The id of the container that holds this item.
     */
    @field:ColumnInfo(name = "container")
    @JvmField
    var container: Long = NO_ID.toLong()

    /**
     * Indicates the screen in which the shortcut appears.
     */
    @field:ColumnInfo(name = "screen_id")
    @JvmField
    var screenId: Long = -1

    /** Indicates the position of the associated cell. */
    @field:ColumnInfo(name = "cell")
    @JvmField
    var cell: Int = INVALID_CELL

    /** Title of the item. */
    @field:ColumnInfo(name = "title")
    @JvmField
    var title: CharSequence? = null

    @field:Ignore
    @JvmField
    var user: UserHandle? = null

    /** Icon of the item. */
    @field:Ignore
    @JvmField
    var icon: Drawable? = null

    /** Used for shortcuts on api lower than oreo. */
    @field:ColumnInfo(name = "icon", typeAffinity = ColumnInfo.BLOB)
    @JvmField
    var icon_blob: ByteArray? = null

    /** Intent used to launch this shortcut. */
    @field:Ignore
    @JvmField
    var launchIntent: Intent? = null

    @field:ColumnInfo(name = "intent_uri")
    @JvmField
    var launchIntentUri: String? = null

    /**
     * Package name of the respective launcher item. For folders it would be "FOLDER".
     */
    @field:ColumnInfo(name = "package")
    @JvmField
    var packageName: String? = null

    fun getIntent(): Intent? {
        launchIntent?.let { return it }
        val uri = launchIntentUri
        if (uri != null) {
            return try {
                Intent.parseUri(uri, 0).also { launchIntent = it }
            } catch (e: URISyntaxException) {
                e.printStackTrace()
                null
            }
        }
        return null
    }

    fun getTargetComponent(): ComponentName? = getIntent()?.component

    override fun toString(): String {
        return "[id: $id, item_type: $itemType, container: $container, screen: $screenId, cell: $cell]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other !is LauncherItem) {
            return false
        }

        return other.id == id
    }

    override fun hashCode(): Int {
        var hash = 3
        hash = 53 * hash + id.hashCode()
        return hash
    }

    companion object {
        const val NO_ID = -1
        const val INVALID_CELL = -1
    }
}
