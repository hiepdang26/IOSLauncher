package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hd2;
import defpackage.ka2;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzccv {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzccv(zzcbk zzcbkVar) {
        Context context = zzcbkVar.getContext();
        this.zza = context;
        this.zzb = hd2.B.c.w(context, zzcbkVar.zzn().g);
        this.zzc = new WeakReference(zzcbkVar);
    }

    public static /* bridge */ /* synthetic */ void zze(zzccv zzccvVar, String str, Map map) {
        zzcbk zzcbkVar = (zzcbk) zzccvVar.zzc.get();
        if (zzcbkVar != null) {
            zzcbkVar.zzd("onPrecacheEvent", map);
        }
    }

    public void release() {
    }

    public abstract void zzf();

    public final void zzg(String str, String str2, String str3, String str4) {
        ka2.b.post(new zzccu(this, str, str2, str3, str4));
    }

    public final void zzh(String str, String str2, int i) {
        ka2.b.post(new zzccs(this, str, str2, i));
    }

    public final void zzj(String str, String str2, long j) {
        ka2.b.post(new zzcct(this, str, str2, j));
    }

    public final void zzn(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        ka2.b.post(new zzccr(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    public final void zzo(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        ka2.b.post(new zzccq(this, str, str2, j, j2, j3, j4, j5, z, i, i2));
    }

    public void zzp(int i) {
    }

    public void zzq(int i) {
    }

    public void zzr(int i) {
    }

    public void zzs(int i) {
    }

    public abstract boolean zzt(String str);

    public boolean zzu(String str, String[] strArr) {
        return zzt(str);
    }

    public boolean zzw(String str, String[] strArr, zzccn zzccnVar) {
        return zzt(str);
    }
}
