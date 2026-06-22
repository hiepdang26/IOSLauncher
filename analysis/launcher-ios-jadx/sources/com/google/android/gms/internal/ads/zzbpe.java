package com.google.android.gms.internal.ads;

import android.location.Location;
import defpackage.os0;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpe implements os0 {
    private final Date zza;
    private final int zzb;
    private final Set zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final boolean zzg;

    public zzbpe(Date date, int i, Set set, Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.zza = date;
        this.zzb = i;
        this.zzc = set;
        this.zze = location;
        this.zzd = z;
        this.zzf = i2;
        this.zzg = z2;
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

    @Override // defpackage.os0
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzg;
    }

    @Override // defpackage.os0
    public final boolean isTesting() {
        return this.zzd;
    }

    @Override // defpackage.os0
    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }
}
