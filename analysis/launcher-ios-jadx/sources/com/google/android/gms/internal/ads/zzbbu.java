package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbu implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    volatile boolean zza = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(final SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            this.zzh = new JSONObject((String) zzbby.zza(new zzfvk() { // from class: com.google.android.gms.internal.ads.zzbbr
                @Override // com.google.android.gms.internal.ads.zzfvk
                public final Object zza() {
                    return sharedPreferences.getString("flag_configuration", "{}");
                }
            }));
        } catch (JSONException unused) {
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    public final Object zza(final zzbbn zzbbnVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                try {
                    if (!this.zza) {
                        throw new IllegalStateException("Flags.initialize() was not called!");
                    }
                } finally {
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null && !this.zzj) {
                }
                return zzbbnVar.zzm();
            }
        }
        if (zzbbnVar.zze() != 2) {
            return (zzbbnVar.zze() == 1 && this.zzh.has(zzbbnVar.zzn())) ? zzbbnVar.zza(this.zzh) : zzbby.zza(new zzfvk() { // from class: com.google.android.gms.internal.ads.zzbbs
                @Override // com.google.android.gms.internal.ads.zzfvk
                public final Object zza() {
                    return this.zza.zzc(zzbbnVar);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzbbnVar.zzm() : zzbbnVar.zzb(bundle);
    }

    public final Object zzb(zzbbn zzbbnVar) {
        return (this.zzd || this.zza) ? zza(zzbbnVar) : zzbbnVar.zzm();
    }

    public final /* synthetic */ Object zzc(zzbbn zzbbnVar) {
        return zzbbnVar.zzc(this.zze);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00b1 A[Catch: all -> 0x0061, TRY_ENTER, TryCatch #0 {all -> 0x0061, blocks: (B:22:0x0046, B:24:0x004b, B:29:0x0059, B:35:0x0066, B:37:0x0070, B:38:0x0078, B:40:0x007e, B:42:0x008e, B:44:0x00a3, B:48:0x00b1, B:50:0x00b5, B:52:0x00c5, B:54:0x00da, B:57:0x00e6, B:67:0x0125, B:73:0x0134, B:75:0x014c, B:77:0x0150, B:78:0x0153, B:60:0x00f7, B:62:0x0105, B:64:0x010d, B:65:0x0118), top: B:87:0x0046, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e6 A[Catch: all -> 0x0061, TRY_ENTER, TryCatch #0 {all -> 0x0061, blocks: (B:22:0x0046, B:24:0x004b, B:29:0x0059, B:35:0x0066, B:37:0x0070, B:38:0x0078, B:40:0x007e, B:42:0x008e, B:44:0x00a3, B:48:0x00b1, B:50:0x00b5, B:52:0x00c5, B:54:0x00da, B:57:0x00e6, B:67:0x0125, B:73:0x0134, B:75:0x014c, B:77:0x0150, B:78:0x0153, B:60:0x00f7, B:62:0x0105, B:64:0x010d, B:65:0x0118), top: B:87:0x0046, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012b A[Catch: all -> 0x000f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x000f, blocks: (B:7:0x0009, B:9:0x000d, B:13:0x0012, B:15:0x0017, B:16:0x0019, B:18:0x002b, B:19:0x002f, B:20:0x0031, B:45:0x00a7, B:46:0x00ae, B:55:0x00de, B:71:0x012b, B:79:0x015a, B:80:0x0161, B:82:0x0163, B:83:0x016a, B:22:0x0046, B:24:0x004b, B:29:0x0059, B:35:0x0066, B:37:0x0070, B:38:0x0078, B:40:0x007e, B:42:0x008e, B:44:0x00a3, B:48:0x00b1, B:50:0x00b5, B:52:0x00c5, B:54:0x00da, B:57:0x00e6, B:67:0x0125, B:73:0x0134, B:75:0x014c, B:77:0x0150, B:78:0x0153, B:60:0x00f7, B:62:0x0105, B:64:0x010d, B:65:0x0118), top: B:94:0x0009, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0134 A[Catch: all -> 0x0061, TRY_ENTER, TryCatch #0 {all -> 0x0061, blocks: (B:22:0x0046, B:24:0x004b, B:29:0x0059, B:35:0x0066, B:37:0x0070, B:38:0x0078, B:40:0x007e, B:42:0x008e, B:44:0x00a3, B:48:0x00b1, B:50:0x00b5, B:52:0x00c5, B:54:0x00da, B:57:0x00e6, B:67:0x0125, B:73:0x0134, B:75:0x014c, B:77:0x0150, B:78:0x0153, B:60:0x00f7, B:62:0x0105, B:64:0x010d, B:65:0x0118), top: B:87:0x0046, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(android.content.Context r11) {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbu.zzd(android.content.Context):void");
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzi;
    }
}
