package defpackage;

import android.R;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class ph0 extends s81 {
    public static final int[] i = {R.attr.listDivider};
    public final /* synthetic */ int g = 0;
    public Object h;

    public /* synthetic */ ph0() {
    }

    @Override // defpackage.s81
    public void g(Canvas canvas, RecyclerView recyclerView) {
        switch (this.g) {
            case 1:
                if ((recyclerView.getAdapter() instanceof l02) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                    ((ir0) this.h).getClass();
                    throw null;
                }
                return;
            default:
                return;
        }
    }

    @Override // defpackage.s81
    public void h(Canvas canvas, RecyclerView recyclerView) {
        switch (this.g) {
            case 0:
                recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                for (int i2 = 1; i2 < recyclerView.getChildCount() - 1; i2++) {
                    ViewGroup viewGroup = (ViewGroup) recyclerView.getChildAt(i2);
                    View childAt = viewGroup.getChildAt(1);
                    if (childAt instanceof TextView) {
                        int left = childAt.getLeft();
                        int bottom = viewGroup.getBottom() + ((ViewGroup.MarginLayoutParams) ((v81) viewGroup.getLayoutParams())).bottomMargin;
                        Drawable drawable = (Drawable) this.h;
                        drawable.setBounds(left, bottom, width, drawable.getIntrinsicHeight() + bottom);
                        drawable.draw(canvas);
                    }
                }
                break;
        }
    }

    public ph0(ir0 ir0Var) {
        this.h = ir0Var;
        sq1.c(null);
        sq1.c(null);
    }
}
