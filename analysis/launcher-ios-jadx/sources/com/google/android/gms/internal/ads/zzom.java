package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class zzom {
    private final Context zza;
    private final Handler zzb;
    private final zzoi zzc;
    private final BroadcastReceiver zzd;
    private final zzoj zze;
    private zzof zzf;
    private zzon zzg;
    private zzh zzh;
    private boolean zzi;
    private final zzpx zzj;

    /* JADX WARN: Multi-variable type inference failed */
    public zzom(Context context, zzpx zzpxVar, zzh zzhVar, zzon zzonVar) {
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzj = zzpxVar;
        this.zzh = zzhVar;
        this.zzg = zzonVar;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Handler handler = new Handler(zzet.zzy(), null);
        this.zzb = handler;
        this.zzc = zzet.zza >= 23 ? new zzoi(this, objArr2 == true ? 1 : 0) : null;
        this.zzd = new zzol(this, objArr == true ? 1 : 0);
        Uri uriZza = zzof.zza();
        this.zze = uriZza != null ? new zzoj(this, handler, applicationContext.getContentResolver(), uriZza) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(zzof zzofVar) {
        if (!this.zzi || zzofVar.equals(this.zzf)) {
            return;
        }
        this.zzf = zzofVar;
        this.zzj.zza.zzI(zzofVar);
    }

    public final zzof zzc() {
        zzoi zzoiVar;
        if (this.zzi) {
            zzof zzofVar = this.zzf;
            zzofVar.getClass();
            return zzofVar;
        }
        this.zzi = true;
        zzoj zzojVar = this.zze;
        if (zzojVar != null) {
            zzojVar.zza();
        }
        if (zzet.zza >= 23 && (zzoiVar = this.zzc) != null) {
            zzog.zza(this.zza, zzoiVar, this.zzb);
        }
        zzof zzofVarZzd = zzof.zzd(this.zza, this.zzd != null ? this.zza.registerReceiver(this.zzd, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.zzb) : null, this.zzh, this.zzg);
        this.zzf = zzofVarZzd;
        return zzofVarZzd;
    }

    public final void zzg(zzh zzhVar) {
        this.zzh = zzhVar;
        zzj(zzof.zzc(this.zza, zzhVar, this.zzg));
    }

    public final void zzh(AudioDeviceInfo audioDeviceInfo) {
        zzon zzonVar = this.zzg;
        if (zzet.zzG(audioDeviceInfo, zzonVar == null ? null : zzonVar.zza)) {
            return;
        }
        zzon zzonVar2 = audioDeviceInfo != null ? new zzon(audioDeviceInfo) : null;
        this.zzg = zzonVar2;
        zzj(zzof.zzc(this.zza, this.zzh, zzonVar2));
    }

    public final void zzi() {
        zzoi zzoiVar;
        if (this.zzi) {
            this.zzf = null;
            if (zzet.zza >= 23 && (zzoiVar = this.zzc) != null) {
                zzog.zzb(this.zza, zzoiVar);
            }
            BroadcastReceiver broadcastReceiver = this.zzd;
            if (broadcastReceiver != null) {
                this.zza.unregisterReceiver(broadcastReceiver);
            }
            zzoj zzojVar = this.zze;
            if (zzojVar != null) {
                zzojVar.zzb();
            }
            this.zzi = false;
        }
    }
}
