package defpackage;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class ta0 extends s81 {
    public final /* synthetic */ int g = 0;
    public int h;
    public Object i;

    public /* synthetic */ ta0() {
    }

    @Override // defpackage.s81
    public void f(Rect rect, View view, RecyclerView recyclerView, i91 i91Var) {
        switch (this.g) {
            case 0:
                recyclerView.getClass();
                int iO = RecyclerView.O(view);
                int i = iO % 2;
                boolean zV = ar1.v((Resources) this.i);
                int i2 = this.h;
                if (zV) {
                    rect.right = (i * i2) / 2;
                    rect.left = i2 - (((i + 1) * i2) / 2);
                } else {
                    rect.left = (i * i2) / 2;
                    rect.right = i2 - (((i + 1) * i2) / 2);
                }
                if (iO >= 2) {
                    rect.top = i2 / 2;
                }
                break;
            default:
                super.f(rect, view, recyclerView, i91Var);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4  */
    @Override // defpackage.s81
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.graphics.Canvas r10, androidx.recyclerview.widget.RecyclerView r11) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ta0.h(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView):void");
    }

    public ta0(q8 q8Var) {
        this.i = q8Var;
    }
}
