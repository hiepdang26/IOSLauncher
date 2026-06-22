package defpackage;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class vg1 extends s81 {
    public Drawable g;
    public boolean h;
    public int i;

    @Override // defpackage.s81
    public final void g(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int i = this.i;
        boolean z = this.h;
        int i2 = paddingLeft + (z ? 0 : i);
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        if (!z) {
            i = 0;
        }
        int i3 = width - i;
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 <= childCount - 2; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((v81) childAt.getLayoutParams())).bottomMargin;
            Drawable drawable = this.g;
            drawable.setBounds(i2, bottom, i3, drawable.getIntrinsicHeight() + bottom);
            drawable.draw(canvas);
        }
    }
}
