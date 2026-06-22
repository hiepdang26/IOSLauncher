package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: loaded from: classes.dex */
public final class zzasj extends zzgxy implements zzgzk {
    private static final zzasj zza;
    private static volatile zzgzr zzb;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private long zzI;
    private long zzJ;
    private long zzK;
    private long zzM;
    private zzasl zzP;
    private zzase zzaF;
    private long zzaL;
    private zzarw zzaO;
    private zzary zzaP;
    private int zzaS;
    private long zzaT;
    private boolean zzaW;
    private long zzaY;
    private zzass zzaZ;
    private zzasg zzah;
    private zzasi zzaj;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzasu zzax;
    private int zzc;
    private int zzd;
    private int zze;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzu;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zzf = "";
    private String zzg = "";
    private String zzv = "";
    private String zzF = "";
    private String zzG = "D";
    private String zzH = "";
    private String zzL = "";
    private long zzN = -1;
    private long zzO = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private long zzV = -1;
    private String zzW = "D";
    private String zzX = "D";
    private long zzY = -1;
    private int zzZ = zzbbc.zzq.zzf;
    private int zzaa = zzbbc.zzq.zzf;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private long zzaf = -1;
    private int zzag = zzbbc.zzq.zzf;
    private zzgyk zzai = zzgxy.zzbK();
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private long zzar = -1;
    private String zzas = "D";
    private long zzat = -1;
    private long zzay = -1;
    private int zzaz = zzbbc.zzq.zzf;
    private int zzaA = zzbbc.zzq.zzf;
    private String zzaB = "D";
    private zzgyk zzaC = zzgxy.zzbK();
    private int zzaD = zzbbc.zzq.zzf;
    private zzgyk zzaE = zzgxy.zzbK();
    private String zzaG = "";
    private long zzaH = -1;
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaM = -1;
    private String zzaN = "";
    private long zzaQ = -1;
    private long zzaR = -1;
    private String zzaU = "";
    private int zzaV = 2;
    private String zzaX = "";
    private long zzba = -1;
    private String zzbb = "";

    static {
        zzasj zzasjVar = new zzasj();
        zza = zzasjVar;
        zzgxy.zzcb(zzasj.class, zzasjVar);
    }

    private zzasj() {
    }

    public static /* synthetic */ void zzA(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 134217728;
        zzasjVar.zzK = j;
    }

    public static /* synthetic */ void zzB(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 268435456;
        zzasjVar.zzL = str;
    }

    public static /* synthetic */ void zzC(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 536870912;
        zzasjVar.zzM = j;
    }

    public static /* synthetic */ void zzD(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 1073741824;
        zzasjVar.zzN = j;
    }

    public static /* synthetic */ void zzE(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= RtlSpacingHelper.UNDEFINED;
        zzasjVar.zzO = j;
    }

    public static /* synthetic */ void zzF(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 2;
        zzasjVar.zzQ = j;
    }

    public static /* synthetic */ void zzG(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 4;
        zzasjVar.zzR = j;
    }

    public static /* synthetic */ void zzH(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 8;
        zzasjVar.zzS = j;
    }

    public static /* synthetic */ void zzI(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 16;
        zzasjVar.zzT = j;
    }

    public static /* synthetic */ void zzJ(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 32;
        zzasjVar.zzU = j;
    }

    public static /* synthetic */ void zzK(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 64;
        zzasjVar.zzV = j;
    }

    public static /* synthetic */ void zzL(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzd |= 128;
        zzasjVar.zzW = str;
    }

    public static /* synthetic */ void zzM(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzd |= MotionScene.Transition.TransitionOnClick.JUMP_TO_END;
        zzasjVar.zzX = str;
    }

    public static /* synthetic */ void zzN(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= MotionScene.Transition.TransitionOnClick.JUMP_TO_START;
        zzasjVar.zzab = j;
    }

    public static /* synthetic */ void zzO(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 8192;
        zzasjVar.zzac = j;
    }

    public static /* synthetic */ void zzP(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 16384;
        zzasjVar.zzad = j;
    }

    public static /* synthetic */ void zzQ(zzasj zzasjVar, zzasg zzasgVar) {
        zzasgVar.getClass();
        zzasjVar.zzah = zzasgVar;
        zzasjVar.zzd |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION;
    }

