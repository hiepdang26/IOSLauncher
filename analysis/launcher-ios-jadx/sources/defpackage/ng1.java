package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.t;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ng1 extends ViewGroup {
    public int[] A;
    public final int[] g;
    public final WallpaperManager h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public final t o;
    public final xu p;
    public Boolean q;
    public boolean r;
    public final HashMap s;
    public final HashMap t;
    public boolean u;
    public final float[] v;
    public final float[] w;
    public final float[] x;
    public final HashMap y;
    public AnimatorSet z;

    public ng1(Context context) {
        super(context);
        this.g = new int[2];
        this.q = Boolean.FALSE;
        this.r = false;
        this.s = new HashMap();
        this.t = new HashMap();
        this.u = false;
        this.v = new float[]{-9.0f, -3.0f, 6.0f, 12.0f, -10.0f, -2.0f, 5.0f, 13.0f, -13.0f, -3.0f, 6.0f, 16.0f, -17.0f, -6.0f, 9.0f, 20.0f, -22.0f, -9.0f, 12.0f, 25.0f, -28.0f, -12.0f, 15.0f, 31.0f};
        this.w = new float[]{-12.0f, -10.0f, -10.0f, -12.0f, -1.0f, -3.5f, -3.5f, -1.0f, 10.0f, 6.0f, 6.0f, 10.0f, 28.0f, 25.0f, 25.0f, 28.0f, 45.0f, 40.0f, 40.0f, 45.0f, 55.0f, 50.0f, 50.0f, 55.0f};
        this.x = new float[]{6.0f, 6.0f, 6.0f, 6.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 10.0f, 10.0f, 8.0f, 10.0f, 10.0f, 10.0f, 10.0f, 13.0f, 13.0f, 13.0f, 13.0f, 15.0f, 15.0f, 15.0f, 15.0f};
        this.y = new HashMap();
        this.A = new int[2];
        setClipChildren(false);
        setClipToPadding(false);
        t tVar = (t) context;
        this.o = tVar;
        this.p = tVar.getDeviceProfile();
        this.h = WallpaperManager.getInstance(context);
        this.z = ik0.a();
    }

    private void setPivotsForZoom(View view) {
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
    }

    public final void a() {
        this.q = Boolean.FALSE;
        kg1 kg1Var = new kg1(this, 2);
        if (getMeasuredWidth() == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new lg1(this, kg1Var, 1));
        } else {
            kg1Var.run();
        }
    }

    public final View b(int i, int i2) {
        int i3;
        try {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                zg zgVar = (zg) childAt.getLayoutParams();
                int i5 = zgVar.a;
                if (i5 <= i && i < i5 + zgVar.f && (i3 = zgVar.b) <= i2 && i2 < i3 + zgVar.g) {
                    return childAt;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void c() {
        if (this.i || (getChildAt(0) instanceof wq)) {
            return;
        }
        int i = 0;
        while (true) {
            int childCount = getChildCount();
            HashMap map = this.y;
            if (i >= childCount) {
                map.size();
                return;
            }
            View childAt = getChildAt(i);
            if ((childAt instanceof BubbleTextView) || (childAt instanceof FolderIcon)) {
                Object tag = childAt.getTag();
                if (tag instanceof qh0) {
                    qh0 qh0Var = (qh0) tag;
                    int i2 = (qh0Var.l * this.p.a.d) + qh0Var.k;
                    PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, this.l * this.v[i2], 0.0f);
                    PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, this.m * this.w[i2], 0.0f);
                    float[] fArr = this.x;
                    ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(childAt, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, fArr[i2], 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, fArr[i2], 1.0f));
                    objectAnimatorOfPropertyValuesHolder.setDuration(866L);
                    map.put(childAt, objectAnimatorOfPropertyValuesHolder);
                }
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).cancelLongPress();
        }
    }

    public final boolean d() {
        return this.u && ar1.v(getResources());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.l == 0 && this.m == 0) {
            int measuredWidth = getMeasuredWidth();
            xu xuVar = this.p;
            this.l = measuredWidth / xuVar.a.d;
            this.m = getMeasuredHeight() / xuVar.a.c;
        }
    }

    public final void e(View view) {
        int i = this.j;
        int i2 = this.k;
        zg zgVar = (zg) view.getLayoutParams();
        if (zgVar.i) {
            zgVar.k = 0;
            zgVar.l = 0;
            ((ViewGroup.MarginLayoutParams) zgVar).width = getMeasuredWidth();
            ((ViewGroup.MarginLayoutParams) zgVar).height = getMeasuredHeight();
        } else {
            zgVar.a(d(), i, i2, this.n);
            if (!(view instanceof pk0)) {
                int i3 = (int) (this.p.t / 2.0f);
                view.setPadding(i3, 0, i3, 0);
            }
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) zgVar).width, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) zgVar).height, 1073741824));
    }

    public final void f() {
        HashMap map = this.y;
        if (map.isEmpty()) {
            this.r = false;
            return;
        }
        this.z.setInterpolator(new PathInterpolator(0.0f, 1.01f, 0.0f, 1.01f));
        this.z.playTogether(map.values());
        this.z.addListener(new be(this, 16));
        this.z.start();
    }

    public final void g() {
        this.r = true;
        if (this.y.size() != getChildCount()) {
            c();
        }
        this.z = ik0.a();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof BubbleTextView) || (childAt instanceof FolderIcon)) {
                Object tag = childAt.getTag();
                if (tag instanceof qh0) {
                    qh0 qh0Var = (qh0) tag;
                    int i2 = (qh0Var.l * this.p.a.d) + qh0Var.k;
                    childAt.setTranslationX(this.l * this.v[i2]);
                    childAt.setTranslationY(this.m * this.w[i2]);
                    float[] fArr = this.x;
                    childAt.setScaleX(fArr[i2]);
                    childAt.setScaleY(fArr[i2]);
                }
            }
        }
    }

    public int getCellContentHeight() {
        int measuredHeight = getMeasuredHeight();
        boolean z = this.i;
        xu xuVar = this.p;
        return Math.min(measuredHeight, z ? xuVar.Q : xuVar.I);
    }

    public int getCellContentWidth() {
        int measuredHeight = getMeasuredHeight();
        boolean z = this.i;
        xu xuVar = this.p;
        return Math.min(measuredHeight, z ? xuVar.P : xuVar.H);
    }

    public final float h(View view) {
        float width;
        double dRandom;
        if (view instanceof pk0) {
            width = view.getWidth();
            dRandom = Math.random();
        } else {
            int i = this.l;
            if (i == 0) {
                i = this.p.H;
            }
            width = i;
            dRandom = Math.random();
        }
        return ((((float) dRandom) * 0.38f) + 0.3f) * width;
    }

    public final float i(View view) {
        float height;
        float fRandom;
        float f;
        if (view instanceof pk0) {
            height = view.getHeight();
            fRandom = ((float) Math.random()) * 0.38f;
            f = 0.3f;
        } else {
            int i = this.m;
            if (i == 0) {
                i = this.p.I;
            }
            height = i;
            fRandom = ((float) Math.random()) * 0.38f;
            f = 0.36f;
        }
        return (fRandom + f) * height;
    }

    public final void j(int i, int i2, int i3, int i4) {
        this.j = i;
        this.k = i2;
        this.n = i3;
    }

    public final void k() {
        this.q = Boolean.TRUE;
        kg1 kg1Var = new kg1(this, 1);
        if (getMeasuredWidth() == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new lg1(this, kg1Var, 0));
        } else {
            kg1Var.run();
        }
    }

    public final void l(View view) {
        if (view instanceof BubbleTextView) {
            ((BubbleTextView) view).y();
        } else if (view instanceof pk0) {
            ((pk0) view).c();
        }
        HashMap map = this.s;
        if (map.get(view) == null || ((ValueAnimator) map.get(view)).isRunning()) {
            return;
        }
        ((ValueAnimator) map.get(view)).start();
    }

    public final void m(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Objects.toString(childAt);
            if (childAt instanceof BubbleTextView) {
                BubbleTextView bubbleTextView = (BubbleTextView) childAt;
                if (bubbleTextView.getIconView() != null) {
                    bubbleTextView.getIconView().setTint(i);
                }
            } else if (childAt instanceof FolderIcon) {
                FolderIcon folderIcon = (FolderIcon) childAt;
                Folder folder = folderIcon.getFolder();
                folder.getClass();
                for (int i3 = 0; i3 < folder.r.getChildCount(); i3++) {
                    try {
                        ((CellLayout) folder.r.getChildAt(i3)).getShortcutsAndWidgets().m(i);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                folderIcon.postInvalidateOnAnimation();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        getMeasuredHeight();
        int[] iArr = this.g;
        getLocationOnScreen(iArr);
        int[] iArr2 = this.A;
        if (iArr2[0] != 0 && iArr2[1] != 0) {
            this.A = iArr;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                zg zgVar = (zg) childAt.getLayoutParams();
                int i6 = zgVar.k;
                int i7 = zgVar.l;
                childAt.layout(i6, i7, ((ViewGroup.MarginLayoutParams) zgVar).width + i6, ((ViewGroup.MarginLayoutParams) zgVar).height + i7);
                if (zgVar.m) {
                    zgVar.m = false;
                    this.h.sendWallpaperCommand(getWindowToken(), "android.home.drop", (((ViewGroup.MarginLayoutParams) zgVar).width / 2) + iArr[0] + i6, (((ViewGroup.MarginLayoutParams) zgVar).height / 2) + iArr[1] + i7, 0, null);
                }
            }
        }
        int measuredWidth = getMeasuredWidth();
        xu xuVar = this.p;
        this.l = measuredWidth / xuVar.a.d;
        int measuredHeight = getMeasuredHeight() / xuVar.a.c;
        this.m = measuredHeight;
        if (this.l == 0 && measuredHeight == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new lg(this, 3));
        } else {
            c();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        try {
            int childCount = getChildCount();
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    e(childAt);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        boolean z = view instanceof BubbleTextView;
        if (z || (view instanceof FolderIcon) || (view instanceof pk0)) {
            t tVar = this.o;
            if (tVar.isUseLiquidGlass && !tVar.isRuntimeRenderSupport && (view instanceof FolderIcon) && this.i) {
                ((FolderIcon) view).i();
            }
            boolean z2 = view instanceof pk0;
            ObjectAnimator objectAnimatorD = ik0.d(view, PropertyValuesHolder.ofFloat("pivotX", h(view), h(view)), PropertyValuesHolder.ofFloat("pivotY", i(view), i(view)), PropertyValuesHolder.ofFloat(Key.ROTATION, ((3.1415927f / (z2 ? 6.0f : 2.0f)) * (-1.0f)) + ((float) (Math.random() * ((double) (z2 ? 0.1f : 0.6f)))), (3.1415927f / (z2 ? 6.0f : 2.0f)) + ((float) (((double) (z2 ? 0.1f : 0.6f)) * Math.random()))));
            objectAnimatorD.setDuration((long) ((Math.random() * 36.0d) + 113.0d));
            objectAnimatorD.setRepeatCount(-1);
            objectAnimatorD.setRepeatMode(2);
            objectAnimatorD.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorD.addListener(new mg1(0, view));
            this.s.put(view, objectAnimatorD);
            if (this.q.booleanValue()) {
                objectAnimatorD.start();
                if (z) {
                    ((BubbleTextView) view).y();
                }
                if (z2) {
                    ((pk0) view).c();
                }
            }
            HashMap map = this.t;
            ObjectAnimator objectAnimatorD2 = ik0.d(view, PropertyValuesHolder.ofFloat("pivotX", this.l / 2.0f), PropertyValuesHolder.ofFloat("pivotY", this.m / 2.0f), PropertyValuesHolder.ofFloat(Key.ROTATION, 0.0f));
            objectAnimatorD2.setDuration(100L);
            objectAnimatorD2.addListener(new mg1(1, view));
            map.put(view, objectAnimatorD2);
            if (this.i || (getChildAt(0) instanceof wq)) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof qh0) {
                qh0 qh0Var = (qh0) tag;
                int i = qh0Var.k;
                int i2 = qh0Var.l;
                xu xuVar = this.p;
                int i3 = (i2 * xuVar.a.d) + i;
                if (this.l == 0 && this.m == 0) {
                    int measuredWidth = getMeasuredWidth();
                    xg0 xg0Var = xuVar.a;
                    this.l = measuredWidth / xg0Var.d;
                    this.m = getMeasuredHeight() / xg0Var.c;
                }
                PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, this.l * this.v[i3], 0.0f);
                PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, this.m * this.w[i3], 0.0f);
                float[] fArr = this.x;
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, fArr[i3], 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, fArr[i3], 1.0f));
                objectAnimatorOfPropertyValuesHolder.setDuration(866L);
                this.y.put(view, objectAnimatorOfPropertyValuesHolder);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((view instanceof BubbleTextView) || (view instanceof FolderIcon)) {
            boolean zBooleanValue = this.q.booleanValue();
            HashMap map = this.t;
            HashMap map2 = this.s;
            if (zBooleanValue) {
                ((ValueAnimator) map2.get(view)).end();
                ((ValueAnimator) map.get(view)).start();
            }
            map2.remove(view);
            map.remove(view);
            this.y.remove(view);
        }
        postOnAnimationDelayed(new kg1(this, 0), 168L);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (view != null) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            requestRectangleOnScreen(rect);
        }
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawingCacheEnabled(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.setDrawingCacheEnabled(z);
            if (!childAt.isHardwareAccelerated() && z) {
                childAt.buildDrawingCache(true);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawnWithCacheEnabled(boolean z) {
        super.setChildrenDrawnWithCacheEnabled(z);
    }

    public void setIconTextColor(int i) {
        try {
            for (View view : this.s.keySet()) {
                Objects.toString(view);
                if (view instanceof BubbleTextView) {
                    ((BubbleTextView) view).setTextColor(i);
                } else if (view instanceof FolderIcon) {
                    FolderIcon folderIcon = (FolderIcon) view;
                    folderIcon.setTextColor(i);
                    Folder folder = folderIcon.h;
                    if (folder != null && folder.r != null) {
                        for (int i2 = 0; i2 < folder.r.getChildCount(); i2++) {
                            ((CellLayout) folder.r.getChildAt(i2)).getShortcutsAndWidgets().setIconTextColor(i);
                        }
                    }
                } else if (view instanceof pk0) {
                    ((pk0) view).setTextColor(i);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void setInvertIfRtl(boolean z) {
        this.u = z;
    }

    public void setIsHotseat(boolean z) {
        this.i = z;
    }

    public void setIsShaking(boolean z) {
        this.q = Boolean.valueOf(z);
    }

    public void setupLp(zg zgVar) {
        zgVar.a(d(), this.j, this.k, this.n);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
