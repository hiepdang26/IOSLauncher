package defpackage;

import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public abstract class zu1 extends ImageButton {
    public int g;

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.g = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.g;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }
}
