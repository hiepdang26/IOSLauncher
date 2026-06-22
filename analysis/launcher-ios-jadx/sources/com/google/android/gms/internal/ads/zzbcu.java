package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import defpackage.hd2;
import defpackage.hr;
import defpackage.k92;
import defpackage.n42;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcu extends hr {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private final List zzb = Arrays.asList(((String) n42.d.c.zza(zzbbw.zziV)).split(","));
    private final zzbcx zzc;
    private final hr zzd;

    public zzbcu(zzbcx zzbcxVar, hr hrVar) {
        this.zzd = hrVar;
        this.zzc = zzbcxVar;
    }

    @Override // defpackage.hr
    public final void extraCallback(String str, Bundle bundle) {
        hr hrVar = this.zzd;
        if (hrVar != null) {
            hrVar.extraCallback(str, bundle);
        }
    }

    @Override // defpackage.hr
    public final Bundle extraCallbackWithResult(String str, Bundle bundle) {
        hr hrVar = this.zzd;
        if (hrVar != null) {
            return hrVar.extraCallbackWithResult(str, bundle);
        }
        return null;
    }

    public final void onActivityResized(int i, int i2, Bundle bundle) {
        hr hrVar = this.zzd;
        if (hrVar != null) {
            hrVar.onActivityResized(i, i2, bundle);
        }
    }

    @Override // defpackage.hr
    public final void onMessageChannelReady(Bundle bundle) {
        this.zza.set(false);
        hr hrVar = this.zzd;
        if (hrVar != null) {
            hrVar.onMessageChannelReady(bundle);
        }
    }

    @Override // defpackage.hr
    public final void onNavigationEvent(int i, Bundle bundle) {
        List list;
        this.zza.set(false);
        hr hrVar = this.zzd;
        if (hrVar != null) {
            hrVar.onNavigationEvent(i, bundle);
        }
        zzbcx zzbcxVar = this.zzc;
        hd2.B.j.getClass();
        zzbcxVar.zzi(System.currentTimeMillis());
        if (this.zzc == null || (list = this.zzb) == null || !list.contains(String.valueOf(i))) {
            return;
        }
        this.zzc.zzf();
    }

    @Override // defpackage.hr
    public final void onPostMessage(String str, Bundle bundle) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("gpa", -1) == 0) {
                this.zza.set(true);
                this.zzc.zzh(jSONObject.getString("paw_id"));
            }
        } catch (JSONException unused) {
            k92.b();
        }
        hr hrVar = this.zzd;
        if (hrVar != null) {
            hrVar.onPostMessage(str, bundle);
        }
    }

    @Override // defpackage.hr
    public final void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
        hr hrVar = this.zzd;
        if (hrVar != null) {
            hrVar.onRelationshipValidationResult(i, uri, z, bundle);
        }
    }

    public final Boolean zza() {
        return Boolean.valueOf(this.zza.get());
    }
}
