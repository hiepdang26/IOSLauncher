package defpackage;

import android.os.Build;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes.dex */
public final class ne1 {
    public final me1 a;

    public ne1(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.a = new le1(nestedScrollView);
        } else {
            this.a = new m21();
        }
    }
}
