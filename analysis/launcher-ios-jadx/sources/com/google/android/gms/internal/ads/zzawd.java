package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.os.Build;
import defpackage.n42;
import defpackage.tn;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzawd extends zzaxd {
    private static final zzaxe zzh = new zzaxe();
    private final Context zzi;

    public zzawd(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, Context context, zzarh zzarhVar) {
        super(zzavpVar, "iz9pI8M74OdFMOjBXhk6CVKK/c29GtinDT3TfbuphLdYOSnoV+Rg8WuW9whaa7rD", "AMztxBQmasdCMrU1nlH2RhtlfSPsjcYFxTHFmKvCDYM=", zzaroVar, i, 27);
        this.zzi = context;
    }

    private final String zzc() {
        try {
            if (this.zza.zzl() != null) {
                this.zza.zzl().get();
            }
            zzasj zzasjVarZzc = this.zza.zzc();
            if (zzasjVarZzc == null || !zzasjVarZzc.zzaj()) {
                return null;
            }
            return zzasjVarZzc.zzh();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        int i;
        zzata zzataVar;
        AtomicReference atomicReferenceZza = zzh.zza(this.zzi.getPackageName());
        synchronized (atomicReferenceZza) {
            try {
                zzata zzataVar2 = (zzata) atomicReferenceZza.get();
                if (zzataVar2 == null || zzavs.zzd(zzataVar2.zza) || zzataVar2.zza.equals("E") || zzataVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                    if (zzavs.zzd(null)) {
                        zzavs.zzd(null);
                        i = 3;
                    } else {
                        i = 5;
                    }
                    Boolean boolValueOf = Boolean.valueOf(i == 3);
                    zzbbn zzbbnVar = zzbbw.zzch;
                    n42 n42Var = n42.d;
                    Boolean bool = (Boolean) n42Var.c.zza(zzbbnVar);
                    String strZzb = ((Boolean) n42Var.c.zza(zzbbw.zzcg)).booleanValue() ? zzb() : null;
                    if (bool.booleanValue() && this.zza.zzp() && zzavs.zzd(strZzb)) {
                        strZzb = zzc();
                    }
                    zzata zzataVar3 = new zzata((String) this.zze.invoke(null, this.zzi, boolValueOf, strZzb));
                    if (zzavs.zzd(zzataVar3.zza) || zzataVar3.zza.equals("E")) {
                        int i2 = i - 1;
                        if (i2 == 3) {
                            String strZzc = zzc();
                            if (!zzavs.zzd(strZzc)) {
                                zzataVar3.zza = strZzc;
                            }
                        } else if (i2 == 4) {
                            throw null;
                        }
                    }
                    atomicReferenceZza.set(zzataVar3);
                }
                zzataVar = (zzata) atomicReferenceZza.get();
            } finally {
            }
        }
        synchronized (this.zzd) {
            if (zzataVar != null) {
                try {
                    this.zzd.zzx(zzataVar.zza);
                    this.zzd.zzX(zzataVar.zzb);
                    this.zzd.zzZ(zzataVar.zzc);
                    this.zzd.zzi(zzataVar.zzd);
                    this.zzd.zzw(zzataVar.zze);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.google.android.gms.internal.ads.zzaxf] */
    public final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            zzbbn zzbbnVar = zzbbw.zzci;
            n42 n42Var = n42.d;
            byte[] bArrZzf = zzavs.zzf((String) n42Var.c.zza(zzbbnVar));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzavs.zzf((String) n42Var.c.zza(zzbbw.zzcj)))));
            }
            Context context = this.zzi;
            String packageName = context.getPackageName();
            this.zza.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            final zzgdc zzgdcVarZze = zzgdc.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager.OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzaxf
                @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
                public final void onChecksumsReady(List list) {
                    zzgdc zzgdcVar = zzgdcVarZze;
                    if (list == null) {
                        zzgdcVar.zzc(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ApkChecksum apkChecksumE = tn.e(list.get(i));
                            if (apkChecksumE.getType() == 8) {
                                zzgdcVar.zzc(zzavs.zzb(apkChecksumE.getValue()));
                                return;
                            }
                        }
                        zzgdcVar.zzc(null);
                    } catch (Throwable unused) {
                        zzgdcVar.zzc(null);
                    }
                }
            });
            return (String) zzgdcVarZze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
