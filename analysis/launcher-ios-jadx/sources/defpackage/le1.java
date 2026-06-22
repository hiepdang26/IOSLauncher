package defpackage;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes.dex */
public final class le1 implements me1 {
    public final ScrollFeedbackProvider g;

    public le1(NestedScrollView nestedScrollView) {
        this.g = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // defpackage.me1
    public final void c(boolean z, int i, int i2, int i3) {
        this.g.onScrollLimit(i, i2, i3, z);
    }

    @Override // defpackage.me1
    public final void d(int i, int i2, int i3, int i4) {
        this.g.onScrollProgress(i, i2, i3, i4);
    }
}
