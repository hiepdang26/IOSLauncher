package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import defpackage.hd2;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class zzbar {
    private zzbag zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    public zzbar(Context context) {
        this.zzc = context;
    }

    public static /* bridge */ /* synthetic */ void zze(zzbar zzbarVar) {
        synchronized (zzbarVar.zzd) {
            try {
                zzbag zzbagVar = zzbarVar.zza;
                if (zzbagVar == null) {
                    return;
                }
                zzbagVar.disconnect();
                zzbarVar.zza = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Future zzc(zzbah zzbahVar) {
        zzbal zzbalVar = new zzbal(this);
        zzbap zzbapVar = new zzbap(this, zzbahVar, zzbalVar);
        zzbaq zzbaqVar = new zzbaq(this, zzbalVar);
        synchronized (this.zzd) {
            zzbag zzbagVar = new zzbag(this.zzc, hd2.B.r.a(), zzbapVar, zzbaqVar);
            this.zza = zzbagVar;
            zzbagVar.checkAvailabilityAndConnect();
        }
        return zzbalVar;
    }
}
