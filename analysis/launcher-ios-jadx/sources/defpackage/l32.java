package defpackage;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbts;

/* JADX INFO: loaded from: classes.dex */
public final class l32 extends u32 {
    public final /* synthetic */ xv0 b;
    public final /* synthetic */ FrameLayout c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ s32 e;

    public l32(s32 s32Var, xv0 xv0Var, FrameLayout frameLayout, Context context) {
        this.b = xv0Var;
        this.c = frameLayout;
        this.d = context;
        this.e = s32Var;
    }

    @Override // defpackage.u32
    public final Object a() {
        s32.a(this.d, "native_ad_view_delegate");
        return new fa2();
    }

    @Override // defpackage.u32
    public final Object b(x62 x62Var) {
        return x62Var.d(new gy0(this.b), new gy0(this.c));
    }

    @Override // defpackage.u32
    public final Object c() {
        Context context = this.d;
        zzbbw.zza(context);
        boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzjN)).booleanValue();
        FrameLayout frameLayout = this.c;
        xv0 xv0Var = this.b;
        s32 s32Var = this.e;
        if (!zBooleanValue) {
            return ((zzbhc) s32Var.d).zza(context, xv0Var, frameLayout);
        }
        try {
            try {
                return zzbfg.zzdA(zzbfj.zzb(e42.x(context).b("com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl")).zze(new gy0(context), new gy0(xv0Var), new gy0(frameLayout), 242402000));
            } catch (Exception e) {
                throw new nc2(e);
            }
        } catch (RemoteException e2) {
            e = e2;
            zzbts zzbtsVarZza = zzbtq.zza(context);
            s32Var.f = zzbtsVarZza;
            zzbtsVarZza.zzh(e, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            zzbts zzbtsVarZza2 = zzbtq.zza(context);
            s32Var.f = zzbtsVarZza2;
            zzbtsVarZza2.zzh(e, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        } catch (nc2 e4) {
            e = e4;
            zzbts zzbtsVarZza22 = zzbtq.zza(context);
            s32Var.f = zzbtsVarZza22;
            zzbtsVarZza22.zzh(e, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        }
    }
}
