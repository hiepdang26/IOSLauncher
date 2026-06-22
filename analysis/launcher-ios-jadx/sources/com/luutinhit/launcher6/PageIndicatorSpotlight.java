package com.luutinhit.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.e51;
import defpackage.m61;
import defpackage.r1;
import defpackage.v01;
import defpackage.w01;
import defpackage.yu;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PageIndicatorSpotlight extends PageIndicator {
    public static final /* synthetic */ int D = 0;
    public int A;
    public int B;
    public final r1 C;
    public final ArrayList y;
    public int z;

    public PageIndicatorSpotlight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new ArrayList();
        this.z = 0;
        this.A = 0;
        this.B = 1;
        this.C = new r1(this, 22);
    }

    public static void g(PageIndicatorSpotlight pageIndicatorSpotlight, int i, v01 v01Var) {
        ArrayList arrayList = pageIndicatorSpotlight.m;
        int iMax = Math.max(0, Math.min(i, arrayList.size()));
        int i2 = m61.page_indicator_marker;
        LayoutInflater layoutInflater = pageIndicatorSpotlight.g;
        PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) layoutInflater.inflate(i2, (ViewGroup) pageIndicatorSpotlight, false);
        pageIndicatorMarker.setMarkerDrawables(v01Var.a);
        arrayList.add(iMax, pageIndicatorMarker);
        pageIndicatorSpotlight.B = arrayList.size();
        ArrayList arrayList2 = pageIndicatorSpotlight.y;
        int size = arrayList2.size();
        PageIndicatorMarker pageIndicatorMarker2 = (PageIndicatorMarker) layoutInflater.inflate(m61.page_indicator_marker, (ViewGroup) pageIndicatorSpotlight, false);
        w01 w01Var = w01.h;
        if (pageIndicatorSpotlight.B > 4) {
            if (size == 4) {
                if (pageIndicatorSpotlight.A == iMax - 1) {
                    pageIndicatorSpotlight.setupFlexibleCirclesRight(arrayList2.size() - 2);
                } else {
                    ((PageIndicatorMarker) arrayList2.get(size - 1)).c(w01.g, true);
                }
            }
        } else if (size == 0) {
            w01Var = w01.i;
        }
        pageIndicatorMarker2.c(w01Var, true);
        if (size < 4) {
            arrayList2.add(pageIndicatorMarker2);
            pageIndicatorMarker2.setVisibility(0);
            pageIndicatorSpotlight.addView(pageIndicatorMarker2);
        }
    }

    private void setupFlexibleCirclesLeft(int i) {
        getVisibleDotCounts();
        getNoOfPages();
        int i2 = this.A;
        w01 w01Var = w01.h;
        w01 w01Var2 = w01.i;
        ArrayList arrayList = this.y;
        if (i == 2) {
            ((PageIndicatorMarker) arrayList.get(2)).c(w01Var, true);
            ((PageIndicatorMarker) arrayList.get(1)).c(w01Var2, true);
            return;
        }
        if (i >= 2) {
            ((PageIndicatorMarker) arrayList.get(i - 1)).c(w01Var2, true);
            return;
        }
        if (i2 == 0) {
            ((PageIndicatorMarker) arrayList.get(0)).c(w01Var2, true);
            return;
        }
        getVisibleDotCounts();
        getNoOfPages();
        int size = arrayList.size() - 1;
        removeView((View) arrayList.get(size));
        arrayList.remove(size);
        PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) arrayList.get(arrayList.size() - 1);
        w01 w01Var3 = w01.g;
        pageIndicatorMarker.c(w01Var3, false);
        PageIndicatorMarker pageIndicatorMarker2 = (PageIndicatorMarker) this.g.inflate(m61.page_indicator_marker, (ViewGroup) this, false);
        pageIndicatorMarker2.c(this.A == 1 ? w01Var : w01Var3, false);
        h(false, pageIndicatorMarker2);
        if (i != 1 && ((PageIndicatorMarker) arrayList.get(1)).getState() == w01Var3) {
            ((PageIndicatorMarker) arrayList.get(1)).c(w01Var, false);
        }
        ((PageIndicatorMarker) arrayList.get(i)).c(w01Var2, false);
    }

    private void setupFlexibleCirclesRight(int i) {
        getVisibleDotCounts();
        getNoOfPages();
        int i2 = this.A;
        w01 w01Var = w01.i;
        ArrayList arrayList = this.y;
        if (i < 2) {
            if (i2 < arrayList.size() - 1 || arrayList.size() < 3) {
                ((PageIndicatorMarker) arrayList.get(this.A)).c(w01Var, true);
                return;
            } else {
                ((PageIndicatorMarker) arrayList.get(2)).c(w01Var, true);
                return;
            }
        }
        if (i2 == getNoOfPages() - 1) {
            ((PageIndicatorMarker) arrayList.get(arrayList.size() - 1)).c(w01Var, true);
            return;
        }
        getVisibleDotCounts();
        getNoOfPages();
        removeView((View) arrayList.get(0));
        arrayList.remove(0);
        PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) arrayList.get(0);
        w01 w01Var2 = w01.g;
        pageIndicatorMarker.c(w01Var2, false);
        PageIndicatorMarker pageIndicatorMarker2 = (PageIndicatorMarker) this.g.inflate(m61.page_indicator_marker, (ViewGroup) this, false);
        if (this.A == getNoOfPages() - 2) {
            w01Var2 = w01.h;
        }
        pageIndicatorMarker2.c(w01Var2, true);
        h(true, pageIndicatorMarker2);
        ((PageIndicatorMarker) arrayList.get(i)).c(w01Var, false);
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    public final void a(int i, v01 v01Var) {
        post(new yu(this, i, v01Var, 2));
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    public final void b() {
        removeCallbacks(this.C);
        TextViewCustomFont textViewCustomFont = this.w;
        if (textViewCustomFont != null) {
            textViewCustomFont.setVisibility(8);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null && (getChildAt(i) instanceof PageIndicatorMarker)) {
                getChildAt(i).setVisibility(0);
            }
        }
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    public final void e(int i) {
        ArrayList arrayList = this.m;
        if (!arrayList.isEmpty()) {
            arrayList.remove(Math.max(0, Math.min(arrayList.size() - 1, i)));
        }
        int size = arrayList.size();
        this.B = size;
        ArrayList arrayList2 = this.y;
        if (arrayList2.size() > size) {
            int size2 = arrayList2.size() - 1;
            removeView((View) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        int i2 = this.A;
        w01 w01Var = w01.h;
        w01 w01Var2 = w01.i;
        if ((i2 == size || i2 == size - 1) && arrayList2.size() > 1) {
            ((PageIndicatorMarker) arrayList2.get(arrayList2.size() - 1)).c(w01Var2, false);
            ((PageIndicatorMarker) arrayList2.get(arrayList2.size() - 2)).c(w01Var, false);
        } else {
            if (this.A != size - 2 || arrayList2.size() <= 1) {
                return;
            }
            ((PageIndicatorMarker) arrayList2.get(arrayList2.size() - 1)).c(w01Var, false);
            ((PageIndicatorMarker) arrayList2.get(arrayList2.size() - 2)).c(w01Var2, false);
            if (arrayList2.size() >= 3) {
                ((PageIndicatorMarker) arrayList2.get(arrayList2.size() - 3)).c(w01Var, false);
            }
        }
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    public final void f() {
        r1 r1Var = this.C;
        removeCallbacks(r1Var);
        postOnAnimationDelayed(r1Var, 1369L);
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    public int getBottomPosition() {
        return super.getBottomPosition();
    }

    public int getNoOfPages() {
        return this.B;
    }

    public int getVisibleDotCounts() {
        return 4;
    }

    public final void h(boolean z, PageIndicatorMarker pageIndicatorMarker) {
        pageIndicatorMarker.setScaleX(0.0f);
        pageIndicatorMarker.setScaleY(0.0f);
        int dimensionPixelSize = (int) ((pageIndicatorMarker.getState() == w01.g ? getResources().getDimensionPixelSize(e51.dynamic_grid_page_indicator_size) * 0.4f : 0.0f) + (getResources().getDimensionPixelSize(e51.dynamic_grid_page_indicator_margin) * 2));
        ArrayList arrayList = this.y;
        if (z) {
            arrayList.add(pageIndicatorMarker);
            addView(pageIndicatorMarker);
            pageIndicatorMarker.setTranslationX(getLayoutDirection() == 1 ? -dimensionPixelSize : dimensionPixelSize);
        } else {
            arrayList.add(0, pageIndicatorMarker);
            addView(pageIndicatorMarker, 0);
            pageIndicatorMarker.setTranslationX(getLayoutDirection() == 1 ? dimensionPixelSize : -dimensionPixelSize);
        }
        pageIndicatorMarker.animate().withLayer().scaleX(1.0f).scaleY(1.0f).translationX(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(268L).start();
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    public void setActiveMarker(int i) {
        if (i != this.n) {
            this.n = i;
        }
        int i2 = this.n;
        getNoOfPages();
        this.A = i2;
        if (i2 == this.z || i2 < 0 || i2 > getNoOfPages() - 1) {
            return;
        }
        if (this.z < getNoOfPages()) {
            int i3 = this.B;
            w01 w01Var = w01.h;
            ArrayList arrayList = this.y;
            if (i3 > 4) {
                arrayList.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) arrayList.get(i4);
                    if (pageIndicatorMarker.h) {
                        pageIndicatorMarker.c(w01Var, true);
                        if (this.A > this.z) {
                            setupFlexibleCirclesRight(i4);
                        } else {
                            setupFlexibleCirclesLeft(i4);
                        }
                    } else {
                        i4++;
                    }
                }
            } else {
                ((PageIndicatorMarker) arrayList.get(this.A)).c(w01.i, true);
                ((PageIndicatorMarker) arrayList.get(this.z)).c(w01Var, true);
            }
        }
        this.z = this.A;
    }
}
