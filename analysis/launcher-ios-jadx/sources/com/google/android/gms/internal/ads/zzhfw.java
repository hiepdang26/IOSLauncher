package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import defpackage.lr;
import defpackage.nr;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzhfw extends nr {
    private final WeakReference zza;

    public zzhfw(zzbct zzbctVar) {
        this.zza = new WeakReference(zzbctVar);
    }

    @Override // defpackage.nr
    public final void onCustomTabsServiceConnected(ComponentName componentName, lr lrVar) {
        zzbct zzbctVar = (zzbct) this.zza.get();
        if (zzbctVar != null) {
            zzbctVar.zzc(lrVar);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbct zzbctVar = (zzbct) this.zza.get();
        if (zzbctVar != null) {
            zzbctVar.zzd();
        }
    }
}
