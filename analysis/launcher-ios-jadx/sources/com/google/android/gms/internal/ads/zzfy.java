package com.google.android.gms.internal.ads;

import android.net.Uri;
import defpackage.uo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzfy {
    public static final /* synthetic */ int zzh = 0;
    public final Uri zza;
    public final int zzb;
    public final byte[] zzc;
    public final Map zzd;
    public final long zze;
    public final long zzf;
    public final int zzg;

    static {
        zzbd.zzb("media3.datasource");
    }

    public final String toString() {
        StringBuilder sbO = uo.o("DataSpec[GET ", this.zza.toString(), ", ");
        sbO.append(this.zze);
        sbO.append(", ");
        sbO.append(this.zzf);
        sbO.append(", null, ");
        return uo.j(sbO, this.zzg, "]");
    }

    public final zzfw zza() {
        return new zzfw(this, null);
    }

    public final boolean zzb(int i) {
        return (this.zzg & i) == i;
    }

    private zzfy(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj) {
        boolean z = false;
        boolean z2 = j2 >= 0;
        zzdi.zzd(z2);
        zzdi.zzd(z2);
        if (j3 > 0) {
            z = true;
        } else if (j3 == -1) {
            j3 = -1;
            z = true;
        }
        zzdi.zzd(z);
        uri.getClass();
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zze = j2;
        this.zzf = j3;
        this.zzg = i2;
    }

    @Deprecated
    public zzfy(Uri uri, long j, long j2, String str) {
        this(uri, 0L, 1, null, Collections.EMPTY_MAP, j, j2, null, 0, null);
    }
}
