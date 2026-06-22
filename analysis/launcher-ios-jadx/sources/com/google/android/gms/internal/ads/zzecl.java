package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.hd2;
import defpackage.za2;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzecl extends zzecm {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcvu zzd;
    private final TelephonyManager zze;
    private final zzecd zzf;
    private zzbbc.zzq zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbbc.zzaf.zzd.CONNECTED);
        int iOrdinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzbbc.zzaf.zzd zzdVar = zzbbc.zzaf.zzd.CONNECTING;
        sparseArray.put(iOrdinal, zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbbc.zzaf.zzd.DISCONNECTING);
        int iOrdinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzbbc.zzaf.zzd zzdVar2 = zzbbc.zzaf.zzd.DISCONNECTED;
        sparseArray.put(iOrdinal2, zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbbc.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzdVar);
    }

    public zzecl(Context context, zzcvu zzcvuVar, zzecd zzecdVar, zzebz zzebzVar, za2 za2Var) {
        super(zzebzVar, za2Var);
        this.zzc = context;
        this.zzd = zzcvuVar;
        this.zzf = zzecdVar;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    public static /* bridge */ /* synthetic */ zzbbc.zzab zza(zzecl zzeclVar, Bundle bundle) {
        zzbbc.zzab.zzb zzbVar;
        zzbbc.zzab.zza zzaVarZza = zzbbc.zzab.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzeclVar.zzg = zzbbc.zzq.ENUM_TRUE;
        } else {
            zzeclVar.zzg = zzbbc.zzq.ENUM_FALSE;
            if (i == 0) {
                zzaVarZza.zzd(zzbbc.zzab.zzc.CELL);
            } else if (i != 1) {
                zzaVarZza.zzd(zzbbc.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzaVarZza.zzd(zzbbc.zzab.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzbbc.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzbbc.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzbbc.zzab.zzb.LTE;
                    break;
                default:
                    zzbVar = zzbbc.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzaVarZza.zzc(zzbVar);
        }
        return zzaVarZza.zzbr();
    }

    public static /* bridge */ /* synthetic */ zzbbc.zzaf.zzd zzb(zzecl zzeclVar, Bundle bundle) {
        return (zzbbc.zzaf.zzd) zzb.get(zzffu.zza(zzffu.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzbbc.zzaf.zzd.UNSPECIFIED);
    }

    public static byte[] zze(zzecl zzeclVar, boolean z, ArrayList arrayList, zzbbc.zzab zzabVar, zzbbc.zzaf.zzd zzdVar) {
        zzbbc.zzaf.zza.C0002zza c0002zzaZzn = zzbbc.zzaf.zza.zzn();
        c0002zzaZzn.zzn(arrayList);
        c0002zzaZzn.zzD(zzg(Settings.Global.getInt(zzeclVar.zzc.getContentResolver(), "airplane_mode_on", 0) != 0));
        hd2 hd2Var = hd2.B;
        c0002zzaZzn.zzE(hd2Var.e.c(zzeclVar.zzc, zzeclVar.zze));
        c0002zzaZzn.zzM(zzeclVar.zzf.zze());
        c0002zzaZzn.zzL(zzeclVar.zzf.zzb());
        c0002zzaZzn.zzG(zzeclVar.zzf.zza());
        c0002zzaZzn.zzH(zzdVar);
        c0002zzaZzn.zzJ(zzabVar);
        c0002zzaZzn.zzK(zzeclVar.zzg);
        c0002zzaZzn.zzN(zzg(z));
        c0002zzaZzn.zzP(zzeclVar.zzf.zzd());
        hd2Var.j.getClass();
        c0002zzaZzn.zzO(System.currentTimeMillis());
        c0002zzaZzn.zzQ(zzg(Settings.Global.getInt(zzeclVar.zzc.getContentResolver(), "wifi_on", 0) != 0));
        return c0002zzaZzn.zzbr().zzaV();
    }

    private static final zzbbc.zzq zzg(boolean z) {
        return z ? zzbbc.zzq.ENUM_TRUE : zzbbc.zzq.ENUM_FALSE;
    }

    public final void zzd(boolean z) {
        zzgcj.zzr(this.zzd.zzb(new Bundle()), new zzeck(this, z), zzbzo.zzf);
    }
}
