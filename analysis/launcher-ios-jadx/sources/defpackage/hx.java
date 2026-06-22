package defpackage;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: classes.dex */
public final class hx implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
