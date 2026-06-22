package com.luutinhit.weather;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.viewpager.widget.ViewPager;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.IndicatorView;
import com.luutinhit.weather.WeatherActivity;
import defpackage.aw1;
import defpackage.bw1;
import defpackage.ci1;
import defpackage.en;
import defpackage.fw1;
import defpackage.g41;
import defpackage.h60;
import defpackage.l51;
import defpackage.m61;
import defpackage.nm;
import defpackage.nx0;
import defpackage.og0;
import defpackage.qg0;
import defpackage.s2;
import defpackage.u71;
import defpackage.ua;
import defpackage.uv1;
import defpackage.v51;
import defpackage.w61;
import defpackage.xi;
import defpackage.xv1;
import defpackage.yf;
import defpackage.yi1;
import defpackage.zi1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class WeatherActivity extends ua implements View.OnClickListener {
    public static final /* synthetic */ int V = 0;
    public Context B;
    public ViewPager C;
    public ImageView D;
    public ConstraintWeatherLayout E;
    public IndicatorView F;
    public ArrayList G = new ArrayList();
    public fw1 H;
    public final ArrayList I;
    public u71 J;
    public u71 K;
    public u71 L;
    public ci1 M;
    public int N;
    public int O;
    public final int[] P;
    public final int[] Q;
    public final int[] R;
    public final int[] S;
    public final Random T;
    public og0 U;

    public WeatherActivity() {
        new ArrayList();
        this.I = new ArrayList();
        int i = l51.cloud_1;
        int i2 = l51.cloud_2;
        int i3 = l51.cloud_3;
        int i4 = l51.cloud_4;
        int i5 = l51.cloud_5;
        int i6 = l51.cloud_6;
        int i7 = l51.cloud_7;
        int i8 = l51.cloud_8;
        int i9 = l51.cloud_9;
        int i10 = l51.cloud_10;
        int i11 = l51.cloud_11;
        int i12 = l51.cloud_12;
        int i13 = l51.cloud_13;
        int i14 = l51.cloud_14;
        this.P = new int[]{i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14};
        this.Q = new int[]{i, i9, i10};
        this.R = new int[]{i7, i8, i11, i12, i13, i14};
        this.S = new int[]{l51.weather_lighting_1, l51.weather_lighting_2, l51.weather_lighting_3, l51.weather_lighting_5, l51.weather_lighting_6, l51.weather_lighting_8};
        this.T = new Random();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void A(int[] iArr, int i, boolean z) {
        for (int i2 = 0; i2 < i; i2++) {
            ImageFilterView imageFilterView = new ImageFilterView(this);
            int iGenerateViewId = View.generateViewId();
            imageFilterView.setId(iGenerateViewId);
            Random random = this.T;
            imageFilterView.setImageResource(iArr[random.nextInt(iArr.length)]);
            if (z) {
                imageFilterView.setAlpha(0.6f);
                imageFilterView.setContrast(0.9f);
                imageFilterView.setBrightness(0.6f);
                imageFilterView.setWarmth(1.0f);
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.1f, 2, -1.1f, 2, (random.nextFloat() - 0.8f) / 3.0f, 2, (random.nextFloat() - 0.8f) / 3.0f);
            translateAnimation.setFillEnabled(true);
            translateAnimation.setFillAfter(true);
            translateAnimation.setStartOffset(((long) i2) * 5000);
            translateAnimation.setDuration((random.nextInt(5) + 1) * 36000);
            translateAnimation.setInterpolator(new PathInterpolator(0.15f, 0.5f, 0.8f, 0.5f));
            translateAnimation.setRepeatCount(-1);
            if (random.nextBoolean()) {
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, -1.1f, 2, (random.nextFloat() - 0.8f) / 3.0f, 2, (random.nextFloat() - 0.8f) / 3.0f);
                translateAnimation2.setDuration((random.nextInt(5) + 1) * 36000);
                translateAnimation2.setInterpolator(new PathInterpolator(0.15f, 0.5f, 0.8f, 0.5f));
                translateAnimation2.setAnimationListener(new aw1(imageFilterView, translateAnimation));
                imageFilterView.startAnimation(translateAnimation2);
            } else {
                imageFilterView.startAnimation(translateAnimation);
            }
            this.E.addView(imageFilterView, 1);
            ArrayList arrayList = this.I;
            arrayList.add(Integer.valueOf(iGenerateViewId));
            arrayList.size();
        }
    }

    public final void B(int i) {
        u71 u71Var = (u71) findViewById(v51.weather_drizzle_effect);
        this.J = u71Var;
        if (u71Var != null) {
            this.E.removeView(u71Var);
        } else {
            u71 u71Var2 = new u71(this);
            this.J = u71Var2;
            u71Var2.setId(v51.weather_drizzle_effect);
        }
        this.E.addView(this.J, 1);
        this.J.post(new yf(this, i, 5));
    }

    public final void C(int i) {
        u71 u71Var = (u71) findViewById(v51.weather_rain_effect);
        this.K = u71Var;
        if (u71Var != null) {
            this.E.removeView(u71Var);
        } else {
            u71 u71Var2 = new u71(this);
            this.K = u71Var2;
            u71Var2.setId(v51.weather_rain_effect);
        }
        this.E.addView(this.K, 1);
        this.K.post(new xv1(this, i, 0));
    }

    public final void D(int i) {
        u71 u71Var = (u71) findViewById(v51.weather_sleet_effect);
        this.L = u71Var;
        if (u71Var != null) {
            this.E.removeView(u71Var);
        } else {
            u71 u71Var2 = new u71(this);
            this.L = u71Var2;
            u71Var2.setId(v51.weather_sleet_effect);
        }
        this.E.addView(this.L, 1);
        this.L.post(new xv1(this, i, 2));
    }

    public final void E(int i) {
        ci1 ci1Var = (ci1) findViewById(v51.weather_snow_effect);
        this.M = ci1Var;
        if (ci1Var != null) {
            this.E.removeView(ci1Var);
        } else {
            ci1 ci1Var2 = new ci1(this);
            this.M = ci1Var2;
            ci1Var2.setId(v51.weather_snow_effect);
        }
        this.M.post(new xv1(this, i, 1));
        this.E.addView(this.M, 1);
    }

    public final void F() {
        zi1 zi1Var = (zi1) findViewById(v51.weather_star_effect);
        if (zi1Var != null) {
            this.E.removeView(zi1Var);
        } else {
            zi1Var = new zi1(this);
            zi1Var.g = new ArrayList();
            zi1Var.g = new ArrayList();
            for (int i = 0; i < 100; i++) {
                ArrayList arrayList = zi1Var.g;
                int height = zi1Var.getHeight();
                int width = zi1Var.getWidth();
                yi1 yi1Var = new yi1();
                yi1Var.c = 255;
                yi1Var.d = true;
                yi1Var.g = -1;
                yi1Var.h = Color.parseColor("#26FFFFFF");
                yi1Var.i = 10;
                if (yi1.l == 0.0f) {
                    yi1.l = 0.02f;
                }
                if (yi1.j == null) {
                    Paint paint = new Paint();
                    yi1.j = paint;
                    paint.setAntiAlias(true);
                    Paint paint2 = yi1.j;
                    qg0.h(paint2);
                    paint2.setColor(-1);
                    Paint paint3 = yi1.j;
                    qg0.h(paint3);
                    paint3.setAlpha(yi1Var.c);
                    Paint paint4 = yi1.j;
                    qg0.h(paint4);
                    paint4.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                if (yi1.k == null) {
                    Paint paint5 = new Paint();
                    yi1.k = paint5;
                    paint5.setAntiAlias(true);
                    Paint paint6 = yi1.k;
                    qg0.h(paint6);
                    paint6.setColor(-1);
                    Paint paint7 = yi1.k;
                    qg0.h(paint7);
                    paint7.setAlpha(yi1Var.c);
                    Paint paint8 = yi1.k;
                    qg0.h(paint8);
                    paint8.setStyle(Paint.Style.FILL_AND_STROKE);
                    Paint paint9 = yi1.k;
                    qg0.h(paint9);
                    paint9.setStrokeWidth(1.0f);
                }
                yi1Var.a(height, width);
                arrayList.add(yi1Var);
            }
            zi1Var.setId(v51.weather_star_effect);
        }
        this.E.addView(zi1Var, 1);
    }

    public final void G(float f) {
        ImageFilterView imageFilterView = new ImageFilterView(this);
        imageFilterView.setId(v51.weather_sun_effect);
        imageFilterView.setImageResource(l51.sun_light);
        int i = this.N;
        nm nmVar = new nm(i, i);
        this.E.addView(imageFilterView, 1, nmVar);
        en enVar = new en();
        enVar.f(this.E);
        enVar.g(imageFilterView.getId(), 3, 0, 3, 0);
        enVar.g(imageFilterView.getId(), 2, 0, 2, 0);
        enVar.b(this.E);
        float f2 = 0.5f - f;
        if (f > 0.5f) {
            f = 1.0f - f;
        }
        int i2 = this.N;
        ((ViewGroup.MarginLayoutParams) nmVar).topMargin = (int) ((-f) * i2);
        ((ViewGroup.MarginLayoutParams) nmVar).rightMargin = (int) (f2 * i2);
        imageFilterView.startAnimation(AnimationUtils.loadAnimation(this.B, g41.sun_rotate_anim));
    }

    public final void H(final int i, final boolean z) {
        final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 100);
        valueAnimatorOfInt.setDuration(5000L);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        this.E.post(new Runnable() { // from class: yv1
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = WeatherActivity.V;
                final WeatherActivity weatherActivity = this.g;
                weatherActivity.getClass();
                final int i3 = i;
                final boolean z2 = z;
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: zv1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int i4 = 29;
                        int i5 = 1;
                        int i6 = 2;
                        int i7 = 0;
                        WeatherActivity weatherActivity2 = weatherActivity;
                        Random random = weatherActivity2.T;
                        if (random.nextInt(10) != 0 || random.nextInt(100) >= i3) {
                            return;
                        }
                        ImageView imageView = (ImageView) weatherActivity2.findViewById(v51.flash);
                        imageView.setVisibility(0);
                        Resources resources = weatherActivity2.getResources();
                        int[] iArr = weatherActivity2.S;
                        int i8 = iArr[random.nextInt(iArr.length)];
                        ThreadLocal threadLocal = rb1.a;
                        ClipDrawable clipDrawable = new ClipDrawable(resources.getDrawable(i8, null), 48, 2);
                        ImageFilterView imageFilterView = new ImageFilterView(weatherActivity2);
                        imageFilterView.setId(View.generateViewId());
                        imageFilterView.setImageDrawable(clipDrawable);
                        imageFilterView.setScaleX(random.nextFloat() + 1.0f);
                        imageFilterView.setRotation(random.nextInt(90));
                        imageFilterView.setContrast(2.0f);
                        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(0, 10000);
                        valueAnimatorOfInt2.setDuration(123L);
                        valueAnimatorOfInt2.setInterpolator(new LinearInterpolator());
                        valueAnimatorOfInt2.addUpdateListener(new qo0(clipDrawable, i6));
                        boolean zNextBoolean = random.nextBoolean();
                        boolean z3 = z2;
                        if (zNextBoolean) {
                            imageView.animate().withLayer().alpha(0.0f).setDuration(0L).setStartDelay(0L).withEndAction(new wv1(imageView, 6)).start();
                            if (z3 && random.nextBoolean()) {
                                imageFilterView.animate().withLayer().alpha(0.0f).setDuration(0L).setStartDelay(0L).withEndAction(new vv1(weatherActivity2, imageFilterView, i7)).withStartAction(new r1(valueAnimatorOfInt2, i4)).start();
                                weatherActivity2.E.addView(imageFilterView, 1);
                                return;
                            }
                            return;
                        }
                        imageView.animate().withLayer().alpha(0.0f).setDuration(0L).setStartDelay(0L).withEndAction(new wv1(imageView, i7)).start();
                        if (z3 && random.nextBoolean()) {
                            imageFilterView.animate().withLayer().alpha(0.0f).setDuration(0L).setStartDelay(0L).withEndAction(new vv1(weatherActivity2, imageFilterView, i5)).withStartAction(new r1(valueAnimatorOfInt2, i4)).start();
                            weatherActivity2.E.addView(imageFilterView, 1);
                        }
                    }
                });
            }
        });
        valueAnimatorOfInt.start();
    }

    public final void I(boolean z) {
        try {
            og0.load(this, getString(w61.ad_unit_id_weather), new s2(new nx0(2)), new bw1(this, z));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void J(int i, long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(11);
        calendar.setTimeInMillis(j);
        int i3 = calendar.get(11);
        calendar.setTimeInMillis(j2);
        float f = (i2 - i3) / (calendar.get(11) - i3);
        boolean z = f < 0.0f || f > 1.0f;
        View viewFindViewById = findViewById(v51.weather_sun_effect);
        if (viewFindViewById != null) {
            viewFindViewById.clearAnimation();
            this.E.removeView(viewFindViewById);
        }
        View viewFindViewById2 = findViewById(v51.weather_rain_effect);
        if (viewFindViewById2 != null) {
            viewFindViewById2.clearAnimation();
            this.E.removeView(viewFindViewById2);
        }
        View viewFindViewById3 = findViewById(v51.weather_drizzle_effect);
        if (viewFindViewById3 != null) {
            viewFindViewById3.clearAnimation();
            this.E.removeView(viewFindViewById3);
        }
        View viewFindViewById4 = findViewById(v51.weather_sleet_effect);
        if (viewFindViewById4 != null) {
            viewFindViewById4.clearAnimation();
            this.E.removeView(viewFindViewById4);
        }
        ArrayList arrayList = this.I;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            View viewFindViewById5 = findViewById(((Integer) obj).intValue());
            if (viewFindViewById5 != null) {
                viewFindViewById5.clearAnimation();
                this.E.removeView(viewFindViewById5);
            }
        }
        this.E.invalidate();
        arrayList.clear();
        int[] iArr = this.Q;
        int[] iArr2 = this.P;
        int[] iArr3 = this.R;
        if (z) {
            switch (i) {
                case 200:
                    K(9);
                    A(iArr3, 8, true);
                    H(3, true);
                    C(50);
                    break;
                case 201:
                case 202:
                    K(9);
                    A(iArr3, 10, true);
                    H(5, true);
                    C(150);
                    break;
                case 210:
                case 211:
                case 212:
                    K(8);
                    A(iArr3, 8, true);
                    H(5, true);
                    break;
                case 221:
                    K(8);
                    K(8);
                    A(iArr3, 6, true);
                    H(2, true);
                    break;
                case 230:
                    K(9);
                    A(iArr3, 6, true);
                    H(3, true);
                    B(60);
                    break;
                case 231:
                case 232:
                    K(9);
                    A(iArr3, 10, true);
                    H(5, true);
                    B(100);
                    break;
                case t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT /* 300 */:
                    K(10);
                    A(iArr3, 6, true);
                    B(60);
                    break;
                case 301:
                case 302:
                    K(11);
                    A(iArr3, 10, true);
                    B(100);
                    break;
                case 310:
                    K(10);
                    A(iArr3, 6, true);
                    B(50);
                    C(50);
                    break;
                case 311:
                case 312:
                case 313:
                case 314:
                case 321:
                    K(11);
                    A(iArr3, 8, true);
                    B(100);
                    C(50);
                    break;
                case 500:
                case 501:
                case 520:
                    K(10);
                    A(iArr3, 6, true);
                    C(60);
                    break;
                case 502:
                case 503:
                case 521:
                    K(11);
                    A(iArr3, 10, true);
                    C(100);
                    break;
                case 504:
                case 522:
                case 531:
                    K(3);
                    A(iArr3, 8, true);
                    C(150);
                    break;
                case 511:
                    K(3);
                    A(iArr3, 8, false);
                    C(50);
                    E(50);
                    break;
                case 600:
                    K(5);
                    A(iArr2, 5, false);
                    E(50);
                    break;
                case 601:
                case 602:
                    K(5);
                    A(iArr2, 5, false);
                    E(100);
                    break;
                case 611:
                case 612:
                case 613:
                    K(5);
                    A(iArr2, 5, false);
                    D(80);
                    break;
                case 615:
                    K(5);
                    A(iArr2, 5, false);
                    E(50);
                    C(30);
                    break;
                case 616:
                case 620:
                case 621:
                case 622:
                    K(3);
                    A(iArr2, 5, false);
                    E(80);
                    C(80);
                    break;
                case 701:
                case 711:
                case 721:
                case 731:
                case 741:
                case 751:
                case 761:
                case 762:
                    K(2);
                    A(iArr2, 6, true);
                    break;
                case 771:
                    K(5);
                    A(iArr2, 6, false);
                    D(60);
                    break;
                case 781:
                    K(8);
                    A(iArr2, 6, true);
                    H(3, false);
                    break;
                case 800:
                    K(1);
                    F();
                    break;
                case 801:
                    K(12);
                    A(iArr, 2, false);
                    F();
                    break;
                case 802:
                    K(12);
                    A(iArr, 3, false);
                    F();
                    break;
                case 803:
                    K(12);
                    A(iArr2, 5, false);
                    F();
                    break;
                case 804:
                    K(12);
                    A(iArr2, 8, true);
                    break;
            }
        }
        switch (i) {
            case 200:
                K(9);
                A(iArr3, 8, true);
                H(3, true);
                C(50);
                break;
            case 201:
            case 202:
                K(9);
                A(iArr3, 10, true);
                H(5, true);
                C(150);
                break;
            case 210:
            case 211:
            case 212:
                K(8);
                A(iArr3, 8, true);
                H(5, true);
                break;
            case 221:
                K(8);
                K(8);
                A(iArr3, 6, true);
                H(2, true);
                break;
            case 230:
                K(9);
                A(iArr3, 6, true);
                H(3, true);
                B(60);
                break;
            case 231:
            case 232:
                K(9);
                A(iArr3, 10, true);
                H(5, true);
                B(100);
                break;
            case t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT /* 300 */:
                K(10);
                A(iArr3, 6, true);
                B(60);
                break;
            case 301:
            case 302:
                K(11);
                A(iArr3, 10, true);
                B(100);
                break;
            case 310:
                K(10);
                A(iArr3, 6, true);
                B(50);
                C(50);
                break;
            case 311:
            case 312:
            case 313:
            case 314:
            case 321:
                K(11);
                A(iArr3, 8, true);
                B(100);
                C(50);
                break;
            case 500:
            case 501:
            case 520:
                K(10);
                A(iArr3, 6, true);
                C(60);
                break;
            case 502:
            case 503:
            case 521:
                K(11);
                A(iArr3, 10, true);
                C(100);
                break;
            case 504:
            case 522:
            case 531:
                K(3);
                A(iArr3, 8, true);
                C(150);
                break;
            case 511:
                K(3);
                A(iArr3, 8, false);
                C(50);
                E(50);
                break;
            case 600:
                K(5);
                A(iArr2, 5, false);
                E(50);
                break;
            case 601:
            case 602:
                K(5);
                A(iArr2, 5, false);
                E(100);
                break;
            case 611:
            case 612:
            case 613:
                K(5);
                A(iArr2, 5, false);
                D(80);
                break;
            case 615:
                K(5);
                A(iArr2, 5, false);
                E(50);
                C(30);
                break;
            case 616:
            case 620:
            case 621:
            case 622:
                K(3);
                A(iArr2, 5, false);
                E(80);
                C(80);
                break;
            case 701:
            case 711:
            case 721:
            case 731:
            case 741:
            case 751:
            case 761:
            case 762:
                K(2);
                A(iArr2, 6, true);
                break;
            case 771:
                K(5);
                A(iArr2, 6, false);
                D(60);
                break;
            case 781:
                K(8);
                A(iArr2, 6, true);
                H(3, false);
                break;
            case 800:
                K(0);
                G(f);
                break;
            case 801:
                K(13);
                G(f);
                A(iArr, 2, false);
                break;
            case 802:
                K(13);
                G(f);
                A(iArr, 3, false);
                break;
            case 803:
                K(14);
                G(f);
                A(iArr2, 5, false);
                break;
            case 804:
                K(15);
                A(iArr2, 8, true);
                break;
        }
    }

    public final void K(int i) {
        if (this.E.getBackground() == null) {
            this.E.setBackground(l51.weather_background_state);
        }
        this.E.getBackground().setLevel(i);
    }

    @Override // defpackage.e6, androidx.activity.a, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        fw1 fw1Var;
        super.onActivityResult(i, i2, intent);
        if (i == 33 && i2 == -1 && (fw1Var = this.H) != null) {
            fw1Var.W();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == v51.city_switch) {
            startActivity(new Intent(this, (Class<?>) WeatherCitiesActivity.class));
        }
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.B = getApplicationContext();
        new Thread(new uv1(this, 0)).start();
        setContentView(m61.activity_weather);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        this.N = point.x;
        this.O = point.y;
        this.E = (ConstraintWeatherLayout) findViewById(v51.weather_background);
        this.C = (ViewPager) findViewById(v51.city_page);
        this.D = (ImageView) findViewById(v51.city_switch);
        this.F = (IndicatorView) findViewById(v51.indicator);
        z(this.E, false);
        fw1 fw1Var = new fw1();
        this.H = fw1Var;
        this.G.add(fw1Var);
        h60 h60VarO = o();
        ArrayList arrayList = this.G;
        xi xiVar = new xi(h60VarO);
        xiVar.h = arrayList;
        this.C.setAdapter(xiVar);
        this.C.setOffscreenPageLimit(this.G.size());
        this.F.setUpWithViewPager(this.C);
        this.D.setOnClickListener(this);
        this.I.clear();
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.G = null;
    }

    @Override // defpackage.e6, androidx.activity.a, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 68) {
            try {
                HashMap map = new HashMap();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    map.put(strArr[i2], Integer.valueOf(iArr[i2]));
                }
                if (((Integer) map.get("android.permission.ACCESS_FINE_LOCATION")).intValue() != 0) {
                    Toast.makeText(this, w61.warning_location_permission, 1).show();
                    return;
                }
                fw1 fw1Var = this.H;
                if (fw1Var != null) {
                    fw1Var.W();
                }
            } catch (Throwable unused) {
                Toast.makeText(this, w61.warning_location_permission, 1).show();
            }
        }
    }

    @Override // defpackage.ua, defpackage.e6, android.app.Activity
    public final void onStart() {
        super.onStart();
        Objects.toString(this.U);
        try {
            og0 og0Var = this.U;
            if (og0Var != null) {
                og0Var.show(this);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
