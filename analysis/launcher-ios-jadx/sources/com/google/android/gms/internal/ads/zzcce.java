package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import defpackage.hd2;
import defpackage.hs0;
import defpackage.n42;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class zzcce implements zzfs {
    private final Context zza;
    private final zzfs zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbah zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private zzfy zzl;

    public zzcce(Context context, zzfs zzfsVar, String str, int i, zzgu zzguVar, zzccd zzccdVar) {
        this.zza = context;
        this.zzb = zzfsVar;
        this.zzc = str;
        this.zzd = i;
        new AtomicLong(-1L);
        this.zze = ((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue();
    }

    private final boolean zzg() {
        if (!this.zze) {
            return false;
        }
        zzbbn zzbbnVar = zzbbw.zzdT;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() || this.zzj) {
            return ((Boolean) n42Var.c.zza(zzbbw.zzdU)).booleanValue() && !this.zzk;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        return inputStream != null ? inputStream.read(bArr, i, i2) : this.zzb.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws IOException {
        Long l;
        if (this.zzg) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.zzg = true;
        Uri uri = zzfyVar.zza;
        this.zzh = uri;
        this.zzl = zzfyVar;
        this.zzi = zzbah.zza(uri);
        zzbbn zzbbnVar = zzbbw.zzdQ;
        n42 n42Var = n42.d;
        zzbae zzbaeVarZzb = null;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzfyVar.zze;
                this.zzi.zzi = zzfvj.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbaeVarZzb = hd2.B.i.zzb(this.zzi);
            }
            if (zzbaeVarZzb != null && zzbaeVarZzb.zze()) {
                this.zzj = zzbaeVarZzb.zzg();
                this.zzk = zzbaeVarZzb.zzf();
                if (!zzg()) {
                    this.zzf = zzbaeVarZzb.zzc();
                    return -1L;
                }
            }
        } else if (this.zzi != null) {
            this.zzi.zzh = zzfyVar.zze;
            this.zzi.zzi = zzfvj.zzc(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l = (Long) n42Var.c.zza(zzbbw.zzdS);
            } else {
                l = (Long) n42Var.c.zza(zzbbw.zzdR);
            }
            long jLongValue = l.longValue();
            hd2.B.j.getClass();
            SystemClock.elapsedRealtime();
            Future futureZza = zzbas.zza(this.zza, this.zzi);
            try {
                try {
                    try {
                        zzbat zzbatVar = (zzbat) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                        zzbatVar.zzd();
                        this.zzj = zzbatVar.zzf();
                        this.zzk = zzbatVar.zze();
                        zzbatVar.zza();
                        if (!zzg()) {
                            this.zzf = zzbatVar.zzc();
                        }
                    } catch (ExecutionException | TimeoutException unused) {
                        futureZza.cancel(false);
                    }
                } catch (InterruptedException unused2) {
                    futureZza.cancel(false);
                    Thread.currentThread().interrupt();
                }
            } catch (Throwable unused3) {
            }
            hd2.B.j.getClass();
            SystemClock.elapsedRealtime();
            throw null;
        }
        if (this.zzi != null) {
            zzfw zzfwVarZza = zzfyVar.zza();
            zzfwVarZza.zzd(Uri.parse(this.zzi.zza));
            this.zzl = zzfwVarZza.zze();
        }
        return this.zzb.zzb(this.zzl);
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        InputStream inputStream = this.zzf;
        if (inputStream == null) {
            this.zzb.zzd();
        } else {
            hs0.h(inputStream);
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final /* synthetic */ Map zze() {
        return Collections.EMPTY_MAP;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzf(zzgu zzguVar) {
    }
}
