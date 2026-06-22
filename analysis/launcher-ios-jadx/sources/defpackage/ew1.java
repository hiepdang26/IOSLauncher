package defpackage;

import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdff;
import com.google.android.gms.internal.ads.zzfpk;
import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzftn;
import com.google.android.gms.internal.ads.zzgcf;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.WeatherWidget;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ew1 implements ty0, wr0, ab, zzgcf, z91, zzfpk, zzftn {
    public static ew1 i;
    public final /* synthetic */ int g;
    public Object h;

    public /* synthetic */ ew1() {
        this.g = 6;
    }

    @Override // defpackage.wr0
    public void a(Object obj) {
        ((WidgetsContainerView) this.h).post(new wc(this, (qx1) obj, 25));
    }

    @Override // defpackage.z91
    public void e(Object obj, Object obj2) {
        y32 y32Var = (y32) obj;
        iw1 iw1Var = new iw1((qm1) obj2);
        y32Var.checkConnected();
        hp0 hp0Var = (hp0) this.h;
        w32 w32Var = new w32();
        w32Var.attachInterface(w32Var, "com.google.android.gms.location.internal.ISettingsCallbacks");
        w32Var.h = iw1Var;
        b32 b32Var = (b32) y32Var.getService();
        b32Var.getClass();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(b32Var.h);
        int i2 = j62.a;
        parcelObtain.writeInt(1);
        hp0Var.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(w32Var);
        parcelObtain.writeString(null);
        b32Var.getClass();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            b32Var.g.transact(63, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // defpackage.ab
    public void onConnected(Bundle bundle) {
        ((fa0) this.h).f();
    }

    @Override // defpackage.ab
    public void onConnectionSuspended(int i2) {
        ((fa0) this.h).onConnectionSuspended(i2);
    }

    @Override // defpackage.wr0
    public void onError(Throwable th) {
        th.getMessage();
    }

    @Override // defpackage.ty0
    public void onFailure(Exception exc) {
        switch (this.g) {
            case 0:
                exc.getMessage();
                if (exc instanceof cb1) {
                    try {
                        ((cb1) exc).a(((fw1) this.h).d());
                    } catch (IntentSender.SendIntentException unused) {
                        return;
                    }
                }
                break;
            default:
                if (exc instanceof cb1) {
                    try {
                        ((cb1) exc).a((t) ((WeatherWidget) this.h).k);
                    } catch (IntentSender.SendIntentException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpk
    public void zza(int i2, long j) {
        ((lb2) this.h).n.zzd(i2, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfpk
    public void zzb(int i2, long j, String str) {
        ((lb2) this.h).n.zze(i2, System.currentTimeMillis() - j, str);
    }

    public /* synthetic */ ew1(Object obj, int i2) {
        this.g = i2;
        this.h = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzftn
    public void zza(zzftm zzftmVar) {
        wc0 wc0Var = (wc0) this.h;
        wc0Var.getClass();
        if (!TextUtils.isEmpty(zzftmVar.zzb())) {
            if (!((Boolean) n42.d.c.zza(zzbbw.zzkC)).booleanValue()) {
                wc0Var.i = zzftmVar.zzb();
            }
        }
        switch (zzftmVar.zza()) {
            case 8152:
                zzbzo.zze.execute(new xm(wc0Var, "onLMDOverlayOpened", new HashMap(), 18));
                break;
            case 8153:
                zzbzo.zze.execute(new xm(wc0Var, "onLMDOverlayClicked", new HashMap(), 18));
                break;
            case 8155:
                zzbzo.zze.execute(new xm(wc0Var, "onLMDOverlayClose", new HashMap(), 18));
                break;
            case 8157:
                wc0Var.i = null;
                wc0Var.h = null;
                wc0Var.g = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put("error", String.valueOf(zzftmVar.zza()));
                zzbzo.zze.execute(new xm(wc0Var, "onLMDOverlayFailedToOpen", map, 18));
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public /* synthetic */ void zzb(Object obj) {
        ((zzdff) this.h).zza((v32) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public void zza(Throwable th) {
        ((zzdff) this.h).zzb(th.getMessage());
    }

    @Override // defpackage.wr0
    public void d() {
    }

    @Override // defpackage.wr0
    public void c(cw cwVar) {
    }
}
