package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.RemoteException;
import defpackage.cw0;
import defpackage.k92;
import defpackage.l72;
import defpackage.t92;
import defpackage.ta2;
import defpackage.uv0;
import defpackage.vv0;
import defpackage.wv0;
import defpackage.zr1;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzbps implements cw0 {
    private final Date zza;
    private final int zzb;
    private final Set zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final zzbes zzg;
    private final boolean zzi;
    private final List zzh = new ArrayList();
    private final Map zzj = new HashMap();

    public zzbps(Date date, int i, Set set, Location location, boolean z, int i2, zzbes zzbesVar, List list, boolean z2, int i3, String str) {
        this.zza = date;
        this.zzb = i;
        this.zzc = set;
        this.zze = location;
        this.zzd = z;
        this.zzf = i2;
        this.zzg = zzbesVar;
        this.zzi = z2;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.startsWith("custom:")) {
                    String[] strArrSplit = str2.split(":", 3);
                    if (strArrSplit.length == 3) {
                        if ("true".equals(strArrSplit[2])) {
                            this.zzj.put(strArrSplit[1], Boolean.TRUE);
                        } else if ("false".equals(strArrSplit[2])) {
                            this.zzj.put(strArrSplit[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.zzh.add(str2);
                }
            }
        }
    }

    public final float getAdVolume() {
        t92 t92VarF = t92.f();
        synchronized (t92VarF.d) {
            l72 l72Var = (l72) t92VarF.f;
            float fZze = 1.0f;
            if (l72Var == null) {
                return 1.0f;
            }
            try {
                fZze = l72Var.zze();
            } catch (RemoteException unused) {
                k92.f();
            }
            return fZze;
        }
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    @Override // defpackage.os0
    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    @Override // defpackage.cw0
    public final wv0 getNativeAdOptions() {
        uv0 uv0Var = new uv0();
        zzbes zzbesVar = this.zzg;
        if (zzbesVar == null) {
            return new wv0(uv0Var);
        }
        int i = zzbesVar.zza;
        if (i == 2) {
            uv0Var.f = zzbesVar.zze;
        } else {
            if (i != 3) {
                if (i == 4) {
                    uv0Var.g = zzbesVar.zzg;
                    uv0Var.c = zzbesVar.zzh;
                }
            }
            ta2 ta2Var = zzbesVar.zzf;
            if (ta2Var != null) {
                uv0Var.e = new zr1(ta2Var);
            }
            uv0Var.f = zzbesVar.zze;
        }
        uv0Var.a = zzbesVar.zzb;
        uv0Var.b = zzbesVar.zzc;
        uv0Var.d = zzbesVar.zzd;
        return new wv0(uv0Var);
    }

    @Override // defpackage.cw0
    public final vv0 getNativeAdRequestOptions() {
        return zzbes.zza(this.zzg);
    }

    public final boolean isAdMuted() {
        t92 t92VarF = t92.f();
        synchronized (t92VarF.d) {
            l72 l72Var = (l72) t92VarF.f;
            boolean zZzv = false;
            if (l72Var == null) {
                return false;
            }
            try {
                zZzv = l72Var.zzv();
            } catch (RemoteException unused) {
                k92.f();
            }
            return zZzv;
        }
    }

    @Override // defpackage.os0
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    @Override // defpackage.os0
    public final boolean isTesting() {
        return this.zzd;
    }

    @Override // defpackage.cw0
    public final boolean isUnifiedNativeAdRequested() {
        return this.zzh.contains("6");
    }

    @Override // defpackage.os0
    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    @Override // defpackage.cw0
    public final Map zza() {
        return this.zzj;
    }

    @Override // defpackage.cw0
    public final boolean zzb() {
        return this.zzh.contains("3");
    }
}
