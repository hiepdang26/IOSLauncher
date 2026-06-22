package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import defpackage.k92;
import defpackage.mv0;
import defpackage.nv0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrs extends mv0 {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbrs(zzbew zzbewVar) {
        try {
            this.zzb = zzbewVar.zzg();
        } catch (RemoteException unused) {
            k92.f();
            this.zzb = "";
        }
        try {
            for (Object obj : zzbewVar.zzh()) {
                zzbfd zzbfdVarZzg = obj instanceof IBinder ? zzbfc.zzg((IBinder) obj) : null;
                if (zzbfdVarZzg != null) {
                    this.zza.add(new zzbru(zzbfdVarZzg));
                }
            }
        } catch (RemoteException unused2) {
            k92.f();
        }
    }

    public final List<nv0> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
