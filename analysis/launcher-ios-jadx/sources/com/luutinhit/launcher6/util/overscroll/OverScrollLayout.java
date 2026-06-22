package com.luutinhit.launcher6.util.overscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import defpackage.gz0;
import defpackage.l01;
import defpackage.m01;
import defpackage.n01;
import defpackage.u81;
import defpackage.xy0;
import defpackage.yy0;

/* JADX INFO: loaded from: classes.dex */
public class OverScrollLayout extends LinearLayout {
    public static final int SCROLL_BOTTOM = 2;
    public static int SCROLL_HORIZONTAL = 0;
    public static final int SCROLL_LEFT = 3;
    public static final int SCROLL_RIGHT = 4;
    public static final int SCROLL_TOP = 1;
    public static int SCROLL_VERTICAL = 1;
    private static final String TAG = "OverScrollLayout";
    private boolean abortScroller;
    private float baseOverScrollLength;
    private boolean bottomOverScrollEnable;
    private boolean canOverScrollHorizontally;
    private boolean canOverScrollVertical;
    private l01 checkListener;
    private boolean checkScrollDirectionFinish;
    private View child;
    private ViewConfiguration configuration;
    private int dealtX;
    private int dealtY;
    private GestureDetector detector;
    private boolean disallowIntercept;
    private float downX;
    private float downY;
    private boolean finishOverScroll;
    private m01 flingRunnable;
    private OverScroller flingScroller;
    private boolean isHorizontallyMove;
    private boolean isOverScrollBottom;
    private boolean isOverScrollLeft;
    private boolean isOverScrollRight;
    private boolean isOverScrollTop;
    private boolean isVerticalMove;
    private boolean leftOverScrollEnable;
    private Scroller mScroller;
    private float oldX;
    private float oldY;
    private xy0 onOverScrollFinishListener;
    private yy0 onOverScrollListener;
    private n01 overScrollRunnable;
    private boolean rightOverScrollEnable;
    private boolean shouldSetScrollerStart;
    private boolean topOverScrollEnable;

