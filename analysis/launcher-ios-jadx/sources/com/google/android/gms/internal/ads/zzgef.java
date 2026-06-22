package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzgef {
    private final List zza = new ArrayList();
    private final zzgln zzb = zzgln.zza;
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzged) it.next()).zza = false;
        }
    }

    public final zzgef zza(zzged zzgedVar) {
        if (zzgedVar.zzf != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzgedVar.zza) {
            zzd();
        }
        zzgedVar.zzf = this;
        this.zza.add(zzgedVar);
        return this;
    }

    public final zzgej zzb() throws GeneralSecurityException {
        int i;
        int i2;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        char c = 1;
        this.zzc = true;
        List list = this.zza;
        zzgte zzgteVarZzd = zzgth.zzd();
        ArrayList arrayList = new ArrayList(list.size());
        List list2 = this.zza;
        char c2 = 0;
        int i3 = 0;
        while (i3 < list2.size() - 1) {
            int i4 = i3 + 1;
            if (((zzged) list2.get(i3)).zze == zzgee.zza && ((zzged) list2.get(i4)).zze != zzgee.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i3 = i4;
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzged zzgedVar : this.zza) {
            zzgea unused = zzgedVar.zzb;
            if (zzgedVar.zze == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            if (zzgedVar.zze == zzgee.zza) {
                int i5 = 0;
                while (true) {
                    if (i5 != 0 && !hashSet.contains(Integer.valueOf(i5))) {
                        break;
                    }
                    SecureRandom secureRandom = new SecureRandom();
                    byte[] bArr = new byte[4];
                    int i6 = 0;
                    while (i6 == 0) {
                        secureRandom.nextBytes(bArr);
                        i6 = ((bArr[2] & 255) << 8) | ((bArr[c2] & 255) << 24) | ((bArr[c] & 255) << 16) | (bArr[3] & 255);
                        c2 = 0;
                    }
                    i5 = i6;
                }
                i = i5;
            } else {
                zzgee unused2 = zzgedVar.zze;
                i = 0;
            }
            Integer numValueOf = Integer.valueOf(i);
            if (hashSet.contains(numValueOf)) {
                throw new GeneralSecurityException(uo.d(i, "Id ", " is used twice in the keyset"));
            }
            hashSet.add(numValueOf);
            zzged.zza(zzgedVar);
            zzgdy zzgdyVarZza = zzgma.zzb().zza(zzgedVar.zzd, c != zzgedVar.zzd.zza() ? null : numValueOf);
            zzgeh zzgehVar = new zzgeh(zzgdyVarZza, zzgedVar.zzb, i, zzgedVar.zza, null);
            int i7 = i;
            zzgea zzgeaVar = zzgedVar.zzb;
            zzgnl zzgnlVar = (zzgnl) zzgmk.zzc().zzd(zzgdyVarZza, zzgnl.class, zzger.zza());
            Integer numZzf = zzgnlVar.zzf();
            if (numZzf != null && numZzf.intValue() != i7) {
                throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
            }
            zzgea zzgeaVar2 = zzgea.zza;
            if (zzgeaVar2.equals(zzgeaVar)) {
                i2 = 3;
            } else if (zzgea.zzb.equals(zzgeaVar)) {
                i2 = 4;
            } else {
                if (!zzgea.zzc.equals(zzgeaVar)) {
                    throw new IllegalStateException("Unknown key status");
                }
                i2 = 5;
            }
            zzgtf zzgtfVarZzd = zzgtg.zzd();
            zzgst zzgstVarZza = zzgsv.zza();
            zzgstVarZza.zzb(zzgnlVar.zzg());
            zzgstVarZza.zzc(zzgnlVar.zze());
            zzgstVarZza.zza(zzgnlVar.zzb());
            zzgtfVarZzd.zza(zzgstVarZza);
            zzgtfVarZzd.zzd(i2);
            zzgtfVarZzd.zzb(i7);
            zzgtfVarZzd.zzc(zzgnlVar.zzc());
            zzgteVarZzd.zza((zzgtg) zzgtfVarZzd.zzbr());
            if (zzgedVar.zza) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzgedVar.zzb != zzgeaVar2) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = numValueOf;
            }
            arrayList.add(zzgehVar);
            c = 1;
            c2 = 0;
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzgteVarZzd.zzb(num.intValue());
        zzgth zzgthVar = (zzgth) zzgteVarZzd.zzbr();
        zzgej.zzh(zzgthVar);
        return new zzgej(zzgthVar, arrayList, this.zzb, null);
    }
}
