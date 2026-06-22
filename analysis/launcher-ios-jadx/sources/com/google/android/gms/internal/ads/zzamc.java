package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzamc implements zzanr {
    private final List zza;

    public zzamc(int i, List list) {
        this.zza = list;
    }

    private final zzani zzb(zzanq zzanqVar) {
        return new zzani(zzd(zzanqVar));
    }

    private final zzanv zzc(zzanq zzanqVar) {
        return new zzanv(zzd(zzanqVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4 */
    private final List zzd(zzanq zzanqVar) {
        String str;
        int i;
        zzek zzekVar = new zzek(zzanqVar.zze);
        ArrayList arrayList = this.zza;
        while (zzekVar.zzb() > 0) {
            int iZzm = zzekVar.zzm();
            int iZzd = zzekVar.zzd() + zzekVar.zzm();
            if (iZzm == 134) {
                arrayList = new ArrayList();
                int iZzm2 = zzekVar.zzm() & 31;
                for (int i2 = 0; i2 < iZzm2; i2++) {
                    String strZzA = zzekVar.zzA(3, zzfuj.zzc);
                    int iZzm3 = zzekVar.zzm();
                    boolean z = (iZzm3 & 128) != 0;
                    if (z) {
                        i = iZzm3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bZzm = (byte) zzekVar.zzm();
                    zzekVar.zzL(1);
                    List listSingletonList = z ? Collections.singletonList((bZzm & 64) != 0 ? new byte[]{1} : new byte[]{0}) : null;
                    zzad zzadVar = new zzad();
                    zzadVar.zzX(str);
                    zzadVar.zzO(strZzA);
                    zzadVar.zzw(i);
                    zzadVar.zzL(listSingletonList);
                    arrayList.add(zzadVar.zzad());
                }
            }
            zzekVar.zzK(iZzd);
            arrayList = arrayList;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzanr
    public final zzant zza(int i, zzanq zzanqVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzamz(new zzamr(zzanqVar.zzb, zzanqVar.zza()));
            }
            if (i == 21) {
                return new zzamz(new zzamp());
            }
            if (i == 27) {
                return new zzamz(new zzamm(zzb(zzanqVar), false, false));
            }
            if (i == 36) {
                return new zzamz(new zzamo(zzb(zzanqVar)));
            }
            if (i == 45) {
                return new zzamz(new zzams());
            }
            if (i == 89) {
                return new zzamz(new zzame(zzanqVar.zzd));
            }
            if (i == 172) {
                return new zzamz(new zzalz(zzanqVar.zzb, zzanqVar.zza()));
            }
            if (i == 257) {
                return new zzanh(new zzamy("application/vnd.dvb.ait"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzamz(new zzamd(zzanqVar.zzb, zzanqVar.zza(), 5408));
                        }
                        switch (i) {
                            case 15:
                                return new zzamz(new zzamb(false, zzanqVar.zzb, zzanqVar.zza()));
                            case 16:
                                return new zzamz(new zzamk(zzc(zzanqVar)));
                            case 17:
                                return new zzamz(new zzamq(zzanqVar.zzb, zzanqVar.zza()));
                            default:
                                switch (i) {
                                    case 134:
                                        return new zzanh(new zzamy("application/x-scte35"));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new zzamz(new zzamd(zzanqVar.zzb, zzanqVar.zza(), MotionScene.Transition.TransitionOnClick.JUMP_TO_START));
                }
                return new zzamz(new zzalx(zzanqVar.zzb, zzanqVar.zza()));
            }
        }
        return new zzamz(new zzamh(zzc(zzanqVar)));
    }

    public zzamc() {
        this(0);
    }

    public zzamc(int i) {
        this.zza = zzfxr.zzm();
    }
}