    public static /* synthetic */ void zzR(zzasj zzasjVar, zzasg zzasgVar) {
        zzasgVar.getClass();
        zzgyk zzgykVar = zzasjVar.zzai;
        if (!zzgykVar.zzc()) {
            zzasjVar.zzai = zzgxy.zzbL(zzgykVar);
        }
        zzasjVar.zzai.add(zzasgVar);
    }

    public static /* synthetic */ void zzT(zzasj zzasjVar, zzasi zzasiVar) {
        zzasiVar.getClass();
        zzasjVar.zzaj = zzasiVar;
        zzasjVar.zzd |= 524288;
    }

    public static /* synthetic */ void zzU(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 2097152;
        zzasjVar.zzal = j;
    }

    public static /* synthetic */ void zzV(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 4194304;
        zzasjVar.zzam = j;
    }

    public static /* synthetic */ void zzW(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 8388608;
        zzasjVar.zzan = j;
    }

    public static /* synthetic */ void zzX(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 67108864;
        zzasjVar.zzaq = j;
    }

    public static /* synthetic */ void zzY(zzasj zzasjVar, long j) {
        zzasjVar.zzd |= 134217728;
        zzasjVar.zzar = j;
    }

    public static /* synthetic */ void zzZ(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzd |= 268435456;
        zzasjVar.zzas = str;
    }

    public static zzaro zza() {
        return (zzaro) zza.zzaZ();
    }

    public static /* synthetic */ void zzaa(zzasj zzasjVar, long j) {
        zzasjVar.zze |= 512;
        zzasjVar.zzaH = j;
    }

    public static /* synthetic */ void zzab(zzasj zzasjVar, long j) {
        zzasjVar.zze |= 1024;
        zzasjVar.zzaI = j;
    }

    public static /* synthetic */ void zzac(zzasj zzasjVar, long j) {
        zzasjVar.zze |= 2048;
        zzasjVar.zzaJ = j;
    }

    public static /* synthetic */ void zzad(zzasj zzasjVar, long j) {
        zzasjVar.zze |= MotionScene.Transition.TransitionOnClick.JUMP_TO_START;
        zzasjVar.zzaK = j;
    }

    public static /* synthetic */ void zzae(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zze |= 32768;
        zzasjVar.zzaN = str;
    }

    public static /* synthetic */ void zzaf(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zze |= 4194304;
        zzasjVar.zzaU = str;
    }

    public static /* synthetic */ void zzag(zzasj zzasjVar, boolean z) {
        zzasjVar.zze |= 16777216;
        zzasjVar.zzaW = z;
    }

    public static /* synthetic */ void zzah(zzasj zzasjVar, long j) {
        zzasjVar.zze |= 67108864;
        zzasjVar.zzaY = j;
    }

    public static /* synthetic */ void zzam(zzasj zzasjVar, int i) {
        zzasjVar.zzZ = i - 1;
        zzasjVar.zzd |= 1024;
    }

    public static /* synthetic */ void zzan(zzasj zzasjVar, int i) {
        zzasjVar.zzaa = i - 1;
        zzasjVar.zzd |= 2048;
    }

    public static /* synthetic */ void zzao(zzasj zzasjVar, int i) {
        zzasjVar.zzag = i - 1;
        zzasjVar.zzd |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ;
    }

    public static /* synthetic */ void zzap(zzasj zzasjVar, int i) {
        zzasjVar.zzaz = i - 1;
        zzasjVar.zze |= 8;
    }

    public static /* synthetic */ void zzaq(zzasj zzasjVar, int i) {
        zzasjVar.zzaA = i - 1;
        zzasjVar.zze |= 16;
    }

    public static /* synthetic */ void zzar(zzasj zzasjVar, int i) {
        zzasjVar.zzaS = i - 1;
        zzasjVar.zze |= 1048576;
    }

    public static /* synthetic */ void zzas(zzasj zzasjVar, int i) {
        zzasjVar.zzaV = 5;
        zzasjVar.zze |= 8388608;
    }

    public static zzasj zzd() {
        return zza;
    }

    public static zzasj zze(byte[] bArr, zzgxi zzgxiVar) {
        return (zzasj) zzgxy.zzbx(zza, bArr, zzgxiVar);
    }

    public static /* synthetic */ void zzi(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 1;
        zzasjVar.zzf = str;
    }

    public static /* synthetic */ void zzj(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 2;
        zzasjVar.zzg = str;
    }

