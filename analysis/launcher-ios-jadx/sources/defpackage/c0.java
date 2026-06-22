package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends ClickableSpan {
    public final int a;
    public final r0 b;
    public final int c;

    public c0(int i, r0 r0Var, int i2) {
        this.a = i;
        this.b = r0Var;
        this.c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.a.performAction(this.c, bundle);
    }
}
