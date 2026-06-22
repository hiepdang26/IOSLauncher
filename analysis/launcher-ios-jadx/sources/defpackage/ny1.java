package defpackage;

import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public class ny1 extends my1 {
    @Override // defpackage.p02
    public final void w(boolean z) {
        Window window = this.m;
        if (!z) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(67108864);
            window.addFlags(RtlSpacingHelper.UNDEFINED);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }
}
