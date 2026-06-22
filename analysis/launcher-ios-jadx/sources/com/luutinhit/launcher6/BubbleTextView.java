package com.luutinhit.launcher6;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.LauncherApps;
import android.content.pm.ShortcutInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.util.BadgeTextView;
import com.luutinhit.launcher6.util.CustomIconView;
import com.luutinhit.launcher6.util.DeleteCircleView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.ar;
import defpackage.ar1;
import defpackage.be;
import defpackage.bh1;
import defpackage.br;
import defpackage.c71;
import defpackage.ce;
import defpackage.cw;
import defpackage.ee1;
import defpackage.en;
import defpackage.ew;
import defpackage.f8;
import defpackage.fz1;
import defpackage.g71;
import defpackage.gl0;
import defpackage.hg0;
import defpackage.i31;
import defpackage.ik0;
import defpackage.jd;
import defpackage.jk0;
import defpackage.kb;
import defpackage.ld;
import defpackage.m61;
import defpackage.mc1;
import defpackage.o1;
import defpackage.o20;
import defpackage.oe0;
import defpackage.og1;
import defpackage.q11;
import defpackage.qh0;
import defpackage.rl0;
import defpackage.s01;
import defpackage.td1;
import defpackage.v51;
import defpackage.v6;
import defpackage.vr0;
import defpackage.w61;
import defpackage.x4;
import defpackage.xm;
import defpackage.xu;
import defpackage.yc1;
import defpackage.z71;
import java.text.NumberFormat;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BubbleTextView extends ConstraintLayout implements kb {
    public static final SparseArray F = new SparseArray(2);
    public final ObjectAnimator A;
    public final ObjectAnimator B;
    public final o1 C;
    public final LauncherApps D;
    public List E;
    public final t g;
    public Drawable h;
    public Bitmap i;
    public final ld j;
    public final jd k;
    public float l;
    public final boolean m;
    public final int n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public final CustomIconView s;
    public final TextViewCustomFont t;
    public final DeleteCircleView u;
    public final BadgeTextView v;
    public String w;
    public q11 x;
    public int[] y;
    public boolean z;

    public BubbleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Resources.Theme getPreloaderTheme() {
        Object tag = getTag();
        int i = (!(tag instanceof og1) || ((og1) tag).i < 0) ? c71.PreloadIcon : c71.PreloadIcon_Folder;
        SparseArray sparseArray = F;
        Resources.Theme theme = (Resources.Theme) sparseArray.get(i);
        if (theme != null) {
            return theme;
        }
        Resources.Theme themeNewTheme = getResources().newTheme();
        themeNewTheme.applyStyle(i, true);
        sparseArray.put(i, themeNewTheme);
        return themeNewTheme;
    }

    public final void A() {
        q11 q11Var = this.x;
        if (q11Var != null) {
            ((Handler) q11Var.i).removeCallbacks((xm) q11Var.h);
            this.x = null;
        }
        if (getTag() instanceof v6) {
            v6 v6Var = (v6) getTag();
            if (v6Var.z) {
                this.x = jk0.a().b.K(this, v6Var);
                return;
            }
            return;
        }
        if (getTag() instanceof og1) {
            og1 og1Var = (og1) getTag();
            if (og1Var.A) {
                this.x = jk0.a().b.K(this, og1Var);
                return;
            }
            return;
        }
        if (getTag() instanceof s01) {
            s01 s01Var = (s01) getTag();
            if (s01Var.y) {
                this.x = jk0.a().b.K(this, s01Var);
            }
        }
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        this.j.b();
    }

    public BadgeTextView getBadgeView() {
        return this.v;
    }

    public Bitmap getBitmapIcon() {
        return this.i;
    }

    public String getComponentName() {
        return this.w;
    }

    public Drawable getIcon() {
        return this.h;
    }

    public int getIconSize() {
        return this.n;
    }

    public CustomIconView getIconView() {
        return this.s;
    }

    public int[] getLocationIcon() {
        int[] iArr = this.y;
        return iArr != null ? iArr : getLocationIconViewOnScreen();
    }

    public int[] getLocationIconViewOnScreen() {
        int[] iArr = new int[2];
        getIconView().getLocationOnScreen(iArr);
        return iArr;
    }

    public TextView getName() {
        return this.t;
    }

    public String getPackageName() {
        String str = this.w;
        if (str == null) {
            return null;
        }
        if (!str.contains("/")) {
            return this.w;
        }
        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(this.w);
        if (componentNameUnflattenFromString != null) {
            return componentNameUnflattenFromString.getPackageName();
        }
        return null;
    }

    public List<ShortcutInfo> getShortcutInfoList() {
        return this.E;
    }

    public final void l(v6 v6Var) {
        if (v6Var != null) {
            ComponentName componentName = v6Var.A;
            if (componentName != null) {
                this.w = componentName.flattenToString();
            }
            FastBitmapDrawable fastBitmapDrawableCreateIconDrawable = this.g.createIconDrawable(v6Var.y);
            if (v6Var.c()) {
                fastBitmapDrawableCreateIconDrawable.f(o20.DISABLED);
            }
            x(fastBitmapDrawableCreateIconDrawable, this.n);
            setText(v6Var.u);
            CharSequence charSequence = v6Var.v;
            if (charSequence != null) {
                setContentDescription(charSequence);
            }
            super.setTag(v6Var);
            A();
        }
    }

    public final void n(s01 s01Var) {
        if (s01Var != null) {
            this.w = s01Var.z;
            x(this.g.createIconDrawable(s01Var.x), this.n);
            setText(s01Var.u);
            CharSequence charSequence = s01Var.v;
            if (charSequence != null) {
                setContentDescription(charSequence);
            }
            super.setTag(s01Var);
            A();
        }
    }

    public final void o(og1 og1Var, oe0 oe0Var, boolean z) {
        if (og1Var != null) {
            if (og1Var.g() != null) {
                this.w = og1Var.g().flattenToString();
            }
            if (og1Var.C == null) {
                og1Var.i(oe0Var);
            }
            Bitmap bitmap = og1Var.C;
            this.i = bitmap;
            bitmap.getWidth();
            this.i.getHeight();
            FastBitmapDrawable fastBitmapDrawableCreateIconDrawable = this.g.createIconDrawable(this.i);
            if (og1Var.c()) {
                fastBitmapDrawableCreateIconDrawable.f(o20.DISABLED);
            }
            x(fastBitmapDrawableCreateIconDrawable, this.n);
            CharSequence charSequence = og1Var.v;
            if (charSequence != null) {
                setContentDescription(charSequence);
            }
            setText(og1Var.u);
            setTag(og1Var);
            if (z || og1Var.h(3)) {
                u(z);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.h;
        if (drawable instanceof i31) {
            ((i31) drawable).a(getPreloaderTheme());
        }
        this.l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Drawable drawable = this.h;
        boolean z = drawable instanceof br;
        t tVar = this.g;
        if (z) {
            tVar.removeOnTinyDBChangeListener((br) drawable);
        } else if (drawable instanceof ar) {
            tVar.removeOnTinyDBChangeListener((ar) drawable);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.q = true;
        boolean zOnKeyUp = super.onKeyUp(i, keyEvent);
        this.q = false;
        z();
        return zOnKeyUp;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        t tVar = this.g;
        tVar.mDeviceProfile.F = getName().getMeasuredHeight();
        xu xuVar = tVar.mDeviceProfile;
        xuVar.M = (xuVar.C * 2) - ((xuVar.L - xuVar.J) - xuVar.F);
        int i5 = -xuVar.A;
        float f = tVar.isRTL ? -i5 : i5;
        DeleteCircleView deleteCircleView = this.u;
        deleteCircleView.setTranslationX(f);
        deleteCircleView.setTranslationY(i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r2 != 3) goto L30;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            java.util.Objects.toString(r9)
            boolean r0 = super.onTouchEvent(r9)
            jd r1 = r8.k
            boolean r2 = r1.a(r9)
            r3 = 1
            ld r4 = r8.j
            if (r2 == 0) goto L16
            r4.b()
            r0 = 1
        L16:
            int r2 = r9.getAction()
            r5 = 0
            o1 r6 = r8.C
            com.luutinhit.launcher6.t r7 = r8.g
            if (r2 == 0) goto L4b
            if (r2 == r3) goto L3e
            r1 = 2
            if (r2 == r1) goto L2a
            r1 = 3
            if (r2 == r1) goto L3e
            goto L79
        L2a:
            float r1 = r9.getX()
            float r9 = r9.getY()
            float r2 = r8.l
            boolean r9 = defpackage.ar1.y(r8, r1, r9, r2)
            if (r9 != 0) goto L79
            r4.b()
            return r0
        L3e:
            r8.removeCallbacks(r6)
            r8.setStayPressed(r5)
            r7.onTouchIcon(r8, r9)
            r4.b()
            return r0
        L4b:
            boolean r9 = r8.q
            if (r9 != 0) goto L54
            r8.p = r3
            r8.z()
        L54:
            boolean r9 = r1.a
            if (r9 != 0) goto L5b
            r4.d()
        L5b:
            boolean r9 = r7.isShaking()
            if (r9 != 0) goto L79
            boolean r9 = r7.isWidgetsViewVisible()
            if (r9 != 0) goto L79
            r8.z = r5
            int[] r9 = r8.getLocationIconViewOnScreen()
            r8.y = r9
            int r9 = android.view.ViewConfiguration.getTapTimeout()
            int r9 = r9 + 200
            long r1 = (long) r9
            r8.postDelayed(r6, r1)
        L79:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.BubbleTextView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.r) {
            return;
        }
        super.requestLayout();
    }

    public void setLongPressTimeout(int i) {
        this.j.b = i;
    }

    public void setStayPressed(boolean z) {
        this.p = z;
        z();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        int i = 1;
        if (obj != null) {
            qh0 qh0Var = (qh0) obj;
            HandlerThread handlerThread = rl0.w;
            Objects.toString(qh0Var);
            rl0.y(new gl0(qh0Var.g, qh0Var, new Throwable().getStackTrace()));
            mc1 mc1Var = new mc1(new f8(this, obj, i), 24);
            td1 td1Var = ee1.a;
            z71.m(td1Var, "scheduler is null");
            try {
                vr0 vr0Var = new vr0(new fz1(this, 5), x4.a(), i);
                try {
                    bh1 bh1Var = new bh1(vr0Var, mc1Var);
                    vr0Var.c(bh1Var);
                    cw cwVarB = td1Var.b(bh1Var);
                    yc1 yc1Var = bh1Var.h;
                    yc1Var.getClass();
                    ew.c(yc1Var, cwVarB);
                } catch (NullPointerException e) {
                    throw e;
                } catch (Throwable th) {
                    hg0.C(th);
                    NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
                    nullPointerException.initCause(th);
                    throw nullPointerException;
                }
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th2) {
                hg0.C(th2);
                NullPointerException nullPointerException2 = new NullPointerException("subscribeActual failed");
                nullPointerException2.initCause(th2);
                throw nullPointerException2;
            }
        }
        super.setTag(obj);
    }

    public void setText(CharSequence charSequence) {
        this.t.setText(charSequence);
    }

    public void setTextColor(int i) {
        this.o = i;
        this.t.setTextColor(i);
    }

    public void setTextVisibility(boolean z) {
        TextViewCustomFont textViewCustomFont = this.t;
        if (textViewCustomFont != null) {
            textViewCustomFont.setVisibility(z ? 0 : 8);
        }
        if (z) {
            return;
        }
        en enVar = new en();
        enVar.f(this);
        enVar.g(v51.icon_app, 3, 0, 3, 0);
        enVar.g(v51.icon_app, 4, 0, 4, 0);
        enVar.b(this);
    }

    public final void u(boolean z) {
        og1 og1Var;
        i31 i31Var;
        if (!(getTag() instanceof og1) || (og1Var = (og1) getTag()) == null) {
            return;
        }
        if (og1Var.g() != null) {
            this.w = og1Var.g().flattenToString();
        }
        int i = og1Var.h(3) ? og1Var.h(4) ? og1Var.F : 0 : 100;
        setContentDescription(i > 0 ? getContext().getString(w61.app_downloading_title, og1Var.u, NumberFormat.getPercentInstance().format(((double) i) * 0.01d)) : getContext().getString(w61.app_waiting_download_title, og1Var.u));
        Drawable drawable = this.h;
        if (drawable != null) {
            if (drawable instanceof i31) {
                i31Var = (i31) drawable;
            } else {
                i31Var = new i31(this.h, getPreloaderTheme());
                x(i31Var, this.n);
            }
            i31Var.setLevel(i);
            if (!z || i31Var.i > -1.0f) {
                return;
            }
            ObjectAnimator objectAnimator = i31Var.j;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (0.0f != i31Var.i) {
                i31Var.i = 0.0f;
                i31Var.invalidateSelf();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(i31Var, "animationProgress", 0.0f, 1.0f);
            i31Var.j = objectAnimatorOfFloat;
            objectAnimatorOfFloat.start();
        }
    }

    public final void w() {
        if (this.A.isRunning()) {
            this.A.cancel();
        }
        if (this.z) {
            this.B.start();
        }
    }

    public final void x(Drawable drawable, int i) {
        Drawable drawable2;
        CustomIconView customIconView = this.s;
        customIconView.getWidth();
        this.h = drawable;
        String str = this.w;
        if (str == null || (!(str.contains("clock") || this.w.contains("ch.bitspin.timely") || (this.w.contains("organizer") && !this.w.contains("microsoft"))) || this.w.contains("wearable"))) {
            String str2 = this.w;
            if (str2 != null && str2.contains("calendar")) {
                float f = i;
                this.h = new ar(getContext(), f, f);
            }
        } else {
            customIconView.setClockView(true);
            float f2 = i;
            this.h = new br(getContext(), f2, f2);
        }
        if (i != -1 && (drawable2 = this.h) != null) {
            drawable2.setBounds(0, 0, i, i);
        }
        customIconView.setBackgroundDrawable(this.h);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.getTag()
            boolean r1 = r0 instanceof defpackage.v6
            if (r1 == 0) goto L18
            r1 = r0
            v6 r1 = (defpackage.v6) r1
            android.content.ComponentName r2 = r1.A
            int r1 = r1.C
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.util.Pair r1 = android.util.Pair.create(r2, r1)
            goto L35
        L18:
            boolean r1 = r0 instanceof defpackage.og1
            if (r1 == 0) goto L34
            r1 = r0
            og1 r1 = (defpackage.og1) r1
            android.content.ComponentName r2 = r1.g()
            int r3 = r1.h
            if (r3 != 0) goto L34
            if (r2 == 0) goto L34
            int r1 = r1.G
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.util.Pair r1 = android.util.Pair.create(r2, r1)
            goto L35
        L34:
            r1 = 0
        L35:
            r2 = 0
            com.luutinhit.launcher6.util.DeleteCircleView r3 = r6.u
            r4 = 1
            if (r1 != 0) goto L49
            boolean r5 = r0 instanceof defpackage.og1
            if (r5 == 0) goto L49
            og1 r0 = (defpackage.og1) r0
            int r0 = r0.h
            if (r0 != r4) goto L4e
            r3.c(r2, r4)
            return
        L49:
            if (r1 == 0) goto L4e
            r3.c(r2, r4)
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.BubbleTextView.y():void");
    }

    public final void z() {
        Drawable drawable = this.h;
        if (drawable instanceof FastBitmapDrawable) {
            FastBitmapDrawable fastBitmapDrawable = (FastBitmapDrawable) drawable;
            if ((getTag() instanceof qh0) && ((qh0) getTag()).c()) {
                fastBitmapDrawable.a(o20.DISABLED);
            } else if (this.p) {
                fastBitmapDrawable.a(o20.PRESSED);
            } else {
                fastBitmapDrawable.a(o20.NORMAL);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        int i2 = 0;
        this.o = -1;
        this.q = false;
        this.r = false;
        this.w = "";
        this.z = false;
        this.C = new o1(this, 9);
        this.D = null;
        this.E = null;
        LayoutInflater.from(context).inflate(m61.icon_view_layout, (ViewGroup) this, true);
        this.s = (CustomIconView) findViewById(v51.icon_app);
        TextViewCustomFont textViewCustomFont = (TextViewCustomFont) findViewById(v51.icon_name);
        this.t = textViewCustomFont;
        this.u = (DeleteCircleView) findViewById(v51.icon_delete);
        this.v = (BadgeTextView) findViewById(v51.icon_badge);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.BubbleTextView, 0, 0);
        this.m = typedArrayObtainStyledAttributes.getBoolean(g71.BubbleTextView_layoutHorizontal, false);
        textViewCustomFont.setVisibility(typedArrayObtainStyledAttributes.getBoolean(g71.BubbleTextView_hideIconName, false) ? 8 : 0);
        typedArrayObtainStyledAttributes.recycle();
        t tVar = (t) context;
        this.g = tVar;
        if (ar1.e) {
            this.D = (LauncherApps) context.getSystemService("launcherapps");
        }
        int i3 = tVar.getDeviceProfile().D;
        this.n = i3;
        en enVar = new en();
        enVar.f(this);
        enVar.k(v51.icon_app).e.c = i3;
        enVar.k(v51.icon_app).e.d = i3;
        enVar.b(this);
        setClipChildren(false);
        setClipToPadding(false);
        textViewCustomFont.setTextSize(0, r8.E);
        setTextColor(this.o);
        textViewCustomFont.measure(0, 0);
        ObjectAnimator objectAnimatorD = ik0.d(this, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f, 0.96f, 1.1f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 0.96f, 1.1f));
        objectAnimatorD.addListener(new be(this, i2));
        objectAnimatorD.setDuration(368L);
        this.A = objectAnimatorD;
        ObjectAnimator objectAnimatorD2 = ik0.d(this, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f));
        objectAnimatorD2.addListener(new ce(0));
        objectAnimatorD2.setDuration(268L);
        this.B = objectAnimatorD2;
        this.j = new ld(this);
        this.k = new jd(this);
        setAccessibilityDelegate(jk0.a().f);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.o = colorStateList.getDefaultColor();
        this.t.setTextColor(colorStateList);
    }
}
