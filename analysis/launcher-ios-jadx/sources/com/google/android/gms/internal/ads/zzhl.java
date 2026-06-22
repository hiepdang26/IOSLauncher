package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
final class zzhl {
    private final AudioManager zza;
    private final zzhj zzb;
    private zzhk zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzhl(Context context, Handler handler, zzhk zzhkVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        audioManager.getClass();
        this.zza = audioManager;
        this.zzc = zzhkVar;
        this.zzb = new zzhj(this, handler);
        this.zzd = 0;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzhl zzhlVar, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzhlVar.zzg(3);
                return;
            } else {
                zzhlVar.zzf(0);
                zzhlVar.zzg(2);
                return;
            }
        }
        if (i == -1) {
            zzhlVar.zzf(-1);
            zzhlVar.zze();
        } else if (i != 1) {
            k31.n(i, "Unknown focus change type: ", "AudioFocusManager");
        } else {
            zzhlVar.zzg(1);
            zzhlVar.zzf(1);
        }
    }

    private final void zze() {
        if (this.zzd == 0) {
            return;
        }
        if (zzet.zza < 26) {
            this.zza.abandonAudioFocus(this.zzb);
        }
        zzg(0);
    }

    private final void zzf(int i) {
        zzhk zzhkVar = this.zzc;
        if (zzhkVar != null) {
            zzji zzjiVar = (zzji) zzhkVar;
            boolean zZzu = zzjiVar.zza.zzu();
            zzjiVar.zza.zzaf(zZzu, i, zzjm.zzS(zZzu, i));
        }
    }

    private final void zzg(int i) {
        if (this.zzd == i) {
            return;
        }
        this.zzd = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.zze != f) {
            this.zze = f;
            zzhk zzhkVar = this.zzc;
            if (zzhkVar != null) {
                ((zzji) zzhkVar).zza.zzac();
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z, int i) {
        zze();
        return z ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }
}