    public OverScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.topOverScrollEnable = true;
        this.bottomOverScrollEnable = true;
        this.leftOverScrollEnable = true;
        this.rightOverScrollEnable = true;
        this.configuration = ViewConfiguration.get(getContext());
        this.mScroller = new Scroller(getContext(), new PathInterpolator(0.25f, 0.68f, 0.38f, 0.88f));
        this.flingRunnable = new m01(this);
        this.overScrollRunnable = new n01(this);
        this.flingScroller = new OverScroller(getContext());
        this.detector = new GestureDetector(getContext(), new gz0(this, 1));
    }

    public static void i(OverScrollLayout overScrollLayout, float f) {
        float scaledMaximumFlingVelocity = f / overScrollLayout.configuration.getScaledMaximumFlingVelocity();
        if (overScrollLayout.canOverScrollVertical) {
            if (overScrollLayout.m()) {
                overScrollLayout.overScrollRunnable.a(0.0f, scaledMaximumFlingVelocity);
                return;
            } else {
                overScrollLayout.overScrollRunnable.a(0.0f, -scaledMaximumFlingVelocity);
                return;
            }
        }
        if (overScrollLayout.l()) {
            overScrollLayout.overScrollRunnable.a(-scaledMaximumFlingVelocity, 0.0f);
        } else {
            overScrollLayout.overScrollRunnable.a(scaledMaximumFlingVelocity, 0.0f);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
            return;
        }
        if (this.abortScroller) {
            this.abortScroller = false;
            return;
        }
        if (this.finishOverScroll) {
            xy0 xy0Var = this.onOverScrollFinishListener;
            if (xy0Var != null) {
                WallpaperActivity wallpaperActivity = (WallpaperActivity) xy0Var;
                if ((this.isOverScrollTop ? (char) 1 : this.isOverScrollBottom ? (char) 2 : this.isOverScrollLeft ? (char) 3 : this.isOverScrollRight ? (char) 4 : (char) 0) == 2) {
                    wallpaperActivity.R.postDelayed(wallpaperActivity.S, 0L);
                }
            }
            this.isOverScrollTop = false;
            this.isOverScrollBottom = false;
            this.isOverScrollLeft = false;
            this.isOverScrollRight = false;
            this.finishOverScroll = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:194:0x0296 A[Catch: all -> 0x000a, TryCatch #0 {all -> 0x000a, blocks: (B:3:0x0001, B:5:0x0005, B:9:0x000d, B:213:0x02f0, B:20:0x002c, B:21:0x0032, B:22:0x0038, B:24:0x003c, B:26:0x0040, B:28:0x0044, B:31:0x004a, B:33:0x005b, B:35:0x0062, B:49:0x0084, B:52:0x008a, B:54:0x0099, B:68:0x00bd, B:71:0x00c3, B:73:0x00d2, B:57:0x00a5, B:59:0x00a9, B:62:0x00ae, B:64:0x00b5, B:38:0x006c, B:40:0x0070, B:43:0x0075, B:45:0x007c, B:74:0x00dc, B:76:0x00e0, B:77:0x00eb, B:79:0x00f1, B:81:0x00f8, B:83:0x0115, B:85:0x0119, B:86:0x011b, B:88:0x011f, B:90:0x0123, B:91:0x0125, B:93:0x0130, B:95:0x0134, B:102:0x0142, B:104:0x014e, B:106:0x0154, B:97:0x0138, B:99:0x013c, B:109:0x0169, B:111:0x016d, B:113:0x0171, B:116:0x0177, B:118:0x0188, B:120:0x018f, B:134:0x01b1, B:137:0x01b7, B:139:0x01c6, B:141:0x01d0, B:144:0x01d5, B:146:0x01dc, B:150:0x01e5, B:153:0x01eb, B:155:0x01fa, B:123:0x0199, B:125:0x019d, B:128:0x01a2, B:130:0x01a9, B:156:0x0204, B:158:0x0208, B:159:0x0213, B:161:0x0219, B:163:0x0220, B:165:0x023d, B:167:0x0241, B:168:0x0243, B:170:0x0247, B:172:0x024b, B:173:0x024d, B:175:0x0258, B:177:0x025c, B:184:0x026a, B:186:0x0276, B:188:0x027c, B:179:0x0260, B:181:0x0264, B:192:0x0291, B:194:0x0296, B:195:0x029c, B:197:0x02b2, B:199:0x02be, B:201:0x02d0, B:203:0x02dc, B:205:0x02e0, B:207:0x02e4, B:209:0x02e8, B:212:0x02ed, B:202:0x02d3, B:198:0x02b5), top: B:218:0x0001 }] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.util.overscroll.OverScrollLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public yy0 getOnOverScrollListener() {
        return null;
    }

    public l01 getOverScrollCheckListener() {
        return null;
    }

    public boolean isBottomOverScrollEnable() {
        return this.bottomOverScrollEnable;
    }

    public boolean isLeftOverScrollEnable() {
        return this.leftOverScrollEnable;
    }

    public boolean isRightOverScrollEnable() {
        return this.rightOverScrollEnable;
    }

    public boolean isTopOverScrollEnable() {
        return this.topOverScrollEnable;
    }

    public final boolean j() {
        View view = this.child;
        return view != null && view.canScrollVertically(1);
    }

    public final boolean k() {
        View view = this.child;
        return view != null && view.canScrollHorizontally(-1);
    }

    public final boolean l() {
        View view = this.child;
        return view != null && view.canScrollHorizontally(1);
    }

    public final boolean m() {
        View view = this.child;
        return view != null && view.canScrollVertically(-1);
    }

    public void mSmoothScrollBy(int i, int i2) {
        Scroller scroller = this.mScroller;
        scroller.startScroll(scroller.getFinalX(), this.mScroller.getFinalY(), i, i2);
        invalidate();
    }

    public void mSmoothScrollTo(int i, int i2) {
        mSmoothScrollBy(i - this.mScroller.getFinalX(), i2 - this.mScroller.getFinalY());
    }

    public final void n() {
        if (this.checkScrollDirectionFinish) {
            return;
        }
        View view = this.child;
        if ((view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof WebView)) {
            this.canOverScrollHorizontally = false;
            this.canOverScrollVertical = true;
        } else if (view instanceof RecyclerView) {
            u81 layoutManager = ((RecyclerView) view).getLayoutManager();
            int i = layoutManager instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) layoutManager).t : layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).p : -1;
            this.canOverScrollHorizontally = i == 0;
            this.canOverScrollVertical = 1 == i;
        } else if (view instanceof HorizontalScrollView) {
            this.canOverScrollHorizontally = true;
            this.canOverScrollVertical = false;
        } else if (view instanceof ViewPager) {
            this.canOverScrollHorizontally = false;
            this.canOverScrollVertical = false;
        } else {
            this.canOverScrollHorizontally = false;
            this.canOverScrollVertical = true;
        }
        this.checkScrollDirectionFinish = true;
        if (this.canOverScrollVertical) {
            this.baseOverScrollLength = getHeight();
        } else {
            this.baseOverScrollLength = getWidth();
        }
    }

    public final void o(float f, float f2) {
        if (this.isVerticalMove || this.isHorizontallyMove) {
            return;
        }
        if (this.canOverScrollVertical) {
            this.isVerticalMove = Math.abs(f2 - this.downY) >= ((float) this.configuration.getScaledTouchSlop());
        } else if (this.canOverScrollHorizontally) {
            this.isHorizontallyMove = Math.abs(f - this.downX) >= ((float) this.configuration.getScaledTouchSlop());
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        int childCount = getChildCount();
        if (childCount > 1) {
            throw new IllegalStateException("OverScrollLayout only can host 1 element");
        }
        if (childCount == 1) {
            View childAt = getChildAt(0);
            this.child = childAt;
            childAt.setOverScrollMode(2);
        }
        super.onFinishInflate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final float p(float f, float f2) {
        if (f * f2 < 0.0f) {
            return f;
        }
        return (1.0f - Math.min(new AccelerateInterpolator(0.15f).getInterpolation((float) Math.min(Math.max(Math.abs(f2), 0.1d) / ((double) Math.abs(this.baseOverScrollLength)), 1.0d)), 1.0f)) * f;
    }

    public void setBottomOverScrollEnable(boolean z) {
        this.bottomOverScrollEnable = z;
    }

    public void setDisallowInterceptTouchEvent(boolean z) {
        this.disallowIntercept = z;
    }

    public void setLeftOverScrollEnable(boolean z) {
        this.leftOverScrollEnable = z;
    }

    public void setOnOverScrollFinishListener(xy0 xy0Var) {
        this.onOverScrollFinishListener = xy0Var;
    }

    public void setRightOverScrollEnable(boolean z) {
        this.rightOverScrollEnable = z;
    }

    public void setTopOverScrollEnable(boolean z) {
        this.topOverScrollEnable = z;
    }

    public void setOnOverScrollListener(yy0 yy0Var) {
    }

    public void setOverScrollCheckListener(l01 l01Var) {
    }
}
