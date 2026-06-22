package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.Settings;
import android.util.SparseArray;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzof {
    static final zzfxu zzb;
    private final SparseArray zzd;
    private final int zze;
    public static final zzof zza = new zzof(zzfxr.zzn(zzod.zza));
    private static final zzfxr zzc = zzfxr.zzp(2, 5, 6);

    static {
        zzfxt zzfxtVar = new zzfxt();
        zzfxtVar.zza(5, 6);
        zzfxtVar.zza(17, 6);
        zzfxtVar.zza(7, 6);
        zzfxtVar.zza(30, 10);
        zzfxtVar.zza(18, 6);
        zzfxtVar.zza(6, 8);
        zzfxtVar.zza(8, 8);
        zzfxtVar.zza(14, 8);
        zzb = zzfxtVar.zzc();
    }

    public static Uri zza() {
        if (zzf()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public static zzof zzc(Context context, zzh zzhVar, zzon zzonVar) {
        return zzd(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzhVar, zzonVar);
    }

    public static zzof zzd(Context context, Intent intent, zzh zzhVar, zzon zzonVar) {
        Object systemService = context.getSystemService("audio");
        systemService.getClass();
        AudioManager audioManager = (AudioManager) systemService;
        if (zzonVar == null) {
            zzonVar = zzet.zza >= 33 ? zzoc.zzb(audioManager, zzhVar) : null;
        }
        int i = zzet.zza;
        if (i >= 33 && (zzet.zzN(context) || zzet.zzJ(context))) {
            return zzoc.zza(audioManager, zzhVar);
        }
        if (i >= 23 && zzoa.zza(audioManager, zzonVar)) {
            return zza;
        }
        zzfxv zzfxvVar = new zzfxv();
        zzfxvVar.zzf((Object) 2);
        if (i >= 29 && (zzet.zzN(context) || zzet.zzJ(context))) {
            zzfxvVar.zzh(zzob.zzb(zzhVar));
            return new zzof(zze(zzgap.zzh(zzfxvVar.zzi()), 10));
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z || zzf()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            zzfxvVar.zzh(zzc);
        }
        if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new zzof(zze(zzgap.zzh(zzfxvVar.zzi()), 10));
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            zzfxvVar.zzh(zzgap.zzg(intArrayExtra));
        }
        return new zzof(zze(zzgap.zzh(zzfxvVar.zzi()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
    }

    private static zzfxr zze(int[] iArr, int i) {
        zzfxo zzfxoVar = new zzfxo();
        for (int i2 : iArr) {
            zzfxoVar.zzf(new zzod(i2, i));
        }
        return zzfxoVar.zzi();
    }

    private static boolean zzf() {
        String str = zzet.zzc;
        return "Amazon".equals(str) || "Xiaomi".equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            if (r7 != r8) goto L3
            goto L44
        L3:
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzof
            r1 = 0
            if (r0 != 0) goto L9
            goto L46
        L9:
            com.google.android.gms.internal.ads.zzof r8 = (com.google.android.gms.internal.ads.zzof) r8
            android.util.SparseArray r0 = r7.zzd
            android.util.SparseArray r2 = r8.zzd
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            r4 = 31
            if (r3 < r4) goto L1c
            boolean r0 = defpackage.ic2.w(r0, r2)
            if (r0 == 0) goto L46
            goto L3e
        L1c:
            int r3 = r0.size()
            int r4 = r2.size()
            if (r3 != r4) goto L46
            r4 = 0
        L27:
            if (r4 >= r3) goto L3e
            int r5 = r0.keyAt(r4)
            java.lang.Object r6 = r0.valueAt(r4)
            java.lang.Object r5 = r2.get(r5)
            boolean r5 = java.util.Objects.equals(r6, r5)
            if (r5 == 0) goto L46
            int r4 = r4 + 1
            goto L27
        L3e:
            int r0 = r7.zze
            int r8 = r8.zze
            if (r0 != r8) goto L46
        L44:
            r8 = 1
            return r8
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzof.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iContentHashCode;
        int i = zzet.zza;
        SparseArray sparseArray = this.zzd;
        if (i >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iHashCode = 17;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                iHashCode = Objects.hashCode(sparseArray.valueAt(i2)) + ((sparseArray.keyAt(i2) + (iHashCode * 31)) * 31);
            }
            iContentHashCode = iHashCode;
        }
        return (iContentHashCode * 31) + this.zze;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.zze + ", audioProfiles=" + this.zzd.toString() + "]";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c A[PHI: r0
  0x003c: PHI (r0v3 int) = (r0v2 int), (r0v7 int) binds: [B:11:0x002d, B:14:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair zzb(com.google.android.gms.internal.ads.zzaf r9, com.google.android.gms.internal.ads.zzh r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.zzm
            r0.getClass()
            java.lang.String r1 = r9.zzj
            int r0 = com.google.android.gms.internal.ads.zzbn.zza(r0, r1)
            com.google.android.gms.internal.ads.zzfxu r1 = com.google.android.gms.internal.ads.zzof.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L19
            goto Lc5
        L19:
            r1 = 7
            r2 = 8
            r3 = 6
            r4 = 18
            if (r0 != r4) goto L2d
            android.util.SparseArray r0 = r8.zzd
            boolean r0 = com.google.android.gms.internal.ads.zzet.zzH(r0, r4)
            if (r0 != 0) goto L2b
            r0 = 6
            goto L49
        L2b:
            r0 = 18
        L2d:
            if (r0 != r2) goto L3c
            android.util.SparseArray r0 = r8.zzd
            boolean r0 = com.google.android.gms.internal.ads.zzet.zzH(r0, r2)
            if (r0 == 0) goto L3a
            r0 = 8
            goto L3c
        L3a:
            r0 = 7
            goto L49
        L3c:
            r5 = 30
            if (r0 != r5) goto L49
            android.util.SparseArray r6 = r8.zzd
            boolean r5 = com.google.android.gms.internal.ads.zzet.zzH(r6, r5)
            if (r5 != 0) goto L49
            goto L3a
        L49:
            android.util.SparseArray r5 = r8.zzd
            boolean r5 = com.google.android.gms.internal.ads.zzet.zzH(r5, r0)
            if (r5 == 0) goto Lc5
            android.util.SparseArray r5 = r8.zzd
            java.lang.Object r5 = r5.get(r0)
            com.google.android.gms.internal.ads.zzod r5 = (com.google.android.gms.internal.ads.zzod) r5
            r5.getClass()
            int r6 = r9.zzz
            r7 = -1
            if (r6 == r7) goto L80
            if (r0 != r4) goto L64
            goto L80
        L64:
            java.lang.String r9 = r9.zzm
            java.lang.String r10 = "audio/vnd.dts.uhd;profile=p2"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L79
            int r9 = com.google.android.gms.internal.ads.zzet.zza
            r10 = 33
            if (r9 >= r10) goto L79
            r9 = 10
            if (r6 <= r9) goto L8b
            goto Lc5
        L79:
            boolean r9 = r5.zzb(r6)
            if (r9 != 0) goto L8b
            goto Lc5
        L80:
            int r9 = r9.zzA
            if (r9 != r7) goto L87
            r9 = 48000(0xbb80, float:6.7262E-41)
        L87:
            int r6 = r5.zza(r9, r10)
        L8b:
            int r9 = com.google.android.gms.internal.ads.zzet.zza
            r10 = 28
            if (r9 > r10) goto L9f
            if (r6 != r1) goto L94
            goto La0
        L94:
            r10 = 3
            if (r6 == r10) goto L9d
            r10 = 4
            if (r6 == r10) goto L9d
            r10 = 5
            if (r6 != r10) goto L9f
        L9d:
            r2 = 6
            goto La0
        L9f:
            r2 = r6
        La0:
            r10 = 26
            if (r9 > r10) goto Lb2
            java.lang.String r9 = "fugu"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzet.zzb
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto Lb2
            r9 = 1
            if (r2 != r9) goto Lb2
            r2 = 2
        Lb2:
            int r9 = com.google.android.gms.internal.ads.zzet.zzh(r2)
            if (r9 == 0) goto Lc5
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            android.util.Pair r9 = android.util.Pair.create(r10, r9)
            return r9
        Lc5:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzof.zzb(com.google.android.gms.internal.ads.zzaf, com.google.android.gms.internal.ads.zzh):android.util.Pair");
    }

    private zzof(List list) {
        this.zzd = new SparseArray();
        for (int i = 0; i < list.size(); i++) {
            zzod zzodVar = (zzod) list.get(i);
            this.zzd.put(zzodVar.zzb, zzodVar);
        }
        int iMax = 0;
        for (int i2 = 0; i2 < this.zzd.size(); i2++) {
            iMax = Math.max(iMax, ((zzod) this.zzd.valueAt(i2)).zzc);
        }
        this.zze = iMax;
    }
}
