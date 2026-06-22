package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.b1;
import defpackage.b51;
import defpackage.eg0;
import defpackage.hs1;
import defpackage.hx;
import defpackage.ix;
import defpackage.jx;
import defpackage.kx;
import defpackage.lx;
import defpackage.ly1;
import defpackage.m71;
import defpackage.n0;
import defpackage.n41;
import defpackage.ow1;
import defpackage.qs1;
import defpackage.vs1;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private static boolean sEdgeSizeUsingSystemGestureInsets;
    private final b1 mActionDismiss;
    private final ix mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final lx mLeftCallback;
    private final vs1 mLeftDragger;
    private jx mListener;
    private List<jx> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final lx mRightCallback;
    private final vs1 mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;
    private static final int[] THEME_ATTRS = {R.attr.colorPrimaryDark};
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z = CHILDREN_DISALLOW_INTERCEPT;
        CAN_HIDE_DESCENDANTS = CHILDREN_DISALLOW_INTERCEPT;
        SET_DRAWER_SHADOW_FROM_ELEVATION = CHILDREN_DISALLOW_INTERCEPT;
        if (i < 29) {
            z = false;
        }
        sEdgeSizeUsingSystemGestureInsets = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DrawerLayout(Context context, AttributeSet attributeSet) {
        int i = n41.drawerLayoutStyle;
        super(context, attributeSet, i);
        this.mChildAccessibilityDelegate = new ix();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = CHILDREN_DISALLOW_INTERCEPT;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.mActionDismiss = new ow1(this, 11);
        setDescendantFocusability(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION);
        float f = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * f) + 0.5f);
        float f2 = f * 400.0f;
        lx lxVar = new lx(this, 3);
        this.mLeftCallback = lxVar;
        lx lxVar2 = new lx(this, 5);
        this.mRightCallback = lxVar2;
        vs1 vs1VarH = vs1.h(this, TOUCH_SLOP_SENSITIVITY, lxVar);
        this.mLeftDragger = vs1VarH;
        vs1VarH.q = 1;
        vs1VarH.n = f2;
        lxVar.b = vs1VarH;
        vs1 vs1VarH2 = vs1.h(this, TOUCH_SLOP_SENSITIVITY, lxVar2);
        this.mRightDragger = vs1VarH2;
        vs1VarH2.q = 2;
        vs1VarH2.n = f2;
        lxVar2.b = vs1VarH2;
        setFocusableInTouchMode(CHILDREN_DISALLOW_INTERCEPT);
        WeakHashMap weakHashMap = qs1.a;
        setImportantForAccessibility(1);
        qs1.p(this, new a(this));
        setMotionEventSplittingEnabled(false);
        if (getFitsSystemWindows()) {
            setOnApplyWindowInsetsListener(new hx());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(THEME_ATTRS);
            try {
                this.mStatusBarBackground = typedArrayObtainStyledAttributes.getDrawable(0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, m71.DrawerLayout, i, 0);
        try {
            if (typedArrayObtainStyledAttributes2.hasValue(m71.DrawerLayout_elevation)) {
                this.mDrawerElevation = typedArrayObtainStyledAttributes2.getDimension(m71.DrawerLayout_elevation, 0.0f);
            } else {
                this.mDrawerElevation = getResources().getDimension(b51.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.mNonDrawerViews = new ArrayList<>();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public static String gravityToString(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    public static boolean includeChildForAccessibility(View view) {
        WeakHashMap weakHashMap = qs1.a;
        if (view.getImportantForAccessibility() == 4 || view.getImportantForAccessibility() == 2) {
            return false;
        }
        return CHILDREN_DISALLOW_INTERCEPT;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r3 = this;
            boolean r0 = androidx.drawerlayout.widget.DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION
            if (r0 == 0) goto L5
            return
        L5:
            java.util.WeakHashMap r0 = defpackage.qs1.a
            int r0 = r3.getLayoutDirection()
            if (r0 != 0) goto L1d
            android.graphics.drawable.Drawable r1 = r3.mShadowStart
            if (r1 == 0) goto L2d
            boolean r2 = r1.isAutoMirrored()
            if (r2 == 0) goto L1a
            defpackage.az1.G(r1, r0)
        L1a:
            android.graphics.drawable.Drawable r0 = r3.mShadowStart
            goto L2f
        L1d:
            android.graphics.drawable.Drawable r1 = r3.mShadowEnd
            if (r1 == 0) goto L2d
            boolean r2 = r1.isAutoMirrored()
            if (r2 == 0) goto L2a
            defpackage.az1.G(r1, r0)
        L2a:
            android.graphics.drawable.Drawable r0 = r3.mShadowEnd
            goto L2f
        L2d:
            android.graphics.drawable.Drawable r0 = r3.mShadowLeft
        L2f:
            r3.mShadowLeftResolved = r0
            int r0 = r3.getLayoutDirection()
            if (r0 != 0) goto L47
            android.graphics.drawable.Drawable r1 = r3.mShadowEnd
            if (r1 == 0) goto L57
            boolean r2 = r1.isAutoMirrored()
            if (r2 == 0) goto L44
            defpackage.az1.G(r1, r0)
        L44:
            android.graphics.drawable.Drawable r0 = r3.mShadowEnd
            goto L59
        L47:
            android.graphics.drawable.Drawable r1 = r3.mShadowStart
            if (r1 == 0) goto L57
            boolean r2 = r1.isAutoMirrored()
            if (r2 == 0) goto L54
            defpackage.az1.G(r1, r0)
        L54:
            android.graphics.drawable.Drawable r0 = r3.mShadowStart
            goto L59
        L57:
            android.graphics.drawable.Drawable r0 = r3.mShadowRight
        L59:
            r3.mShadowRightResolved = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.a():void");
    }

    public void addDrawerListener(jx jxVar) {
        if (jxVar == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(jxVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!isDrawerView(childAt)) {
                this.mNonDrawerViews.add(childAt);
            } else if (isDrawerOpen(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = CHILDREN_DISALLOW_INTERCEPT;
            }
        }
        if (!z) {
            int size = this.mNonDrawerViews.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.mNonDrawerViews.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.mNonDrawerViews.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (findOpenDrawer() != null || isDrawerView(view)) {
            WeakHashMap weakHashMap = qs1.a;
            view.setImportantForAccessibility(4);
        } else {
            WeakHashMap weakHashMap2 = qs1.a;
            view.setImportantForAccessibility(1);
        }
        if (CAN_HIDE_DESCENDANTS) {
            return;
        }
        qs1.p(view, this.mChildAccessibilityDelegate);
    }

    public final void b(View view) {
        n0 n0Var = n0.l;
        qs1.m(n0Var.a(), view);
        qs1.h(0, view);
        if (!isDrawerOpen(view) || getDrawerLockMode(view) == 2) {
            return;
        }
        qs1.n(view, n0Var, this.mActionDismiss);
    }

    public final void c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || isDrawerView(childAt)) && !(z && childAt == view)) {
                WeakHashMap weakHashMap = qs1.a;
                childAt.setImportantForAccessibility(4);
            } else {
                WeakHashMap weakHashMap2 = qs1.a;
                childAt.setImportantForAccessibility(1);
            }
        }
    }

    public void cancelChildViewTouch() {
        if (this.mChildrenCanceledTouch) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.mChildrenCanceledTouch = CHILDREN_DISALLOW_INTERCEPT;
    }

    public boolean checkDrawerViewAbsoluteGravity(View view, int i) {
        if ((getDrawerViewAbsoluteGravity(view) & i) == i) {
            return CHILDREN_DISALLOW_INTERCEPT;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof b) && super.checkLayoutParams(layoutParams)) {
            return CHILDREN_DISALLOW_INTERCEPT;
        }
        return false;
    }

    public void close() {
        closeDrawer(8388611);
    }

    public void closeDrawer(View view) {
        closeDrawer(view, CHILDREN_DISALLOW_INTERCEPT);
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((b) getChildAt(i).getLayoutParams()).b);
        }
        this.mScrimOpacity = fMax;
        boolean zG = this.mLeftDragger.g();
        boolean zG2 = this.mRightDragger.g();
        if (zG || zG2) {
            WeakHashMap weakHashMap = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean zDispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.mScrimOpacity <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (this.mChildHitRect == null) {
                this.mChildHitRect = new Rect();
            }
            childAt.getHitRect(this.mChildHitRect);
            if (this.mChildHitRect.contains((int) x, (int) y) && !isContentView(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.mChildInvertedMatrix == null) {
                            this.mChildInvertedMatrix = new Matrix();
                        }
                        matrix.invert(this.mChildInvertedMatrix);
                        motionEventObtain.transform(this.mChildInvertedMatrix);
                    }
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (zDispatchGenericMotionEvent) {
                    return CHILDREN_DISALLOW_INTERCEPT;
                }
            }
        }
        return false;
    }

    public void dispatchOnDrawerClosed(View view) {
        View rootView;
        int size;
        b bVar = (b) view.getLayoutParams();
        if ((bVar.d & 1) == 1) {
            bVar.d = 0;
            List<jx> list = this.mListeners;
            if (list != null && (size = list.size() - 1) >= 0) {
                this.mListeners.get(size).getClass();
                throw new ClassCastException();
            }
            c(view, false);
            b(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    public void dispatchOnDrawerOpened(View view) {
        int size;
        b bVar = (b) view.getLayoutParams();
        if ((bVar.d & 1) == 0) {
            bVar.d = 1;
            List<jx> list = this.mListeners;
            if (list != null && (size = list.size() - 1) >= 0) {
                this.mListeners.get(size).getClass();
                throw new ClassCastException();
            }
            c(view, CHILDREN_DISALLOW_INTERCEPT);
            b(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public void dispatchOnDrawerSlide(View view, float f) {
        int size;
        if (this.mListeners == null || r1.size() - 1 < 0) {
            return;
        }
        this.mListeners.get(size).getClass();
        throw new ClassCastException();
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        Drawable background;
        int height = getHeight();
        boolean zIsContentView = isContentView(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i = 0;
        if (zIsContentView) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && isDrawerView(childAt) && childAt.getHeight() >= height) {
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        float f = this.mScrimOpacity;
        if (f > 0.0f && zIsContentView) {
            this.mScrimPaint.setColor((this.mScrimColor & 16777215) | (((int) ((((-16777216) & r0) >>> 24) * f)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.mScrimPaint);
            return zDrawChild;
        }
        if (this.mShadowLeftResolved != null && checkDrawerViewAbsoluteGravity(view, 3)) {
            int intrinsicWidth = this.mShadowLeftResolved.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.mLeftDragger.o, TOUCH_SLOP_SENSITIVITY));
            this.mShadowLeftResolved.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.mShadowLeftResolved.setAlpha((int) (fMax * 255.0f));
            this.mShadowLeftResolved.draw(canvas);
            return zDrawChild;
        }
        if (this.mShadowRightResolved != null && checkDrawerViewAbsoluteGravity(view, 5)) {
            int intrinsicWidth2 = this.mShadowRightResolved.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.mRightDragger.o, TOUCH_SLOP_SENSITIVITY));
            this.mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.mShadowRightResolved.setAlpha((int) (fMax2 * 255.0f));
            this.mShadowRightResolved.draw(canvas);
        }
        return zDrawChild;
    }

    public View findDrawerWithGravity(int i) {
        WeakHashMap weakHashMap = qs1.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((getDrawerViewAbsoluteGravity(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    public View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((b) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public View findVisibleDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            b bVar = (b) layoutParams;
            b bVar2 = new b((ViewGroup.MarginLayoutParams) bVar);
            bVar2.a = 0;
            bVar2.a = bVar.a;
            return bVar2;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return new b(layoutParams);
        }
        b bVar3 = new b((ViewGroup.MarginLayoutParams) layoutParams);
        bVar3.a = 0;
        return bVar3;
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return this.mDrawerElevation;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i) {
        WeakHashMap weakHashMap = qs1.a;
        int layoutDirection = getLayoutDirection();
        if (i == 3) {
            int i2 = this.mLockModeLeft;
            if (i2 != 3) {
                return i2;
            }
            int i3 = layoutDirection == 0 ? this.mLockModeStart : this.mLockModeEnd;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.mLockModeRight;
            if (i4 != 3) {
                return i4;
            }
            int i5 = layoutDirection == 0 ? this.mLockModeEnd : this.mLockModeStart;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.mLockModeStart;
            if (i6 != 3) {
                return i6;
            }
            int i7 = layoutDirection == 0 ? this.mLockModeLeft : this.mLockModeRight;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.mLockModeEnd;
        if (i8 != 3) {
            return i8;
        }
        int i9 = layoutDirection == 0 ? this.mLockModeRight : this.mLockModeLeft;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    public CharSequence getDrawerTitle(int i) {
        WeakHashMap weakHashMap = qs1.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        if (absoluteGravity == 3) {
            return this.mTitleLeft;
        }
        if (absoluteGravity == 5) {
            return this.mTitleRight;
        }
        return null;
    }

    public int getDrawerViewAbsoluteGravity(View view) {
        int i = ((b) view.getLayoutParams()).a;
        WeakHashMap weakHashMap = qs1.a;
        return Gravity.getAbsoluteGravity(i, getLayoutDirection());
    }

    public float getDrawerViewOffset(View view) {
        return ((b) view.getLayoutParams()).b;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    public boolean isContentView(View view) {
        if (((b) view.getLayoutParams()).a == 0) {
            return CHILDREN_DISALLOW_INTERCEPT;
        }
        return false;
    }

    public boolean isDrawerOpen(View view) {
        if (isDrawerView(view)) {
            if ((((b) view.getLayoutParams()).d & 1) == 1) {
                return CHILDREN_DISALLOW_INTERCEPT;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerView(View view) {
        int i = ((b) view.getLayoutParams()).a;
        WeakHashMap weakHashMap = qs1.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        if ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) {
            return false;
        }
        return CHILDREN_DISALLOW_INTERCEPT;
    }

    public boolean isDrawerVisible(View view) {
        if (isDrawerView(view)) {
            if (((b) view.getLayoutParams()).b > 0.0f) {
                return CHILDREN_DISALLOW_INTERCEPT;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isOpen() {
        return isDrawerOpen(8388611);
    }

    public void moveDrawerToOffset(View view, float f) {
        float drawerViewOffset = getDrawerViewOffset(view);
        float width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (drawerViewOffset * width));
        if (!checkDrawerViewAbsoluteGravity(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        setDrawerViewOffset(view, f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = CHILDREN_DISALLOW_INTERCEPT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = CHILDREN_DISALLOW_INTERCEPT;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground || this.mStatusBarBackground == null) {
            return;
        }
        Object obj = this.mLastInsets;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.mStatusBarBackground.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.mStatusBarBackground.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            vs1 r1 = r8.mLeftDragger
            boolean r1 = r1.r(r9)
            vs1 r2 = r8.mRightDragger
            boolean r2 = r2.r(r9)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L6a
            if (r0 == r2) goto L63
            r9 = 2
            if (r0 == r9) goto L1e
            r9 = 3
            if (r0 == r9) goto L63
            goto L68
        L1e:
            vs1 r9 = r8.mLeftDragger
            float[] r0 = r9.d
            int r0 = r0.length
            r4 = 0
        L24:
            if (r4 >= r0) goto L68
            int r5 = r9.k
            int r6 = r2 << r4
            r5 = r5 & r6
            if (r5 == 0) goto L60
            float[] r5 = r9.f
            r5 = r5[r4]
            float[] r6 = r9.d
            r6 = r6[r4]
            float r5 = r5 - r6
            float[] r6 = r9.g
            r6 = r6[r4]
            float[] r7 = r9.e
            r7 = r7[r4]
            float r6 = r6 - r7
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r5 = r9.b
            int r5 = r5 * r5
            float r5 = (float) r5
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L60
            lx r9 = r8.mLeftCallback
            o1 r0 = r9.c
            androidx.drawerlayout.widget.DrawerLayout r9 = r9.d
            r9.removeCallbacks(r0)
            lx r9 = r8.mRightCallback
            o1 r0 = r9.c
            androidx.drawerlayout.widget.DrawerLayout r9 = r9.d
            r9.removeCallbacks(r0)
            goto L68
        L60:
            int r4 = r4 + 1
            goto L24
        L63:
            r8.closeDrawers(r2)
            r8.mChildrenCanceledTouch = r3
        L68:
            r9 = 0
            goto L92
        L6a:
            float r0 = r9.getX()
            float r9 = r9.getY()
            r8.mInitialMotionX = r0
            r8.mInitialMotionY = r9
            float r4 = r8.mScrimOpacity
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L8f
            vs1 r4 = r8.mLeftDragger
            int r0 = (int) r0
            int r9 = (int) r9
            android.view.View r9 = r4.i(r0, r9)
            if (r9 == 0) goto L8f
            boolean r9 = r8.isContentView(r9)
            if (r9 == 0) goto L8f
            r9 = 1
            goto L90
        L8f:
            r9 = 0
        L90:
            r8.mChildrenCanceledTouch = r3
        L92:
            if (r1 != 0) goto Lb5
            if (r9 != 0) goto Lb5
            int r9 = r8.getChildCount()
            r0 = 0
        L9b:
            if (r0 >= r9) goto Laf
            android.view.View r1 = r8.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.drawerlayout.widget.b r1 = (androidx.drawerlayout.widget.b) r1
            boolean r1 = r1.c
            if (r1 == 0) goto Lac
            goto Lb5
        Lac:
            int r0 = r0 + 1
            goto L9b
        Laf:
            boolean r9 = r8.mChildrenCanceledTouch
            if (r9 == 0) goto Lb4
            goto Lb5
        Lb4:
            return r3
        Lb5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || findVisibleDrawer() == null) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return CHILDREN_DISALLOW_INTERCEPT;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View viewFindVisibleDrawer = findVisibleDrawer();
        if (viewFindVisibleDrawer != null && getDrawerLockMode(viewFindVisibleDrawer) == 0) {
            closeDrawers();
        }
        if (viewFindVisibleDrawer != null) {
            return CHILDREN_DISALLOW_INTERCEPT;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        float f;
        int i5;
        this.mInLayout = CHILDREN_DISALLOW_INTERCEPT;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                if (isContentView(childAt)) {
                    int i8 = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
                    childAt.layout(i8, ((ViewGroup.MarginLayoutParams) bVar).topMargin, childAt.getMeasuredWidth() + i8, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bVar).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        float f2 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (bVar.b * f2));
                        f = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i6 - r11) / f3;
                        i5 = i6 - ((int) (bVar.b * f3));
                    }
                    boolean z2 = f != bVar.b ? CHILDREN_DISALLOW_INTERCEPT : false;
                    int i9 = bVar.a & 112;
                    if (i9 == 16) {
                        int i10 = i4 - i2;
                        int i11 = (i10 - measuredHeight) / 2;
                        int i12 = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
                        if (i11 < i12) {
                            i11 = i12;
                        } else {
                            int i13 = i11 + measuredHeight;
                            int i14 = i10 - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
                            if (i13 > i14) {
                                i11 = i14 - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i11, measuredWidth + i5, measuredHeight + i11);
                    } else if (i9 != 80) {
                        int i15 = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
                        childAt.layout(i5, i15, measuredWidth + i5, measuredHeight + i15);
                    } else {
                        int i16 = i4 - i2;
                        childAt.layout(i5, (i16 - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i16 - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin);
                    }
                    if (z2) {
                        setDrawerViewOffset(childAt, f);
                    }
                    int i17 = bVar.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i17) {
                        childAt.setVisibility(i17);
                    }
                }
            }
        }
        if (sEdgeSizeUsingSystemGestureInsets && (rootWindowInsets = getRootWindowInsets()) != null) {
            eg0 eg0VarI = ly1.h(rootWindowInsets, null).a.i();
            vs1 vs1Var = this.mLeftDragger;
            vs1Var.o = Math.max(vs1Var.p, eg0VarI.a);
            vs1 vs1Var2 = this.mRightDragger;
            vs1Var2.o = Math.max(vs1Var2.p, eg0VarI.c);
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View viewFindDrawerWithGravity;
        if (!(parcelable instanceof kx)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        kx kxVar = (kx) parcelable;
        super.onRestoreInstanceState(kxVar.getSuperState());
        int i = kxVar.g;
        if (i != 0 && (viewFindDrawerWithGravity = findDrawerWithGravity(i)) != null) {
            openDrawer(viewFindDrawerWithGravity);
        }
        int i2 = kxVar.h;
        if (i2 != 3) {
            setDrawerLockMode(i2, 3);
        }
        int i3 = kxVar.i;
        if (i3 != 3) {
            setDrawerLockMode(i3, 5);
        }
        int i4 = kxVar.j;
        if (i4 != 3) {
            setDrawerLockMode(i4, 8388611);
        }
        int i5 = kxVar.k;
        if (i5 != 3) {
            setDrawerLockMode(i5, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        a();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        kx kxVar = new kx(super.onSaveInstanceState());
        kxVar.g = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b bVar = (b) getChildAt(i).getLayoutParams();
            int i2 = bVar.d;
            boolean z = CHILDREN_DISALLOW_INTERCEPT;
            boolean z2 = i2 == 1 ? CHILDREN_DISALLOW_INTERCEPT : false;
            if (i2 != 2) {
                z = false;
            }
            if (z2 || z) {
                kxVar.g = bVar.a;
                break;
            }
        }
        kxVar.h = this.mLockModeLeft;
        kxVar.i = this.mLockModeRight;
        kxVar.j = this.mLockModeStart;
        kxVar.k = this.mLockModeEnd;
        return kxVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            vs1 r0 = r6.mLeftDragger
            r0.k(r7)
            vs1 r0 = r6.mRightDragger
            r0.k(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L60
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6e
        L1a:
            r6.closeDrawers(r2)
            r6.mChildrenCanceledTouch = r1
            goto L6e
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            vs1 r3 = r6.mLeftDragger
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.i(r4, r5)
            if (r3 == 0) goto L5b
            boolean r3 = r6.isContentView(r3)
            if (r3 == 0) goto L5b
            float r3 = r6.mInitialMotionX
            float r0 = r0 - r3
            float r3 = r6.mInitialMotionY
            float r7 = r7 - r3
            vs1 r3 = r6.mLeftDragger
            int r3 = r3.b
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r7 = r7 + r0
            int r3 = r3 * r3
            float r0 = (float) r3
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L5b
            android.view.View r7 = r6.findOpenDrawer()
            if (r7 == 0) goto L5b
            int r7 = r6.getDrawerLockMode(r7)
            r0 = 2
            if (r7 != r0) goto L5c
        L5b:
            r1 = 1
        L5c:
            r6.closeDrawers(r1)
            goto L6e
        L60:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.mInitialMotionX = r0
            r6.mInitialMotionY = r7
            r6.mChildrenCanceledTouch = r1
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void open() {
        openDrawer(8388611);
    }

    public void openDrawer(View view) {
        openDrawer(view, CHILDREN_DISALLOW_INTERCEPT);
    }

    public void removeDrawerListener(jx jxVar) {
        List<jx> list;
        if (jxVar == null || (list = this.mListeners) == null) {
            return;
        }
        list.remove(jxVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            closeDrawers(CHILDREN_DISALLOW_INTERCEPT);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    public void setChildInsets(Object obj, boolean z) {
        this.mLastInsets = obj;
        this.mDrawStatusBarBackground = z;
        setWillNotDraw((z || getBackground() != null) ? false : CHILDREN_DISALLOW_INTERCEPT);
        requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.mDrawerElevation = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt)) {
                float f2 = this.mDrawerElevation;
                WeakHashMap weakHashMap = qs1.a;
                hs1.l(childAt, f2);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(jx jxVar) {
        if (jxVar != null) {
            addDrawerListener(jxVar);
        }
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        if ((i & 8388611) == 8388611) {
            this.mShadowStart = drawable;
        } else if ((i & 8388613) == 8388613) {
            this.mShadowEnd = drawable;
        } else if ((i & 3) == 3) {
            this.mShadowLeft = drawable;
        } else if ((i & 5) != 5) {
            return;
        } else {
            this.mShadowRight = drawable;
        }
        a();
        invalidate();
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        WeakHashMap weakHashMap = qs1.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        if (absoluteGravity == 3) {
            this.mTitleLeft = charSequence;
        } else if (absoluteGravity == 5) {
            this.mTitleRight = charSequence;
        }
    }

    public void setDrawerViewOffset(View view, float f) {
        b bVar = (b) view.getLayoutParams();
        if (f == bVar.b) {
            return;
        }
        bVar.b = f;
        dispatchOnDrawerSlide(view, f);
    }

    public void setScrimColor(int i) {
        this.mScrimColor = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.mStatusBarBackground = new ColorDrawable(i);
        invalidate();
    }

    public void updateDrawerState(int i, View view) {
        int i2;
        int size;
        int i3 = this.mLeftDragger.a;
        int i4 = this.mRightDragger.a;
        if (i3 == 1 || i4 == 1) {
            i2 = 1;
        } else {
            i2 = 2;
            if (i3 != 2 && i4 != 2) {
                i2 = 0;
            }
        }
        if (view != null && i == 0) {
            float f = ((b) view.getLayoutParams()).b;
            if (f == 0.0f) {
                dispatchOnDrawerClosed(view);
            } else if (f == TOUCH_SLOP_SENSITIVITY) {
                dispatchOnDrawerOpened(view);
            }
        }
        if (i2 != this.mDrawerState) {
            this.mDrawerState = i2;
            List<jx> list = this.mListeners;
            if (list == null || (size = list.size() - 1) < 0) {
                return;
            }
            this.mListeners.get(size).getClass();
            throw new ClassCastException();
        }
    }

    public void closeDrawer(View view, boolean z) {
        if (!isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        b bVar = (b) view.getLayoutParams();
        if (this.mFirstLayout) {
            bVar.b = 0.0f;
            bVar.d = 0;
        } else if (z) {
            bVar.d |= 4;
            if (checkDrawerViewAbsoluteGravity(view, 3)) {
                this.mLeftDragger.s(view, -view.getWidth(), view.getTop());
            } else {
                this.mRightDragger.s(view, getWidth(), view.getTop());
            }
        } else {
            moveDrawerToOffset(view, 0.0f);
            updateDrawerState(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void closeDrawers(boolean z) {
        int childCount = getChildCount();
        boolean zS = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            b bVar = (b) childAt.getLayoutParams();
            if (isDrawerView(childAt) && (!z || bVar.c)) {
                zS |= checkDrawerViewAbsoluteGravity(childAt, 3) ? this.mLeftDragger.s(childAt, -childAt.getWidth(), childAt.getTop()) : this.mRightDragger.s(childAt, getWidth(), childAt.getTop());
                bVar.c = false;
            }
        }
        lx lxVar = this.mLeftCallback;
        lxVar.d.removeCallbacks(lxVar.c);
        lx lxVar2 = this.mRightCallback;
        lxVar2.d.removeCallbacks(lxVar2.c);
        if (zS) {
            invalidate();
        }
    }

    public void openDrawer(View view, boolean z) {
        if (!isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        b bVar = (b) view.getLayoutParams();
        if (this.mFirstLayout) {
            bVar.b = TOUCH_SLOP_SENSITIVITY;
            bVar.d = 1;
            c(view, CHILDREN_DISALLOW_INTERCEPT);
            b(view);
        } else if (z) {
            bVar.d |= 2;
            if (checkDrawerViewAbsoluteGravity(view, 3)) {
                this.mLeftDragger.s(view, 0, view.getTop());
            } else {
                this.mRightDragger.s(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            moveDrawerToOffset(view, TOUCH_SLOP_SENSITIVITY);
            updateDrawerState(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void setDrawerLockMode(int i, int i2) {
        View viewFindDrawerWithGravity;
        WeakHashMap weakHashMap = qs1.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        if (i2 == 3) {
            this.mLockModeLeft = i;
        } else if (i2 == 5) {
            this.mLockModeRight = i;
        } else if (i2 == 8388611) {
            this.mLockModeStart = i;
        } else if (i2 == 8388613) {
            this.mLockModeEnd = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.mLeftDragger : this.mRightDragger).a();
        }
        if (i != 1) {
            if (i == 2 && (viewFindDrawerWithGravity = findDrawerWithGravity(absoluteGravity)) != null) {
                openDrawer(viewFindDrawerWithGravity);
                return;
            }
            return;
        }
        View viewFindDrawerWithGravity2 = findDrawerWithGravity(absoluteGravity);
        if (viewFindDrawerWithGravity2 != null) {
            closeDrawer(viewFindDrawerWithGravity2);
        }
    }

    public void setStatusBarBackground(int i) {
        this.mStatusBarBackground = i != 0 ? getContext().getDrawable(i) : null;
        invalidate();
    }

    public boolean isDrawerVisible(int i) {
        View viewFindDrawerWithGravity = findDrawerWithGravity(i);
        if (viewFindDrawerWithGravity != null) {
            return isDrawerVisible(viewFindDrawerWithGravity);
        }
        return false;
    }

    public boolean isDrawerOpen(int i) {
        View viewFindDrawerWithGravity = findDrawerWithGravity(i);
        if (viewFindDrawerWithGravity != null) {
            return isDrawerOpen(viewFindDrawerWithGravity);
        }
        return false;
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(getContext().getDrawable(i), i2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public int getDrawerLockMode(View view) {
        if (isDrawerView(view)) {
            return getDrawerLockMode(((b) view.getLayoutParams()).a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void setDrawerLockMode(int i, View view) {
        if (isDrawerView(view)) {
            setDrawerLockMode(i, ((b) view.getLayoutParams()).a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void closeDrawer(int i) {
        closeDrawer(i, CHILDREN_DISALLOW_INTERCEPT);
    }

    public void closeDrawer(int i, boolean z) {
        View viewFindDrawerWithGravity = findDrawerWithGravity(i);
        if (viewFindDrawerWithGravity != null) {
            closeDrawer(viewFindDrawerWithGravity, z);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i));
        }
    }

    public void openDrawer(int i) {
        openDrawer(i, CHILDREN_DISALLOW_INTERCEPT);
    }

    public void openDrawer(int i, boolean z) {
        View viewFindDrawerWithGravity = findDrawerWithGravity(i);
        if (viewFindDrawerWithGravity != null) {
            openDrawer(viewFindDrawerWithGravity, z);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i));
        }
    }
}
