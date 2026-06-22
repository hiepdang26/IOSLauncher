package com.google.android.gms.internal.ads;

import defpackage.k92;
import defpackage.x32;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzezj implements zzevn {
    private final Map zza;

    public zzezj(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", x32.f.a.h(this.zza));
        } catch (JSONException e) {
            k92.a("Could not encode video decoder properties: ".concat(String.valueOf(e.getMessage())));
        }
    }
}
