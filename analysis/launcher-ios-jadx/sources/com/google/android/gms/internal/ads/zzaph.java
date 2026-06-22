package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import defpackage.uo;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaph implements Comparable {
    private final zzaps zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzapl zzf;
    private Integer zzg;
    private zzapk zzh;
    private boolean zzi;
    private zzaoq zzj;
    private zzapg zzk;
    private final zzaov zzl;

    public zzaph(int i, String str, zzapl zzaplVar) {
        Uri uri;
        String host;
        this.zza = zzaps.zza ? new zzaps() : null;
        this.zze = new Object();
        int iHashCode = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzaplVar;
        this.zzl = new zzaov();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzd = iHashCode;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzaph) obj).zzg.intValue();
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        return "[ ] " + this.zzc + " " + "0x".concat(strValueOf) + " NORMAL " + this.zzg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzaoq zzd() {
        return this.zzj;
    }

    public final zzaph zze(zzaoq zzaoqVar) {
        this.zzj = zzaoqVar;
        return this;
    }

    public final zzaph zzf(zzapk zzapkVar) {
        this.zzh = zzapkVar;
        return this;
    }

    public final zzaph zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    public abstract zzapn zzh(zzapd zzapdVar);

    public final String zzj() {
        int i = this.zzb;
        String str = this.zzc;
        return i != 0 ? uo.i(Integer.toString(1), "-", str) : str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() {
        return Collections.EMPTY_MAP;
    }

    public final void zzm(String str) {
        if (zzaps.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzapq zzapqVar) {
        zzapl zzaplVar;
        synchronized (this.zze) {
            zzaplVar = this.zzf;
        }
        zzaplVar.zza(zzapqVar);
    }

    public abstract void zzo(Object obj);

    public final void zzp(String str) {
        zzapk zzapkVar = this.zzh;
        if (zzapkVar != null) {
            zzapkVar.zzb(this);
        }
        if (zzaps.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzapf(this, str, id));
            } else {
                this.zza.zza(str, id);
                this.zza.zzb(toString());
            }
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    public final void zzr() {
        zzapg zzapgVar;
        synchronized (this.zze) {
            zzapgVar = this.zzk;
        }
        if (zzapgVar != null) {
            zzapgVar.zza(this);
        }
    }

    public final void zzs(zzapn zzapnVar) {
        zzapg zzapgVar;
        synchronized (this.zze) {
            zzapgVar = this.zzk;
        }
        if (zzapgVar != null) {
            zzapgVar.zzb(this, zzapnVar);
        }
    }

    public final void zzt(int i) {
        zzapk zzapkVar = this.zzh;
        if (zzapkVar != null) {
            zzapkVar.zzc(this, i);
        }
    }

    public final void zzu(zzapg zzapgVar) {
        synchronized (this.zze) {
            this.zzk = zzapgVar;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() {
        return null;
    }

    public final zzaov zzy() {
        return this.zzl;
    }
}
