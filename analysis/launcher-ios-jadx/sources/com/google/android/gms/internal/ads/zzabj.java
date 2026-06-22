package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import com.google.android.gms.internal.ads.zzbbc;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzabj {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, MotionScene.Transition.TransitionOnClick.JUMP_TO_END, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * MotionScene.Transition.TransitionOnClick.JUMP_TO_END;
        }
        return 1536;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b = bArr[4];
            return zzf((b & 192) >> 6, b & 63);
        }
        int i = bArr[2] & 7;
        int i2 = ((bArr[3] & 255) | (i << 8)) + 1;
        return i2 + i2;
    }

    public static zzaf zzc(zzek zzekVar, String str, String str2, zzy zzyVar) {
        zzej zzejVar = new zzej();
        zzejVar.zzj(zzekVar);
        int i = zzc[zzejVar.zzd(2)];
        zzejVar.zzn(8);
        int i2 = zze[zzejVar.zzd(3)];
        if (zzejVar.zzd(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzejVar.zzd(5)] * zzbbc.zzq.zzf;
        zzejVar.zzf();
        zzekVar.zzK(zzejVar.zzb());
        zzad zzadVar = new zzad();
        zzadVar.zzK(str);
        zzadVar.zzX("audio/ac3");
        zzadVar.zzy(i2);
        zzadVar.zzY(i);
        zzadVar.zzE(zzyVar);
        zzadVar.zzO(str2);
        zzadVar.zzx(i3);
        zzadVar.zzS(i3);
        return zzadVar.zzad();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzaf zzd(com.google.android.gms.internal.ads.zzek r7, java.lang.String r8, java.lang.String r9, com.google.android.gms.internal.ads.zzy r10) {
        /*
            com.google.android.gms.internal.ads.zzej r0 = new com.google.android.gms.internal.ads.zzej
            r0.<init>()
            r0.zzj(r7)
            r1 = 13
            int r1 = r0.zzd(r1)
            int r1 = r1 * 1000
            r2 = 3
            r0.zzn(r2)
            r3 = 2
            int r3 = r0.zzd(r3)
            int[] r4 = com.google.android.gms.internal.ads.zzabj.zzc
            r3 = r4[r3]
            r4 = 10
            r0.zzn(r4)
            int[] r4 = com.google.android.gms.internal.ads.zzabj.zze
            int r5 = r0.zzd(r2)
            r4 = r4[r5]
            r5 = 1
            int r6 = r0.zzd(r5)
            if (r6 == 0) goto L33
            int r4 = r4 + 1
        L33:
            r0.zzn(r2)
            r2 = 4
            int r2 = r0.zzd(r2)
            r0.zzn(r5)
            if (r2 <= 0) goto L4f
            r2 = 6
            r0.zzn(r2)
            int r2 = r0.zzd(r5)
            if (r2 == 0) goto L4c
            int r4 = r4 + 2
        L4c:
            r0.zzn(r5)
        L4f:
            int r2 = r0.zza()
            r6 = 7
            if (r2 <= r6) goto L62
            r0.zzn(r6)
            int r2 = r0.zzd(r5)
            if (r2 == 0) goto L62
            java.lang.String r2 = "audio/eac3-joc"
            goto L64
        L62:
            java.lang.String r2 = "audio/eac3"
        L64:
            r0.zzf()
            int r0 = r0.zzb()
            r7.zzK(r0)
            com.google.android.gms.internal.ads.zzad r7 = new com.google.android.gms.internal.ads.zzad
            r7.<init>()
            r7.zzK(r8)
            r7.zzX(r2)
            r7.zzy(r4)
            r7.zzY(r3)
            r7.zzE(r10)
            r7.zzO(r9)
            r7.zzS(r1)
            com.google.android.gms.internal.ads.zzaf r7 = r7.zzad()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabj.zzd(com.google.android.gms.internal.ads.zzek, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzy):com.google.android.gms.internal.ads.zzaf");
    }

    public static zzabi zze(zzej zzejVar) {
        int iZzf;
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int iZzc = zzejVar.zzc();
        zzejVar.zzn(40);
        int iZzd = zzejVar.zzd(5);
        zzejVar.zzl(iZzc);
        int i10 = -1;
        if (iZzd > 10) {
            zzejVar.zzn(16);
            int iZzd2 = zzejVar.zzd(2);
            if (iZzd2 == 0) {
                i10 = 0;
            } else if (iZzd2 == 1) {
                i10 = 1;
            } else if (iZzd2 == 2) {
                i10 = 2;
            }
            zzejVar.zzn(3);
            int iZzd3 = zzejVar.zzd(11) + 1;
            int iZzd4 = zzejVar.zzd(2);
            if (iZzd4 == 3) {
                i = zzd[zzejVar.zzd(2)];
                i6 = 3;
                i7 = 6;
            } else {
                int iZzd5 = zzejVar.zzd(2);
                int i11 = zzb[iZzd5];
                i6 = iZzd5;
                i = zzc[iZzd4];
                i7 = i11;
            }
            iZzf = iZzd3 + iZzd3;
            int i12 = (iZzf * i) / (i7 * 32);
            int iZzd6 = zzejVar.zzd(3);
            boolean zZzp = zzejVar.zzp();
            i2 = zze[iZzd6] + (zZzp ? 1 : 0);
            zzejVar.zzn(10);
            if (zzejVar.zzp()) {
                zzejVar.zzn(8);
            }
            if (iZzd6 == 0) {
                zzejVar.zzn(5);
                if (zzejVar.zzp()) {
                    zzejVar.zzn(8);
                }
                i8 = 0;
                iZzd6 = 0;
            } else {
                i8 = iZzd6;
            }
            if (i10 == 1) {
                if (zzejVar.zzp()) {
                    zzejVar.zzn(16);
                }
                i9 = 1;
            } else {
                i9 = i10;
            }
            if (zzejVar.zzp()) {
                if (i8 > 2) {
                    zzejVar.zzn(2);
                }
                if ((i8 & 1) != 0 && i8 > 2) {
                    zzejVar.zzn(6);
                }
                if ((i8 & 4) != 0) {
                    zzejVar.zzn(6);
                }
                if (zZzp && zzejVar.zzp()) {
                    zzejVar.zzn(5);
                }
                if (i9 == 0) {
                    if (zzejVar.zzp()) {
                        zzejVar.zzn(6);
                    }
                    if (i8 == 0 && zzejVar.zzp()) {
                        zzejVar.zzn(6);
                    }
                    if (zzejVar.zzp()) {
                        zzejVar.zzn(6);
                    }
                    int iZzd7 = zzejVar.zzd(2);
                    if (iZzd7 == 1) {
                        zzejVar.zzn(5);
                    } else if (iZzd7 == 2) {
                        zzejVar.zzn(12);
                    } else if (iZzd7 == 3) {
                        int iZzd8 = zzejVar.zzd(5);
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(5);
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(4);
                            }
                            if (zzejVar.zzp()) {
                                if (zzejVar.zzp()) {
                                    zzejVar.zzn(4);
                                }
                                if (zzejVar.zzp()) {
                                    zzejVar.zzn(4);
                                }
                            }
                        }
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(5);
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(7);
                                if (zzejVar.zzp()) {
                                    zzejVar.zzn(8);
                                }
                            }
                        }
                        zzejVar.zzn((iZzd8 + 2) * 8);
                        zzejVar.zzf();
                    }
                    if (i8 < 2) {
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(14);
                        }
                        if (iZzd6 == 0 && zzejVar.zzp()) {
                            zzejVar.zzn(14);
                        }
                    }
                    if (!zzejVar.zzp()) {
                        i9 = 0;
                    } else if (i6 == 0) {
                        zzejVar.zzn(5);
                        i9 = 0;
                        i6 = 0;
                    } else {
                        for (int i13 = 0; i13 < i7; i13++) {
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(5);
                            }
                        }
                        i9 = 0;
                    }
                }
            }
            if (zzejVar.zzp()) {
                zzejVar.zzn(5);
                if (i8 == 2) {
                    zzejVar.zzn(4);
                    i8 = 2;
                }
                if (i8 >= 6) {
                    zzejVar.zzn(2);
                }
                if (zzejVar.zzp()) {
                    zzejVar.zzn(8);
                }
                if (i8 == 0 && zzejVar.zzp()) {
                    zzejVar.zzn(8);
                }
                if (iZzd4 < 3) {
                    zzejVar.zzm();
                }
            }
            if (i9 == 0 && i6 != 3) {
                zzejVar.zzm();
            }
            if (i9 == 2 && (i6 == 3 || zzejVar.zzp())) {
                zzejVar.zzn(6);
            }
            str = (zzejVar.zzp() && zzejVar.zzd(6) == 1 && zzejVar.zzd(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i4 = i10;
            i5 = i7 * MotionScene.Transition.TransitionOnClick.JUMP_TO_END;
            i3 = i12;
        } else {
            zzejVar.zzn(32);
            int iZzd9 = zzejVar.zzd(2);
            String str2 = iZzd9 == 3 ? null : "audio/ac3";
            int iZzd10 = zzejVar.zzd(6);
            int i14 = zzf[iZzd10 / 2] * zzbbc.zzq.zzf;
            iZzf = zzf(iZzd9, iZzd10);
            zzejVar.zzn(8);
            int iZzd11 = zzejVar.zzd(3);
            if ((iZzd11 & 1) != 0 && iZzd11 != 1) {
                zzejVar.zzn(2);
            }
            if ((iZzd11 & 4) != 0) {
                zzejVar.zzn(2);
            }
            if (iZzd11 == 2) {
                zzejVar.zzn(2);
            }
            i = iZzd9 < 3 ? zzc[iZzd9] : -1;
            i2 = zze[iZzd11] + (zzejVar.zzp() ? 1 : 0);
            str = str2;
            i3 = i14;
            i4 = -1;
            i5 = 1536;
        }
        return new zzabi(str, i4, i2, i, iZzf, i5, i3, null);
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
