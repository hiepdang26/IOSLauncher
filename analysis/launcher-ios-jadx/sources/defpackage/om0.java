package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class om0 extends l00 {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ om0(kc1 kc1Var, int i) {
        super(kc1Var);
        this.d = i;
    }

    @Override // defpackage.ig1
    public final String c() {
        switch (this.d) {
            case 0:
                return "DELETE FROM `LeftPageWidget` WHERE `widgetId` = ?";
            case 1:
                return "UPDATE OR REPLACE `LeftPageWidget` SET `widgetId` = ?,`layoutId` = ?,`order` = ?,`size` = ?,`type` = ? WHERE `widgetId` = ?";
            default:
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }
    }
}
