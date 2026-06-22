package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.rc2;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzeno implements zzevn {
    public final Context zza;
    public final rc2 zzb;
    public final List zzc;

    public zzeno(Context context, rc2 rc2Var, List list) {
        this.zza = context;
        this.zzb = rc2Var;
        this.zzc = list;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Bundle bundle = (Bundle) obj;
        if (((Boolean) zzbdv.zza.zze()).booleanValue()) {
            Bundle bundle2 = new Bundle();
            cd2 cd2Var = hd2.B.c;
            String className = null;
            try {
                ActivityManager activityManager = (ActivityManager) this.zza.getSystemService("activity");
                if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                    className = runningTaskInfo.topActivity.getClassName();
                }
            } catch (Exception unused) {
            }
            bundle2.putString("activity", className);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("width", this.zzb.k);
            bundle3.putInt("height", this.zzb.h);
            bundle2.putBundle("size", bundle3);
            if (!this.zzc.isEmpty()) {
                List list = this.zzc;
                bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle.putBundle("view_hierarchy", bundle2);
        }
    }
}
