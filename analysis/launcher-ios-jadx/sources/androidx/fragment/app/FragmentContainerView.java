package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import defpackage.b61;
import defpackage.ly1;
import defpackage.n71;
import defpackage.qs1;
import defpackage.w50;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public ArrayList g;
    public ArrayList h;
    public View.OnApplyWindowInsetsListener i;
    public boolean j;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        this.j = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n71.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(n71.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    public final void a(View view) {
        ArrayList arrayList = this.h;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(b61.fragment_container_view_tag);
        if ((tag instanceof w50 ? (w50) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        Object tag = view.getTag(b61.fragment_container_view_tag);
        if ((tag instanceof w50 ? (w50) tag : null) != null) {
            return super.addViewInLayout(view, i, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        ly1 ly1VarH = ly1.h(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.i;
        ly1 ly1VarH2 = onApplyWindowInsetsListener != null ? ly1.h(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets), null) : qs1.k(this, ly1VarH);
        if (!ly1VarH2.a.m()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                qs1.b(getChildAt(i), ly1VarH2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.j && this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                super.drawChild(canvas, (View) this.g.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList arrayList;
        if (!this.j || (arrayList = this.g) == null || arrayList.size() <= 0 || !this.g.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ArrayList arrayList = this.h;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.g;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.j = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        a(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.j = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.i = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.h == null) {
                this.h = new ArrayList();
            }
            this.h.add(view);
        }
        super.startViewTransition(view);
    }
}
