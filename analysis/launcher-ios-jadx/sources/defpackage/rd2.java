package defpackage;

import android.app.Activity;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbze;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class rd2 extends md2 {
    @Override // defpackage.i22
    public final int f(AudioManager audioManager) {
        return audioManager.getStreamMinVolume(3);
    }

    @Override // defpackage.i22
    public final void g(final Activity activity) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzaW)).booleanValue() && ((ib2) hd2.B.g.zzi()).A() == null && !activity.isInMultiWindowMode()) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (1 != attributes.layoutInDisplayCutoutMode) {
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: qd2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    hd2 hd2Var = hd2.B;
                    if (((ib2) hd2Var.g.zzi()).A() == null) {
                        DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                        zzbze zzbzeVar = hd2Var.g;
                        String strConcat = "";
                        if (displayCutout != null) {
                            za2 za2VarZzi = zzbzeVar.zzi();
                            for (Rect rect : displayCutout.getBoundingRects()) {
                                Locale locale = Locale.US;
                                String str = rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom;
                                if (!TextUtils.isEmpty(strConcat)) {
                                    strConcat = strConcat.concat("|");
                                }
                                strConcat = strConcat.concat(str);
                            }
                            ((ib2) za2VarZzi).c(strConcat);
                        } else {
                            ((ib2) zzbzeVar.zzi()).c("");
                        }
                    }
                    Window window2 = activity.getWindow();
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    if (2 != attributes2.layoutInDisplayCutoutMode) {
                        attributes2.layoutInDisplayCutoutMode = 2;
                        window2.setAttributes(attributes2);
                    }
                    return view.onApplyWindowInsets(windowInsets);
                }
            });
        }
    }
}
