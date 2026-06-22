package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.k92;
import defpackage.nj;
import defpackage.us;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcop implements zzaxw {
    private zzcej zza;
    private final Executor zzb;
    private final zzcob zzc;
    private final nj zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcoe zzg = new zzcoe();

    public zzcop(Executor executor, zzcob zzcobVar, nj njVar) {
        this.zzb = executor;
        this.zzc = zzcobVar;
        this.zzd = njVar;
    }

    private final void zzg() {
        try {
            final JSONObject jSONObjectZzb = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcoo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzd(jSONObjectZzb);
                    }
                });
            }
        } catch (JSONException unused) {
            k92.b();
        }
    }

    public final void zza() {
        this.zze = false;
    }

    public final void zzb() {
        this.zze = true;
        zzg();
    }

    public final /* synthetic */ void zzd(JSONObject jSONObject) {
        this.zza.zzl("AFMA_updateActiveView", jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaxw
    public final void zzdp(zzaxv zzaxvVar) {
        boolean z = this.zzf ? false : zzaxvVar.zzj;
        zzcoe zzcoeVar = this.zzg;
        zzcoeVar.zza = z;
        ((us) this.zzd).getClass();
        zzcoeVar.zzd = SystemClock.elapsedRealtime();
        this.zzg.zzf = zzaxvVar;
        if (this.zze) {
            zzg();
        }
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final void zzf(zzcej zzcejVar) {
        this.zza = zzcejVar;
    }
}
