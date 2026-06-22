package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.hd2;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzbve {
    private int zzA;
    private final String zzB;
    private boolean zzC;
    private int zza;
    private boolean zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;
    private double zzm;
    private boolean zzn;
    private String zzo;
    private String zzp;
    private final boolean zzq;
    private final boolean zzr;
    private final String zzs;
    private final boolean zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final String zzw;
    private final String zzx;
    private float zzy;
    private int zzz;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbve(android.content.Context r7) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbve.<init>(android.content.Context):void");
    }

    private static ResolveInfo zzb(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
        } catch (Throwable th) {
            hd2.B.g.zzw(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private final void zzc(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zza = audioManager.getMode();
                this.zzb = audioManager.isMusicActive();
                this.zzc = audioManager.isSpeakerphoneOn();
                this.zzd = audioManager.getStreamVolume(3);
                this.zze = audioManager.getRingerMode();
                this.zzf = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                hd2.B.g.zzw(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zza = -2;
        this.zzb = false;
        this.zzc = false;
        this.zzd = 0;
        this.zze = 2;
        this.zzf = 0;
    }

    private final void zzd(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent intentRegisterReceiver = (!((Boolean) n42.d.c.zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) ? context.registerReceiver(null, intentFilter) : context.registerReceiver(null, intentFilter, 4);
        if (intentRegisterReceiver == null) {
            this.zzm = -1.0d;
            this.zzn = false;
        } else {
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            this.zzm = intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1);
            this.zzn = intExtra == 2 || intExtra == 5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zze(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r6.getSystemService(r1)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            java.lang.String r2 = r0.getNetworkOperator()
            r5.zzg = r2
            boolean r2 = defpackage.os.k()
            r3 = 0
            if (r2 == 0) goto L31
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzhL
            n42 r4 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r4 = r4.c
            java.lang.Object r2 = r4.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L31
            r2 = 0
            goto L35
        L31:
            int r2 = r0.getNetworkType()
        L35:
            r5.zzi = r2
            int r0 = r0.getPhoneType()
            r5.zzj = r0
            r0 = -2
            r5.zzh = r0
            r5.zzk = r3
            r0 = -1
            r5.zzl = r0
            hd2 r2 = defpackage.hd2.B
            cd2 r2 = r2.c
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = defpackage.cd2.a(r6, r2)
            if (r6 == 0) goto L70
            android.net.NetworkInfo r6 = r1.getActiveNetworkInfo()
            if (r6 == 0) goto L68
            int r0 = r6.getType()
            r5.zzh = r0
            android.net.NetworkInfo$DetailedState r6 = r6.getDetailedState()
            int r6 = r6.ordinal()
            r5.zzl = r6
            goto L6a
        L68:
            r5.zzh = r0
        L6a:
            boolean r6 = r1.isActiveNetworkMetered()
            r5.zzk = r6
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbve.zze(android.content.Context):void");
    }

    public final zzbvf zza() {
        return new zzbvf(this.zza, this.zzq, this.zzr, this.zzg, this.zzs, this.zzt, this.zzu, this.zzv, this.zzb, this.zzc, this.zzw, this.zzx, this.zzB, this.zzd, this.zzh, this.zzi, this.zzj, this.zze, this.zzf, this.zzy, this.zzz, this.zzA, this.zzm, this.zzn, this.zzk, this.zzl, this.zzo, this.zzC, this.zzp);
    }

    public zzbve(Context context, zzbvf zzbvfVar) {
        zzbbw.zza(context);
        zzc(context);
        zze(context);
        zzd(context);
        this.zzo = Build.FINGERPRINT;
        this.zzp = Build.DEVICE;
        this.zzC = zzbct.zzg(context);
        this.zzq = zzbvfVar.zza;
        this.zzr = zzbvfVar.zzb;
        this.zzs = zzbvfVar.zzc;
        this.zzt = zzbvfVar.zzd;
        this.zzu = zzbvfVar.zze;
        this.zzv = zzbvfVar.zzf;
        this.zzw = zzbvfVar.zzg;
        this.zzx = zzbvfVar.zzh;
        this.zzB = zzbvfVar.zzi;
        this.zzy = zzbvfVar.zzl;
        this.zzz = zzbvfVar.zzm;
        this.zzA = zzbvfVar.zzn;
    }
}
