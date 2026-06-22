package defpackage;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: classes.dex */
public class py1 extends p02 {
    public final WindowInsetsController m;
    public final Window n;

    public py1(Window window) {
        this.m = window.getInsetsController();
        this.n = window;
    }

    @Override // defpackage.p02
    public final void v(boolean z) {
        Window window = this.n;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.m.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.m.setSystemBarsAppearance(0, 16);
    }

    @Override // defpackage.p02
    public final void w(boolean z) {
        Window window = this.n;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.m.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.m.setSystemBarsAppearance(0, 8);
    }
}
