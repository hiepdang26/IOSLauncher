package defpackage;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.profileinstaller.ProfileVersion;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.gms.internal.ads.zzbbc;
import com.luutinhit.launcher6.BlurScreenLayout;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.LauncherRootView;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.DeleteCircleView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcher6.widget.CalendarWidget;
import com.luutinhit.launcher6.widget.CalendarWidget_2x2;
import com.luutinhit.launcher6.widget.WeatherWidget;
import com.luutinhit.launcher6.widget.WeatherWidget_2x2;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.weather.model.openweathermodel.Daily;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wc implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    public /* synthetic */ wc(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    private final void a() {
        s31 s31Var = (s31) this.h;
        zy1 zy1Var = (zy1) this.i;
        synchronized (s31Var.k) {
            try {
                ArrayList arrayList = s31Var.j;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((h10) obj).d(zy1Var, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2 = 1;
        switch (this.g) {
            case 0:
                int i3 = BlurScreenLayout.q;
                ((BlurScreenLayout) this.h).dispatchDraw((Canvas) this.i);
                return;
            case 1:
                Integer num = (Integer) this.i;
                ow1 ow1Var = (ow1) this.h;
                ow1Var.getClass();
                try {
                    int iIntValue = num.intValue();
                    CalendarWidget calendarWidget = (CalendarWidget) ow1Var.h;
                    if (iIntValue > 2) {
                        y00 y00Var = calendarWidget.s;
                        y00Var.p = calendarWidget.u;
                        y00Var.f();
                        y00 y00Var2 = calendarWidget.t;
                        y00Var2.p = calendarWidget.v;
                        y00Var2.f();
                        calendarWidget.n.setVisibility(0);
                    } else {
                        y00 y00Var3 = calendarWidget.s;
                        y00Var3.p = calendarWidget.u;
                        y00Var3.f();
                        calendarWidget.n.setVisibility(8);
                    }
                    calendarWidget.x = true;
                    return;
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
            case 2:
                ArrayList arrayList = (ArrayList) this.i;
                fz1 fz1Var = (fz1) this.h;
                fz1Var.getClass();
                try {
                    int size = arrayList.size();
                    CalendarWidget_2x2 calendarWidget_2x2 = (CalendarWidget_2x2) fz1Var.h;
                    if (size < 2) {
                        arrayList.add(new w00(0, -16711936, calendarWidget_2x2.k.getString(w61.no_more_events), ""));
                    }
                    y00 y00Var4 = calendarWidget_2x2.p;
                    y00Var4.p = arrayList;
                    y00Var4.f();
                    calendarWidget_2x2.q = true;
                    arrayList.toString();
                    return;
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
            case 3:
                List list = (List) this.h;
                qg0.l(list, "$listenersList");
                fn fnVar = (fn) this.i;
                qg0.l(fnVar, "this$0");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((jm) it.next()).a(fnVar.e);
                }
                return;
            case 4:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.h;
                do0 do0Var = (do0) this.i;
                qg0.l(constraintTrackingWorker, "this$0");
                synchronized (constraintTrackingWorker.l) {
                    try {
                        if (constraintTrackingWorker.m) {
                            nf1 nf1Var = constraintTrackingWorker.n;
                            qg0.k(nf1Var, "future");
                            int i4 = hn.a;
                            nf1Var.i(new fo0());
                        } else {
                            constraintTrackingWorker.n.k(do0Var);
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return;
            case 5:
                View view = (View) this.i;
                my myVar = (my) this.h;
                t tVar = myVar.x;
                try {
                    int i5 = !ar1.v(myVar.getResources()) ? 1 : 0;
                    WeakHashMap weakHashMap = qs1.a;
                    myVar.setLayoutDirection(i5);
                    pw pwVar = (pw) myVar.getLayoutParams();
                    ((FrameLayout.LayoutParams) pwVar).height = (myVar.getResources().getDimensionPixelSize(e51.shortcut_info_item_height) * 2) - 1;
                    myVar.setLayoutParams(pwVar);
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i6 = iArr[0];
                    int i7 = myVar.B;
                    int i8 = i7 / 2;
                    int i9 = myVar.z;
                    int i10 = myVar.A;
                    if (i6 < i8) {
                        i = i9 + i10;
                        myVar.setPivotX(i9 / 2.0f);
                        myVar.setPivotY(0.0f);
                    } else {
                        int i11 = myVar.C;
                        int i12 = (i7 - i11) - i10;
                        myVar.setPivotX(i11 - (i9 / 2.0f));
                        myVar.setPivotY(0.0f);
                        i = i9 + i10;
                        i10 = i12;
                    }
                    pwVar.b = Math.max(i10, 0);
                    pwVar.c = Math.max(i, 0);
                    myVar.setLayoutParams(pwVar);
                    try {
                        tVar.getDragLayer().removeView(myVar);
                        break;
                    } catch (Throwable th4) {
                        th4.getMessage();
                    }
                    try {
                        tVar.getDragLayer().addView(myVar, pwVar);
                        break;
                    } catch (Throwable th5) {
                        th5.getMessage();
                    }
                    myVar.setScaleX(0.0f);
                    myVar.setScaleY(0.0f);
                    myVar.setAlpha(0.0f);
                    myVar.postDelayed(new ky(myVar, i2), 80L);
                    return;
                } catch (Throwable th6) {
                    th6.getMessage();
                    return;
                }
            case 6:
                ((b70) this.h).dispatchDraw((Canvas) this.i);
                return;
            case 7:
                c90 c90Var = (c90) this.h;
                ((b90) this.i).a(c90Var.b, c90Var.d);
                return;
            case 8:
                l90 l90Var = (l90) this.h;
                int i13 = l90Var.o;
                Bitmap bitmap = (Bitmap) this.i;
                l90Var.o = l90Var.h(bitmap, i13, true);
                try {
                    bitmap.recycle();
                    break;
                } catch (Throwable unused) {
                }
                l90Var.O.set(true);
                l90Var.P.set(true);
                return;
            case 9:
                ((IOSLauncher) this.h).lambda$hideNavigationNow$2((View) this.i);
                return;
            case 10:
                ((IOSLauncher) this.h).lambda$setWallpaperFromBitmap$10((Bitmap) this.i);
                return;
            case 11:
                ((t) this.h).w((BubbleTextView) this.i);
                return;
            case 12:
                ((t) this.h).w((pk0) this.i);
                return;
            case 13:
                ((t) this.h).bindAppWidget((qk0) this.i);
                return;
            case 14:
                int i14 = LauncherRootView.l;
                ((LauncherRootView) this.h).dispatchDraw((Canvas) this.i);
                return;
            case 15:
                a();
                return;
            case 16:
                ((qb1) this.h).onFontRetrieved((Typeface) this.i);
                return;
            case 17:
                kg1 kg1Var = (kg1) this.h;
                View view2 = (View) this.i;
                if (view2 instanceof BubbleTextView) {
                    ((BubbleTextView) view2).u.c(8, true);
                } else if (view2 instanceof pk0) {
                    DeleteCircleView deleteCircleView = ((pk0) view2).n;
                    Objects.toString(deleteCircleView);
                    if (deleteCircleView != null) {
                        deleteCircleView.c(8, true);
                    }
                }
                ng1 ng1Var = kg1Var.h;
                Animator animator = (Animator) ng1Var.s.get(view2);
                if (animator != null) {
                    animator.cancel();
                }
                Animator animator2 = (Animator) ng1Var.t.get(view2);
                if (animator2 != null) {
                    animator2.start();
                    return;
                }
                return;
            case 18:
                int i15 = TextViewCustomFont.g;
                TextViewCustomFont textViewCustomFont = (TextViewCustomFont) this.h;
                textViewCustomFont.getClass();
                AttributeSet attributeSet = (AttributeSet) this.i;
                String str = "fonts/SFProTextMedium.otf";
                if (attributeSet != null) {
                    try {
                        TypedArray typedArrayObtainStyledAttributes = textViewCustomFont.getContext().obtainStyledAttributes(attributeSet, g71.TextViewCustomFont);
                        int i16 = typedArrayObtainStyledAttributes.getInt(g71.TextViewCustomFont_customFont, 0);
                        if (i16 == 1) {
                            str = "fonts/SFProTextLight.otf";
                        } else if (i16 == 2) {
                            str = "fonts/SFProTextUltralight.otf";
                        } else if (i16 == 3) {
                            str = "fonts/SFProTextSemiBold.ttf";
                        }
                        typedArrayObtainStyledAttributes.recycle();
                    } catch (Exception unused2) {
                        textViewCustomFont.setTypeface(Typeface.DEFAULT);
                        return;
                    }
                }
                Context context = textViewCustomFont.getContext();
                HashMap map = jn1.a;
                Typeface typefaceCreateFromAsset = (Typeface) map.get(str);
                if (typefaceCreateFromAsset == null) {
                    try {
                        typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), str);
                        map.put(str, typefaceCreateFromAsset);
                    } catch (Exception unused3) {
                        typefaceCreateFromAsset = Typeface.DEFAULT;
                    }
                    break;
                }
                textViewCustomFont.setTypeface(typefaceCreateFromAsset);
                return;
            case 19:
                xv xvVar = (xv) this.h;
                qg0.l(xvVar, "this$0");
                bj1 bj1Var = (bj1) this.i;
                qg0.l(bj1Var, "$token");
                ((q11) xvVar.i).P(bj1Var, 3);
                return;
            case 20:
                ((ViewTransition) this.h).lambda$applyTransition$0((View[]) this.i);
                return;
            case zzbbc.zzt.zzm /* 21 */:
                ((fw1) this.h).y0.p((ArrayList) this.i, true);
                return;
            case 22:
                int i17 = WeatherWidget.H;
                WeatherWidget weatherWidget = (WeatherWidget) this.h;
                weatherWidget.getClass();
                DailyResponse dailyResponse = (DailyResponse) this.i;
                if (dailyResponse != null) {
                    List<Daily> list2 = dailyResponse.getList();
                    weatherWidget.n.setText("H:" + list2.get(0).getTemp().getMax() + "° L:" + list2.get(0).getTemp().getMin() + (char) 176);
                    bo1 bo1Var = weatherWidget.A;
                    int min = list2.get(0).getTemp().getMin();
                    StringBuilder sb = new StringBuilder();
                    sb.append(min);
                    sb.append((char) 176);
                    bo1Var.h("current_temp_low", sb.toString());
                    bo1 bo1Var2 = weatherWidget.A;
                    int max = list2.get(0).getTemp().getMax();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(max);
                    sb2.append((char) 176);
                    bo1Var2.h("current_temp_high", sb2.toString());
                    return;
                }
                return;
            case 23:
                ((WeatherWidget) this.h).v.p((ArrayList) this.i, false);
                return;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                int i18 = WeatherWidget_2x2.E;
                WeatherWidget_2x2 weatherWidget_2x2 = (WeatherWidget_2x2) this.h;
                weatherWidget_2x2.getClass();
                DailyResponse dailyResponse2 = (DailyResponse) this.i;
                if (dailyResponse2 != null) {
                    List<Daily> list3 = dailyResponse2.getList();
                    weatherWidget_2x2.n.setText("H:" + list3.get(0).getTemp().getMax() + "° L:" + list3.get(0).getTemp().getMin() + (char) 176);
                    bo1 bo1Var3 = weatherWidget_2x2.y;
                    int min2 = list3.get(0).getTemp().getMin();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(min2);
                    sb3.append((char) 176);
                    bo1Var3.h("current_temp_low", sb3.toString());
                    bo1 bo1Var4 = weatherWidget_2x2.y;
                    int max2 = list3.get(0).getTemp().getMax();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(max2);
                    sb4.append((char) 176);
                    bo1Var4.h("current_temp_high", sb4.toString());
                    return;
                }
                return;
            case 25:
                qx1 qx1Var = (qx1) this.i;
                WidgetsContainerView widgetsContainerView = (WidgetsContainerView) ((ew1) this.h).h;
                try {
                    qx1Var.a.size();
                    px1 px1Var = widgetsContainerView.U;
                    px1Var.l = qx1Var;
                    px1Var.s = new boolean[qx1Var.b.size()];
                    if (widgetsContainerView.T.T()) {
                        return;
                    }
                    widgetsContainerView.U.f();
                    return;
                } catch (Throwable th7) {
                    th7.getMessage();
                    return;
                }
            case 26:
                xy1 xy1Var = (xy1) this.h;
                nf1 nf1Var2 = (nf1) this.i;
                if (xy1Var.g.g instanceof h) {
                    nf1Var2.cancel(true);
                    return;
                } else {
                    nf1Var2.k(xy1Var.j.getForegroundInfoAsync());
                    return;
                }
            default:
                uz1 uz1Var = (uz1) this.h;
                nf1 nf1Var3 = (nf1) this.i;
                if (uz1Var.w.g instanceof h) {
                    nf1Var3.cancel(true);
                    return;
                }
                return;
        }
    }
}
