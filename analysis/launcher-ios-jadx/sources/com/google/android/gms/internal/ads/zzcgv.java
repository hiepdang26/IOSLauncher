package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgv implements zzhfc {
    public zzcgv(zzcgm zzcgmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* synthetic */ Object zzb() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.android.vending");
        intent.setData(Uri.parse("https://play.google.com/d"));
        return intent;
    }
}
