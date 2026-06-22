package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public final class zzaal {
    private final zzzv zza = new zzzv();
    private final zzaaj zzb;
    private final zzaak zzc;
    private boolean zzd;
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzaal(Context context) {
        DisplayManager displayManager;
        zzaaj zzaajVar = (context == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : new zzaaj(this, displayManager);
        this.zzb = zzaajVar;
        this.zzc = zzaajVar != null ? zzaak.zza() : null;
        this.zzk = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    public static /* bridge */ /* synthetic */ void zzb(zzaal zzaalVar, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zzaalVar.zzk = refreshRate;
            zzaalVar.zzl = (refreshRate * 80) / 100;
        } else {
            zzea.zzf("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            zzaalVar.zzk = -9223372036854775807L;
            zzaalVar.zzl = -9223372036854775807L;
        }
    }

    private final void zzk() {
        Surface surface;
        if (zzet.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE || this.zzh == 0.0f) {
            return;
        }
        this.zzh = 0.0f;
        zzaai.zza(surface, 0.0f);
    }

    private final void zzl() {
        this.zzm = 0L;
        this.zzp = -1L;
        this.zzn = -1L;
    }

    private final void zzm() {
        if (zzet.zza < 30 || this.zze == null) {
            return;
        }
        float fZza = this.zza.zzg() ? this.zza.zza() : this.zzf;
        float f = this.zzg;
        if (fZza != f) {
            if (fZza != -1.0f && f != -1.0f) {
                float f2 = 1.0f;
                if (this.zza.zzg() && this.zza.zzd() >= 5000000000L) {
                    f2 = 0.02f;
                }
                if (Math.abs(fZza - this.zzg) < f2) {
                    return;
                }
            } else if (fZza == -1.0f && this.zza.zzb() < 30) {
                return;
            }
            this.zzg = fZza;
            zzn(false);
        }
    }

    private final void zzn(boolean z) {
        Surface surface;
        if (zzet.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.zzd) {
            float f2 = this.zzg;
            if (f2 != -1.0f) {
                f = this.zzi * f2;
            }
        }
        if (z || this.zzh != f) {
            this.zzh = f;
            zzaai.zza(surface, f);
        }
    }

    public final long zza(long j) {
        long j2;
        if (this.zzp != -1 && this.zza.zzg()) {
            long jZzc = this.zza.zzc();
            long j3 = this.zzq + ((long) (((this.zzm - this.zzp) * jZzc) / this.zzi));
            if (Math.abs(j - j3) > 20000000) {
                zzl();
            } else {
                j = j3;
            }
        }
        this.zzn = this.zzm;
        this.zzo = j;
        zzaak zzaakVar = this.zzc;
        if (zzaakVar != null && this.zzk != -9223372036854775807L) {
            long j4 = zzaakVar.zza;
            if (j4 != -9223372036854775807L) {
                long j5 = this.zzk;
                long j6 = (((j - j4) / j5) * j5) + j4;
                if (j <= j6) {
                    j2 = j6 - j5;
                } else {
                    j2 = j6;
                    j6 = j5 + j6;
                }
                long j7 = this.zzl;
                if (j6 - j >= j - j2) {
                    j6 = j2;
                }
                return j6 - j7;
            }
        }
        return j;
    }

    public final void zzc(float f) {
        this.zzf = f;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j) {
        long j2 = this.zzn;
        if (j2 != -1) {
            this.zzp = j2;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j * 1000);
        zzm();
    }

    public final void zze(float f) {
        this.zzi = f;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        if (this.zzb != null) {
            zzaak zzaakVar = this.zzc;
            zzaakVar.getClass();
            zzaakVar.zzb();
            this.zzb.zza();
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzaaj zzaajVar = this.zzb;
        if (zzaajVar != null) {
            zzaajVar.zzb();
            zzaak zzaakVar = this.zzc;
            zzaakVar.getClass();
            zzaakVar.zzc();
        }
        zzk();
    }

    public final void zzi(Surface surface) {
        if (true == (surface instanceof zzaad)) {
            surface = null;
        }
        if (this.zze == surface) {
            return;
        }
        zzk();
        this.zze = surface;
        zzn(true);
    }

    public final void zzj(int i) {
        if (this.zzj == i) {
            return;
        }
        this.zzj = i;
        zzn(true);
    }
}
