package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.n90;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqd {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzfpk zze;
    private boolean zzf;

    public zzfqd(Context context, int i, zzfpk zzfpkVar, boolean z) {
        this.zzf = false;
        this.zzb = context;
        this.zzd = Integer.toString(i - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzfpkVar;
        this.zzf = z;
    }

    private final File zze(String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(zzaxi zzaxiVar) {
        zzaxk zzaxkVarZze = zzaxl.zze();
        zzaxkVarZze.zze(zzaxiVar.zzd().zzk());
        zzaxkVarZze.zza(zzaxiVar.zzd().zzj());
        zzaxkVarZze.zzb(zzaxiVar.zzd().zza());
        zzaxkVarZze.zzd(zzaxiVar.zzd().zzd());
        zzaxkVarZze.zzc(zzaxiVar.zzd().zzc());
        return n90.d(((zzaxl) zzaxkVarZze.zzbr()).zzaV());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i, long j) {
        this.zze.zza(i, j);
    }

    private final void zzj(int i, long j, String str) {
        this.zze.zzb(i, j, str);
    }

    private final zzaxl zzk(int i) {
        String string = i == 1 ? this.zzc.getString(zzh(), null) : this.zzc.getString(zzg(), null);
        if (string == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            byte[] bArrD = n90.D(string);
            return zzaxl.zzi(zzgwm.zzv(bArrD, 0, bArrD.length), this.zzf ? zzgxi.zza() : zzgxi.zzb());
        } catch (zzgyn unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, jCurrentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, jCurrentTimeMillis);
            return null;
        }
    }

    public final boolean zza(zzaxi zzaxiVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                if (!zzfpx.zze(new File(zze(zzaxiVar.zzd().zzk()), "pcbc"), zzaxiVar.zze().zzA())) {
                    zzi(4020, jCurrentTimeMillis);
                    return false;
                }
                String strZzf = zzf(zzaxiVar);
                SharedPreferences.Editor editorEdit = this.zzc.edit();
                editorEdit.putString(zzh(), strZzf);
                boolean zCommit = editorEdit.commit();
                if (zCommit) {
                    zzi(5015, jCurrentTimeMillis);
                } else {
                    zzi(4021, jCurrentTimeMillis);
                }
                return zCommit;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzb(zzaxi zzaxiVar, zzfqc zzfqcVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzaxl zzaxlVarZzk = zzk(1);
                String strZzk = zzaxiVar.zzd().zzk();
                if (zzaxlVarZzk != null && zzaxlVarZzk.zzk().equals(strZzk)) {
                    zzi(4014, jCurrentTimeMillis);
                    return false;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File fileZze = zze(strZzk);
                if (fileZze.exists()) {
                    zzj(4023, jCurrentTimeMillis2, "d:" + (true != fileZze.isDirectory() ? "0" : "1") + ",f:" + (true != fileZze.isFile() ? "0" : "1"));
                    zzi(4015, jCurrentTimeMillis2);
                } else if (!fileZze.mkdirs()) {
                    zzj(4024, jCurrentTimeMillis2, "cw:".concat(true != fileZze.canWrite() ? "0" : "1"));
                    zzi(4015, jCurrentTimeMillis2);
                    return false;
                }
                File fileZze2 = zze(strZzk);
                File file = new File(fileZze2, "pcam.jar");
                File file2 = new File(fileZze2, "pcbc");
                if (!zzfpx.zze(file, zzaxiVar.zzf().zzA())) {
                    zzi(4016, jCurrentTimeMillis);
                    return false;
                }
                if (!zzfpx.zze(file2, zzaxiVar.zze().zzA())) {
                    zzi(4017, jCurrentTimeMillis);
                    return false;
                }
                if (zzfqcVar != null && !zzfqcVar.zza(file)) {
                    zzi(4018, jCurrentTimeMillis);
                    zzfpx.zzd(fileZze2);
                    return false;
                }
                String strZzf = zzf(zzaxiVar);
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                String string = this.zzc.getString(zzh(), null);
                SharedPreferences.Editor editorEdit = this.zzc.edit();
                editorEdit.putString(zzh(), strZzf);
                if (string != null) {
                    editorEdit.putString(zzg(), string);
                }
                if (!editorEdit.commit()) {
                    zzi(4019, jCurrentTimeMillis3);
                    return false;
                }
                HashSet hashSet = new HashSet();
                zzaxl zzaxlVarZzk2 = zzk(1);
                if (zzaxlVarZzk2 != null) {
                    hashSet.add(zzaxlVarZzk2.zzk());
                }
                zzaxl zzaxlVarZzk3 = zzk(2);
                if (zzaxlVarZzk3 != null) {
                    hashSet.add(zzaxlVarZzk3.zzk());
                }
                for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                    if (!hashSet.contains(file3.getName())) {
                        zzfpx.zzd(file3);
                    }
                }
                zzi(5014, jCurrentTimeMillis);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzfpv zzc(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzaxl zzaxlVarZzk = zzk(1);
                if (zzaxlVarZzk == null) {
                    zzi(4022, jCurrentTimeMillis);
                    return null;
                }
                File fileZze = zze(zzaxlVarZzk.zzk());
                File file = new File(fileZze, "pcam.jar");
                if (!file.exists()) {
                    file = new File(fileZze, "pcam");
                }
                File file2 = new File(fileZze, "pcbc");
                File file3 = new File(fileZze, "pcopt");
                zzi(5016, jCurrentTimeMillis);
                return new zzfpv(zzaxlVarZzk, file, file2, file3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzd(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzaxl zzaxlVarZzk = zzk(1);
                if (zzaxlVarZzk == null) {
                    zzi(4025, jCurrentTimeMillis);
                    return false;
                }
                File fileZze = zze(zzaxlVarZzk.zzk());
                if (!new File(fileZze, "pcam.jar").exists()) {
                    zzi(4026, jCurrentTimeMillis);
                    return false;
                }
                if (new File(fileZze, "pcbc").exists()) {
                    zzi(5019, jCurrentTimeMillis);
                    return true;
                }
                zzi(4027, jCurrentTimeMillis);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
