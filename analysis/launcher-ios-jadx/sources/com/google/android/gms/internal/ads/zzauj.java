package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes.dex */
public final class zzauj {
    protected volatile Boolean zzb;
    private final zzavp zze;
    private static final ConditionVariable zzc = new ConditionVariable();
    protected static volatile zzfqj zza = null;
    private static volatile Random zzd = null;

    public zzauj(zzavp zzavpVar) {
        this.zze = zzavpVar;
        zzavpVar.zzk().execute(new zzaui(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zzd == null) {
                synchronized (zzauj.class) {
                    try {
                        if (zzd == null) {
                            zzd = new Random();
                        }
                    } finally {
                    }
                }
            }
            return zzd.nextInt();
        }
    }

    public final void zzc(int i, int i2, long j, String str, Exception exc) {
        try {
            zzc.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzara zzaraVarZza = zzare.zza();
            zzaraVarZza.zza(this.zze.zza.getPackageName());
            zzaraVarZza.zze(j);
            if (str != null) {
                zzaraVarZza.zzb(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzaraVarZza.zzf(stringWriter.toString());
                zzaraVarZza.zzd(exc.getClass().getName());
            }
            zzfqi zzfqiVarZza = zza.zza(((zzare) zzaraVarZza.zzbr()).zzaV());
            zzfqiVarZza.zza(i);
            if (i2 != -1) {
                zzfqiVarZza.zzb(i2);
            }
            zzfqiVarZza.zzc();
        } catch (Exception unused) {
        }
    }
}
