package com.google.android.gms.internal.ads;

import androidx.profileinstaller.ProfileVerifier;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzahp implements zzack {
    private final zzek zza;
    private final zzadc zzb;
    private final zzacy zzc;
    private final zzada zzd;
    private final zzadp zze;
    private zzacn zzf;
    private zzadp zzg;
    private zzadp zzh;
    private int zzi;
    private zzbk zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private int zzn;
    private zzahr zzo;
    private boolean zzp;

    public zzahp() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x025c  */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45, types: [com.google.android.gms.internal.ads.zzadi] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [com.google.android.gms.internal.ads.zzadi, com.google.android.gms.internal.ads.zzahr] */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r5v34, types: [com.google.android.gms.internal.ads.zzacn] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzg(com.google.android.gms.internal.ads.zzacl r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahp.zzg(com.google.android.gms.internal.ads.zzacl):int");
    }

    private final long zzh(long j) {
        zzadc zzadcVar = this.zzb;
        return ((j * 1000000) / ((long) zzadcVar.zzd)) + this.zzk;
    }

    private static boolean zzk(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private final boolean zzl(zzacl zzaclVar) {
        zzahr zzahrVar = this.zzo;
        if (zzahrVar != null) {
            long jZzd = zzahrVar.zzd();
            if (jZzd != -1 && zzaclVar.zze() > jZzd - 4) {
                return true;
            }
        }
        try {
            return !zzaclVar.zzm(this.zza.zzM(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzm(zzacl zzaclVar, boolean z) throws zzbo, EOFException, InterruptedIOException {
        int i;
        int iZze;
        int iZzb;
        zzaclVar.zzj();
        if (zzaclVar.zzf() == 0) {
            zzbk zzbkVarZza = this.zzd.zza(zzaclVar, null);
            this.zzj = zzbkVarZza;
            if (zzbkVarZza != null) {
                this.zzc.zzb(zzbkVarZza);
            }
            iZze = (int) zzaclVar.zze();
            if (!z) {
                ((zzaby) zzaclVar).zzo(iZze, false);
            }
            i = 0;
        } else {
            i = 0;
            iZze = 0;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (!zzl(zzaclVar)) {
                this.zza.zzK(0);
                int iZzg = this.zza.zzg();
                if ((i == 0 || zzk(iZzg, i)) && (iZzb = zzadd.zzb(iZzg)) != -1) {
                    i2++;
                    if (i2 != 1) {
                        if (i2 == 4) {
                            break;
                        }
                    } else {
                        this.zzb.zza(iZzg);
                        i = iZzg;
                    }
                    ((zzaby) zzaclVar).zzl(iZzb - 4, false);
                } else {
                    int i4 = i3 + 1;
                    if (i3 == (true != z ? ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ : 32768)) {
                        if (z) {
                            return false;
                        }
                        throw zzbo.zza("Searched too many bytes.", null);
                    }
                    if (z) {
                        zzaclVar.zzj();
                        ((zzaby) zzaclVar).zzl(iZze + i4, false);
                    } else {
                        ((zzaby) zzaclVar).zzo(1, false);
                    }
                    i3 = i4;
                    i = 0;
                    i2 = 0;
                }
            } else if (i2 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            ((zzaby) zzaclVar).zzo(iZze + i3, false);
        } else {
            zzaclVar.zzj();
        }
        this.zzi = i;
        return true;
    }

    public final void zza() {
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws Throwable {
        zzdi.zzb(this.zzg);
        int i = zzet.zza;
        int iZzg = zzg(zzaclVar);
        if (iZzg == -1 && (this.zzo instanceof zzahn)) {
            if (this.zzo.zza() != zzh(this.zzl)) {
                throw null;
            }
        }
        return iZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzf = zzacnVar;
        zzadp zzadpVarZzw = zzacnVar.zzw(0, 1);
        this.zzg = zzadpVarZzw;
        this.zzh = zzadpVarZzw;
        this.zzf.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        this.zzi = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = 0L;
        this.zzn = 0;
        if (this.zzo instanceof zzahn) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) {
        return zzm(zzaclVar, true);
    }

    public zzahp(int i) {
        this.zza = new zzek(10);
        this.zzb = new zzadc();
        this.zzc = new zzacy();
        this.zzk = -9223372036854775807L;
        this.zzd = new zzada();
        zzacj zzacjVar = new zzacj();
        this.zze = zzacjVar;
        this.zzh = zzacjVar;
    }
}
