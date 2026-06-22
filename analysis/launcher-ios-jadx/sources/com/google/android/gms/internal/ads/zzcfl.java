package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.a92;
import defpackage.e9;
import defpackage.k92;
import defpackage.n42;
import defpackage.ta2;
import defpackage.w82;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfl extends w82 {
    private final zzcbk zza;
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    private a92 zzf;
    private boolean zzg;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbgl zzn;
    private final Object zzb = new Object();
    private boolean zzh = true;

    public zzcfl(zzcbk zzcbkVar, float f, boolean z, boolean z2) {
        this.zza = zzcbkVar;
        this.zzi = f;
        this.zzc = z;
        this.zzd = z2;
    }

    private final void zzw(final int i, final int i2, final boolean z, final boolean z2) {
        zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(i, i2, z, z2);
            }
        });
    }

    private final void zzx(String str, Map map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzr(map2);
            }
        });
    }

    public final void zzc(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (this.zzb) {
            try {
                z2 = true;
                if (f2 == this.zzi && f3 == this.zzk) {
                    z2 = false;
                }
                this.zzi = f2;
                if (!((Boolean) n42.d.c.zza(zzbbw.zzlP)).booleanValue()) {
                    this.zzj = f;
                }
                z3 = this.zzh;
                this.zzh = z;
                i2 = this.zze;
                this.zze = i;
                float f4 = this.zzk;
                this.zzk = f3;
                if (Math.abs(f3 - f4) > 1.0E-4f) {
                    this.zza.zzF().invalidate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            try {
                zzbgl zzbglVar = this.zzn;
                if (zzbglVar != null) {
                    zzbglVar.zze();
                }
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
        zzw(i2, i, z3, z);
    }

    public final /* synthetic */ void zzd(int i, int i2, boolean z, boolean z2) {
        int i3;
        boolean z3;
        boolean z4;
        a92 a92Var;
        a92 a92Var2;
        a92 a92Var3;
        synchronized (this.zzb) {
            try {
                boolean z5 = this.zzg;
                if (z5 || i2 != 1) {
                    i3 = i2;
                    z3 = false;
                } else {
                    i2 = 1;
                    i3 = 1;
                    z3 = true;
                }
                boolean z6 = i != i2;
                if (z6 && i3 == 1) {
                    z4 = true;
                    i3 = 1;
                } else {
                    z4 = false;
                }
                boolean z7 = z6 && i3 == 2;
                boolean z8 = z6 && i3 == 3;
                this.zzg = z5 || z3;
                if (z3) {
                    try {
                        a92 a92Var4 = this.zzf;
                        if (a92Var4 != null) {
                            a92Var4.zzi();
                        }
                    } catch (RemoteException e) {
                        k92.i("#007 Could not call remote method.", e);
                    }
                }
                if (z4 && (a92Var3 = this.zzf) != null) {
                    a92Var3.zzh();
                }
                if (z7 && (a92Var2 = this.zzf) != null) {
                    a92Var2.zzg();
                }
                if (z8) {
                    a92 a92Var5 = this.zzf;
                    if (a92Var5 != null) {
                        a92Var5.zze();
                    }
                    this.zza.zzw();
                }
                if (z != z2 && (a92Var = this.zzf) != null) {
                    a92Var.j(z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.x82
    public final float zze() {
        float f;
        synchronized (this.zzb) {
            f = this.zzk;
        }
        return f;
    }

    @Override // defpackage.x82
    public final float zzf() {
        float f;
        synchronized (this.zzb) {
            f = this.zzj;
        }
        return f;
    }

    @Override // defpackage.x82
    public final float zzg() {
        float f;
        synchronized (this.zzb) {
            f = this.zzi;
        }
        return f;
    }

    @Override // defpackage.x82
    public final int zzh() {
        int i;
        synchronized (this.zzb) {
            i = this.zze;
        }
        return i;
    }

    @Override // defpackage.x82
    public final a92 zzi() {
        a92 a92Var;
        synchronized (this.zzb) {
            a92Var = this.zzf;
        }
        return a92Var;
    }

    @Override // defpackage.x82
    public final void zzj(boolean z) {
        zzx(true != z ? "unmute" : "mute", null);
    }

    @Override // defpackage.x82
    public final void zzk() {
        zzx("pause", null);
    }

    @Override // defpackage.x82
    public final void zzl() {
        zzx("play", null);
    }

    @Override // defpackage.x82
    public final void zzm(a92 a92Var) {
        synchronized (this.zzb) {
            this.zzf = a92Var;
        }
    }

    @Override // defpackage.x82
    public final void zzn() {
        zzx("stop", null);
    }

    @Override // defpackage.x82
    public final boolean zzo() {
        boolean z;
        Object obj = this.zzb;
        boolean zZzp = zzp();
        synchronized (obj) {
            z = false;
            if (!zZzp) {
                try {
                    if (this.zzm && this.zzd) {
                        z = true;
                    }
                } finally {
                }
            }
        }
        return z;
    }

    @Override // defpackage.x82
    public final boolean zzp() {
        boolean z;
        synchronized (this.zzb) {
            try {
                z = false;
                if (this.zzc && this.zzl) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.x82
    public final boolean zzq() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzh;
        }
        return z;
    }

    public final /* synthetic */ void zzr(Map map) {
        this.zza.zzd("pubVideoCmd", map);
    }

    public final void zzs(ta2 ta2Var) {
        Object obj = this.zzb;
        boolean z = ta2Var.g;
        boolean z2 = ta2Var.h;
        boolean z3 = ta2Var.i;
        synchronized (obj) {
            this.zzl = z2;
            this.zzm = z3;
        }
        String str = true != z ? "0" : "1";
        String str2 = true != z2 ? "0" : "1";
        String str3 = true != z3 ? "0" : "1";
        e9 e9Var = new e9(3);
        e9Var.put("muteStart", str);
        e9Var.put("customControlsRequested", str2);
        e9Var.put("clickToExpandRequested", str3);
        zzx("initialState", Collections.unmodifiableMap(e9Var));
    }

    public final void zzt(float f) {
        synchronized (this.zzb) {
            this.zzj = f;
        }
    }

    public final void zzu() {
        boolean z;
        int i;
        synchronized (this.zzb) {
            z = this.zzh;
            i = this.zze;
            this.zze = 3;
        }
        zzw(i, 3, z, z);
    }

    public final void zzv(zzbgl zzbglVar) {
        synchronized (this.zzb) {
            this.zzn = zzbglVar;
        }
    }
}
