package com.luutinhit.launcher6.appslibrary;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.b8;
import defpackage.b90;
import defpackage.d8;
import defpackage.d90;
import defpackage.e8;
import defpackage.h90;
import defpackage.ik0;
import defpackage.l51;
import defpackage.m61;
import defpackage.nm;
import defpackage.v51;
import defpackage.v6;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class AppsLibraryItemFull extends ConstraintLayout implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {
    public final AppsLibraryBubbleTextView g;
    public final AppsLibraryBubbleTextView h;
    public final AppsLibraryBubbleTextView i;
    public final AppsLibraryBubbleTextView j;
    public final ConstraintLayout k;
    public final TextViewCustomFont l;
    public String m;
    public final t n;
    public final d90 o;
    public final h90 p;
    public boolean q;
    public int r;

    public AppsLibraryItemFull(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.m = "";
        this.q = false;
        setLayerType(2, null);
        LayoutInflater.from(context).inflate(m61.apps_library_item_full, (ViewGroup) this, true);
        if (context instanceof t) {
            this.n = (t) context;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(v51.app_background);
        this.k = constraintLayout;
        this.l = (TextViewCustomFont) findViewById(v51.app_category_title);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView = (AppsLibraryBubbleTextView) findViewById(v51.app_1);
        this.g = appsLibraryBubbleTextView;
        AppsLibraryBubbleTextView appsLibraryBubbleTextView2 = (AppsLibraryBubbleTextView) findViewById(v51.app_2);
        this.h = appsLibraryBubbleTextView2;
        AppsLibraryBubbleTextView appsLibraryBubbleTextView3 = (AppsLibraryBubbleTextView) findViewById(v51.app_3);
        this.i = appsLibraryBubbleTextView3;
        AppsLibraryBubbleTextView appsLibraryBubbleTextView4 = (AppsLibraryBubbleTextView) findViewById(v51.app_4);
        this.j = appsLibraryBubbleTextView4;
        this.n.getTinyDB().j(this);
        t tVar = this.n;
        if (!tVar.isUseLiquidGlass) {
            constraintLayout.setBackgroundResource(tVar.isDarkMode ? l51.icon_apps_library_background_dark : l51.icon_apps_library_background);
        } else if (tVar.isRuntimeRenderSupport) {
            h90 h90Var = new h90(tVar, false);
            this.p = h90Var;
            h90Var.setLayerType(2, null);
            h90Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
            h90Var.setFullBitmap(this.n.getBlurWallpaperProvider().e);
            h90Var.setSdfTexture(l51.lib);
            constraintLayout.addView(h90Var, 0);
        } else {
            d90 d90Var = new d90(this.n);
            this.o = d90Var;
            d90Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
            constraintLayout.addView(d90Var, 0);
        }
        int i = this.n.getDeviceProfile().C / 3;
        nm nmVar = (nm) appsLibraryBubbleTextView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) nmVar).topMargin = i;
        nmVar.setMarginStart(i);
        nm nmVar2 = (nm) appsLibraryBubbleTextView2.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) nmVar2).topMargin = i;
        nmVar2.setMarginEnd(i);
        nm nmVar3 = (nm) appsLibraryBubbleTextView3.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) nmVar3).bottomMargin = i;
        nmVar3.setMarginStart(i);
        nm nmVar4 = (nm) appsLibraryBubbleTextView4.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) nmVar4).bottomMargin = i;
        nmVar4.setMarginEnd(i);
        appsLibraryBubbleTextView.setOnClickListener(this);
        appsLibraryBubbleTextView2.setOnClickListener(this);
        appsLibraryBubbleTextView3.setOnClickListener(this);
        appsLibraryBubbleTextView4.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (view == null || view.getTag() == null) {
            return;
        }
        if (view.getId() != v51.app_4 || !this.q) {
            this.n.startAppShortcutOrInfoActivity(view);
            return;
        }
        e8 e8Var = this.j.H;
        if (e8Var.getParent() != null) {
            Objects.toString(e8Var);
            Objects.toString(e8Var.getParent());
            return;
        }
        t tVar = e8Var.k;
        tVar.hideAppsLibrary();
        tVar.getLauncherView().addView(e8Var);
        e8Var.setScaleX(0.3f);
        e8Var.setScaleY(0.3f);
        e8Var.setAlpha(0.0f);
        ObjectAnimator objectAnimatorD = ik0.d(e8Var, PropertyValuesHolder.ofFloat(Key.ALPHA, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f));
        objectAnimatorD.setDuration(399L);
        objectAnimatorD.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
        objectAnimatorD.addListener(new d8(e8Var, i));
        objectAnimatorD.start();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        d90 d90Var = this.o;
        if (d90Var == null) {
            h90 h90Var = this.p;
            if (h90Var != null) {
                h90Var.g();
                this.r = i;
                return;
            }
            return;
        }
        float f = i;
        float f2 = i2;
        b90 b90Var = (b90) d90Var.g.v.get(d90Var);
        if (b90Var == null) {
            return;
        }
        b90Var.f = f;
        b90Var.g = f2;
        b90Var.h = true;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null || !str.equals("dark_mode")) {
            return;
        }
        this.k.setBackgroundResource(sharedPreferences.getBoolean(str, false) ? l51.icon_apps_library_background_dark : l51.icon_apps_library_background);
    }

    public void setApps(ArrayList<v6> arrayList) {
        Objects.toString(arrayList);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView = this.g;
        appsLibraryBubbleTextView.setTag(null);
        appsLibraryBubbleTextView.getIconView().setBackground(null);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView2 = this.h;
        appsLibraryBubbleTextView2.setTag(null);
        appsLibraryBubbleTextView2.getIconView().setBackground(null);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView3 = this.i;
        appsLibraryBubbleTextView3.setTag(null);
        appsLibraryBubbleTextView3.getIconView().setBackground(null);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView4 = this.j;
        appsLibraryBubbleTextView4.setTag(null);
        appsLibraryBubbleTextView4.getIconView().setBackground(null);
        int i = 0;
        this.q = false;
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = 1;
            if (size <= 4) {
                if (size > 0) {
                    appsLibraryBubbleTextView.setTag(arrayList.get(0));
                    appsLibraryBubbleTextView.l(arrayList.get(0));
                    if (size > 1) {
                        appsLibraryBubbleTextView2.setTag(arrayList.get(1));
                        appsLibraryBubbleTextView2.l(arrayList.get(1));
                    }
                    if (size > 2) {
                        appsLibraryBubbleTextView3.setTag(arrayList.get(2));
                        appsLibraryBubbleTextView3.l(arrayList.get(2));
                    }
                    if (size > 3) {
                        appsLibraryBubbleTextView4.setTag(arrayList.get(3));
                        appsLibraryBubbleTextView4.l(arrayList.get(3));
                        return;
                    }
                    return;
                }
                return;
            }
            appsLibraryBubbleTextView.setTag(arrayList.get(0));
            appsLibraryBubbleTextView.l(arrayList.get(0));
            appsLibraryBubbleTextView2.setTag(arrayList.get(1));
            appsLibraryBubbleTextView2.l(arrayList.get(1));
            appsLibraryBubbleTextView3.setTag(arrayList.get(2));
            appsLibraryBubbleTextView3.l(arrayList.get(2));
            appsLibraryBubbleTextView4.setTag(arrayList.get(3));
            Objects.toString(arrayList);
            Paint paint = new Paint(1);
            paint.setAntiAlias(true);
            int width = arrayList.get(0).y.getWidth();
            double d = width;
            int i3 = (int) (d / 2.6d);
            int i4 = (int) ((d * 0.6d) / 7.800000000000001d);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            int iMin = Math.min(arrayList.size() - 3, 4);
            while (i < iMin) {
                int i5 = i % 2;
                int i6 = ((i5 + i2) * i4) + (i5 * i3);
                int i7 = i / 2;
                int i8 = ((i7 + i2) * i4) + (i7 * i3);
                canvas.drawBitmap(arrayList.get(i + 3).y, (Rect) null, new Rect(i6, i8, i6 + i3, i8 + i3), paint);
                i++;
                i3 = i3;
                i2 = 1;
            }
            appsLibraryBubbleTextView4.x(appsLibraryBubbleTextView4.G.createIconDrawable(bitmapCreateBitmap), appsLibraryBubbleTextView4.getIconSize());
            String str = this.m;
            e8 e8Var = appsLibraryBubbleTextView4.H;
            e8Var.getClass();
            Objects.toString(arrayList);
            b8 b8Var = e8Var.m;
            ArrayList arrayList2 = b8Var.k;
            arrayList2.clear();
            arrayList2.addAll(arrayList);
            b8Var.m = str;
            b8Var.f();
            this.q = true;
        }
    }

    public void setTitle(String str) {
        this.m = str;
        this.l.setText(str);
    }
}
