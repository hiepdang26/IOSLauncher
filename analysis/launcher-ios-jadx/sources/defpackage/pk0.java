package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RemoteViews;
import androidx.constraintlayout.motion.widget.Key;
import androidx.profileinstaller.ProfileVerifier;
import com.luutinhit.launcher6.DragLayer;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.DeleteCircleView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class pk0 extends AppWidgetHostView implements qw {
    public final ObjectAnimator A;
    public final ok0 B;
    public final LayoutInflater g;
    public final ld h;
    public final jd i;
    public final t j;
    public final xu k;
    public int l;
    public final DragLayer m;
    public final DeleteCircleView n;
    public final TextViewCustomFont o;
    public int p;
    public int q;
    public float r;
    public boolean s;
    public String t;
    public final Paint u;
    public final Path v;
    public float w;
    public int[] x;
    public boolean y;
    public final ObjectAnimator z;

    public pk0(Context context) {
        super(context);
        this.u = new Paint(1);
        this.v = new Path();
        new RectF();
        this.y = false;
        this.B = new ok0(this, 0);
        t tVar = (t) context;
        this.j = tVar;
        this.k = tVar.getDeviceProfile();
        TextViewCustomFont textViewCustomFont = new TextViewCustomFont(context);
        this.o = textViewCustomFont;
        this.n = new DeleteCircleView(getContext(), null);
        this.w = context.getResources().getDimensionPixelSize(e51.widget_round_corner);
        this.p = tVar.mDeviceProfile.F;
        this.h = new ld(this);
        this.i = new jd(this);
        this.g = (LayoutInflater) context.getSystemService("layout_inflater");
        DragLayer dragLayer = ((t) context).getDragLayer();
        this.m = dragLayer;
        setAccessibilityDelegate(jk0.a().f);
        ObjectAnimator objectAnimatorD = ik0.d(this, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f, 0.98f, 1.05f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 0.98f, 1.05f));
        objectAnimatorD.addListener(new be(this, 12));
        objectAnimatorD.setDuration(368L);
        this.z = objectAnimatorD;
        ObjectAnimator objectAnimatorD2 = ik0.d(this, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f));
        objectAnimatorD2.addListener(new ce(1));
        objectAnimatorD2.setDuration(268L);
        this.A = objectAnimatorD2;
        setClipToPadding(false);
        setClipChildren(false);
        setClipToOutline(false);
        dragLayer.setClipChildren(false);
        dragLayer.setClipToPadding(false);
        dragLayer.setClipToOutline(false);
        setLayoutParams(new pw(-2, -2));
        textViewCustomFont.setTextSize(1, 11.0f);
        textViewCustomFont.setTextAlignment(4);
        textViewCustomFont.setTextColor(tVar.mIconTextColor);
        textViewCustomFont.setSingleLine();
        textViewCustomFont.setEllipsize(TextUtils.TruncateAt.END);
        textViewCustomFont.setShadowLayer(10.0f, 0.0f, 0.0f, 1291845632);
        pw pwVar = new pw(-1, -2);
        ((FrameLayout.LayoutParams) pwVar).gravity = 80;
        addView(textViewCustomFont, 0, pwVar);
        textViewCustomFont.measure(0, 0);
    }

    private int[] getLocationIconViewOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return iArr;
    }

    public final void a() {
        if (this.z.isRunning()) {
            this.z.cancel();
        }
        if (this.y) {
            this.A.start();
        }
    }

    public boolean b() {
        return this.l != this.j.getResources().getConfiguration().orientation;
    }

    public final void c() {
        DeleteCircleView deleteCircleView = this.n;
        Objects.toString(deleteCircleView);
        if (deleteCircleView != null) {
            post(new nk0(this, 1));
        }
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        this.h.b();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void clearChildFocus(View view) {
        super.clearChildFocus(view);
        setSelected(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.s || keyEvent.getKeyCode() != 111 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.s = false;
        requestFocus();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        int action = motionEvent.getAction();
        ok0 ok0Var = this.B;
        t tVar = this.j;
        if (action == 0) {
            tVar.isShaking();
            if (!tVar.isShaking()) {
                this.y = false;
                this.x = getLocationIconViewOnScreen();
                postDelayed(ok0Var, ViewConfiguration.getTapTimeout() + 200);
            }
        } else if (action == 1 || action == 3) {
            removeCallbacks(ok0Var);
            if (!tVar.showingFloatingMenu) {
                a();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchUnhandledMove(View view, int i) {
        return this.s;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        Objects.toString(view);
        if ((view instanceof TextViewCustomFont) || (view instanceof DeleteCircleView)) {
            return super.drawChild(canvas, view, j);
        }
        canvas.save();
        int i = Build.VERSION.SDK_INT;
        Path path = this.v;
        if (i >= 26) {
            canvas.clipOutPath(path);
        } else {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return zDrawChild;
    }

    @Override // android.appwidget.AppWidgetHostView
    public AppWidgetProviderInfo getAppWidgetInfo() {
        AppWidgetProviderInfo appWidgetInfo = super.getAppWidgetInfo();
        if (appWidgetInfo == null || (appWidgetInfo instanceof rk0)) {
            return appWidgetInfo;
        }
        throw new IllegalStateException("Launcher widget must have LauncherAppWidgetProviderInfo");
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        if (this.s) {
            return ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ;
        }
        return 393216;
    }

    @Override // android.appwidget.AppWidgetHostView
    public View getErrorView() {
        return this.g.inflate(m61.appwidget_error, (ViewGroup) this, false);
    }

    public String getKey() {
        return this.t;
    }

    public CharSequence getLabel() {
        return this.o.getText();
    }

    public rk0 getLauncherAppWidgetProviderInfo() {
        return (rk0) getAppWidgetInfo();
    }

    public int[] getLocationWidget() {
        int[] iArr = this.x;
        return iArr != null ? iArr : getLocationIconViewOnScreen();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        post(new nk0(this, 0));
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            this.s = false;
            setSelected(false);
        }
        super.onFocusChanged(z, i, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.util.Objects.toString(r8)
            int r0 = r8.getAction()
            ok0 r1 = r7.B
            ld r2 = r7.h
            com.luutinhit.launcher6.t r3 = r7.j
            if (r0 != 0) goto L1c
            r2.b()
            r7.removeCallbacks(r1)
            boolean r0 = r3.showingFloatingMenu
            if (r0 != 0) goto L1c
            r7.a()
        L1c:
            boolean r0 = r2.a
            r4 = 1
            if (r0 == 0) goto L2f
            r2.b()
            r7.removeCallbacks(r1)
            boolean r8 = r3.showingFloatingMenu
            if (r8 != 0) goto L44
            r7.a()
            return r4
        L2f:
            jd r0 = r7.i
            boolean r5 = r0.a(r8)
            if (r5 == 0) goto L45
            r2.b()
            r7.removeCallbacks(r1)
            boolean r8 = r3.showingFloatingMenu
            if (r8 != 0) goto L44
            r7.a()
        L44:
            return r4
        L45:
            int r5 = r8.getAction()
            r6 = 0
            if (r5 == 0) goto L81
            if (r5 == r4) goto L73
            r0 = 2
            if (r5 == r0) goto L55
            r8 = 3
            if (r5 == r8) goto L73
            goto La8
        L55:
            float r0 = r8.getX()
            float r8 = r8.getY()
            float r4 = r7.r
            boolean r8 = defpackage.ar1.y(r7, r0, r8, r4)
            if (r8 != 0) goto La8
            r2.b()
            r7.removeCallbacks(r1)
            boolean r8 = r3.showingFloatingMenu
            if (r8 != 0) goto La8
            r7.a()
            return r6
        L73:
            r2.b()
            r7.removeCallbacks(r1)
            boolean r8 = r3.showingFloatingMenu
            if (r8 != 0) goto La8
            r7.a()
            return r6
        L81:
            boolean r8 = r0.a
            if (r8 != 0) goto L88
            r2.d()
        L88:
            com.luutinhit.launcher6.DragLayer r8 = r7.m
            r8.setTouchCompleteListener(r7)
            r3.isShaking()
            boolean r8 = r3.isShaking()
            if (r8 != 0) goto La8
            r7.y = r6
            int[] r8 = r7.getLocationIconViewOnScreen()
            r7.x = r8
            int r8 = android.view.ViewConfiguration.getTapTimeout()
            int r8 = r8 + 200
            long r2 = (long) r8
            r7.postDelayed(r1, r2)
        La8:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pk0.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.s || i != 66) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (keyEvent.isTracking() && !this.s && i == 66) {
            this.s = true;
            ArrayList<View> focusables = getFocusables(2);
            focusables.remove(this);
            int size = focusables.size();
            if (size != 0) {
                if (size == 1) {
                    Object tag = getTag();
                    if (tag instanceof qh0) {
                        qh0 qh0Var = (qh0) tag;
                        if (qh0Var.m == 1 && qh0Var.n == 1) {
                            focusables.get(0).performClick();
                            this.s = false;
                            return true;
                        }
                    }
                }
                focusables.get(0).requestFocus();
                return true;
            }
            this.s = false;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.appwidget.AppWidgetHostView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
        } catch (RuntimeException unused) {
            post(new ok0(this, 1));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        t tVar = this.j;
        super.onSizeChanged(i, i2, i3, i4);
        final View childAt = getChildAt(1);
        try {
            ComponentName componentName = getAppWidgetInfo().provider;
            TextViewCustomFont textViewCustomFont = this.o;
            if (componentName == null || getAppWidgetInfo().provider.getPackageName() == null || !getAppWidgetInfo().provider.getPackageName().equals(tVar.getPackageName())) {
                childAt.setPadding(0, 0, 0, 0);
                Drawable background = childAt.getBackground();
                if (background == null && (childAt instanceof ViewGroup)) {
                    View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                    Objects.toString(textViewCustomFont.getText());
                    Objects.toString(childAt2);
                    if (childAt2 != null && (background = childAt2.getBackground()) == null && (childAt2 instanceof ImageView)) {
                        background = ((ImageView) childAt2).getDrawable();
                    }
                }
                Objects.toString(textViewCustomFont.getText());
                Objects.toString(background);
                if (background instanceof ColorDrawable) {
                    childAt.setBackgroundColor(((ColorDrawable) background).getColor());
                } else if (background instanceof GradientDrawable) {
                    Bitmap bitmapK = ar1.k(background);
                    Objects.toString(textViewCustomFont.getText());
                    Objects.toString(bitmapK);
                    if (bitmapK != null) {
                        final int i5 = 0;
                        new jz(bitmapK).c(new k11(this) { // from class: mk0
                            public final /* synthetic */ pk0 h;

                            {
                                this.h = this;
                            }

                            @Override // defpackage.k11
                            public final void b(m11 m11Var) {
                                l11 l11Var;
                                l11 l11Var2;
                                switch (i5) {
                                    case 0:
                                        TextViewCustomFont textViewCustomFont2 = this.h.o;
                                        Objects.toString(textViewCustomFont2.getText());
                                        Objects.toString(m11Var);
                                        if (m11Var != null && (l11Var = m11Var.d) != null) {
                                            childAt.setBackgroundColor(l11Var != null ? l11Var.d : 0);
                                            Objects.toString(textViewCustomFont2.getText());
                                            break;
                                        }
                                        break;
                                    default:
                                        pk0 pk0Var = this.h;
                                        if (m11Var != null && (l11Var2 = m11Var.d) != null) {
                                            childAt.setBackgroundColor(l11Var2 != null ? l11Var2.d : -16777216);
                                            Objects.toString(pk0Var.o.getText());
                                            break;
                                        }
                                        break;
                                }
                            }
                        });
                    }
                } else if (background instanceof BitmapDrawable) {
                    jz jzVar = new jz(((BitmapDrawable) background).getBitmap());
                    final int i6 = 1;
                    jzVar.c(new k11(this) { // from class: mk0
                        public final /* synthetic */ pk0 h;

                        {
                            this.h = this;
                        }

                        @Override // defpackage.k11
                        public final void b(m11 m11Var) {
                            l11 l11Var;
                            l11 l11Var2;
                            switch (i6) {
                                case 0:
                                    TextViewCustomFont textViewCustomFont2 = this.h.o;
                                    Objects.toString(textViewCustomFont2.getText());
                                    Objects.toString(m11Var);
                                    if (m11Var != null && (l11Var = m11Var.d) != null) {
                                        childAt.setBackgroundColor(l11Var != null ? l11Var.d : 0);
                                        Objects.toString(textViewCustomFont2.getText());
                                        break;
                                    }
                                    break;
                                default:
                                    pk0 pk0Var = this.h;
                                    if (m11Var != null && (l11Var2 = m11Var.d) != null) {
                                        childAt.setBackgroundColor(l11Var2 != null ? l11Var2.d : -16777216);
                                        Objects.toString(pk0Var.o.getText());
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                }
            } else {
                Objects.toString(textViewCustomFont.getText());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        xu xuVar = this.k;
        if (i <= xuVar.H && i2 <= xuVar.I) {
            this.w = tVar.getResources().getDimensionPixelSize(e51.icon_round_corner);
        }
        Path path = this.v;
        path.reset();
        float f = i;
        float f2 = i2 - this.p;
        float f3 = this.w;
        Path path2 = new Path();
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        float f4 = f - 0.0f;
        float f5 = f2 - 0.0f;
        float f6 = f3 * 2.0f;
        float fMin = f6 > Math.min(f4, f5) ? 1.0f - (Math.min(1.0f, ((f6 / Math.min(f4, f5)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float fMin2 = ((double) (f6 / Math.min(f4, f5))) > 0.6d ? 1.0f + (Math.min(1.0f, ((f3 / Math.min(f4 / 2.0f, f5 / 2.0f)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        float f7 = f4 / 2.0f;
        path2.moveTo(0.0f + f7, 0.0f);
        float f8 = f3 / 100.0f;
        float f9 = 128.19f * f8 * fMin;
        float f10 = f4 - f9;
        path2.lineTo(Math.max(f7, f10) + 0.0f, 0.0f);
        float f11 = f4 + 0.0f;
        float f12 = 83.62f * f8 * fMin2;
        float f13 = f11 - f12;
        float f14 = f8 * 67.45f;
        float f15 = f11 - f14;
        float f16 = f8 * 4.64f;
        float f17 = 0.0f + f16;
        float f18 = f8 * 51.16f;
        float f19 = f11 - f18;
        float f20 = 13.36f * f8;
        float f21 = 0.0f + f20;
        path2.cubicTo(f13, 0.0f, f15, f17, f19, f21);
        float f22 = f8 * 34.86f;
        float f23 = f11 - f22;
        float f24 = f8 * 22.07f;
        float f25 = 0.0f + f24;
        float f26 = f11 - f24;
        float f27 = 0.0f + f22;
        float f28 = f11 - f20;
        float f29 = 0.0f + f18;
        path2.cubicTo(f23, f25, f26, f27, f28, f29);
        float f30 = f11 - f16;
        float f31 = 0.0f + f14;
        float f32 = 0.0f + f12;
        float f33 = f5 / 2.0f;
        path2.cubicTo(f30, f31, f11, f32, f11, Math.min(f33, f9) + 0.0f);
        float f34 = f5 - f9;
        path2.lineTo(f11, Math.max(f33, f34) + 0.0f);
        float f35 = 0.0f + f5;
        float f36 = f35 - f12;
        float f37 = f35 - f14;
        float f38 = f35 - f18;
        path2.cubicTo(f11, f36, f30, f37, f28, f38);
        float f39 = f35 - f22;
        float f40 = f35 - f24;
        float f41 = f35 - f20;
        path2.cubicTo(f26, f39, f23, f40, f19, f41);
        float f42 = f35 - f16;
        path2.cubicTo(f15, f42, f13, f35, Math.max(f7, f10) + 0.0f, f35);
        path2.lineTo(Math.min(f7, f9) + 0.0f, f35);
        path2.cubicTo(f32, f35, f31, f42, f29, f41);
        path2.cubicTo(f27, f40, f25, f39, f21, f38);
        path2.cubicTo(f17, f37, 0.0f, f36, 0.0f, Math.max(f33, f34) + 0.0f);
        path2.lineTo(0.0f, Math.min(f33, f9) + 0.0f);
        path2.cubicTo(0.0f, f32, f17, f31, f21, f29);
        path2.cubicTo(f25, f27, f27, f25, f29, f21);
        path2.cubicTo(f31, f17, f32, 0.0f, Math.min(f7, f9) + 0.0f, 0.0f);
        path2.close();
        path.addPath(path2);
        path.setFillType(Path.FillType.INVERSE_WINDING);
        path.close();
        Paint paint = this.u;
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        int action = motionEvent.getAction();
        t tVar = this.j;
        ok0 ok0Var = this.B;
        ld ldVar = this.h;
        if (action != 1) {
            if (action == 2) {
                if (ar1.y(this, motionEvent.getX(), motionEvent.getY(), this.r)) {
                    return false;
                }
                ldVar.b();
                removeCallbacks(ok0Var);
                if (tVar.showingFloatingMenu) {
                    return false;
                }
                a();
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        ldVar.b();
        removeCallbacks(ok0Var);
        if (tVar.showingFloatingMenu) {
            return false;
        }
        a();
        return false;
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void prepareView(View view) {
        Objects.toString(view);
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.setMargins(0, 0, 0, this.q);
            layoutParams.gravity = 119;
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        setSelected(this.s && view2 != null);
        if (view2 != null) {
            view2.setFocusableInTouchMode(false);
        }
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void setAppWidget(int i, AppWidgetProviderInfo appWidgetProviderInfo) {
        super.setAppWidget(i, appWidgetProviderInfo);
        Objects.toString(appWidgetProviderInfo);
        this.t = "widget_" + i;
        String strLoadLabel = appWidgetProviderInfo.label;
        t tVar = this.j;
        if (strLoadLabel == null) {
            strLoadLabel = ar1.m ? appWidgetProviderInfo.loadLabel(tVar.getPackageManager()) : "";
        }
        bo1 tinyDB = tVar.getTinyDB();
        int appWidgetId = getAppWidgetId();
        tinyDB.getClass();
        String string = tinyDB.a.getString("widget_label_" + appWidgetId, null);
        TextViewCustomFont textViewCustomFont = this.o;
        if (string != null) {
            strLoadLabel = string;
        }
        textViewCustomFont.setText(strLoadLabel);
        this.p = textViewCustomFont.getMeasuredHeight();
        this.q = this.p;
    }

    public void setLabel(CharSequence charSequence) {
        if (charSequence != null) {
            this.o.setText(charSequence.toString());
            bo1 tinyDB = this.j.getTinyDB();
            int appWidgetId = getAppWidgetId();
            String string = charSequence.toString();
            tinyDB.getClass();
            String str = "widget_label_" + appWidgetId;
            str.getClass();
            string.getClass();
            tinyDB.a.edit().putString(str, string).apply();
        }
    }

    public void setTextColor(int i) {
        this.o.setTextColor(i);
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void updateAppWidget(RemoteViews remoteViews) {
        this.l = this.j.getResources().getConfiguration().orientation;
        setPadding(0, 0, 0, 0);
        super.updateAppWidget(remoteViews);
    }
}
