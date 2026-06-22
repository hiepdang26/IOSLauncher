package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes.dex */
public final class wt1 extends RecyclerView {
    public final /* synthetic */ ViewPager2 Q0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wt1(ViewPager2 viewPager2, Context context) {
        super(context, null);
        this.Q0 = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        this.Q0.y.getClass();
        return super.getAccessibilityClassName();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        ViewPager2 viewPager2 = this.Q0;
        accessibilityEvent.setFromIndex(viewPager2.i);
        accessibilityEvent.setToIndex(viewPager2.i);
        accessibilityEvent.setSource((ViewPager2) viewPager2.y.j);
        accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.Q0.w && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.Q0.w && super.onTouchEvent(motionEvent);
    }
}
