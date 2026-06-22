package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqf {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfqg zzc;
    private final zzfoh zzd;
    private final zzfoc zze;
    private zzfpu zzf;
    private final Object zzg = new Object();

    public zzfqf(Context context, zzfqg zzfqgVar, zzfoh zzfohVar, zzfoc zzfocVar) {
        this.zzb = context;
        this.zzc = zzfqgVar;
        this.zzd = zzfohVar;
        this.zze = zzfocVar;
    }

    private final synchronized Class zzd(zzfpv zzfpvVar) {
        try {
            String strZzk = zzfpvVar.zza().zzk();
            HashMap map = zza;
            Class cls = (Class) map.get(strZzk);
            if (cls != null) {
                return cls;
            }
            try {
                if (!this.zze.zza(zzfpvVar.zzc())) {
                    throw new zzfqe(2026, "VM did not pass signature verification");
                }
                try {
                    File fileZzb = zzfpvVar.zzb();
                    if (!fileZzb.exists()) {
                        fileZzb.mkdirs();
                    }
                    Class<?> clsLoadClass = new DexClassLoader(zzfpvVar.zzc().getAbsolutePath(), fileZzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    map.put(strZzk, clsLoadClass);
                    return clsLoadClass;
                } catch (ClassNotFoundException e) {
                    e = e;
                    throw new zzfqe(2008, e);
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    throw new zzfqe(2008, e);
                } catch (SecurityException e3) {
                    e = e3;
                    throw new zzfqe(2008, e);
                }
            } catch (GeneralSecurityException e4) {
                throw new zzfqe(2026, e4);
            }
        } finally {
        }
    }

    public final zzfok zza() {
        zzfpu zzfpuVar;
        synchronized (this.zzg) {
            zzfpuVar = this.zzf;
        }
        return zzfpuVar;
    }

    public final zzfpv zzb() {
        synchronized (this.zzg) {
            try {
                zzfpu zzfpuVar = this.zzf;
                if (zzfpuVar == null) {
                    return null;
                }
                return zzfpuVar.zzf();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc(zzfpv zzfpvVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfpu zzfpuVar = new zzfpu(zzd(zzfpvVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzfpvVar.zze(), null, new Bundle(), 2), zzfpvVar, this.zzc, this.zzd);
                if (!zzfpuVar.zzh()) {
                    throw new zzfqe(4000, "init failed");
                }
                int iZze = zzfpuVar.zze();
                if (iZze != 0) {
                    throw new zzfqe(4001, "ci: " + iZze);
                }
                synchronized (this.zzg) {
                    zzfpu zzfpuVar2 = this.zzf;
                    if (zzfpuVar2 != null) {
                        try {
                            zzfpuVar2.zzg();
                        } catch (zzfqe e) {
                            this.zzd.zzc(e.zza(), -1L, e);
                        }
                        this.zzf = zzfpuVar;
                    } else {
                        this.zzf = zzfpuVar;
                    }
                }
                this.zzd.zzd(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e2) {
                throw new zzfqe(2004, e2);
            }
        } catch (zzfqe e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - jCurrentTimeMillis, e4);
            return false;
        }
    }
}
