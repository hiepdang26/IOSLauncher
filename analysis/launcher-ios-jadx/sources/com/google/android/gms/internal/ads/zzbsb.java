package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.bw0;
import defpackage.gs0;
import defpackage.k92;
import defpackage.nv0;
import defpackage.x92;
import defpackage.yv0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsb implements bw0 {
    private final zzbfx zza;
    private yv0 zzb;

    public zzbsb(zzbfx zzbfxVar) {
        this.zza = zzbfxVar;
    }

    public final void destroy() {
        try {
            this.zza.zzl();
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zza.zzk();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final String getCustomFormatId() {
        try {
            return this.zza.zzi();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final yv0 getDisplayOpenMeasurement() {
        try {
            if (this.zzb == null && this.zza.zzq()) {
                this.zzb = new zzbrt(this.zza);
            }
        } catch (RemoteException unused) {
            k92.f();
        }
        return this.zzb;
    }

    public final nv0 getImage(String str) {
        try {
            zzbfd zzbfdVarZzg = this.zza.zzg(str);
            if (zzbfdVarZzg != null) {
                return new zzbru(zzbfdVarZzg);
            }
            return null;
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final gs0 getMediaContent() {
        try {
            if (this.zza.zzf() != null) {
                return new x92(this.zza.zzf(), this.zza);
            }
            return null;
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zza.zzj(str);
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final void performClick(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void recordImpression() {
        try {
            this.zza.zzo();
        } catch (RemoteException unused) {
            k92.f();
        }
    }
}
