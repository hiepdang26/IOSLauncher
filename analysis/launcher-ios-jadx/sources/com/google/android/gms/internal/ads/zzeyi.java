package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.k92;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeyi implements zzevn {
    private final List zza;

    public zzeyi(List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(",", this.zza));
        } catch (JSONException unused) {
            k92.a("Failed putting experiment ids.");
        }
    }
}
