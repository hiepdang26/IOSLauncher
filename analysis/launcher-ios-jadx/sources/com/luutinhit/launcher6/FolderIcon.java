package com.luutinhit.launcher6;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.luutinhit.launcher6.util.CustomIconView;
import defpackage.e51;
import defpackage.ed;
import defpackage.fd;
import defpackage.fz1;
import defpackage.g3;
import defpackage.h90;
import defpackage.i31;
import defpackage.ik0;
import defpackage.jd;
import defpackage.jk0;
import defpackage.k40;
import defpackage.l51;
import defpackage.ld;
import defpackage.m61;
import defpackage.nx;
import defpackage.oe0;
import defpackage.og1;
import defpackage.p40;
import defpackage.pw;
import defpackage.q40;
import defpackage.qh0;
import defpackage.r1;
import defpackage.rl0;
import defpackage.t40;
import defpackage.u40;
import defpackage.um;
import defpackage.v40;
import defpackage.v51;
import defpackage.v6;
import defpackage.vc;
import defpackage.vz1;
import defpackage.w1;
import defpackage.w40;
import defpackage.w61;
import defpackage.y80;
import defpackage.z80;
import defpackage.zw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class FolderIcon extends FrameLayout implements v40, SharedPreferences.OnSharedPreferenceChangeListener, ed {
    public static boolean D = true;
    public static int E;
    public static int F;
    public static int G;
    public static int H;
    public final g3 A;
    public qh0 B;
    public final fz1 C;
    public t g;
    public Folder h;
    public w40 i;
    public final ld j;
    public final jd k;
    public y80 l;
    public h90 m;
    public boolean n;
    public BubbleTextView o;
    public t40 p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public final Rect u;
    public float v;
    public boolean w;
    public u40 x;
    public final u40 y;
    public final ArrayList z;

    public FolderIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = false;
        this.p = null;
        this.t = false;
        this.u = new Rect();
        this.w = false;
        this.x = new u40(0.0f, 0.0f, 0.0f);
        this.y = new u40(0.0f, 0.0f, 0.0f);
        this.z = new ArrayList();
        this.A = new g3();
        this.C = new fz1(this, 15);
        this.j = new ld(this);
        this.k = new jd(this);
        setAccessibilityDelegate(jk0.a().f);
        if (context instanceof t) {
            t tVar = (t) context;
            if (tVar.getBlurWallpaperProvider() != null) {
                tVar.getBlurWallpaperProvider().b(this);
            }
        }
    }

    public static u40 f(int i, u40 u40Var) {
        Objects.toString(u40Var);
        float f = t40.l / 3.0f;
        float f2 = f / t40.j;
        float f3 = E;
        float f4 = i % 3;
        float f5 = (f4 * f3) + (f * f4) + f3;
        float f6 = i / 3;
        float f7 = (f3 * f6) + (f * f6) + f3;
        if (u40Var == null) {
            return new u40(f5, f7, f2);
        }
        u40Var.a = f5;
        u40Var.b = f7;
        u40Var.c = f2;
        return u40Var;
    }

    public static FolderIcon j(int i, t tVar, CellLayout cellLayout, w40 w40Var, oe0 oe0Var) {
        Objects.toString(tVar);
        Objects.toString(cellLayout);
        Objects.toString(w40Var);
        Objects.toString(oe0Var);
        G = cellLayout.getCellWidth();
        H = cellLayout.getCellHeight();
        int i2 = tVar.getDeviceProfile().D;
        F = i2;
        E = i2 / 15;
        FolderIcon folderIcon = (FolderIcon) LayoutInflater.from(tVar).inflate(i, (ViewGroup) cellLayout, false);
        folderIcon.g = tVar;
        BubbleTextView bubbleTextView = (BubbleTextView) folderIcon.findViewById(v51.folder_icon_name);
        folderIcon.o = bubbleTextView;
        bubbleTextView.setText(w40Var.u);
        folderIcon.o.setTextColor(tVar.mIconTextColor);
        folderIcon.o.getName().measure(0, 0);
        t tVar2 = folderIcon.g;
        int i3 = 2;
        if (!tVar2.isUseLiquidGlass) {
            CustomIconView iconView = folderIcon.o.getIconView();
            iconView.getClass();
            try {
                t tVar3 = (t) iconView.g;
                iconView.r = tVar3.getDeviceProfile().b();
                iconView.s = tVar3.getDeviceProfile().a();
                fd blurWallpaperProvider = tVar3.getBlurWallpaperProvider();
                float dimensionPixelSize = tVar3.getResources().getDimensionPixelSize(e51.icon_round_corner);
                blurWallpaperProvider.getClass();
                vc vcVar = new vc(blurWallpaperProvider, dimensionPixelSize, 2);
                iconView.k = vcVar;
                iconView.setBackground(vcVar);
            } catch (Throwable unused) {
                iconView.setBackgroundResource(l51.icon_folder_background);
            }
        } else if (tVar2.isRuntimeRenderSupport) {
            folderIcon.setLayerType(2, null);
            h90 h90Var = new h90(tVar, false);
            folderIcon.m = h90Var;
            h90Var.setLayerType(2, null);
            folderIcon.m.setFullBitmap(tVar.getBlurGlassWallpaper());
            folderIcon.m.setSdfTexture(l51.draff);
            folderIcon.addView(folderIcon.m, 0);
        } else {
            y80 y80Var = new y80(tVar, 0.25f);
            folderIcon.l = y80Var;
            y80Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
            y80 y80Var2 = folderIcon.l;
            int i4 = tVar.screenWidth;
            int i5 = tVar.screenHeight;
            y80Var2.i = i4;
            y80Var2.j = i5;
            y80Var2.s = false;
            folderIcon.l.setSdfTexture(l51.draff);
            folderIcon.l.setFullBitmap(folderIcon.getBlurGlassWallpaper());
            folderIcon.addView(folderIcon.l, 0);
        }
        folderIcon.setTag(w40Var);
        folderIcon.setOnClickListener(tVar);
        folderIcon.i = w40Var;
        folderIcon.setContentDescription(String.format(tVar.getString(w61.folder_name_format), w40Var.u));
        Rect rect = Folder.e0;
        Folder folder = (Folder) tVar.getLayoutInflater().inflate(m61.user_folder, (ViewGroup) null);
        folder.setDragController(tVar.getDragController());
        folder.setFolderIcon(folderIcon);
        folder.p = w40Var;
        ArrayList arrayList = w40Var.x;
        Collections.sort(arrayList, Folder.h0);
        FolderPagedView folderPagedView = folder.r;
        folderPagedView.getClass();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            arrayList2.add(folderPagedView.m0((og1) obj));
        }
        folderPagedView.k0(arrayList2.size(), arrayList2, false);
        int size2 = arrayList3.size();
        int i7 = 0;
        while (i7 < size2) {
            Object obj2 = arrayList3.get(i7);
            i7++;
            og1 og1Var = (og1) obj2;
            folder.p.g(og1Var);
            rl0.e(folder.n, og1Var);
        }
        folder.E = true;
        folder.M();
        folder.p.z.add(folder);
        if (Folder.f0.contentEquals(folder.p.u)) {
            folder.y.setText("");
        } else {
            folder.y.setText(folder.p.u);
        }
        folder.y.measure(0, 0);
        if (((pw) folder.getLayoutParams()) == null) {
            pw pwVar = new pw(0, 0);
            pwVar.d = true;
            folder.setLayoutParams(pwVar);
        }
        folder.x();
        folder.q.post(new k40(folder, i3));
        if (folderIcon.g.isUseLiquidGlass) {
            folder.setFolderBackgroundBitmap(folderIcon.getBlurGlassWallpaper());
        } else {
            folder.setFolderBackgroundResource(tVar.isDarkMode ? l51.folder_background_dark : l51.folder_background);
        }
        folderIcon.h = folder;
        folderIcon.p = new t40(tVar, folderIcon);
        w40Var.z.add(folderIcon);
        folderIcon.setOnFocusChangeListener(tVar.mFocusHandler);
        return folderIcon;
    }

    public static Drawable l(BubbleTextView bubbleTextView) {
        Objects.toString(bubbleTextView);
        Drawable icon = bubbleTextView.getIcon();
        return icon instanceof i31 ? ((i31) icon).d : icon;
    }

    private void setGlassViewVisibleFromGLSurface(boolean z) {
        y80 y80Var = this.l;
        if (y80Var != null) {
            y80Var.setVisible(z);
        }
    }

    @Override // defpackage.ed
    public final void a() {
        post(new r1(this, 14));
    }

    public final void b(Drawable drawable, int i, boolean z, k40 k40Var) {
        Objects.toString(drawable);
        Objects.toString(k40Var);
        u40 u40VarF = f(0, null);
        float f = E + 100.0f;
        this.o.getIconView().getLeft();
        this.o.getIconView().getTop();
        this.y.d = drawable;
        ValueAnimator valueAnimatorC = ik0.c(0.0f, 1.0f);
        valueAnimatorC.addUpdateListener(new q40(this, z, f, u40VarF, f, (t40.l / 3.0f) / t40.j));
        valueAnimatorC.addListener(new um(this, k40Var, 4));
        valueAnimatorC.setDuration(i);
        valueAnimatorC.start();
    }

    public final void c(int i) {
        this.q = F;
        RectF rectF = t40.h;
        this.o.getIconView().getLeft();
        getWidth();
        getHeight();
        int x = (int) this.o.getIconView().getX();
        int y = (int) this.o.getIconView().getY();
        if (x != 0 || y != 0) {
            this.r = (int) (this.o.getIconView().getX() + t40.k);
            this.s = (int) (this.o.getIconView().getY() + t40.k);
            this.o.getIconView().getX();
            this.o.getIconView().getY();
            return;
        }
        int i2 = G;
        if (i2 == 0 && H == 0) {
            this.r = ((getWidth() - F) / 2) + t40.k;
            this.s = ((getHeight() - F) - this.o.getName().getMeasuredHeight()) + t40.k;
        } else {
            this.r = ((i2 - F) / 2) + t40.k;
            this.s = ((H - F) - this.o.getName().getMeasuredHeight()) + t40.k;
        }
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        this.j.b();
    }

    @Override // defpackage.v40
    public final void d(String str) {
        this.o.setText(str);
        setContentDescription(String.format(getContext().getString(w61.folder_name_format), str));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            Folder folder = this.h;
            if (folder == null) {
                return;
            }
            if (folder.getItemCount() != 0 || this.t) {
                ArrayList<View> itemsInReadingOrder = this.h.getItemsInReadingOrder();
                boolean z = this.t;
                u40 u40Var = this.y;
                if (z) {
                    Drawable drawable = u40Var.d;
                    Objects.toString(drawable);
                    drawable.getIntrinsicWidth();
                    c(getMeasuredWidth());
                } else {
                    Drawable drawableL = l((BubbleTextView) itemsInReadingOrder.get(0));
                    Objects.toString(drawableL);
                    drawableL.getIntrinsicWidth();
                    c(getMeasuredWidth());
                }
                int iMin = Math.min(itemsInReadingOrder.size(), 9);
                if (this.t) {
                    h(canvas, u40Var);
                    return;
                }
                for (int i = iMin - 1; i >= 0; i--) {
                    BubbleTextView bubbleTextView = (BubbleTextView) itemsInReadingOrder.get(i);
                    if (!this.z.contains(bubbleTextView.getTag())) {
                        Drawable drawableL2 = l(bubbleTextView);
                        u40 u40VarF = f(i, this.x);
                        this.x = u40VarF;
                        u40VarF.d = drawableL2;
                        h(canvas, u40VarF);
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.v40
    public final void e(og1 og1Var) {
        Objects.toString(og1Var);
        invalidate();
        requestLayout();
    }

    public Bitmap getBlurGlassWallpaper() {
        fd blurWallpaperProvider = this.g.getBlurWallpaperProvider();
        Bitmap bitmap = blurWallpaperProvider.f;
        if (bitmap == null) {
            bitmap = blurWallpaperProvider.e;
        }
        if (bitmap == null) {
            return this.g.getBlurWallpaperProvider().g;
        }
        bitmap.toString();
        return bitmap;
    }

    public Folder getFolder() {
        return this.h;
    }

    public w40 getFolderInfo() {
        return this.i;
    }

    public View getFolderName() {
        return this.o;
    }

    public View getIconView() {
        BubbleTextView bubbleTextView = this.o;
        if (bubbleTextView != null) {
            return bubbleTextView.getIconView();
        }
        return null;
    }

    public boolean getTextVisible() {
        return this.o.getVisibility() == 0;
    }

    public final void h(Canvas canvas, u40 u40Var) {
        Objects.toString(canvas);
        Objects.toString(u40Var);
        canvas.save();
        canvas.translate(u40Var.a + this.r, u40Var.b + this.s);
        float f = u40Var.c;
        canvas.scale(f, f);
        Drawable drawable = u40Var.d;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            Rect rect = this.u;
            rect.set(bounds);
            int i = this.q;
            drawable.setBounds(0, 0, i, i);
            if (drawable instanceof FastBitmapDrawable) {
                FastBitmapDrawable fastBitmapDrawable = (FastBitmapDrawable) drawable;
                fastBitmapDrawable.setBrightness(0.0f);
                drawable.draw(canvas);
                fastBitmapDrawable.setBrightness(fastBitmapDrawable.e / 48.0f);
            } else {
                drawable.setColorFilter(Color.argb((int) 0.0f, 255, 255, 255), PorterDuff.Mode.SRC_ATOP);
                drawable.draw(canvas);
                drawable.clearColorFilter();
            }
            drawable.setBounds(rect);
        }
        canvas.restore();
    }

    public final void i() {
        if (this.l != null) {
            setGlassViewVisibleFromGLSurface(false);
        } else {
            h90 h90Var = this.m;
            if (h90Var != null) {
                h90Var.setVisibility(4);
            }
        }
        getIconView().setBackground(new z80());
    }

    @Override // defpackage.v40
    public final void k(og1 og1Var) {
        Objects.toString(og1Var);
        invalidate();
        requestLayout();
    }

    public final void m(nx nxVar) {
        Objects.toString(nxVar);
        Object obj = nxVar.g;
        og1 og1VarI = obj instanceof v6 ? ((v6) obj).i() : (og1) obj;
        Folder folder = this.h;
        if (folder.J) {
            folder.M = true;
        }
        o(og1VarI, nxVar.f, null, 1.0f, this.i.x.size(), nxVar.j, nxVar);
    }

    @Override // defpackage.v40
    public final void n() {
        invalidate();
        requestLayout();
    }

    public final void o(og1 og1Var, zw zwVar, Rect rect, float f, int i, vz1 vz1Var, nx nxVar) {
        Rect rect2;
        float descendantRectRelativeToSelf;
        Objects.toString(og1Var);
        Objects.toString(zwVar);
        Objects.toString(rect);
        Objects.toString(vz1Var);
        Objects.toString(nxVar);
        og1Var.k = -1;
        og1Var.l = -1;
        if (zwVar == null) {
            Objects.toString(og1Var);
            this.i.f(og1Var);
            return;
        }
        DragLayer dragLayer = this.g.getDragLayer();
        Rect rect3 = new Rect();
        dragLayer.getViewRectRelativeToSelf(zwVar, rect3);
        if (rect == null) {
            rect2 = new Rect();
            this.g.getWorkspace().setFinalTransitionTransform((CellLayout) getParent().getParent());
            float scaleX = getScaleX();
            float scaleY = getScaleY();
            setScaleX(1.0f);
            setScaleY(1.0f);
            descendantRectRelativeToSelf = dragLayer.getDescendantRectRelativeToSelf(this, rect2);
            setScaleX(scaleX);
            setScaleY(scaleY);
            Objects.toString((CellLayout) getParent().getParent());
        } else {
            rect2 = rect;
            descendantRectRelativeToSelf = f;
        }
        u40 u40VarF = f(Math.min(9, i), this.x);
        this.x = u40VarF;
        float f2 = u40VarF.a + this.r;
        u40VarF.a = f2;
        float f3 = u40VarF.b + this.s;
        u40VarF.b = f3;
        float f4 = (u40VarF.c * this.q) / 2.0f;
        int[] iArr = {Math.round(f2 + f4), Math.round(f4 + f3)};
        float f5 = this.x.c;
        iArr[0] = Math.round(iArr[0] * descendantRectRelativeToSelf);
        iArr[1] = Math.round(iArr[1] * descendantRectRelativeToSelf);
        rect2.offset(iArr[0] - (zwVar.getMeasuredWidth() / 2), iArr[1] - (zwVar.getMeasuredHeight() / 2));
        float f6 = descendantRectRelativeToSelf * f5;
        dragLayer.animateView(zwVar, rect3, rect2, i < 9 ? 0.5f : 0.0f, 1.0f, 1.0f, f6, f6, 400, new DecelerateInterpolator(2.0f), new AccelerateInterpolator(2.0f), vz1Var, 0, null);
        Objects.toString(og1Var);
        this.i.f(og1Var);
        this.z.add(og1Var);
        this.h.E(og1Var).setVisibility(4);
        postDelayed(new w1(this, og1Var, 19, false), 400L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.v = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.g.getTinyDB().j(this);
        y80 y80Var = this.l;
        if (y80Var != null) {
            y80Var.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.g.getTinyDB().a.unregisterOnSharedPreferenceChangeListener(this);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            y80 y80Var = this.l;
            if (y80Var != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) y80Var.getLayoutParams();
                int i5 = F;
                layoutParams.width = i5;
                layoutParams.height = i5;
                boolean z2 = this.n;
                layoutParams.bottomMargin = z2 ? this.g.mDeviceProfile.F : 0;
                layoutParams.gravity = z2 ? 81 : 17;
                this.l.setLayoutParams(layoutParams);
                this.l.e();
            }
            h90 h90Var = this.m;
            if (h90Var == null) {
                p();
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) h90Var.getLayoutParams();
            int i6 = F;
            layoutParams2.width = i6;
            layoutParams2.height = i6;
            boolean z3 = this.n;
            layoutParams2.bottomMargin = z3 ? this.g.mDeviceProfile.F : 0;
            layoutParams2.gravity = z3 ? 81 : 17;
            this.m.setLayoutParams(layoutParams2);
            this.m.g();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        D = true;
        return super.onSaveInstanceState();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null || str == null || !str.equals("dark_mode")) {
            return;
        }
        boolean z = sharedPreferences.getBoolean(str, false);
        this.h.setFolderBackgroundResource(z ? l51.folder_background_dark : l51.folder_background);
        t40.i.setColor(z ? 1493172224 : -2132877602);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r1 != 3) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            java.util.Objects.toString(r4)
            boolean r0 = super.onTouchEvent(r4)
            jd r1 = r3.k
            boolean r1 = r1.a(r4)
            r2 = 1
            if (r1 == 0) goto L16
            ld r4 = r3.j
            r4.b()
            return r2
        L16:
            int r1 = r4.getAction()
            if (r1 == 0) goto L4b
            if (r1 == r2) goto L3b
            r2 = 2
            if (r1 == r2) goto L25
            r2 = 3
            if (r1 == r2) goto L3b
            goto L3a
        L25:
            float r1 = r4.getX()
            float r4 = r4.getY()
            float r2 = r3.v
            boolean r4 = defpackage.ar1.y(r3, r1, r4, r2)
            if (r4 != 0) goto L3a
            ld r4 = r3.j
            r4.b()
        L3a:
            return r0
        L3b:
            com.luutinhit.launcher6.BubbleTextView r1 = r3.o
            r1.onTouchEvent(r4)
            com.luutinhit.launcher6.BubbleTextView r4 = r3.o
            r4.w()
            ld r4 = r3.j
            r4.b()
            return r0
        L4b:
            ld r4 = r3.j
            r4.d()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.FolderIcon.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        h90 h90Var;
        BubbleTextView bubbleTextView;
        y80 y80Var = this.l;
        if (y80Var != null || this.m != null) {
            boolean z = this.w;
            if (z && y80Var != null) {
                y80Var.e();
                return;
            } else {
                if (!z || (h90Var = this.m) == null) {
                    return;
                }
                h90Var.g();
                return;
            }
        }
        if (!this.w || (bubbleTextView = this.o) == null) {
            return;
        }
        CustomIconView iconView = bubbleTextView.getIconView();
        if (iconView.k != null) {
            int[] iArr = iconView.m;
            iconView.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            if (i < 0 || i > iconView.r || i2 < 0 || i2 > iconView.s) {
                return;
            }
            if (i != iconView.n) {
                iconView.n = i;
                iconView.k.c(i);
            }
            int i3 = iArr[1];
            if (i3 != iconView.o) {
                iconView.o = i3;
                iconView.k.d(i3);
            }
        }
    }

    public final boolean q(qh0 qh0Var) {
        Objects.toString(qh0Var);
        int i = qh0Var.h;
        if (i != 0 && i != 1) {
            return false;
        }
        this.h.r.getClass();
        w40 w40Var = this.i;
        return (qh0Var == w40Var || w40Var.y) ? false : true;
    }

    public void setGlassViewVisible(boolean z) {
        if (!isAttachedToWindow()) {
            post(new p40(this, z, 1));
            return;
        }
        y80 y80Var = this.l;
        if (y80Var != null) {
            y80Var.setVisibility(z ? 0 : 4);
        }
    }

    public void setTextColor(int i) {
        this.o.setTextColor(i);
    }

    public void setTextVisible(boolean z) {
        this.n = z;
        this.o.setTextVisibility(z);
    }

    public void setUseTransparency(boolean z) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setVisibilityGlassBackground(boolean z) {
        if (this.l != null) {
            if (z) {
                getIconView().setBackground(null);
                setGlassViewVisibleFromGLSurface(true);
                return;
            } else {
                getIconView().setBackgroundResource(l51.icon_folder_background);
                setGlassViewVisibleFromGLSurface(false);
                return;
            }
        }
        if (this.m != null) {
            if (z) {
                getIconView().setBackground(null);
                this.m.setVisibility(0);
            } else {
                getIconView().setBackgroundResource(l51.icon_folder_background);
                this.m.setVisibility(4);
            }
        }
    }

    @Override // defpackage.ed
    public final void g() {
    }
}
