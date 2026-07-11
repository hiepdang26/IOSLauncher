package com.vhmsoft.launcherios26.core.migrate

class CurrentMigration {
    @JvmField
    var currentVersion: Int = 0

    @JvmField
    var migrate_infos: List<MigrationInfo>? = null
}
