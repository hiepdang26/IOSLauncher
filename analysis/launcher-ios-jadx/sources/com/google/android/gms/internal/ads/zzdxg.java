package com.google.android.gms.internal.ads;

import defpackage.cd2;
import defpackage.hd2;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxg implements zzhfc {
    public static zzdxg zza() {
        return zzdxf.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        cd2 cd2Var = hd2.B.c;
        String string = UUID.randomUUID().toString();
        zzhfk.zzb(string);
        return string;
    }
}
