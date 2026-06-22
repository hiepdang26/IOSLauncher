package defpackage;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class su1 extends ru1 {
    public static boolean l = true;

    @Override // defpackage.hs0
    public void s(int i, View view) {
        if (Build.VERSION.SDK_INT == 28) {
            super.s(i, view);
        } else if (l) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                l = false;
            }
        }
    }
}
