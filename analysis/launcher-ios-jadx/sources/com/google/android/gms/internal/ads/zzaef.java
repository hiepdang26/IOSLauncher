package com.google.android.gms.internal.ads;

import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
final class zzaef implements zzadx {
    public final zzfxr zza;
    private final int zzb;

    private zzaef(int i, zzfxr zzfxrVar) {
        this.zzb = i;
        this.zza = zzfxrVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzaef zzc(int i, zzek zzekVar) {
        zzadx zzaegVar;
        String str;
        zzfxo zzfxoVar = new zzfxo();
        int iZze = zzekVar.zze();
        int i2 = -2;
        while (zzekVar.zzb() > 8) {
            int iZzi = zzekVar.zzi();
            int iZzd = zzekVar.zzd() + zzekVar.zzi();
            zzekVar.zzJ(iZzd);
            if (iZzi != 1414744396) {
                zzaeg zzaegVar2 = null;
                switch (iZzi) {
                    case 1718776947:
                        if (i2 != 2) {
                            if (i2 == 1) {
                                int iZzk = zzekVar.zzk();
                                String str2 = iZzk != 1 ? iZzk != 85 ? iZzk != 255 ? iZzk != 8192 ? iZzk != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                                if (str2 != null) {
                                    int iZzk2 = zzekVar.zzk();
                                    int iZzi2 = zzekVar.zzi();
                                    zzekVar.zzL(6);
                                    int iZzl = zzet.zzl(zzekVar.zzq());
                                    int iZzk3 = zzekVar.zzk();
                                    byte[] bArr = new byte[iZzk3];
                                    zzekVar.zzG(bArr, 0, iZzk3);
                                    zzad zzadVar = new zzad();
                                    zzadVar.zzX(str2);
                                    zzadVar.zzy(iZzk2);
                                    zzadVar.zzY(iZzi2);
                                    if ("audio/raw".equals(str2) && iZzl != 0) {
                                        zzadVar.zzR(iZzl);
                                    }
                                    if ("audio/mp4a-latm".equals(str2) && iZzk3 > 0) {
                                        zzadVar.zzL(zzfxr.zzn(bArr));
                                    }
                                    zzaegVar = new zzaeg(zzadVar.zzad());
                                } else {
                                    k31.n(iZzk, "Ignoring track with unsupported format tag ", "StreamFormatChunk");
                                }
                            } else {
                                zzea.zzf("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzet.zzC(i2)));
                            }
                            break;
                        } else {
                            zzekVar.zzL(4);
                            int iZzi3 = zzekVar.zzi();
                            int iZzi4 = zzekVar.zzi();
                            zzekVar.zzL(4);
                            int iZzi5 = zzekVar.zzi();
                            switch (iZzi5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = "video/mp42";
                                    break;
                                case 859066445:
                                    str = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = "video/mjpeg";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str == null) {
                                k31.n(iZzi5, "Ignoring track with unsupported compression ", "StreamFormatChunk");
                            } else {
                                zzad zzadVar2 = new zzad();
                                zzadVar2.zzac(iZzi3);
                                zzadVar2.zzI(iZzi4);
                                zzadVar2.zzX(str);
                                zzaegVar2 = new zzaeg(zzadVar2.zzad());
                            }
                        }
                        zzaegVar = zzaegVar2;
                        break;
                    case 1751742049:
                        zzaegVar = zzaec.zzb(zzekVar);
                        break;
                    case 1752331379:
                        zzaegVar = zzaed.zzb(zzekVar);
                        break;
                    case 1852994675:
                        zzaegVar = zzaeh.zzb(zzekVar);
                        break;
                    default:
                        zzaegVar = zzaegVar2;
                        break;
                }
            } else {
                zzaegVar = zzc(zzekVar.zzi(), zzekVar);
            }
            if (zzaegVar != null) {
                if (zzaegVar.zza() == 1752331379) {
                    int i3 = ((zzaed) zzaegVar).zza;
                    if (i3 == 1935960438) {
                        i2 = 2;
                    } else if (i3 == 1935963489) {
                        i2 = 1;
                    } else if (i3 != 1937012852) {
                        zzea.zzf("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i3))));
                        i2 = -1;
                    } else {
                        i2 = 3;
                    }
                }
                zzfxoVar.zzf(zzaegVar);
            }
            zzekVar.zzK(iZzd);
            zzekVar.zzJ(iZze);
        }
        return new zzaef(i, zzfxoVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final int zza() {
        return this.zzb;
    }

    public final zzadx zzb(Class cls) {
        zzfxr zzfxrVar = this.zza;
        int size = zzfxrVar.size();
        int i = 0;
        while (i < size) {
            zzadx zzadxVar = (zzadx) zzfxrVar.get(i);
            i++;
            if (zzadxVar.getClass() == cls) {
                return zzadxVar;
            }
        }
        return null;
    }
}