    public static /* synthetic */ void zzk(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 4;
        zzasjVar.zzh = j;
    }

    public static /* synthetic */ void zzl(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 16;
        zzasjVar.zzj = j;
    }

    public static /* synthetic */ void zzm(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 32;
        zzasjVar.zzk = j;
    }

    public static /* synthetic */ void zzn(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 1024;
        zzasjVar.zzp = j;
    }

    public static /* synthetic */ void zzo(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 2048;
        zzasjVar.zzu = j;
    }

    public static /* synthetic */ void zzp(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 8192;
        zzasjVar.zzw = j;
    }

    public static /* synthetic */ void zzq(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 16384;
        zzasjVar.zzx = j;
    }

    public static /* synthetic */ void zzr(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 32768;
        zzasjVar.zzy = j;
    }

    public static /* synthetic */ void zzs(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST;
        zzasjVar.zzz = j;
    }

    public static /* synthetic */ void zzt(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 524288;
        zzasjVar.zzC = j;
    }

    public static /* synthetic */ void zzu(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 1048576;
        zzasjVar.zzD = j;
    }

    public static /* synthetic */ void zzv(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 2097152;
        zzasjVar.zzE = j;
    }

    public static /* synthetic */ void zzw(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 4194304;
        zzasjVar.zzF = str;
    }

    public static /* synthetic */ void zzx(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 16777216;
        zzasjVar.zzH = str;
    }

    public static /* synthetic */ void zzy(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 33554432;
        zzasjVar.zzI = j;
    }

    public static /* synthetic */ void zzz(zzasj zzasjVar, long j) {
        zzasjVar.zzc |= 67108864;
        zzasjVar.zzJ = j;
    }

    public final boolean zzai() {
        return this.zzaW;
    }

    public final boolean zzaj() {
        return (this.zzc & 4194304) != 0;
    }

    public final boolean zzak() {
        return (this.zze & 134217728) != 0;
    }

    public final int zzal() {
        int iZza = zzart.zza(this.zzaV);
        if (iZza == 0) {
            return 3;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzarn zzarnVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                zzgye zzgyeVar = zzasp.zza;
                return zzgxy.zzbS(zza, "\u0001a\u0000\u0003\u0001Įa\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂU\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈV\u0019ဂZ\u001a᠌W\u001bဈ\u0016\u001cဇX\u001dဈ\u0018\u001eဈY\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌@EဉAFဂBGဂ8Hဂ9I᠌CJဂ)Kဈ\u0017L᠌DMဈEN\u001bO᠌FP\u001bQဉGRဈHSဂITဂJUဂKVဂLWဂMXဂNYဈOZဉP[ဉQ\\ဂR]ဂS^᠌TÉဉ[ĭဂ\\Įဈ]", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzaT", "zzD", "zzE", "zzaU", "zzaY", "zzaV", zzars.zza, "zzF", "zzaW", "zzH", "zzaX", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzai", zzasg.class, "zzU", "zzV", "zzW", "zzX", "zzZ", zzgyeVar, "zzaa", zzgyeVar, "zzah", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", zzgyeVar, "zzaj", "zzak", "zzal", "zzam", "zzan", "zzaq", "zzar", "zzat", "zzau", zzaso.zza, "zzav", zzasq.zza, "zzas", "zzaw", zzarp.zza, "zzax", "zzay", "zzao", "zzap", "zzaz", zzgyeVar, "zzY", "zzG", "zzaA", zzgyeVar, "zzaB", "zzaC", zzasc.class, "zzaD", zzgyeVar, "zzaE", zzarr.class, "zzaF", "zzaG", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaN", "zzaO", "zzaP", "zzaQ", "zzaR", "zzaS", zzarz.zza, "zzaZ", "zzba", "zzbb"});
            case NEW_MUTABLE_INSTANCE:
                return new zzasj();
            case NEW_BUILDER:
                return new zzaro(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzasj.class) {
                    try {
                        zzgxtVar = zzb;
                        if (zzgxtVar == null) {
                            zzgxtVar = new zzgxt(zza);
                            zzb = zzgxtVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return zzgxtVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzass zzf() {
        zzass zzassVar = this.zzaZ;
        return zzassVar == null ? zzass.zzd() : zzassVar;
    }

    public final String zzg() {
        return this.zzaU;
    }

    public final String zzh() {
        return this.zzF;
    }
}
