package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzghz {
    private zzgib zza;
    private String zzb;
    private zzgia zzc;
    private zzgex zzd;

    private zzghz() {
        throw null;
    }

    public final zzghz zza(zzgex zzgexVar) {
        this.zzd = zzgexVar;
        return this;
    }

    public final zzghz zzb(zzgia zzgiaVar) {
        this.zzc = zzgiaVar;
        return this;
    }

    public final zzghz zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzghz zzd(zzgib zzgibVar) {
        this.zza = zzgibVar;
        return this;
    }

    public final zzgid zze() throws GeneralSecurityException {
        if (this.zza == null) {
            this.zza = zzgib.zzb;
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("kekUri must be set");
        }
        zzgia zzgiaVar = this.zzc;
        if (zzgiaVar == null) {
            throw new GeneralSecurityException("dekParsingStrategy must be set");
        }
        zzgex zzgexVar = this.zzd;
        if (zzgexVar == null) {
            throw new GeneralSecurityException("dekParametersForNewKeys must be set");
        }
        if (zzgexVar.zza()) {
            throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
        }
        if ((zzgiaVar.equals(zzgia.zza) && (zzgexVar instanceof zzggo)) || ((zzgiaVar.equals(zzgia.zzc) && (zzgexVar instanceof zzghh)) || ((zzgiaVar.equals(zzgia.zzb) && (zzgexVar instanceof zzgiw)) || ((zzgiaVar.equals(zzgia.zzd) && (zzgexVar instanceof zzgfp)) || ((zzgiaVar.equals(zzgia.zze) && (zzgexVar instanceof zzggb)) || (zzgiaVar.equals(zzgia.zzf) && (zzgexVar instanceof zzghb))))))) {
            return new zzgid(this.zza, this.zzb, this.zzc, this.zzd, null);
        }
        throw new GeneralSecurityException("Cannot use parsing strategy " + this.zzc.toString() + " when new keys are picked according to " + String.valueOf(this.zzd) + ".");
    }

    public /* synthetic */ zzghz(zzghy zzghyVar) {
    }
}
