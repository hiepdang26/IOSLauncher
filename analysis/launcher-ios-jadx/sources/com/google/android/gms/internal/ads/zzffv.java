package com.google.android.gms.internal.ads;

import android.util.Base64;
import defpackage.hd2;
import defpackage.k92;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzffv {
    public zzffv() {
        try {
            zzgev.zza();
        } catch (GeneralSecurityException e) {
            k92.a("Failed to Configure Aead. ".concat(e.toString()));
            hd2.B.g.zzw(e, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgwl zzgwlVarZzt = zzgwm.zzt();
        try {
            zzgdr.zzb(zzgej.zzb(zzgeb.zza(zzgmg.zzb().zza("AES128_GCM"))), zzgdq.zzb(zzgwlVarZzt));
        } catch (IOException | GeneralSecurityException e) {
            k92.a("Failed to generate key".concat(e.toString()));
            hd2.B.g.zzw(e, "CryptoUtils.generateKey");
        }
        String strEncodeToString = Base64.encodeToString(zzgwlVarZzt.zzb().zzA(), 11);
        zzgwlVarZzt.zzc();
        return strEncodeToString;
    }

    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdsf zzdsfVar) {
        zzgej zzgejVarZzc = zzc(str);
        if (zzgejVarZzc == null) {
            return null;
        }
        try {
            byte[] bArrZza = ((zzgdo) zzgejVarZzc.zzd(zzgnp.zza(), zzgdo.class)).zza(bArr, bArr2);
            zzdsfVar.zzb().put("ds", "1");
            return new String(bArrZza, "UTF-8");
        } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e) {
            k92.a("Failed to decrypt ".concat(e.toString()));
            hd2.B.g.zzw(e, "CryptoUtils.decrypt");
            zzdsfVar.zzb().put("dsf", e.toString());
            return null;
        }
    }

    private static final zzgej zzc(String str) {
        try {
            return zzgdr.zza(zzgdp.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e) {
            k92.a("Failed to get keysethandle".concat(e.toString()));
            hd2.B.g.zzw(e, "CryptoUtils.getHandle");
            return null;
        }
    }
}
