package defpackage;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class y21 extends s81 {
    public Drawable g;
    public int h;
    public boolean i = true;
    public final /* synthetic */ z21 j;

    public y21(z21 z21Var) {
        this.j = z21Var;
    }

    @Override // defpackage.s81
    public final void f(Rect rect, View view, RecyclerView recyclerView, i91 i91Var) {
        if (i(view, recyclerView)) {
            rect.bottom = this.h;
        }
    }

    @Override // defpackage.s81
    public final void h(Canvas canvas, RecyclerView recyclerView) {
        if (this.g == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        int width = recyclerView.getWidth();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (i(childAt, recyclerView)) {
                int height = childAt.getHeight() + ((int) childAt.getY());
                this.g.setBounds(0, height, width, this.h + height);
                this.g.draw(canvas);
            }
        }
    }

    public final boolean i(View view, RecyclerView recyclerView) {
        m91 m91VarP = recyclerView.P(view);
        if (!(m91VarP instanceof g31) || !((g31) m91VarP).E) {
            return false;
        }
        boolean z = this.i;
        int iIndexOfChild = recyclerView.indexOfChild(view);
        if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
            return z;
        }
        m91 m91VarP2 = recyclerView.P(recyclerView.getChildAt(iIndexOfChild + 1));
        return (m91VarP2 instanceof g31) && ((g31) m91VarP2).D;
    }
}
