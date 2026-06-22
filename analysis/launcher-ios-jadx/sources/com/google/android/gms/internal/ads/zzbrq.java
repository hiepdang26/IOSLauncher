package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.Key;
import defpackage.k92;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzbrq {
    private final zzcej zza;
    private final String zzb;

    public zzbrq(zzcej zzcejVar, String str) {
        this.zza = zzcejVar;
        this.zzb = str;
    }

    public final void zzg(int i, int i2, int i3, int i4) {
        try {
            this.zza.zze("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException unused) {
            k92.f();
        }
    }

    public final void zzh(String str) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("message", str).put("action", this.zzb);
            zzcej zzcejVar = this.zza;
            if (zzcejVar != null) {
                zzcejVar.zze("onError", jSONObjectPut);
            }
        } catch (JSONException unused) {
            k92.f();
        }
    }

    public final void zzi(String str) {
        try {
            this.zza.zze("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException unused) {
            k92.f();
        }
    }

    public final void zzj(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zza.zze("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put(Key.ROTATION, i5));
        } catch (JSONException unused) {
            k92.f();
        }
    }

    public final void zzk(int i, int i2, int i3, int i4) {
        try {
            this.zza.zze("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException unused) {
            k92.f();
        }
    }

    public final void zzl(String str) {
        try {
            this.zza.zze("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException unused) {
            k92.f();
        }
    }
}
