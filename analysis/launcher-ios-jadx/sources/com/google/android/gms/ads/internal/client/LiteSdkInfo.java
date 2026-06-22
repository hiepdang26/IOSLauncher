package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbom;
import defpackage.e72;
import defpackage.w92;

/* JADX INFO: loaded from: classes.dex */
public class LiteSdkInfo extends e72 {
    public LiteSdkInfo(Context context) {
        super("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // defpackage.g72
    public zzbom getAdapterCreator() {
        return new zzboi();
    }

    @Override // defpackage.g72
    public w92 getLiteSdkVersion() {
        return new w92(ModuleDescriptor.MODULE_VERSION, 242402000, "23.3.0");
    }
}
