package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class k7 extends s81 {
    public final /* synthetic */ int g;
    public final int h;

    public /* synthetic */ k7(int i, int i2) {
        this.g = i2;
        this.h = i;
    }

    @Override // defpackage.s81
    public final void f(Rect rect, View view, RecyclerView recyclerView, i91 i91Var) {
        switch (this.g) {
            case 0:
                int paddingLeft = recyclerView.getPaddingLeft();
                int i = this.h;
                if (paddingLeft != i) {
                    recyclerView.setPadding(i, i, i, i);
                    recyclerView.setClipToPadding(false);
                }
                rect.top = i;
                rect.bottom = i;
                rect.left = i;
                rect.right = i;
                break;
            case 1:
                recyclerView.getClass();
                int iO = RecyclerView.O(view);
                if (iO <= 0) {
                    super.f(rect, view, recyclerView, i91Var);
                } else {
                    int i2 = iO - 1;
                    int i3 = i2 % 3;
                    int i4 = this.h;
                    rect.left = i4 - ((i3 * i4) / 3);
                    rect.right = ((i3 + 1) * i4) / 3;
                    if (i2 < 3) {
                        rect.top = i4;
                    }
                    rect.bottom = i4;
                }
                break;
            default:
                int i5 = this.h;
                rect.top = i5 / 2;
                rect.bottom = i5 / 2;
                rect.left = i5;
                rect.right = i5;
                break;
        }
    }

    public k7(int i) {
        this.g = 0;
        this.h = i / 2;
    }
}
