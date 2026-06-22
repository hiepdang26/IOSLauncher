package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import defpackage.cu1;
import defpackage.q71;
import defpackage.qs1;
import defpackage.r41;
import defpackage.zt1;

/* JADX INFO: loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;
    protected zt1 mVisibilityAnim;

    public class VisibilityAnimListener implements cu1 {
        private boolean mCanceled = false;
        int mFinalVisibility;

        public VisibilityAnimListener() {
        }

        @Override // defpackage.cu1
        public void onAnimationCancel(View view) {
            this.mCanceled = true;
        }

        @Override // defpackage.cu1
        public void onAnimationEnd(View view) {
            if (this.mCanceled) {
                return;
            }
            AbsActionBarView absActionBarView = AbsActionBarView.this;
            absActionBarView.mVisibilityAnim = null;
            AbsActionBarView.super.setVisibility(this.mFinalVisibility);
        }

        @Override // defpackage.cu1
        public void onAnimationStart(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(zt1 zt1Var, int i) {
            AbsActionBarView.this.mVisibilityAnim = zt1Var;
            this.mFinalVisibility = i;
            return this;
        }
    }

    public AbsActionBarView(Context context) {
        this(context, null);
    }

    public static int next(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public void animateToVisibility(int i) {
        setupAnimatorToVisibility(i, 200L).e();
    }

    public boolean canShowOverflowMenu() {
        return isOverflowReserved() && getVisibility() == 0;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    public int getAnimatedVisibility() {
        return this.mVisibilityAnim != null ? this.mVisAnimListener.mFinalVisibility : getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowPending();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowReserved();
    }

    public int measureChildView(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, RtlSpacingHelper.UNDEFINED), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, q71.ActionBar, r41.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(q71.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.onConfigurationChanged(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public int positionChild(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public void postShowOverflowMenu() {
        post(new Runnable() { // from class: androidx.appcompat.widget.AbsActionBarView.1
            @Override // java.lang.Runnable
            public void run() {
                AbsActionBarView.this.showOverflowMenu();
            }
        });
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            zt1 zt1Var = this.mVisibilityAnim;
            if (zt1Var != null) {
                zt1Var.b();
            }
            super.setVisibility(i);
        }
    }

    public zt1 setupAnimatorToVisibility(int i, long j) {
        zt1 zt1Var = this.mVisibilityAnim;
        if (zt1Var != null) {
            zt1Var.b();
        }
        if (i != 0) {
            zt1 zt1VarA = qs1.a(this);
            zt1VarA.a(0.0f);
            zt1VarA.c(j);
            zt1VarA.d(this.mVisAnimListener.withFinalVisibility(zt1VarA, i));
            return zt1VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        zt1 zt1VarA2 = qs1.a(this);
        zt1VarA2.a(1.0f);
        zt1VarA2.c(j);
        zt1VarA2.d(this.mVisAnimListener.withFinalVisibility(zt1VarA2, i));
        return zt1VarA2;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVisAnimListener = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(r41.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.mPopupContext = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.mPopupContext = context;
        }
    }
}
