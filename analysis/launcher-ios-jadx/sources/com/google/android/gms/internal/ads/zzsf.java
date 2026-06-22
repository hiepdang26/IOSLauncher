package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.constraintlayout.motion.widget.MotionScene;
import defpackage.k31;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
public final class zzsf {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    private final boolean zzh;

    public zzsf(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z;
        this.zze = z4;
        this.zzf = z6;
        this.zzh = zzbn.zzi(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzsf zzc(java.lang.String r11, java.lang.String r12, java.lang.String r13, android.media.MediaCodecInfo.CodecCapabilities r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19) {
        /*
            com.google.android.gms.internal.ads.zzsf r0 = new com.google.android.gms.internal.ads.zzsf
            r1 = 1
            r2 = 0
            if (r14 == 0) goto L39
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r14.isFeatureSupported(r3)
            if (r3 == 0) goto L39
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            r4 = 22
            if (r3 > r4) goto L27
            java.lang.String r3 = com.google.android.gms.internal.ads.zzet.zzd
            java.lang.String r4 = "ODROID-XU3"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L29
            java.lang.String r4 = "Nexus 10"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L27
            goto L29
        L27:
            r8 = 1
            goto L3a
        L29:
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L39
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L27
        L39:
            r8 = 0
        L3a:
            if (r14 == 0) goto L48
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            java.lang.String r3 = "tunneled-playback"
            boolean r3 = r14.isFeatureSupported(r3)
            if (r3 == 0) goto L48
            r9 = 1
            goto L49
        L48:
            r9 = 0
        L49:
            if (r19 != 0) goto L57
            if (r14 == 0) goto L62
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            java.lang.String r3 = "secure-playback"
            boolean r3 = r14.isFeatureSupported(r3)
            if (r3 == 0) goto L62
        L57:
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r10 = 1
            goto L6c
        L62:
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r10 = 0
        L6c:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzc(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.ads.zzsf");
    }

    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i3 = zzet.zza;
        return new Point((((i + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i2 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        String str2 = zzet.zze;
        StringBuilder sbO = uo.o("NoSupport [", str, "] [");
        sbO.append(this.zza);
        sbO.append(", ");
        sbO.append(this.zzb);
        sbO.append("] [");
        sbO.append(str2);
        sbO.append("]");
        zzea.zzb("MediaCodecInfo", sbO.toString());
    }

    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointZzi = zzi(videoCapabilities, i, i2);
        int i3 = pointZzi.x;
        int i4 = pointZzi.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzl(com.google.android.gms.internal.ads.zzaf r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzl(com.google.android.gms.internal.ads.zzaf, boolean):boolean");
    }

    private final boolean zzm(zzaf zzafVar) {
        return this.zzb.equals(zzafVar.zzm) || this.zzb.equals(zztc.zzc(zzafVar));
    }

    public final String toString() {
        return this.zza;
    }

    public final Point zza(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i, i2);
    }

    public final zzho zzb(zzaf zzafVar, zzaf zzafVar2) {
        zzaf zzafVar3;
        zzaf zzafVar4;
        int i = true != zzet.zzG(zzafVar.zzm, zzafVar2.zzm) ? 8 : 0;
        if (this.zzh) {
            if (zzafVar.zzu != zzafVar2.zzu) {
                i |= 1024;
            }
            if (!this.zze && (zzafVar.zzr != zzafVar2.zzr || zzafVar.zzs != zzafVar2.zzs)) {
                i |= 512;
            }
            if ((!zzo.zzg(zzafVar.zzy) || !zzo.zzg(zzafVar2.zzy)) && !zzet.zzG(zzafVar.zzy, zzafVar2.zzy)) {
                i |= 2048;
            }
            String str = this.zza;
            if (zzet.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzafVar.zzd(zzafVar2)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzho(this.zza, zzafVar, zzafVar2, true != zzafVar.zzd(zzafVar2) ? 2 : 3, 0);
            }
            zzafVar3 = zzafVar;
            zzafVar4 = zzafVar2;
        } else {
            zzafVar3 = zzafVar;
            zzafVar4 = zzafVar2;
            if (zzafVar3.zzz != zzafVar4.zzz) {
                i |= MotionScene.Transition.TransitionOnClick.JUMP_TO_START;
            }
            if (zzafVar3.zzA != zzafVar4.zzA) {
                i |= 8192;
            }
            if (zzafVar3.zzB != zzafVar4.zzB) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                Pair pairZza = zztc.zza(zzafVar3);
                Pair pairZza2 = zztc.zza(zzafVar4);
                if (pairZza != null && pairZza2 != null) {
                    int iIntValue = ((Integer) pairZza.first).intValue();
                    int iIntValue2 = ((Integer) pairZza2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new zzho(this.zza, zzafVar3, zzafVar4, 3, 0);
                    }
                }
            }
            if (!zzafVar3.zzd(zzafVar4)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzho(this.zza, zzafVar3, zzafVar4, 1, 0);
            }
        }
        return new zzho(this.zza, zzafVar3, zzafVar4, 0, i);
    }

    public final boolean zzd(zzaf zzafVar) {
        return zzm(zzafVar) && zzl(zzafVar, false);
    }

    public final boolean zze(zzaf zzafVar) {
        int i;
        if (!zzm(zzafVar) || !zzl(zzafVar, true)) {
            return false;
        }
        if (this.zzh) {
            int i2 = zzafVar.zzr;
            if (i2 <= 0 || (i = zzafVar.zzs) <= 0) {
                return true;
            }
            int i3 = zzet.zza;
            return zzg(i2, i, zzafVar.zzt);
        }
        int i4 = zzet.zza;
        int i5 = zzafVar.zzA;
        if (i5 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzj("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzj("sampleRate.aCaps");
                return false;
            }
            if (!audioCapabilities.isSampleRateSupported(i5)) {
                zzj(k31.k(i5, "sampleRate.support, "));
                return false;
            }
        }
        int i6 = zzafVar.zzz;
        if (i6 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
            if (codecCapabilities2 == null) {
                zzj("channelCount.caps");
            } else {
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    zzj("channelCount.aCaps");
                } else {
                    String str = this.zza;
                    String str2 = this.zzb;
                    int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                    if (maxInputChannelCount <= 1 && ((zzet.zza < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                        int i7 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                        zzea.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i7 + "]");
                        maxInputChannelCount = i7;
                    }
                    if (maxInputChannelCount < i6) {
                        zzj(k31.k(i6, "channelCount.support, "));
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean zzf(zzaf zzafVar) {
        if (this.zzh) {
            return this.zze;
        }
        Pair pairZza = zztc.zza(zzafVar);
        return pairZza != null && ((Integer) pairZza.first).intValue() == 42;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzg(int r8, int r9, double r10) {
        /*
            r7 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r7.zzd
            r1 = 0
            if (r0 != 0) goto Lb
            java.lang.String r8 = "sizeAndRate.caps"
            r7.zzj(r8)
            return r1
        Lb:
            android.media.MediaCodecInfo$VideoCapabilities r0 = r0.getVideoCapabilities()
            if (r0 != 0) goto L17
            java.lang.String r8 = "sizeAndRate.vCaps"
            r7.zzj(r8)
            return r1
        L17:
            int r2 = com.google.android.gms.internal.ads.zzet.zza
            r3 = 29
            r4 = 1
            java.lang.String r5 = "@"
            java.lang.String r6 = "x"
            if (r2 < r3) goto L3f
            int r2 = com.google.android.gms.internal.ads.zzsh.zza(r0, r8, r9, r10)
            r3 = 2
            if (r2 != r3) goto L2b
            goto Lb5
        L2b:
            if (r2 == r4) goto L2e
            goto L3f
        L2e:
            java.lang.String r0 = "sizeAndRate.cover, "
            java.lang.StringBuilder r8 = defpackage.uo.n(r0, r8, r6, r9, r5)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r7.zzj(r8)
            return r1
        L3f:
            boolean r2 = zzk(r0, r8, r9, r10)
            if (r2 != 0) goto Lb5
            if (r8 >= r9) goto La4
            java.lang.String r2 = r7.zza
            java.lang.String r3 = "OMX.MTK.VIDEO.DECODER.HEVC"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L5b
            java.lang.String r2 = "mcv5a"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzet.zzb
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto La4
        L5b:
            boolean r0 = zzk(r0, r9, r8, r10)
            if (r0 != 0) goto L62
            goto La4
        L62:
            java.lang.String r0 = "sizeAndRate.rotated, "
            java.lang.StringBuilder r8 = defpackage.uo.n(r0, r8, r6, r9, r5)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = r7.zza
            java.lang.String r10 = r7.zzb
            java.lang.String r11 = com.google.android.gms.internal.ads.zzet.zze
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "AssumedSupport ["
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = "] ["
            r0.append(r8)
            r0.append(r9)
            java.lang.String r9 = ", "
            r0.append(r9)
            r0.append(r10)
            r0.append(r8)
            r0.append(r11)
            java.lang.String r8 = "]"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.String r9 = "MediaCodecInfo"
            com.google.android.gms.internal.ads.zzea.zzb(r9, r8)
            goto Lb5
        La4:
            java.lang.String r0 = "sizeAndRate.support, "
            java.lang.StringBuilder r8 = defpackage.uo.n(r0, r8, r6, r9, r5)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r7.zzj(r8)
            return r1
        Lb5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzg(int, int, double):boolean");
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzh() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }
}
