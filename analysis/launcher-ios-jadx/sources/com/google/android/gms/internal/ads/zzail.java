package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzail implements zzack {
    private static final byte[] zza = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzaf zzb;
    private zzaik zzA;
    private int zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private zzacn zzF;
    private zzadp[] zzG;
    private zzadp[] zzH;
    private boolean zzI;
    private final zzajy zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzek zzg;
    private final zzek zzh;
    private final zzek zzi;
    private final byte[] zzj;
    private final zzek zzk;
    private final zzafh zzl;
    private final zzek zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private zzfxr zzp;
    private int zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    private zzek zzu;
    private long zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        zzad zzadVar = new zzad();
        zzadVar.zzX("application/x-emsg");
        zzb = zzadVar.zzad();
    }

    @Deprecated
    public zzail() {
        this(zzajy.zza, 32, null, null, zzfxr.zzm(), null);
    }

    private static int zza(int i) throws zzbo {
        if (i >= 0) {
            return i;
        }
        throw zzbo.zza("Unexpected negative value: " + i, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzy zzg(java.util.List r19) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.zzg(java.util.List):com.google.android.gms.internal.ads.zzy");
    }

    private final void zzh() {
        this.zzq = 0;
        this.zzt = 0;
    }

    private static void zzk(zzek zzekVar, int i, zzaiy zzaiyVar) throws zzbo {
        zzekVar.zzK(i + 8);
        int iZzg = zzekVar.zzg();
        if ((iZzg & 1) != 0) {
            throw zzbo.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iZzg & 2) != 0;
        int iZzp = zzekVar.zzp();
        if (iZzp == 0) {
            Arrays.fill(zzaiyVar.zzl, 0, zzaiyVar.zze, false);
            return;
        }
        int i2 = zzaiyVar.zze;
        if (iZzp != i2) {
            throw zzbo.zza("Senc sample count " + iZzp + " is different from fragment sample count" + i2, null);
        }
        Arrays.fill(zzaiyVar.zzl, 0, iZzp, z);
        zzaiyVar.zza(zzekVar.zzb());
        zzek zzekVar2 = zzaiyVar.zzn;
        zzekVar.zzG(zzekVar2.zzM(), 0, zzekVar2.zze());
        zzaiyVar.zzn.zzK(0);
        zzaiyVar.zzo = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:302:0x075c, code lost:
    
        zzh();
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x075f, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x027a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzl(long r56) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 1888
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.zzl(long):void");
    }

    private static final zzaih zzm(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzaih) sparseArray.valueAt(0);
        }
        zzaih zzaihVar = (zzaih) sparseArray.get(i);
        zzaihVar.getClass();
        return zzaihVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0242, code lost:
    
        r23 = r1.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0247, code lost:
    
        r23 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0249, code lost:
    
        r5.zzs(r10, r20, r34.zzB, 0, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x025c, code lost:
    
        if (r34.zzo.isEmpty() != false) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x025e, code lost:
    
        r1 = (com.google.android.gms.internal.ads.zzaij) r34.zzo.removeFirst();
        r34.zzw -= r1.zzc;
        r3 = r1.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0271, code lost:
    
        if (r1.zzb == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0273, code lost:
    
        r3 = r3 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0275, code lost:
    
        r9 = r3;
        r3 = r34.zzG;
        r4 = r3.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x027a, code lost:
    
        if (r5 >= r4) goto L397;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x027c, code lost:
    
        r3[r5].zzs(r9, 1, r1.zzc, r34.zzw, null);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x028e, code lost:
    
        if (r2.zzk() != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0290, code lost:
    
        r34.zzA = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0294, code lost:
    
        r34.zzq = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0298, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a0, code lost:
    
        r4 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a3, code lost:
    
        if (r34.zzq != 3) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
    
        r3 = r2.zzb();
        r34.zzB = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
    
        if (r2.zzf >= r2.zzi) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
    
        ((com.google.android.gms.internal.ads.zzaby) r35).zzo(r3, false);
        r1 = r2.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
    
        if (r1 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bd, code lost:
    
        r3 = r2.zzb.zzn;
        r1 = r1.zzd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c3, code lost:
    
        if (r1 == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c5, code lost:
    
        r3.zzL(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d0, code lost:
    
        if (r2.zzb.zzb(r2.zzf) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d2, code lost:
    
        r3.zzL(r3.zzq() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00df, code lost:
    
        if (r2.zzk() != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e1, code lost:
    
        r34.zzA = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ec, code lost:
    
        if (r2.zzd.zza.zzg != 1) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ee, code lost:
    
        r34.zzB = r3 - 8;
        ((com.google.android.gms.internal.ads.zzaby) r35).zzo(8, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0108, code lost:
    
        if ("audio/ac4".equals(r2.zzd.zza.zzf.zzm) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010a, code lost:
    
        r34.zzC = r2.zzc(r34.zzB, 7);
        com.google.android.gms.internal.ads.zzabm.zzb(r34.zzB, r34.zzk);
        r2.zza.zzq(r34.zzk, 7);
        r3 = r34.zzC + 7;
        r34.zzC = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0127, code lost:
    
        r3 = r2.zzc(r34.zzB, 0);
        r34.zzC = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x012f, code lost:
    
        r34.zzB += r3;
        r34.zzq = 4;
        r34.zzD = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0139, code lost:
    
        r3 = r2.zzd.zza;
        r5 = r2.zza;
        r10 = r2.zze();
        r6 = r3.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0145, code lost:
    
        if (r6 != 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0147, code lost:
    
        r3 = r34.zzC;
        r4 = r34.zzB;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x014b, code lost:
    
        if (r3 >= r4) goto L393;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x014d, code lost:
    
        r34.zzC += r5.zzf(r35, r4 - r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0158, code lost:
    
        r13 = r34.zzh.zzM();
        r13[0] = 0;
        r13[1] = 0;
        r13[r36] = 0;
        r14 = r6 + 1;
        r6 = 4 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016e, code lost:
    
        if (r34.zzC >= r34.zzB) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0170, code lost:
    
        r12 = r34.zzD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0174, code lost:
    
        if (r12 != 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0176, code lost:
    
        ((com.google.android.gms.internal.ads.zzaby) r35).zzn(r13, r6, r14, r9);
        r34.zzh.zzK(r9);
        r12 = r34.zzh.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0187, code lost:
    
        if (r12 <= 0) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0189, code lost:
    
        r34.zzD = r12 - 1;
        r34.zzg.zzK(r9);
        r5.zzq(r34.zzg, 4);
        r5.zzq(r34.zzh, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a0, code lost:
    
        if (r34.zzH.length <= 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a2, code lost:
    
        r12 = r3.zzf.zzm;
        r17 = r13[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ae, code lost:
    
        if ("video/avc".equals(r12) == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01b2, code lost:
    
        if ((r17 & 31) == r4) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b5, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bb, code lost:
    
        if ("video/hevc".equals(r12) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c2, code lost:
    
        if (((r17 & 126) >> r8) != 39) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c5, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c6, code lost:
    
        r34.zzE = r9;
        r34.zzC += 5;
        r34.zzB += r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d3, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01dc, code lost:
    
        throw com.google.android.gms.internal.ads.zzbo.zza("Invalid NAL length", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01df, code lost:
    
        if (r34.zzE == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e1, code lost:
    
        r34.zzi.zzH(r12);
        ((com.google.android.gms.internal.ads.zzaby) r35).zzn(r34.zzi.zzM(), 0, r34.zzD, false);
        r5.zzq(r34.zzi, r34.zzD);
        r4 = r34.zzD;
        r8 = r34.zzi;
        r8 = com.google.android.gms.internal.ads.zzfh.zzb(r8.zzM(), r8.zze());
        r34.zzi.zzK("video/hevc".equals(r3.zzf.zzm) ? 1 : 0);
        r34.zzi.zzJ(r8);
        com.google.android.gms.internal.ads.zzabv.zza(r10, r34.zzi, r34.zzH);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0226, code lost:
    
        r4 = r5.zzf(r35, r12, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x022b, code lost:
    
        r34.zzC += r4;
        r34.zzD -= r4;
        r4 = 6;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0238, code lost:
    
        r20 = r2.zza();
        r1 = r2.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0240, code lost:
    
        if (r1 == null) goto L101;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v10 */
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
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r35, com.google.android.gms.internal.ads.zzadf r36) throws com.google.android.gms.internal.ads.zzbo, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instruction units count: 1835
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        int i;
        if ((this.zzd & 32) == 0) {
            zzacnVar = new zzakc(zzacnVar, this.zzc);
        }
        this.zzF = zzacnVar;
        zzh();
        zzadp[] zzadpVarArr = new zzadp[2];
        this.zzG = zzadpVarArr;
        int i2 = 100;
        int i3 = 0;
        if ((this.zzd & 4) != 0) {
            zzadpVarArr[0] = this.zzF.zzw(100, 5);
            i = 1;
            i2 = 101;
        } else {
            i = 0;
        }
        zzadp[] zzadpVarArr2 = (zzadp[]) zzet.zzP(this.zzG, i);
        this.zzG = zzadpVarArr2;
        for (zzadp zzadpVar : zzadpVarArr2) {
            zzadpVar.zzl(zzb);
        }
        this.zzH = new zzadp[this.zze.size()];
        while (i3 < this.zzH.length) {
            zzadp zzadpVarZzw = this.zzF.zzw(i2, 3);
            zzadpVarZzw.zzl((zzaf) this.zze.get(i3));
            this.zzH[i3] = zzadpVarZzw;
            i3++;
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        int size = this.zzf.size();
        for (int i = 0; i < size; i++) {
            ((zzaik) this.zzf.valueAt(i)).zzi();
        }
        this.zzo.clear();
        this.zzw = 0;
        this.zzx = j2;
        this.zzn.clear();
        zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) {
        zzadm zzadmVarZza = zzaiv.zza(zzaclVar);
        this.zzp = zzadmVarZza != null ? zzfxr.zzn(zzadmVarZza) : zzfxr.zzm();
        return zzadmVarZza == null;
    }

    public zzail(zzajy zzajyVar, int i, zzer zzerVar, zzaiw zzaiwVar, List list, zzadp zzadpVar) {
        this.zzc = zzajyVar;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzafh();
        this.zzm = new zzek(16);
        this.zzg = new zzek(zzfh.zza);
        this.zzh = new zzek(5);
        this.zzi = new zzek();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzek(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzp = zzfxr.zzm();
        this.zzy = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzF = zzacn.zza;
        this.zzG = new zzadp[0];
        this.zzH = new zzadp[0];
    }
}
