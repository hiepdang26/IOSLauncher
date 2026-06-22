package defpackage;

import androidx.constraintlayout.motion.widget.Key;
import androidx.work.impl.WorkDatabase_Impl;
import com.luutinhit.launcher6.leftpage.database.LeftPageWidgetDatabase_Impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class nm0 extends th0 {
    public final /* synthetic */ int d = 1;
    public final /* synthetic */ kc1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm0(LeftPageWidgetDatabase_Impl leftPageWidgetDatabase_Impl) {
        super(2);
        this.e = leftPageWidgetDatabase_Impl;
    }

    @Override // defpackage.th0
    public final void d(s60 s60Var) {
        switch (this.d) {
            case 0:
                s60Var.n("CREATE TABLE IF NOT EXISTS `LeftPageWidget` (`widgetId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `layoutId` INTEGER NOT NULL, `order` INTEGER NOT NULL, `size` INTEGER NOT NULL, `type` INTEGER NOT NULL)");
                s60Var.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                s60Var.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fc241614abab42898ea133b50fc265df')");
                break;
            default:
                s60Var.n("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                s60Var.n("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                s60Var.n("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                s60Var.n("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                s60Var.n("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                s60Var.n("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
                s60Var.n("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                s60Var.n("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                s60Var.n("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                s60Var.n("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                s60Var.n("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                s60Var.n("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                s60Var.n("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                s60Var.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                s60Var.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d73d21f1bd82c9e5268b6dcf9fde2cb')");
                break;
        }
    }

    @Override // defpackage.th0
    public final void e(s60 s60Var) {
        switch (this.d) {
            case 0:
                s60Var.n("DROP TABLE IF EXISTS `LeftPageWidget`");
                ArrayList arrayList = ((LeftPageWidgetDatabase_Impl) this.e).f;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((dj) obj).getClass();
                    }
                }
                break;
            default:
                s60Var.n("DROP TABLE IF EXISTS `Dependency`");
                s60Var.n("DROP TABLE IF EXISTS `WorkSpec`");
                s60Var.n("DROP TABLE IF EXISTS `WorkTag`");
                s60Var.n("DROP TABLE IF EXISTS `SystemIdInfo`");
                s60Var.n("DROP TABLE IF EXISTS `WorkName`");
                s60Var.n("DROP TABLE IF EXISTS `WorkProgress`");
                s60Var.n("DROP TABLE IF EXISTS `Preference`");
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.e;
                ArrayList arrayList2 = workDatabase_Impl.f;
                if (arrayList2 != null) {
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((dj) workDatabase_Impl.f.get(i2)).getClass();
                    }
                }
                break;
        }
    }

    @Override // defpackage.th0
    public final void p(s60 s60Var) {
        switch (this.d) {
            case 0:
                ArrayList arrayList = ((LeftPageWidgetDatabase_Impl) this.e).f;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((dj) obj).getClass();
                    }
                }
                break;
            default:
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.e;
                ArrayList arrayList2 = workDatabase_Impl.f;
                if (arrayList2 != null) {
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((dj) workDatabase_Impl.f.get(i2)).getClass();
                    }
                }
                break;
        }
    }

    @Override // defpackage.th0
    public final void r(s60 s60Var) {
        switch (this.d) {
            case 0:
                ((LeftPageWidgetDatabase_Impl) this.e).a = s60Var;
                ((LeftPageWidgetDatabase_Impl) this.e).k(s60Var);
                ArrayList arrayList = ((LeftPageWidgetDatabase_Impl) this.e).f;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((dj) obj).a(s60Var);
                    }
                }
                break;
            default:
                ((WorkDatabase_Impl) this.e).a = s60Var;
                s60Var.n("PRAGMA foreign_keys = ON");
                ((WorkDatabase_Impl) this.e).k(s60Var);
                ArrayList arrayList2 = ((WorkDatabase_Impl) this.e).f;
                if (arrayList2 != null) {
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((dj) ((WorkDatabase_Impl) this.e).f.get(i2)).a(s60Var);
                    }
                }
                break;
        }
    }

    @Override // defpackage.th0
    public final void s(s60 s60Var) throws IOException {
        switch (this.d) {
            case 0:
                hs0.k(s60Var);
                break;
            default:
                hs0.k(s60Var);
                break;
        }
    }

    @Override // defpackage.th0
    public final jd v(s60 s60Var) throws IOException {
        switch (this.d) {
            case 0:
                HashMap map = new HashMap(5);
                map.put("widgetId", new fm1(1, "widgetId", "INTEGER", null, true, 1));
                map.put("layoutId", new fm1(0, "layoutId", "INTEGER", null, true, 1));
                map.put("order", new fm1(0, "order", "INTEGER", null, true, 1));
                map.put("size", new fm1(0, "size", "INTEGER", null, true, 1));
                map.put("type", new fm1(0, "type", "INTEGER", null, true, 1));
                jm1 jm1Var = new jm1("LeftPageWidget", map, new HashSet(0), new HashSet(0));
                jm1 jm1VarA = jm1.a(s60Var, "LeftPageWidget");
                if (!jm1Var.equals(jm1VarA)) {
                }
                break;
            default:
                HashMap map2 = new HashMap(2);
                map2.put("work_spec_id", new fm1(1, "work_spec_id", "TEXT", null, true, 1));
                map2.put("prerequisite_id", new fm1(2, "prerequisite_id", "TEXT", null, true, 1));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new gm1("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                hashSet.add(new gm1("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new im1("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                hashSet2.add(new im1("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
                jm1 jm1Var2 = new jm1("Dependency", map2, hashSet, hashSet2);
                jm1 jm1VarA2 = jm1.a(s60Var, "Dependency");
                if (jm1Var2.equals(jm1VarA2)) {
                    HashMap map3 = new HashMap(30);
                    map3.put("id", new fm1(1, "id", "TEXT", null, true, 1));
                    map3.put("state", new fm1(0, "state", "INTEGER", null, true, 1));
                    map3.put("worker_class_name", new fm1(0, "worker_class_name", "TEXT", null, true, 1));
                    map3.put("input_merger_class_name", new fm1(0, "input_merger_class_name", "TEXT", null, true, 1));
                    map3.put("input", new fm1(0, "input", "BLOB", null, true, 1));
                    map3.put("output", new fm1(0, "output", "BLOB", null, true, 1));
                    map3.put("initial_delay", new fm1(0, "initial_delay", "INTEGER", null, true, 1));
                    map3.put("interval_duration", new fm1(0, "interval_duration", "INTEGER", null, true, 1));
                    map3.put("flex_duration", new fm1(0, "flex_duration", "INTEGER", null, true, 1));
                    map3.put("run_attempt_count", new fm1(0, "run_attempt_count", "INTEGER", null, true, 1));
                    map3.put("backoff_policy", new fm1(0, "backoff_policy", "INTEGER", null, true, 1));
                    map3.put("backoff_delay_duration", new fm1(0, "backoff_delay_duration", "INTEGER", null, true, 1));
                    map3.put("last_enqueue_time", new fm1(0, "last_enqueue_time", "INTEGER", "-1", true, 1));
                    map3.put("minimum_retention_duration", new fm1(0, "minimum_retention_duration", "INTEGER", null, true, 1));
                    map3.put("schedule_requested_at", new fm1(0, "schedule_requested_at", "INTEGER", null, true, 1));
                    map3.put("run_in_foreground", new fm1(0, "run_in_foreground", "INTEGER", null, true, 1));
                    map3.put("out_of_quota_policy", new fm1(0, "out_of_quota_policy", "INTEGER", null, true, 1));
                    map3.put("period_count", new fm1(0, "period_count", "INTEGER", "0", true, 1));
                    map3.put("generation", new fm1(0, "generation", "INTEGER", "0", true, 1));
                    map3.put("next_schedule_time_override", new fm1(0, "next_schedule_time_override", "INTEGER", "9223372036854775807", true, 1));
                    map3.put("next_schedule_time_override_generation", new fm1(0, "next_schedule_time_override_generation", "INTEGER", "0", true, 1));
                    map3.put("stop_reason", new fm1(0, "stop_reason", "INTEGER", "-256", true, 1));
                    map3.put("required_network_type", new fm1(0, "required_network_type", "INTEGER", null, true, 1));
                    map3.put("requires_charging", new fm1(0, "requires_charging", "INTEGER", null, true, 1));
                    map3.put("requires_device_idle", new fm1(0, "requires_device_idle", "INTEGER", null, true, 1));
                    map3.put("requires_battery_not_low", new fm1(0, "requires_battery_not_low", "INTEGER", null, true, 1));
                    map3.put("requires_storage_not_low", new fm1(0, "requires_storage_not_low", "INTEGER", null, true, 1));
                    map3.put("trigger_content_update_delay", new fm1(0, "trigger_content_update_delay", "INTEGER", null, true, 1));
                    map3.put("trigger_max_content_delay", new fm1(0, "trigger_max_content_delay", "INTEGER", null, true, 1));
                    map3.put("content_uri_triggers", new fm1(0, "content_uri_triggers", "BLOB", null, true, 1));
                    HashSet hashSet3 = new HashSet(0);
                    HashSet hashSet4 = new HashSet(2);
                    hashSet4.add(new im1("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
                    hashSet4.add(new im1("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
                    jm1 jm1Var3 = new jm1("WorkSpec", map3, hashSet3, hashSet4);
                    jm1 jm1VarA3 = jm1.a(s60Var, "WorkSpec");
                    if (jm1Var3.equals(jm1VarA3)) {
                        HashMap map4 = new HashMap(2);
                        map4.put("tag", new fm1(1, "tag", "TEXT", null, true, 1));
                        map4.put("work_spec_id", new fm1(2, "work_spec_id", "TEXT", null, true, 1));
                        HashSet hashSet5 = new HashSet(1);
                        hashSet5.add(new gm1("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                        HashSet hashSet6 = new HashSet(1);
                        hashSet6.add(new im1("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                        jm1 jm1Var4 = new jm1("WorkTag", map4, hashSet5, hashSet6);
                        jm1 jm1VarA4 = jm1.a(s60Var, "WorkTag");
                        if (jm1Var4.equals(jm1VarA4)) {
                            HashMap map5 = new HashMap(3);
                            map5.put("work_spec_id", new fm1(1, "work_spec_id", "TEXT", null, true, 1));
                            map5.put("generation", new fm1(2, "generation", "INTEGER", "0", true, 1));
                            map5.put("system_id", new fm1(0, "system_id", "INTEGER", null, true, 1));
                            HashSet hashSet7 = new HashSet(1);
                            hashSet7.add(new gm1("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                            jm1 jm1Var5 = new jm1("SystemIdInfo", map5, hashSet7, new HashSet(0));
                            jm1 jm1VarA5 = jm1.a(s60Var, "SystemIdInfo");
                            if (jm1Var5.equals(jm1VarA5)) {
                                HashMap map6 = new HashMap(2);
                                map6.put("name", new fm1(1, "name", "TEXT", null, true, 1));
                                map6.put("work_spec_id", new fm1(2, "work_spec_id", "TEXT", null, true, 1));
                                HashSet hashSet8 = new HashSet(1);
                                hashSet8.add(new gm1("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                                HashSet hashSet9 = new HashSet(1);
                                hashSet9.add(new im1("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                                jm1 jm1Var6 = new jm1("WorkName", map6, hashSet8, hashSet9);
                                jm1 jm1VarA6 = jm1.a(s60Var, "WorkName");
                                if (jm1Var6.equals(jm1VarA6)) {
                                    HashMap map7 = new HashMap(2);
                                    map7.put("work_spec_id", new fm1(1, "work_spec_id", "TEXT", null, true, 1));
                                    map7.put(Key.PROGRESS, new fm1(0, Key.PROGRESS, "BLOB", null, true, 1));
                                    HashSet hashSet10 = new HashSet(1);
                                    hashSet10.add(new gm1("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                                    jm1 jm1Var7 = new jm1("WorkProgress", map7, hashSet10, new HashSet(0));
                                    jm1 jm1VarA7 = jm1.a(s60Var, "WorkProgress");
                                    if (jm1Var7.equals(jm1VarA7)) {
                                        HashMap map8 = new HashMap(2);
                                        map8.put("key", new fm1(1, "key", "TEXT", null, true, 1));
                                        map8.put("long_value", new fm1(0, "long_value", "INTEGER", null, false, 1));
                                        jm1 jm1Var8 = new jm1("Preference", map8, new HashSet(0), new HashSet(0));
                                        jm1 jm1VarA8 = jm1.a(s60Var, "Preference");
                                        if (!jm1Var8.equals(jm1VarA8)) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
        return new jd((String) null, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm0(WorkDatabase_Impl workDatabase_Impl) {
        super(20);
        this.e = workDatabase_Impl;
    }
}
