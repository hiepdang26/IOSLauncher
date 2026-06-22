package defpackage;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public final class kb0 extends mb0 {
    public final View b;
    public final float c;

    public kb0(View view) {
        Resources resources = view.getContext().getResources();
        this.c = resources.getDimension(e51.all_apps_header_scroll_to_elevation);
        View view2 = new View(view.getContext());
        this.b = view2;
        view2.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{503316480, 0}));
        view2.setAlpha(0.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, resources.getDimensionPixelSize(e51.all_apps_header_shadow_height));
        layoutParams.topMargin = ((FrameLayout.LayoutParams) view.getLayoutParams()).height;
        ((ViewGroup) view.getParent()).addView(view2, layoutParams);
    }

    @Override // defpackage.mb0
    public final void c(int i) {
        float f = this.c;
        this.b.setAlpha(Math.min(i, f) / f);
    }

    @Override // defpackage.mb0
    public final void d(Rect rect) {
        View view = this.b;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = rect.left;
        layoutParams.rightMargin = rect.right;
        view.requestLayout();
    }
}
