package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzgwx implements zzgzw {
    private final zzgww zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgwx(zzgww zzgwwVar) {
        zzgyl.zzc(zzgwwVar, "input");
        this.zza = zzgwwVar;
        zzgwwVar.zzc = this;
    }

    private final void zzO(Object obj, zzhae zzhaeVar, zzgxi zzgxiVar) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzhaeVar.zzh(obj, this, zzgxiVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzgyn.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzP(Object obj, zzhae zzhaeVar, zzgxi zzgxiVar) throws zzgyn {
        zzgww zzgwwVar = this.zza;
        int iZzm = zzgwwVar.zzm();
        if (zzgwwVar.zza >= zzgwwVar.zzb) {
            throw new zzgyn("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzd = this.zza.zzd(iZzm);
        this.zza.zza++;
        zzhaeVar.zzh(obj, this, zzgxiVar);
        this.zza.zzy(0);
        r4.zza--;
        this.zza.zzz(iZzd);
    }

    private final void zzQ(int i) throws zzgyn {
        if (this.zza.zzc() != i) {
            throw zzgyn.zzi();
        }
    }

    private final void zzR(int i) throws zzgym {
        if ((this.zzb & 7) != i) {
            throw zzgyn.zza();
        }
    }

    private static final void zzS(int i) throws zzgyn {
        if ((i & 3) != 0) {
            throw zzgyn.zzg();
        }
    }

    private static final void zzT(int i) throws zzgyn {
        if ((i & 7) != 0) {
            throw zzgyn.zzg();
        }
    }

    public static zzgwx zzq(zzgww zzgwwVar) {
        zzgwx zzgwxVar = zzgwwVar.zzc;
        return zzgwxVar != null ? zzgwxVar : new zzgwx(zzgwwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzA(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyy) {
            zzgyy zzgyyVar = (zzgyy) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                int iZzm = this.zza.zzm();
                zzT(iZzm);
                int iZzc = this.zza.zzc() + iZzm;
                do {
                    zzgyyVar.zzg(this.zza.zzn());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            do {
                zzgyyVar.zzg(this.zza.zzn());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                int iZzm2 = this.zza.zzm();
                zzT(iZzm2);
                int iZzc2 = this.zza.zzc() + iZzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                } while (this.zza.zzc() < iZzc2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzn()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzB(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxp) {
            zzgxp zzgxpVar = (zzgxp) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzm = this.zza.zzm();
                zzS(iZzm);
                int iZzc = this.zza.zzc() + iZzm;
                do {
                    zzgxpVar.zzh(this.zza.zzb());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i != 5) {
                throw zzgyn.zza();
            }
            do {
                zzgxpVar.zzh(this.zza.zzb());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZzm2 = this.zza.zzm();
                zzS(iZzm2);
                int iZzc2 = this.zza.zzc() + iZzm2;
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                } while (this.zza.zzc() < iZzc2);
                return;
            }
            if (i2 != 5) {
                throw zzgyn.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzb()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    @Deprecated
    public final void zzC(List list, zzhae zzhaeVar, zzgxi zzgxiVar) throws zzgym {
        int iZzl;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzgyn.zza();
        }
        do {
            Object objZze = zzhaeVar.zze();
            zzO(objZze, zzhaeVar, zzgxiVar);
            zzhaeVar.zzf(objZze);
            list.add(objZze);
            if (this.zza.zzA() || this.zzd != 0) {
                return;
            } else {
                iZzl = this.zza.zzl();
            }
        } while (iZzl == i);
        this.zzd = iZzl;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzD(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar = this.zza;
                int iZzc = zzgwwVar.zzc() + zzgwwVar.zzm();
                do {
                    zzgxzVar.zzi(this.zza.zzg());
                } while (this.zza.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgxzVar.zzi(this.zza.zzg());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar2 = this.zza;
                int iZzc2 = zzgwwVar2.zzc() + zzgwwVar2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzE(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyy) {
            zzgyy zzgyyVar = (zzgyy) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar = this.zza;
                int iZzc = zzgwwVar.zzc() + zzgwwVar.zzm();
                do {
                    zzgyyVar.zzg(this.zza.zzo());
                } while (this.zza.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgyyVar.zzg(this.zza.zzo());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar2 = this.zza;
                int iZzc2 = zzgwwVar2.zzc() + zzgwwVar2.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzF(List list, zzhae zzhaeVar, zzgxi zzgxiVar) throws zzgyn {
        int iZzl;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzgyn.zza();
        }
        do {
            Object objZze = zzhaeVar.zze();
            zzP(objZze, zzhaeVar, zzgxiVar);
            zzhaeVar.zzf(objZze);
            list.add(objZze);
            if (this.zza.zzA() || this.zzd != 0) {
                return;
            } else {
                iZzl = this.zza.zzl();
            }
        } while (iZzl == i);
        this.zzd = iZzl;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzG(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzm = this.zza.zzm();
                zzS(iZzm);
                int iZzc = this.zza.zzc() + iZzm;
                do {
                    zzgxzVar.zzi(this.zza.zzj());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i != 5) {
                throw zzgyn.zza();
            }
            do {
                zzgxzVar.zzi(this.zza.zzj());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZzm2 = this.zza.zzm();
                zzS(iZzm2);
                int iZzc2 = this.zza.zzc() + iZzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzc() < iZzc2);
                return;
            }
            if (i2 != 5) {
                throw zzgyn.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzH(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyy) {
            zzgyy zzgyyVar = (zzgyy) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                int iZzm = this.zza.zzm();
                zzT(iZzm);
                int iZzc = this.zza.zzc() + iZzm;
                do {
                    zzgyyVar.zzg(this.zza.zzs());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            do {
                zzgyyVar.zzg(this.zza.zzs());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                int iZzm2 = this.zza.zzm();
                zzT(iZzm2);
                int iZzc2 = this.zza.zzc() + iZzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzs()));
                } while (this.zza.zzc() < iZzc2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzs()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzI(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar = this.zza;
                int iZzc = zzgwwVar.zzc() + zzgwwVar.zzm();
                do {
                    zzgxzVar.zzi(this.zza.zzk());
                } while (this.zza.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgxzVar.zzi(this.zza.zzk());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar2 = this.zza;
                int iZzc2 = zzgwwVar2.zzc() + zzgwwVar2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzk()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzJ(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyy) {
            zzgyy zzgyyVar = (zzgyy) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar = this.zza;
                int iZzc = zzgwwVar.zzc() + zzgwwVar.zzm();
                do {
                    zzgyyVar.zzg(this.zza.zzt());
                } while (this.zza.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgyyVar.zzg(this.zza.zzt());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar2 = this.zza;
                int iZzc2 = zzgwwVar2.zzc() + zzgwwVar2.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzt()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    public final void zzK(List list, boolean z) throws zzgym {
        int iZzl;
        int iZzl2;
        if ((this.zzb & 7) != 2) {
            throw zzgyn.zza();
        }
        if ((list instanceof zzgyv) && !z) {
            zzgyv zzgyvVar = (zzgyv) list;
            do {
                zzp();
                zzgyvVar.zzb();
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            do {
                list.add(z ? zzs() : zzr());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzL(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar = this.zza;
                int iZzc = zzgwwVar.zzc() + zzgwwVar.zzm();
                do {
                    zzgxzVar.zzi(this.zza.zzm());
                } while (this.zza.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgxzVar.zzi(this.zza.zzm());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar2 = this.zza;
                int iZzc2 = zzgwwVar2.zzc() + zzgwwVar2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                } while (this.zza.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzm()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzM(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgyy) {
            zzgyy zzgyyVar = (zzgyy) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar = this.zza;
                int iZzc = zzgwwVar.zzc() + zzgwwVar.zzm();
                do {
                    zzgyyVar.zzg(this.zza.zzu());
                } while (this.zza.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgyyVar.zzg(this.zza.zzu());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar2 = this.zza;
                int iZzc2 = zzgwwVar2.zzc() + zzgwwVar2.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final boolean zzN() throws zzgym {
        zzR(0);
        return this.zza.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final double zza() throws zzgym {
        zzR(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final float zzb() throws zzgym {
        zzR(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final int zzc() {
        int iZzl = this.zzd;
        if (iZzl != 0) {
            this.zzb = iZzl;
            this.zzd = 0;
        } else {
            iZzl = this.zza.zzl();
            this.zzb = iZzl;
        }
        return (iZzl == 0 || iZzl == this.zzc) ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : iZzl >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final int zze() throws zzgym {
        zzR(0);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final int zzf() throws zzgym {
        zzR(5);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final int zzg() throws zzgym {
        zzR(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final int zzh() throws zzgym {
        zzR(5);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final int zzi() throws zzgym {
        zzR(0);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final int zzj() throws zzgym {
        zzR(0);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final long zzk() throws zzgym {
        zzR(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final long zzl() throws zzgym {
        zzR(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final long zzm() throws zzgym {
        zzR(1);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final long zzn() throws zzgym {
        zzR(0);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final long zzo() throws zzgym {
        zzR(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final zzgwm zzp() throws zzgym {
        zzR(2);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final String zzr() throws zzgym {
        zzR(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final String zzs() throws zzgym {
        zzR(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzt(Object obj, zzhae zzhaeVar, zzgxi zzgxiVar) throws zzgym {
        zzR(3);
        zzO(obj, zzhaeVar, zzgxiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzu(Object obj, zzhae zzhaeVar, zzgxi zzgxiVar) throws zzgyn {
        zzR(2);
        zzP(obj, zzhaeVar, zzgxiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzv(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgwc) {
            zzgwc zzgwcVar = (zzgwc) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar = this.zza;
                int iZzc = zzgwwVar.zzc() + zzgwwVar.zzm();
                do {
                    zzgwcVar.zzg(this.zza.zzB());
                } while (this.zza.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgwcVar.zzg(this.zza.zzB());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar2 = this.zza;
                int iZzc2 = zzgwwVar2.zzc() + zzgwwVar2.zzm();
                do {
                    list.add(Boolean.valueOf(this.zza.zzB()));
                } while (this.zza.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzB()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzw(List list) throws zzgym {
        int iZzl;
        if ((this.zzb & 7) != 2) {
            throw zzgyn.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzA()) {
                return;
            } else {
                iZzl = this.zza.zzl();
            }
        } while (iZzl == this.zzb);
        this.zzd = iZzl;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzx(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxf) {
            zzgxf zzgxfVar = (zzgxf) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                int iZzm = this.zza.zzm();
                zzT(iZzm);
                int iZzc = this.zza.zzc() + iZzm;
                do {
                    zzgxfVar.zzh(this.zza.zza());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            do {
                zzgxfVar.zzh(this.zza.zza());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                int iZzm2 = this.zza.zzm();
                zzT(iZzm2);
                int iZzc2 = this.zza.zzc() + iZzm2;
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                } while (this.zza.zzc() < iZzc2);
                return;
            }
            do {
                list.add(Double.valueOf(this.zza.zza()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzy(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar = this.zza;
                int iZzc = zzgwwVar.zzc() + zzgwwVar.zzm();
                do {
                    zzgxzVar.zzi(this.zza.zze());
                } while (this.zza.zzc() < iZzc);
                zzQ(iZzc);
                return;
            }
            do {
                zzgxzVar.zzi(this.zza.zze());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzgyn.zza();
                }
                zzgww zzgwwVar2 = this.zza;
                int iZzc2 = zzgwwVar2.zzc() + zzgwwVar2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                } while (this.zza.zzc() < iZzc2);
                zzQ(iZzc2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zze()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzw
    public final void zzz(List list) throws zzgyn {
        int iZzl;
        int iZzl2;
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzm = this.zza.zzm();
                zzS(iZzm);
                int iZzc = this.zza.zzc() + iZzm;
                do {
                    zzgxzVar.zzi(this.zza.zzf());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i != 5) {
                throw zzgyn.zza();
            }
            do {
                zzgxzVar.zzi(this.zza.zzf());
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl2 = this.zza.zzl();
                }
            } while (iZzl2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZzm2 = this.zza.zzm();
                zzS(iZzm2);
                int iZzc2 = this.zza.zzc() + iZzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzc() < iZzc2);
                return;
            }
            if (i2 != 5) {
                throw zzgyn.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzA()) {
                    return;
                } else {
                    iZzl = this.zza.zzl();
                }
            } while (iZzl == this.zzb);
            iZzl2 = iZzl;
        }
        this.zzd = iZzl2;
    }
}
