package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ru1 extends qu1 {
    public static boolean k = true;

    @Override // defpackage.hs0
    public void r(View view, int i, int i2, int i3, int i4) {
        if (k) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                k = false;
            }
        }
    }
}
