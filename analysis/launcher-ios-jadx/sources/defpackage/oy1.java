package defpackage;

import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public final class oy1 extends ny1 {
    @Override // defpackage.p02
    public final void v(boolean z) {
        Window window = this.m;
        if (!z) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-17));
        } else {
            window.clearFlags(134217728);
            window.addFlags(RtlSpacingHelper.UNDEFINED);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 16);
        }
    }
}
