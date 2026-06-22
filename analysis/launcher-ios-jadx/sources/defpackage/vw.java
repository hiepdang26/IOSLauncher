package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class vw extends FrameLayout {
    private final String TAG;
    private View mAppsLibrary;
    private View mBlurLayout;
    private final vs1 mDragHelperAppsLibrary;
    private final ts1 mDragHelperCallBackAppsLibrary;
    private final ts1 mDragHelperCallbackLeft;
    private final vs1 mDragHelperLeftPage;
    private View mDragLayer;
    private final h80 mGestureDetector;
    private int mHeight;
    private int mLeftOfAppsLibrary;
    private int mLeftOfLeftPage;
    private View mLeftPage;
    private sw mPanelSlideListener;
    private int mRange;
    private tw mStatusAppsLibrary;
    private tw mStatusLeftPage;
    private int mWidth;

    public vw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.TAG = "DragLayoutLeftRight";
        tw twVar = tw.i;
        this.mStatusAppsLibrary = twVar;
        this.mStatusLeftPage = twVar;
        rw rwVar = new rw(this, 0);
        this.mDragHelperCallBackAppsLibrary = rwVar;
        rw rwVar2 = new rw(this, 1);
        this.mDragHelperCallbackLeft = rwVar2;
        setWillNotDraw(false);
        this.mGestureDetector = new h80(context, new uw());
        this.mDragHelperAppsLibrary = vs1.h(this, 0.5f, rwVar);
        this.mDragHelperLeftPage = vs1.h(this, 0.5f, rwVar2);
    }

    public void closeAppsLibrary() {
        closeAppsLibrary(true);
    }

    public void closeLeftPage() {
        closeLeftPage(true);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelperAppsLibrary.g()) {
            WeakHashMap weakHashMap = qs1.a;
            postInvalidateOnAnimation();
        }
        if (this.mDragHelperLeftPage.g()) {
            WeakHashMap weakHashMap2 = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    public tw getStatus() {
        int i = this.mLeftOfAppsLibrary;
        if (i == 0) {
            this.mStatusAppsLibrary = tw.i;
        } else if (i == this.mRange) {
            this.mStatusAppsLibrary = tw.h;
        } else {
            this.mStatusAppsLibrary = tw.g;
        }
        return this.mStatusAppsLibrary;
    }

    public tw getStatusLeft() {
        int i = this.mLeftOfLeftPage;
        if (i == 0) {
            this.mStatusLeftPage = tw.h;
        } else if (i == (-this.mRange)) {
            this.mStatusLeftPage = tw.i;
        } else {
            this.mStatusLeftPage = tw.g;
        }
        return this.mStatusLeftPage;
    }

    public boolean isAppsLibraryClosed() {
        View view = this.mAppsLibrary;
        return view != null && this.mWidth - Math.abs(view.getLeft()) == 0;
    }

    public boolean isAppsLibraryOpening(int i) {
        this.mAppsLibrary.getLeft();
        View view = this.mAppsLibrary;
        return view != null && Math.abs(view.getLeft()) < i;
    }

    public boolean isLayoutRtlSupport() {
        WeakHashMap weakHashMap = qs1.a;
        return getLayoutDirection() == 1;
    }

    public boolean isLeftPageClosed() {
        Math.abs(this.mLeftPage.getLeft());
        View view = this.mLeftPage;
        return view != null && this.mWidth - Math.abs(view.getLeft()) == 0;
    }

    public boolean isLeftPageOpened() {
        this.mLeftPage.getLeft();
        View view = this.mLeftPage;
        return view != null && Math.abs(view.getLeft()) == 0;
    }

    public boolean isLeftPageOpening(int i) {
        this.mLeftPage.getLeft();
        View view = this.mLeftPage;
        return view != null && Math.abs(view.getLeft()) < i;
    }

    public void moveToX(int i, boolean z) {
        if (!z) {
            int i2 = isLayoutRtlSupport() ? -(this.mWidth + i) : this.mWidth - i;
            this.mAppsLibrary.layout(i2, 0, this.mWidth + i2, this.mHeight);
        } else {
            int i3 = isLayoutRtlSupport() ? this.mWidth - i : -(this.mWidth + i);
            this.mLeftPage.layout(i3, 0, this.mWidth + i3, this.mHeight);
            this.mLeftPage.getLeft();
            this.mLeftPage.getAlpha();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mDragLayer = getChildAt(0);
        this.mBlurLayout = getChildAt(1);
        this.mAppsLibrary = getChildAt(2);
        this.mLeftPage = getChildAt(3);
        this.mDragLayer.setClickable(true);
        this.mAppsLibrary.setClickable(true);
        this.mLeftPage.setClickable(true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 3 && actionMasked != 1) {
            return (this.mDragHelperAppsLibrary.r(motionEvent) || this.mDragHelperLeftPage.r(motionEvent)) && this.mGestureDetector.a.onTouchEvent(motionEvent);
        }
        this.mDragHelperAppsLibrary.a();
        this.mDragHelperLeftPage.a();
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mDragLayer.layout(0, 0, this.mWidth, this.mHeight);
        this.mBlurLayout.layout(0, 0, this.mWidth, this.mHeight);
        View view = this.mAppsLibrary;
        view.layout(view.getLeft(), 0, this.mAppsLibrary.getLeft() + this.mWidth, this.mHeight);
        View view2 = this.mLeftPage;
        view2.layout(view2.getLeft(), 0, this.mLeftPage.getLeft() + this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = this.mDragLayer.getMeasuredWidth();
        this.mHeight = this.mDragLayer.getMeasuredHeight();
        this.mRange = this.mWidth;
        this.mLeftOfAppsLibrary = isLayoutRtlSupport() ? -this.mWidth : this.mWidth;
        this.mLeftOfLeftPage = isLayoutRtlSupport() ? this.mWidth : -this.mWidth;
        this.mDragLayer.layout(0, 0, this.mWidth, this.mHeight);
        this.mBlurLayout.layout(0, 0, this.mWidth, this.mHeight);
        View view = this.mAppsLibrary;
        int i5 = this.mLeftOfAppsLibrary;
        view.layout(i5, 0, this.mWidth + i5, this.mHeight);
        View view2 = this.mLeftPage;
        int i6 = this.mLeftOfLeftPage;
        view2.layout(i6, 0, this.mWidth + i6, this.mHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.mDragHelperAppsLibrary.k(motionEvent);
            this.mDragHelperLeftPage.k(motionEvent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void openAppsLibrary() {
        openAppsLibrary(true);
    }

    public void openLeftPage() {
        openLeftPage(true);
    }

    public void closeAppsLibrary(boolean z) {
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        if (z) {
            if (this.mDragHelperAppsLibrary.s(this.mAppsLibrary, zIsLayoutRtlSupport ? -this.mRange : this.mRange, 0)) {
                WeakHashMap weakHashMap = qs1.a;
                postInvalidateOnAnimation();
                return;
            }
            return;
        }
        View view = this.mAppsLibrary;
        int i = this.mRange;
        if (zIsLayoutRtlSupport) {
            i = -i;
        }
        view.layout(i, 0, zIsLayoutRtlSupport ? 0 : this.mRange * 2, this.mHeight);
    }

    public void closeLeftPage(boolean z) {
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        if (z) {
            if (this.mDragHelperLeftPage.s(this.mLeftPage, zIsLayoutRtlSupport ? this.mRange : -this.mRange, 0)) {
                this.mLeftPage.getLeft();
                WeakHashMap weakHashMap = qs1.a;
                postInvalidateOnAnimation();
                return;
            }
            return;
        }
        View view = this.mLeftPage;
        int i = this.mRange;
        if (!zIsLayoutRtlSupport) {
            i = -i;
        }
        view.layout(i, 0, zIsLayoutRtlSupport ? this.mRange * 2 : 0, this.mHeight);
    }

    public void openAppsLibrary(boolean z) {
        if (!z) {
            this.mAppsLibrary.layout(0, 0, this.mWidth, this.mHeight);
            isLayoutRtlSupport();
        } else if (this.mDragHelperAppsLibrary.s(this.mAppsLibrary, 0, 0)) {
            WeakHashMap weakHashMap = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    public void openLeftPage(boolean z) {
        if (!z) {
            this.mLeftPage.layout(0, 0, this.mWidth, this.mHeight);
            isLayoutRtlSupport();
        } else if (this.mDragHelperLeftPage.s(this.mLeftPage, 0, 0)) {
            WeakHashMap weakHashMap = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    public void setPanelSlideListener(sw swVar) {
    }
}
