package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.DragLayer;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class r7 extends FrameLayout implements View.OnKeyListener {
    public static final Rect O = new Rect();
    public int A;
    public int B;
    public int C;
    public final int D;
    public int E;
    public int F;
    public final int G;
    public final int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public final t g;
    public final pk0 h;
    public final CellLayout i;
    public final DragLayer j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;
    public final Rect o;
    public final int p;
    public final int q;
    public final int[] r;
    public final int[] s;
    public final int[] t;
    public final ax u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    public r7(Context context, pk0 pk0Var, CellLayout cellLayout, DragLayer dragLayer) {
        super(context);
        this.r = new int[2];
        this.s = new int[2];
        this.t = new int[2];
        this.M = 0;
        this.N = 0;
        this.g = (t) context;
        this.i = cellLayout;
        this.h = pk0Var;
        rk0 rk0Var = (rk0) pk0Var.getAppWidgetInfo();
        int i = ((AppWidgetProviderInfo) rk0Var).resizeMode;
        this.D = i;
        this.j = dragLayer;
        this.G = rk0Var.i;
        this.H = rk0Var.j;
        this.u = ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled() ? new ax(0, this) : null;
        setForeground(getResources().getDrawable(l51.widget_resize_frame_new));
        setPadding(0, 0, 0, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e51.widget_handle_margin);
        ImageView imageView = new ImageView(context);
        this.k = imageView;
        imageView.setImageResource(l51.ic_widget_resize_handle);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 19);
        layoutParams.leftMargin = dimensionPixelSize;
        addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.l = imageView2;
        imageView2.setImageResource(l51.ic_widget_resize_handle);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 21);
        layoutParams2.rightMargin = dimensionPixelSize;
        addView(imageView2, layoutParams2);
        ImageView imageView3 = new ImageView(context);
        this.m = imageView3;
        imageView3.setImageResource(l51.ic_widget_resize_handle);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2, 49);
        layoutParams3.topMargin = dimensionPixelSize;
        addView(imageView3, layoutParams3);
        ImageView imageView4 = new ImageView(context);
        this.n = imageView4;
        imageView4.setImageResource(l51.ic_widget_resize_handle);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 81);
        layoutParams4.bottomMargin = dimensionPixelSize;
        addView(imageView4, layoutParams4);
        this.o = AppWidgetHostView.getDefaultPaddingForWidget(context, pk0Var.getAppWidgetInfo().provider, null);
        if (i == 1) {
            imageView3.setVisibility(8);
            imageView4.setVisibility(8);
        } else if (i == 2) {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(e51.resize_frame_background_padding);
        this.p = dimensionPixelSize2;
        this.q = dimensionPixelSize2 * 3;
        cellLayout.w(pk0Var);
        setOnKeyListener(this);
    }

    public static void a(t tVar, int i, int i2, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        Rect rectA0 = Workspace.A0(0, tVar);
        Rect rectA02 = Workspace.A0(1, tVar);
        float f = tVar.getResources().getDisplayMetrics().density;
        int i3 = rectA0.left;
        int i4 = rectA0.top;
        int i5 = i - 1;
        int i6 = (int) (((rectA0.right * i5) + (i3 * i)) / f);
        int i7 = i2 - 1;
        int i8 = (int) (((rectA0.bottom * i7) + (i4 * i2)) / f);
        int i9 = rectA02.left;
        int i10 = rectA02.top;
        rect.set((int) (((i5 * rectA02.right) + (i * i9)) / f), i8, i6, (int) (((i7 * rectA02.bottom) + (i2 * i10)) / f));
    }

    public static void d(int i, int i2, AppWidgetHostView appWidgetHostView, t tVar) {
        Rect rect = O;
        a(tVar, i, i2, rect);
        appWidgetHostView.updateAppWidgetSize(null, rect.left, rect.top, rect.right, rect.bottom);
        appWidgetHostView.setPadding(0, 0, 0, 0);
    }

    public final void b(boolean z) {
        int iMin;
        int i;
        int i2;
        int iMin2;
        CellLayout cellLayout = this.i;
        int widthGap = cellLayout.getWidthGap() + cellLayout.getCellWidth();
        int heightGap = cellLayout.getHeightGap() + cellLayout.getCellHeight();
        int i3 = this.I + this.K;
        float f = ((i3 * 1.0f) / widthGap) - this.E;
        float f2 = (((this.J + this.L) * 1.0f) / heightGap) - this.F;
        int countX = cellLayout.getCountX();
        int countY = cellLayout.getCountY();
        int iRound = Math.abs(f) > 0.66f ? Math.round(f) : 0;
        int iRound2 = Math.abs(f2) > 0.66f ? Math.round(f2) : 0;
        if (!z && iRound == 0 && iRound2 == 0) {
            return;
        }
        pk0 pk0Var = this.h;
        zg zgVar = (zg) pk0Var.getLayoutParams();
        int i4 = zgVar.f;
        int i5 = zgVar.g;
        boolean z2 = zgVar.e;
        int i6 = z2 ? zgVar.c : zgVar.a;
        int i7 = z2 ? zgVar.d : zgVar.b;
        boolean z3 = this.v;
        int i8 = this.G;
        if (z3) {
            iMin = Math.min(zgVar.f - i8, Math.max(-i6, iRound));
            iRound = Math.max(-(zgVar.f - i8), Math.min(i6, iRound * (-1)));
            i = -iRound;
        } else if (this.w) {
            iRound = Math.max(-(zgVar.f - i8), Math.min(countX - (i6 + i4), iRound));
            i = iRound;
            iMin = 0;
        } else {
            iMin = 0;
            i = 0;
        }
        boolean z4 = this.x;
        int i9 = this.H;
        if (z4) {
            iMin2 = Math.min(zgVar.g - i9, Math.max(-i7, iRound2));
            iRound2 = Math.max(-(zgVar.g - i9), Math.min(i7, iRound2 * (-1)));
            i2 = -iRound2;
        } else {
            if (this.y) {
                iRound2 = Math.max(-(zgVar.g - i9), Math.min(countY - (i7 + i5), iRound2));
                i2 = iRound2;
            } else {
                i2 = 0;
            }
            iMin2 = 0;
        }
        int[] iArr = this.r;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean z5 = this.v;
        if (z5 || this.w) {
            i4 += iRound;
            i6 += iMin;
            if (i != 0) {
                iArr[0] = z5 ? -1 : 1;
            }
        }
        int i10 = i4;
        int i11 = i6;
        boolean z6 = this.x;
        if (z6 || this.y) {
            i5 += iRound2;
            i7 += iMin2;
            if (i2 != 0) {
                iArr[1] = z6 ? -1 : 1;
            }
        }
        int i12 = i5;
        int i13 = i7;
        if (!z && i2 == 0 && i == 0) {
            return;
        }
        int[] iArr2 = this.s;
        if (z) {
            iArr[0] = iArr2[0];
            iArr[1] = iArr2[1];
        } else {
            iArr2[0] = iArr[0];
            iArr2[1] = iArr[1];
        }
        if (this.i.m(i11, i13, i10, i12, this.h, iArr, z)) {
            t tVar = this.g;
            ax axVar = this.u;
            if (axVar != null && (zgVar.f != i10 || zgVar.g != i12)) {
                axVar.a(tVar.getString(w61.widget_resized, Integer.valueOf(i10), Integer.valueOf(i12)));
            }
            zgVar.c = i11;
            zgVar.d = i13;
            zgVar.f = i10;
            zgVar.g = i12;
            this.F += i2;
            this.E += i;
            if (!z) {
                d(i10, i12, pk0Var, tVar);
            }
        }
        pk0Var.requestLayout();
    }

    public final void c(boolean z) {
        pw pwVar = (pw) getLayoutParams();
        pk0 pk0Var = this.h;
        int width = pk0Var.getWidth();
        int i = this.p;
        int i2 = i * 2;
        Rect rect = this.o;
        int i3 = ((width + i2) - rect.left) - rect.right;
        int height = ((pk0Var.getHeight() + i2) - rect.top) - rect.bottom;
        int left = pk0Var.getLeft();
        int[] iArr = this.t;
        int i4 = 0;
        iArr[0] = left;
        iArr[1] = pk0Var.getTop();
        ng1 shortcutsAndWidgets = this.i.getShortcutsAndWidgets();
        DragLayer dragLayer = this.j;
        dragLayer.getDescendantCoordRelativeToSelf(shortcutsAndWidgets, iArr);
        int i5 = (iArr[0] - i) + rect.left;
        int i6 = (iArr[1] - i) + rect.top;
        if (i6 < 0) {
            this.M = -i6;
        } else {
            this.M = 0;
        }
        int i7 = i6 + height;
        if (i7 > dragLayer.getHeight()) {
            this.N = -(i7 - dragLayer.getHeight());
        } else {
            this.N = 0;
        }
        ImageView imageView = this.n;
        ImageView imageView2 = this.m;
        ImageView imageView3 = this.l;
        ImageView imageView4 = this.k;
        if (z) {
            PropertyValuesHolder[] propertyValuesHolderArr = {PropertyValuesHolder.ofInt("width", ((FrameLayout.LayoutParams) pwVar).width, i3), PropertyValuesHolder.ofInt("height", ((FrameLayout.LayoutParams) pwVar).height, height), PropertyValuesHolder.ofInt("x", pwVar.b, i5), PropertyValuesHolder.ofInt("y", pwVar.c, i6)};
            WeakHashMap weakHashMap = ik0.a;
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setTarget(pwVar);
            objectAnimator.setValues(propertyValuesHolderArr);
            objectAnimator.addListener(ik0.b);
            new b30(objectAnimator, this);
            ObjectAnimator objectAnimatorB = ik0.b(imageView4, Key.ALPHA, 1.0f);
            ObjectAnimator objectAnimatorB2 = ik0.b(imageView3, Key.ALPHA, 1.0f);
            ObjectAnimator objectAnimatorB3 = ik0.b(imageView2, Key.ALPHA, 1.0f);
            ObjectAnimator objectAnimatorB4 = ik0.b(imageView, Key.ALPHA, 1.0f);
            objectAnimator.addUpdateListener(new q7(this, i4));
            AnimatorSet animatorSetA = ik0.a();
            int i8 = this.D;
            if (i8 == 2) {
                animatorSetA.playTogether(objectAnimator, objectAnimatorB3, objectAnimatorB4);
            } else if (i8 == 1) {
                animatorSetA.playTogether(objectAnimator, objectAnimatorB, objectAnimatorB2);
            } else {
                animatorSetA.playTogether(objectAnimator, objectAnimatorB, objectAnimatorB2, objectAnimatorB3, objectAnimatorB4);
            }
            animatorSetA.setDuration(150L);
            animatorSetA.start();
        } else {
            ((FrameLayout.LayoutParams) pwVar).width = i3;
            ((FrameLayout.LayoutParams) pwVar).height = height;
            pwVar.b = i5;
            pwVar.c = i6;
            imageView4.setAlpha(1.0f);
            imageView3.setAlpha(1.0f);
            imageView2.setAlpha(1.0f);
            imageView.setAlpha(1.0f);
            requestLayout();
        }
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public final void e(int i, int i2) {
        boolean z = this.v;
        DragLayer dragLayer = this.j;
        int i3 = this.q;
        if (z) {
            int iMax = Math.max(-this.B, i);
            this.I = iMax;
            this.I = Math.min(this.z - (i3 * 2), iMax);
        } else if (this.w) {
            int iMin = Math.min(dragLayer.getWidth() - (this.B + this.z), i);
            this.I = iMin;
            this.I = Math.max((i3 * 2) + (-this.z), iMin);
        }
        if (this.x) {
            int iMax2 = Math.max(-this.C, i2);
            this.J = iMax2;
            this.J = Math.min(this.A - (i3 * 2), iMax2);
        } else if (this.y) {
            int iMin2 = Math.min(dragLayer.getHeight() - (this.C + this.A), i2);
            this.J = iMin2;
            this.J = Math.max((i3 * 2) + (-this.A), iMin2);
        }
        pw pwVar = (pw) getLayoutParams();
        if (this.v) {
            int i4 = this.B;
            int i5 = this.I;
            pwVar.b = i4 + i5;
            ((FrameLayout.LayoutParams) pwVar).width = this.z - i5;
        } else if (this.w) {
            ((FrameLayout.LayoutParams) pwVar).width = this.z + this.I;
        }
        if (this.x) {
            int i6 = this.C;
            int i7 = this.J;
            pwVar.c = i6 + i7;
            ((FrameLayout.LayoutParams) pwVar).height = this.A - i7;
        } else if (this.y) {
            ((FrameLayout.LayoutParams) pwVar).height = this.A + this.J;
        }
        b(false);
        requestLayout();
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (!np1.H(i)) {
            return false;
        }
        this.j.clearAllResizeFrames();
        this.h.requestFocus();
        return true;
    }
}
