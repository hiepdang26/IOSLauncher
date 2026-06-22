package com.luutinhit.launcher6;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import defpackage.ar1;
import defpackage.dk0;
import defpackage.g61;
import defpackage.jk0;
import defpackage.l51;
import defpackage.ld;
import defpackage.lw;
import defpackage.mw;
import defpackage.my;
import defpackage.ng1;
import defpackage.ow;
import defpackage.pk0;
import defpackage.pw;
import defpackage.qh0;
import defpackage.qw;
import defpackage.r7;
import defpackage.w1;
import defpackage.w61;
import defpackage.z30;
import defpackage.zg;
import defpackage.zw;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DragLayer extends InsertAbleFrameLayout {
    public static final int ANIMATION_END_DISAPPEAR = 0;
    public static final int ANIMATION_END_REMAIN_VISIBLE = 2;
    private static final int SCRIM_COLOR = 0;
    private static final String TAG = "DragLayer";
    View mAnchorView;
    int mAnchorViewInitialScrollX;
    private float mBackgroundAlpha;
    private int mChildCountOnLastUpdate;
    private final TimeInterpolator mCubicEaseOutInterpolator;
    private r7 mCurrentResizeFrame;
    mw mDragController;
    private ValueAnimator mDropAnim;
    zw mDropView;
    private final Rect mHitRect;
    private boolean mHoverPointClosesFolder;
    private boolean mInScrollArea;
    private final boolean mIsRtl;
    private t mLauncher;
    private final Drawable mLeftHoverDrawable;
    private final Drawable mLeftHoverDrawableActive;
    private View mOverlayView;
    private final ArrayList<r7> mResizeFrames;
    private final Drawable mRightHoverDrawable;
    private final Drawable mRightHoverDrawableActive;
    private final Rect mScrollChildPosition;
    private boolean mShowPageHints;
    private final int[] mTmpXY;
    private int mTopViewIndex;
    private qw mTouchCompleteListener;
    private boolean mWorkSpaceDragOver;
    private int mXDown;
    private int mYDown;

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTmpXY = new int[2];
        this.mResizeFrames = new ArrayList<>();
        this.mDropAnim = null;
        this.mCubicEaseOutInterpolator = new DecelerateInterpolator(1.5f);
        this.mDropView = null;
        this.mAnchorViewInitialScrollX = 0;
        this.mAnchorView = null;
        this.mHoverPointClosesFolder = false;
        this.mHitRect = new Rect();
        this.mChildCountOnLastUpdate = -1;
        this.mBackgroundAlpha = 0.0f;
        this.mScrollChildPosition = new Rect();
        this.mWorkSpaceDragOver = false;
        setMotionEventSplittingEnabled(false);
        setChildrenDrawingOrderEnabled(true);
        Resources resources = getResources();
        this.mLeftHoverDrawable = resources.getDrawable(l51.page_hover_left);
        this.mRightHoverDrawable = resources.getDrawable(l51.page_hover_right);
        this.mLeftHoverDrawableActive = resources.getDrawable(l51.page_hover_left_active);
        this.mRightHoverDrawableActive = resources.getDrawable(l51.page_hover_right_active);
        this.mIsRtl = ar1.v(resources);
    }

    private void drawPageHints(Canvas canvas) {
        if (this.mShowPageHints) {
            Workspace workspace = this.mLauncher.getWorkspace();
            int measuredWidth = getMeasuredWidth();
            int nextPage = workspace.getNextPage();
            CellLayout cellLayout = (CellLayout) workspace.getChildAt(this.mIsRtl ? nextPage + 1 : nextPage - 1);
            CellLayout cellLayout2 = (CellLayout) workspace.getChildAt(this.mIsRtl ? nextPage - 1 : nextPage + 1);
            if (cellLayout != null && cellLayout.o) {
                Drawable drawable = (this.mInScrollArea && cellLayout.getIsDragOverlapping()) ? this.mLeftHoverDrawableActive : this.mLeftHoverDrawable;
                drawable.setBounds(0, this.mScrollChildPosition.top, drawable.getIntrinsicWidth(), this.mScrollChildPosition.bottom);
                drawable.draw(canvas);
            }
            if (cellLayout2 == null || !cellLayout2.o) {
                return;
            }
            Drawable drawable2 = (this.mInScrollArea && cellLayout2.getIsDragOverlapping()) ? this.mRightHoverDrawableActive : this.mRightHoverDrawable;
            int intrinsicWidth = measuredWidth - drawable2.getIntrinsicWidth();
            Rect rect = this.mScrollChildPosition;
            drawable2.setBounds(intrinsicWidth, rect.top, measuredWidth, rect.bottom);
            drawable2.draw(canvas);
        }
    }

    private boolean handleTouchDown(MotionEvent motionEvent, boolean z) {
        Rect rect = new Rect();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        ArrayList<r7> arrayList = this.mResizeFrames;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            r7 r7Var = arrayList.get(i);
            i++;
            r7 r7Var2 = r7Var;
            r7Var2.getHitRect(rect);
            if (rect.contains(x, y)) {
                int left = x - r7Var2.getLeft();
                int top = y - r7Var2.getTop();
                int i2 = r7Var2.D;
                boolean z2 = (i2 & 1) != 0;
                boolean z3 = (i2 & 2) != 0;
                int i3 = r7Var2.q;
                r7Var2.v = left < i3 && z2;
                r7Var2.w = left > r7Var2.getWidth() - i3 && z2;
                r7Var2.x = top < r7Var2.M + i3 && z3;
                boolean z4 = top > (r7Var2.getHeight() - i3) + r7Var2.N && z3;
                r7Var2.y = z4;
                boolean z5 = r7Var2.v || r7Var2.w || r7Var2.x || z4;
                r7Var2.z = r7Var2.getMeasuredWidth();
                r7Var2.A = r7Var2.getMeasuredHeight();
                r7Var2.B = r7Var2.getLeft();
                r7Var2.C = r7Var2.getTop();
                if (z5) {
                    r7Var2.k.setAlpha(r7Var2.v ? 1.0f : 0.0f);
                    r7Var2.l.setAlpha(r7Var2.w ? 1.0f : 0.0f);
                    r7Var2.m.setAlpha(r7Var2.x ? 1.0f : 0.0f);
                    r7Var2.n.setAlpha(r7Var2.y ? 1.0f : 0.0f);
                }
                if (z5) {
                    this.mCurrentResizeFrame = r7Var2;
                    this.mXDown = x;
                    this.mYDown = y;
                    requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            }
        }
        Folder openFolder = this.mLauncher.getWorkspace().getOpenFolder();
        if (openFolder != null && z) {
            if (openFolder.P && !isEventOverFolderTextRegion(openFolder, motionEvent)) {
                openFolder.B();
                return true;
            }
            if (!isEventOverFolder(openFolder, motionEvent) && !isOpenFloatingMenu()) {
                if (isInAccessibleDrag()) {
                    isEventOverDropTargetBar(motionEvent);
                    return !isEventOverDropTargetBar(motionEvent);
                }
                this.mLauncher.closeFolder();
                return true;
            }
        }
        return false;
    }

    private boolean handleTouchDownEditMenu(MotionEvent motionEvent, boolean z) {
        my editMenu = this.mLauncher.getEditMenu();
        if (editMenu == null || !isOpenEditMenu() || !z || isEventOverEditMenu(editMenu, motionEvent)) {
            return false;
        }
        this.mLauncher.closeEditMenu();
        return true;
    }

    private boolean handleTouchDownFloatingMenu(MotionEvent motionEvent, boolean z) {
        z30 floatingMenu = this.mLauncher.getFloatingMenu();
        if (floatingMenu == null || !isOpenFloatingMenu() || !z || isEventOverFloatingMenu(floatingMenu, motionEvent)) {
            return false;
        }
        this.mLauncher.closeFloatingMenu();
        return true;
    }

    private boolean isEventOverDropTargetBar(MotionEvent motionEvent) {
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private boolean isEventOverEditMenu(my myVar, MotionEvent motionEvent) {
        getDescendantRectRelativeToSelf(myVar, this.mHitRect);
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private boolean isEventOverFloatingMenu(z30 z30Var, MotionEvent motionEvent) {
        getDescendantRectRelativeToSelf(z30Var, this.mHitRect);
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private boolean isEventOverFolder(Folder folder, MotionEvent motionEvent) {
        getDescendantRectRelativeToSelf(folder, this.mHitRect);
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private boolean isEventOverFolderTextRegion(Folder folder, MotionEvent motionEvent) {
        getDescendantRectRelativeToSelf(folder.getEditTextRegion(), this.mHitRect);
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private boolean isInAccessibleDrag() {
        dk0 dk0Var = jk0.a().f;
        return (dk0Var == null || dk0Var.i == null) ? false : true;
    }

    private void sendTapOutsideFolderAccessibilityEvent(boolean z) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        int i = z ? w61.folder_tap_to_rename : w61.folder_tap_to_close;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(8);
        onInitializeAccessibilityEvent(accessibilityEventObtain);
        accessibilityEventObtain.getText().add(getContext().getString(i));
        accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
    }

    private void updateChildIndices() {
        this.mTopViewIndex = -1;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) instanceof zw) {
                this.mTopViewIndex = i;
            }
        }
        this.mChildCountOnLastUpdate = childCount;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
        if (this.mLauncher.isShaking()) {
            return;
        }
        Folder openFolder = this.mLauncher.getWorkspace().getOpenFolder();
        if (openFolder != null) {
            arrayList.add(openFolder);
        } else {
            super.addChildrenForAccessibility(arrayList);
        }
    }

    public void addResizeFrame(qh0 qh0Var, pk0 pk0Var, CellLayout cellLayout) {
        r7 r7Var = new r7(getContext(), pk0Var, cellLayout, this);
        pw pwVar = new pw(-1, -1);
        pwVar.d = true;
        addView(r7Var, pwVar);
        this.mResizeFrames.add(r7Var);
        r7Var.c(false);
    }

    public void animateView(zw zwVar, Rect rect, Rect rect2, float f, float f2, float f3, float f4, float f5, int i, Interpolator interpolator, Interpolator interpolator2, Runnable runnable, int i2, View view) {
        int iMax;
        float fHypot = (float) Math.hypot(rect2.left - rect.left, rect2.top - rect.top);
        Resources resources = getResources();
        float integer = resources.getInteger(g61.config_dropAnimMaxDist);
        if (i < 0) {
            int integer2 = resources.getInteger(g61.config_dropAnimMaxDuration);
            if (fHypot < integer) {
                integer2 = (int) (this.mCubicEaseOutInterpolator.getInterpolation(fHypot / integer) * integer2);
            }
            iMax = Math.max(integer2, resources.getInteger(g61.config_dropAnimMinDuration));
        } else {
            iMax = i;
        }
        animateView(zwVar, new b(this, zwVar, interpolator2, interpolator, f2, zwVar.getScaleX(), f3, f4, f5, f, zwVar.getAlpha(), rect, rect2), iMax, (interpolator2 == null || interpolator == null) ? this.mCubicEaseOutInterpolator : null, runnable, i2, view);
    }

    public void animateViewIntoPosition(zw zwVar, int[] iArr, float f, float f2, float f3, int i, Runnable runnable, int i2) {
        Rect rect = new Rect();
        getViewRectRelativeToSelf(zwVar, rect);
        animateViewIntoPosition(zwVar, rect.left, rect.top, iArr[0], iArr[1], f, 1.0f, 1.0f, f2, f3, runnable, i, i2, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        View view2 = this.mOverlayView;
        if (view != view2 && view2 != null) {
            view2.bringToFront();
        }
        updateChildIndices();
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof pw;
    }

    public void clearAllResizeFrames() {
        if (this.mResizeFrames.size() > 0) {
            ArrayList<r7> arrayList = this.mResizeFrames;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                r7 r7Var = arrayList.get(i);
                i++;
                r7 r7Var2 = r7Var;
                r7Var2.b(true);
                r7Var2.requestLayout();
                removeView(r7Var2);
            }
            this.mResizeFrames.clear();
        }
    }

    public void clearAnimatedView() {
        ValueAnimator valueAnimator = this.mDropAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        zw zwVar = this.mDropView;
        if (zwVar != null) {
            mw mwVar = this.mDragController;
            mwVar.getClass();
            if (zwVar.getParent() != null) {
                zwVar.m.removeView(zwVar);
            }
            if (mwVar.k.l) {
                ArrayList arrayList = new ArrayList(mwVar.m);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((lw) obj).t();
                }
            }
        }
        this.mDropView = null;
        invalidate();
    }

    public void dismissOverlayView() {
        removeView(this.mOverlayView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f = this.mBackgroundAlpha;
        if (f > 0.0f) {
            canvas.drawColor(((int) (f * 255.0f)) << 24);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mDragController.f || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        View view2 = this.mDragController.p;
        return view2 != null && view2.dispatchUnhandledMove(view, i);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (view instanceof Workspace) {
            drawPageHints(canvas);
        }
        return zDrawChild;
    }

    public View getAnimatedView() {
        return this.mDropView;
    }

    public float getBackgroundAlpha() {
        return this.mBackgroundAlpha;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mChildCountOnLastUpdate != i) {
            updateChildIndices();
        }
        int i3 = this.mTopViewIndex;
        if (i3 != -1) {
            if (i2 == i - 1) {
                return i3;
            }
            if (i2 >= i3) {
                return i2 + 1;
            }
        }
        return i2;
    }

    public float getDescendantCoordRelativeToSelf(View view, int[] iArr) {
        return getDescendantCoordRelativeToSelf(view, iArr, false);
    }

    public float getDescendantRectRelativeToSelf(View view, Rect rect) {
        int[] iArr = this.mTmpXY;
        iArr[0] = 0;
        iArr[1] = 0;
        float descendantCoordRelativeToSelf = getDescendantCoordRelativeToSelf(view, iArr);
        int[] iArr2 = this.mTmpXY;
        int i = iArr2[0];
        rect.set(i, iArr2[1], (int) ((view.getMeasuredWidth() * descendantCoordRelativeToSelf) + i), (int) ((view.getMeasuredHeight() * descendantCoordRelativeToSelf) + this.mTmpXY[1]));
        return descendantCoordRelativeToSelf;
    }

    public float getLocationInDragLayer(View view, int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        return getDescendantCoordRelativeToSelf(view, iArr);
    }

    public void getViewRectRelativeToSelf(View view, Rect rect) {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0] - i;
        int i4 = iArr[1] - i2;
        rect.set(i3, i4, view.getMeasuredWidth() + i3, view.getMeasuredHeight() + i4);
    }

    public boolean hasResizeFrames() {
        return this.mResizeFrames.size() > 0;
    }

    public void hidePageHints() {
        this.mShowPageHints = false;
        invalidate();
    }

    public boolean isDragWorkspaceOver() {
        return this.mWorkSpaceDragOver;
    }

    public boolean isOpenEditMenu() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) instanceof my) {
                return true;
            }
        }
        return false;
    }

    public boolean isOpenFloatingMenu() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) instanceof z30) {
                return true;
            }
        }
        return false;
    }

    public boolean isWidgetBeingResized() {
        return this.mCurrentResizeFrame != null;
    }

    public float mapCoordInSelfToDescendent(View view, int[] iArr) {
        Rect rect = ar1.a;
        ArrayList arrayList = new ArrayList();
        float[] fArr = {iArr[0], iArr[1]};
        while (view != this) {
            arrayList.add(view);
            view = (View) view.getParent();
        }
        arrayList.add(this);
        Matrix matrix = new Matrix();
        int size = arrayList.size() - 1;
        float scaleX = 1.0f;
        while (size >= 0) {
            View view2 = (View) arrayList.get(size);
            View view3 = size > 0 ? (View) arrayList.get(size - 1) : null;
            fArr[0] = fArr[0] + view2.getScrollX();
            fArr[1] = fArr[1] + view2.getScrollY();
            if (view3 != null) {
                fArr[0] = fArr[0] - view3.getLeft();
                fArr[1] = fArr[1] - view3.getTop();
                view3.getMatrix().invert(matrix);
                matrix.mapPoints(fArr);
                scaleX = view3.getScaleX() * scaleX;
            }
            size--;
        }
        iArr[0] = Math.round(fArr[0]);
        iArr[1] = Math.round(fArr[1]);
        return scaleX;
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        super.onChildViewAdded(view, view2);
        View view3 = this.mOverlayView;
        if (view3 != null) {
            view3.bringToFront();
        }
        updateChildIndices();
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        updateChildIndices();
    }

    public void onEnterScrollArea(int i) {
        this.mInScrollArea = true;
        invalidate();
    }

    public void onExitScrollArea() {
        this.mInScrollArea = false;
        invalidate();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        Folder openFolder;
        AccessibilityManager accessibilityManager;
        t tVar = this.mLauncher;
        if (tVar != null && tVar.getWorkspace() != null && (openFolder = this.mLauncher.getWorkspace().getOpenFolder()) != null && (accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility")) != null && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7) {
                boolean z = isEventOverFolder(openFolder, motionEvent) || (isInAccessibleDrag() && isEventOverDropTargetBar(motionEvent));
                if (!z && !this.mHoverPointClosesFolder) {
                    sendTapOutsideFolderAccessibilityEvent(openFolder.P);
                    this.mHoverPointClosesFolder = true;
                    return true;
                }
                if (!z) {
                    return true;
                }
                this.mHoverPointClosesFolder = false;
            } else if (action == 9) {
                if (isEventOverFolder(openFolder, motionEvent) || (isInAccessibleDrag() && isEventOverDropTargetBar(motionEvent))) {
                    this.mHoverPointClosesFolder = false;
                    return false;
                }
                sendTapOutsideFolderAccessibilityEvent(openFolder.P);
                this.mHoverPointClosesFolder = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (handleTouchDownFloatingMenu(motionEvent, true) || handleTouchDownEditMenu(motionEvent, true) || handleTouchDown(motionEvent, true)) {
                return true;
            }
        } else if (action == 1 || action == 3) {
            qw qwVar = this.mTouchCompleteListener;
            if (qwVar != null) {
                pk0 pk0Var = (pk0) qwVar;
                ld ldVar = pk0Var.h;
                if (!ldVar.a) {
                    ldVar.b();
                    pk0Var.removeCallbacks(pk0Var.B);
                    if (!pk0Var.j.showingFloatingMenu) {
                        pk0Var.a();
                    }
                }
            }
            this.mTouchCompleteListener = null;
        }
        if (hasResizeFrames()) {
            clearAllResizeFrames();
            return true;
        }
        this.mDragController.k(motionEvent);
        return this.mDragController.k(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
        } catch (Throwable th) {
            th = th;
        }
        try {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (layoutParams instanceof pw) {
                    pw pwVar = (pw) layoutParams;
                    if (pwVar.d) {
                        int i6 = pwVar.b;
                        int i7 = pwVar.c;
                        childAt.layout(i6, i7, ((FrameLayout.LayoutParams) pwVar).width + i6, ((FrameLayout.LayoutParams) pwVar).height + i7);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            th.getMessage();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        Folder openFolder = this.mLauncher.getWorkspace().getOpenFolder();
        if (openFolder == null) {
            return super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
        }
        if (view == openFolder) {
            return super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
        }
        if (isInAccessibleDrag() && (view instanceof SearchDropTargetBar)) {
            return super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        if (r0 != 3) goto L70;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.DragLayer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBackgroundAlpha(float f) {
        if (f != this.mBackgroundAlpha) {
            this.mBackgroundAlpha = f;
            invalidate();
        }
    }

    public void setTouchCompleteListener(qw qwVar) {
        this.mTouchCompleteListener = qwVar;
    }

    public void setWorkSpaceDragOver(boolean z) {
        this.mWorkSpaceDragOver = z;
    }

    public void setup(t tVar, mw mwVar) {
        this.mLauncher = tVar;
        this.mDragController = mwVar;
    }

    public void showOverlayView(View view) {
        pw pwVar = new pw(-1, -1);
        this.mOverlayView = view;
        addView(view, pwVar);
        this.mOverlayView.bringToFront();
    }

    public void showPageHints() {
        this.mShowPageHints = true;
        Workspace workspace = this.mLauncher.getWorkspace();
        getDescendantRectRelativeToSelf(workspace.getChildAt(workspace.R0()), this.mScrollChildPosition);
        invalidate();
    }

    public float getDescendantCoordRelativeToSelf(View view, int[] iArr, boolean z) {
        Rect rect = ar1.a;
        ArrayList arrayList = new ArrayList();
        float[] fArr = {iArr[0], iArr[1]};
        for (View view2 = view; view2 != this && view2 != null; view2 = (View) view2.getParent()) {
            arrayList.add(view2);
        }
        arrayList.add(this);
        int size = arrayList.size();
        float scaleX = 1.0f;
        for (int i = 0; i < size; i++) {
            View view3 = (View) arrayList.get(i);
            if (view3 != view || z) {
                fArr[0] = fArr[0] - view3.getScrollX();
                fArr[1] = fArr[1] - view3.getScrollY();
            }
            view3.getMatrix().mapPoints(fArr);
            fArr[0] = fArr[0] + view3.getLeft();
            fArr[1] = fArr[1] + view3.getTop();
            scaleX *= view3.getScaleX();
        }
        iArr[0] = Math.round(fArr[0]);
        iArr[1] = Math.round(fArr[1]);
        return scaleX;
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public pw generateDefaultLayoutParams() {
        return new pw(-2, -2);
    }

    public void animateViewIntoPosition(zw zwVar, View view, Runnable runnable, View view2) {
        animateViewIntoPosition(zwVar, view, -1, runnable, view2);
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public pw generateLayoutParams(AttributeSet attributeSet) {
        pw pwVar = new pw(getContext(), attributeSet);
        pwVar.d = false;
        return pwVar;
    }

    public void animateViewIntoPosition(zw zwVar, View view, int i, Runnable runnable, View view2) {
        int iRound;
        int iRound2;
        int measuredWidth;
        float intrinsicIconScaleFactor;
        ng1 ng1Var = (ng1) view.getParent();
        zg zgVar = (zg) view.getLayoutParams();
        if (ng1Var != null) {
            ng1Var.e(view);
        }
        Rect rect = new Rect();
        getViewRectRelativeToSelf(zwVar, rect);
        float scaleX = view.getScaleX();
        float f = 1.0f - scaleX;
        int[] iArr = {zgVar.k + ((int) ((view.getMeasuredWidth() * f) / 2.0f)), zgVar.l + ((int) ((view.getMeasuredHeight() * f) / 2.0f))};
        float descendantCoordRelativeToSelf = getDescendantCoordRelativeToSelf((View) view.getParent(), iArr) * scaleX;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (view instanceof TextView) {
            intrinsicIconScaleFactor = descendantCoordRelativeToSelf / zwVar.getIntrinsicIconScaleFactor();
            iRound = (int) ((Math.round(((TextView) view).getPaddingTop() * intrinsicIconScaleFactor) + i3) - (((1.0f - intrinsicIconScaleFactor) * zwVar.getMeasuredHeight()) / 2.0f));
            if (zwVar.getDragVisualizeOffset() != null) {
                iRound -= Math.round(zwVar.getDragVisualizeOffset().y * intrinsicIconScaleFactor);
            }
            measuredWidth = i2 - ((zwVar.getMeasuredWidth() - Math.round(descendantCoordRelativeToSelf * view.getMeasuredWidth())) / 2);
        } else {
            if (view instanceof FolderIcon) {
                iRound = (int) (((int) ((Math.round((view.getPaddingTop() - zwVar.getDragRegionTop()) * descendantCoordRelativeToSelf) + i3) - ((descendantCoordRelativeToSelf * 2.0f) / 2.0f))) - (((1.0f - descendantCoordRelativeToSelf) * zwVar.getMeasuredHeight()) / 2.0f));
                iRound2 = (zwVar.getMeasuredWidth() - Math.round(view.getMeasuredWidth() * descendantCoordRelativeToSelf)) / 2;
            } else {
                iRound = i3 - (Math.round((zwVar.getHeight() - view.getMeasuredHeight()) * descendantCoordRelativeToSelf) / 2);
                iRound2 = Math.round((zwVar.getMeasuredWidth() - view.getMeasuredWidth()) * descendantCoordRelativeToSelf) / 2;
            }
            measuredWidth = i2 - iRound2;
            intrinsicIconScaleFactor = descendantCoordRelativeToSelf;
        }
        int i4 = iRound;
        int i5 = rect.left;
        int i6 = rect.top;
        view.setVisibility(4);
        animateViewIntoPosition(zwVar, i5, i6, measuredWidth, i4, 1.0f, 1.0f, 1.0f, intrinsicIconScaleFactor, intrinsicIconScaleFactor, new w1(view, runnable, 11), 0, i, view2);
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public pw generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        pw pwVar = new pw(layoutParams);
        pwVar.d = false;
        return pwVar;
    }

    public void animateView(zw zwVar, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, int i, TimeInterpolator timeInterpolator, Runnable runnable, int i2, View view) {
        ValueAnimator valueAnimator = this.mDropAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mDropView = zwVar;
        ValueAnimator valueAnimator2 = zwVar.o;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            valueAnimator2.cancel();
        }
        zw zwVar2 = this.mDropView;
        zwVar2.q = 0.0f;
        zwVar2.p = 0.0f;
        zwVar2.requestLayout();
        if (view != null) {
            this.mAnchorViewInitialScrollX = view.getScrollX();
        }
        this.mAnchorView = view;
        ValueAnimator valueAnimator3 = new ValueAnimator();
        this.mDropAnim = valueAnimator3;
        valueAnimator3.setInterpolator(timeInterpolator);
        this.mDropAnim.setDuration(i);
        this.mDropAnim.setFloatValues(0.0f, 1.0f);
        this.mDropAnim.addUpdateListener(animatorUpdateListener);
        this.mDropAnim.addListener(new ow(this, runnable, i2));
        this.mDropAnim.start();
    }

    public void animateViewIntoPosition(zw zwVar, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4, float f5, Runnable runnable, int i5, int i6, View view) {
        animateView(zwVar, new Rect(i, i2, zwVar.getMeasuredWidth() + i, zwVar.getMeasuredHeight() + i2), new Rect(i3, i4, zwVar.getMeasuredWidth() + i3, zwVar.getMeasuredHeight() + i4), f, f2, f3, f4, f5, i6, null, null, runnable, i5, view);
    }
}
