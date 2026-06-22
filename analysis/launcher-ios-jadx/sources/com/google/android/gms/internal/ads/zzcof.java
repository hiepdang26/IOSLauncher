package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import defpackage.k92;
import defpackage.mc2;
import defpackage.nj;
import defpackage.us;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcof implements zzaxw, zzcxl, mc2, zzcxk {
    private final zzcoa zza;
    private final zzcob zzb;
    private final zzboa zzd;
    private final Executor zze;
    private final nj zzf;
    private final Set zzc = new HashSet();
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    private final zzcoe zzh = new zzcoe();
    private boolean zzi = false;
    private WeakReference zzj = new WeakReference(this);

    public zzcof(zzbnx zzbnxVar, zzcob zzcobVar, Executor executor, zzcoa zzcoaVar, nj njVar) {
        this.zza = zzcoaVar;
        zzbni zzbniVar = zzbnl.zza;
        this.zzd = zzbnxVar.zza("google.afma.activeView.handleUpdate", zzbniVar, zzbniVar);
        this.zzb = zzcobVar;
        this.zze = executor;
        this.zzf = njVar;
    }

    private final void zzk() {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            this.zza.zzf((zzcej) it.next());
        }
        this.zza.zze();
    }

    @Override // defpackage.mc2
    public final synchronized void zzdH() {
        this.zzh.zzb = false;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final synchronized void zzdj(Context context) {
        this.zzh.zze = "u";
        zzg();
        zzk();
        this.zzi = true;
    }

    @Override // defpackage.mc2
    public final synchronized void zzdk() {
        this.zzh.zzb = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final synchronized void zzdl(Context context) {
        this.zzh.zzb = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final synchronized void zzdm(Context context) {
        this.zzh.zzb = false;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzaxw
    public final synchronized void zzdp(zzaxv zzaxvVar) {
        zzcoe zzcoeVar = this.zzh;
        zzcoeVar.zza = zzaxvVar.zzj;
        zzcoeVar.zzf = zzaxvVar;
        zzg();
    }

    @Override // defpackage.mc2
    public final void zzdq() {
    }

    @Override // defpackage.mc2
    public final void zzdr() {
    }

    @Override // defpackage.mc2
    public final void zzdt() {
    }

    @Override // defpackage.mc2
    public final void zzdu(int i) {
    }

    public final synchronized void zzg() {
        try {
            if (this.zzj.get() == null) {
                zzj();
                return;
            }
            if (this.zzi || !this.zzg.get()) {
                return;
            }
            try {
                zzcoe zzcoeVar = this.zzh;
                ((us) this.zzf).getClass();
                zzcoeVar.zzd = SystemClock.elapsedRealtime();
                final JSONObject jSONObjectZza = this.zzb.zzb(this.zzh);
                for (final zzcej zzcejVar : this.zzc) {
                    this.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcod
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcejVar.zzl("AFMA_updateActiveView", jSONObjectZza);
                        }
                    });
                }
                zzbzr.zzb(this.zzd.zzb(jSONObjectZza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception unused) {
                k92.b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzh(zzcej zzcejVar) {
        this.zzc.add(zzcejVar);
        this.zza.zzd(zzcejVar);
    }

    public final void zzi(Object obj) {
        this.zzj = new WeakReference(obj);
    }

    public final synchronized void zzj() {
        zzk();
        this.zzi = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final synchronized void zzr() {
        if (this.zzg.compareAndSet(false, true)) {
            this.zza.zzc(this);
            zzg();
        }
    }
}
