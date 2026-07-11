package com.vhmsoft.launcherios26.core.migrate

class MigrationInfo : Comparable<MigrationInfo> {
    @JvmField
    var startVersion: Int = 0

    @JvmField
    var endVersion: Int = 0

    @JvmField
    var components: List<MigrateComponentInfo>? = null

    override fun compareTo(other: MigrationInfo): Int = startVersion - other.startVersion
}
