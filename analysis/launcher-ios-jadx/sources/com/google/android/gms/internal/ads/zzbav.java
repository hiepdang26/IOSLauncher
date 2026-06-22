package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzbav {
    private final zzbbb zza;
    private final zzbbc.zzt.zza zzb;
    private final boolean zzc;

    private zzbav() {
        this.zzb = zzbbc.zzt.zzj();
        this.zzc = false;
        this.zza = new zzbbb();
    }

    public static zzbav zza() {
        return new zzbav();
    }

    private final synchronized String zzd(int i) {
        StringBuilder sb;
        String strZzah = this.zzb.zzah();
        hd2.B.j.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strEncodeToString = Base64.encodeToString(this.zzb.zzbr().zzaV(), 3);
        sb = new StringBuilder("id=");
        sb.append(strZzah);
        sb.append(",timestamp=");
        sb.append(jElapsedRealtime);
        sb.append(",event=");
        sb.append(i - 1);
        sb.append(",data=");
        sb.append(strEncodeToString);
        sb.append("\n");
        return sb.toString();
    }

    private final synchronized void zze(int i) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(zzfqu.zza(zzfqt.zza(), externalStorageDirectory, "clearcut_events.txt")), true);
            try {
                try {
                    fileOutputStream.write(zzd(i).getBytes());
                } catch (IOException unused) {
                    k92.a("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        k92.a("Could not close Clearcut output stream.");
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    k92.a("Could not close Clearcut output stream.");
                }
            }
        } catch (FileNotFoundException unused4) {
            k92.a("Could not find file for Clearcut");
        }
    }

    private final synchronized void zzf(int i) {
        zzbbc.zzt.zza zzaVar = this.zzb;
        zzaVar.zzq();
        zzaVar.zzj(cd2.x());
        zzbba zzbbaVar = new zzbba(this.zza, this.zzb.zzbr().zzaV(), null);
        int i2 = i - 1;
        zzbbaVar.zza(i2);
        zzbbaVar.zzc();
        k92.a("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i2, 10))));
    }

    public final synchronized void zzb(zzbau zzbauVar) {
        if (this.zzc) {
            try {
                zzbauVar.zza(this.zzb);
            } catch (NullPointerException e) {
                hd2.B.g.zzw(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i) {
        if (this.zzc) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzeu)).booleanValue()) {
                zze(i);
            } else {
                zzf(i);
            }
        }
    }

    public zzbav(zzbbb zzbbbVar) {
        this.zzb = zzbbc.zzt.zzj();
        this.zza = zzbbbVar;
        this.zzc = ((Boolean) n42.d.c.zza(zzbbw.zzet)).booleanValue();
    }
}
