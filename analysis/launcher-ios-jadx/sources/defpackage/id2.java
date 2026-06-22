package defpackage;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbu;
import com.google.android.gms.internal.ads.zzbbw;

/* JADX INFO: loaded from: classes.dex */
public class id2 extends fd2 {
    @Override // defpackage.i22
    public final boolean a(Activity activity, Configuration configuration) {
        zzbbn zzbbnVar = zzbbw.zzeo;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            return false;
        }
        zzbbn zzbbnVar2 = zzbbw.zzeq;
        zzbbu zzbbuVar = n42Var.c;
        if (((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        ka2 ka2Var = x32.f.a;
        int iN = ka2.n(activity, configuration.screenHeightDp);
        int iK = ka2.k(activity.getResources().getDisplayMetrics(), configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        cd2 cd2Var = hd2.B.c;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int iIntValue = ((Integer) zzbbuVar.zza(zzbbw.zzem)).intValue() * ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d));
        return !(Math.abs(i - (iN + dimensionPixelSize)) <= iIntValue) || Math.abs(i2 - iK) > iIntValue;
    }
}
