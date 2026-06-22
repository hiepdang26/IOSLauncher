package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import defpackage.bf1;
import defpackage.hg0;
import defpackage.j02;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbe {
    private final Context zza;

    public zzbbe(Context context) {
        hg0.j(context, "Context can not be null");
        this.zza = context;
    }

    public final boolean zza(Intent intent) {
        hg0.j(intent, "Intent can not be null");
        return !this.zza.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public final boolean zzb() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    public final boolean zzc() {
        return ((Boolean) bf1.C(this.zza, new Callable() { // from class: com.google.android.gms.internal.ads.zzbbd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
            }
        })).booleanValue() && j02.a(this.zza).h.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
