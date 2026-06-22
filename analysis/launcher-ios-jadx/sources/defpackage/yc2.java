package defpackage;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public final class yc2 extends FrameLayout implements View.OnClickListener {
    public final ImageButton g;
    public final yb2 h;

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public yc2(android.content.Context r7, defpackage.nq r8, defpackage.yb2 r9) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yc2.<init>(android.content.Context, nq, yb2):void");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        yb2 yb2Var = this.h;
        if (yb2Var != null) {
            yb2Var.B = 2;
            yb2Var.g.finish();
        }
    }
}
