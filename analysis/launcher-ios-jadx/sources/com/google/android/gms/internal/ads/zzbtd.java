package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.e41;
import defpackage.f41;
import defpackage.pw1;

/* JADX INFO: loaded from: classes.dex */
final class zzbtd extends zzbyi {
    final /* synthetic */ f41 zza;

    public zzbtd(zzbte zzbteVar, f41 f41Var) {
        this.zza = f41Var;
    }

    @Override // com.google.android.gms.internal.ads.zzbyj
    public final void zzb(String str) {
        this.zza.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbyj
    public final void zzc(String str, String str2, Bundle bundle) {
        this.zza.onSuccess(new e41(new pw1(str)));
    }
}
