package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfsc extends zzfrz {
    private static zzfsc zzc;

    private zzfsc(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfsc zzi(Context context) {
        zzfsc zzfscVar;
        synchronized (zzfsc.class) {
            try {
                if (zzc == null) {
                    zzc = new zzfsc(context);
                }
                zzfscVar = zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfscVar;
    }

    public final zzfry zzh(long j, boolean z) {
        synchronized (zzfsc.class) {
            try {
                if (zzo()) {
                    return zzb(null, null, j, z);
                }
                return new zzfry();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzj() {
        synchronized (zzfsc.class) {
            try {
                if (zzg(false)) {
                    zzf(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzk() {
        this.zzb.zze("paidv2_publisher_option");
    }

    public final void zzl() {
        this.zzb.zze("paidv2_user_option");
    }

    public final void zzm(boolean z) throws IOException {
        this.zzb.zzd("paidv2_user_option", Boolean.valueOf(z));
    }

    public final void zzn(boolean z) throws IOException {
        this.zzb.zzd("paidv2_publisher_option", Boolean.valueOf(z));
        if (z) {
            return;
        }
        zzj();
    }

    public final boolean zzo() {
        return this.zzb.zzf("paidv2_publisher_option", true);
    }

    public final boolean zzp() {
        return this.zzb.zzf("paidv2_user_option", true);
    }
}
