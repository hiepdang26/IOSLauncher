package defpackage;

import android.os.RemoteException;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzbsp;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbts;

/* JADX INFO: loaded from: classes.dex */
public final class h22 extends u32 {
    public final /* synthetic */ AdActivity b;
    public final /* synthetic */ s32 c;

    public h22(s32 s32Var, AdActivity adActivity) {
        this.b = adActivity;
        this.c = s32Var;
    }

    @Override // defpackage.u32
    public final /* bridge */ /* synthetic */ Object a() {
        s32.a(this.b, "ad_overlay");
        return null;
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.zzm(new gy0(this.b));
    }

    @Override // defpackage.u32
    public final Object c() {
        AdActivity adActivity = this.b;
        zzbbw.zza(adActivity);
        boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzjN)).booleanValue();
        s32 s32Var = this.c;
        if (!zBooleanValue) {
            return ((zzbsk) s32Var.e).zza(adActivity);
        }
        try {
            try {
                return zzbsm.zzI(zzbsp.zzb(e42.x(adActivity).b("com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl")).zze(new gy0(adActivity)));
            } catch (Exception e) {
                throw new nc2(e);
            }
        } catch (RemoteException e2) {
            e = e2;
            zzbts zzbtsVarZza = zzbtq.zza(adActivity.getApplicationContext());
            s32Var.f = zzbtsVarZza;
            zzbtsVarZza.zzh(e, "ClientApiBroker.createAdOverlay");
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            zzbts zzbtsVarZza2 = zzbtq.zza(adActivity.getApplicationContext());
            s32Var.f = zzbtsVarZza2;
            zzbtsVarZza2.zzh(e, "ClientApiBroker.createAdOverlay");
            return null;
        } catch (nc2 e4) {
            e = e4;
            zzbts zzbtsVarZza22 = zzbtq.zza(adActivity.getApplicationContext());
            s32Var.f = zzbtsVarZza22;
            zzbtsVarZza22.zzh(e, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }
}
