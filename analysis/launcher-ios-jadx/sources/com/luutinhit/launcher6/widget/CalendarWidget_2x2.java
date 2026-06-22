package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.os.Handler;
import android.provider.CalendarContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.ar1;
import defpackage.cw;
import defpackage.e42;
import defpackage.ee1;
import defpackage.fz1;
import defpackage.hg0;
import defpackage.hs0;
import defpackage.j7;
import defpackage.l51;
import defpackage.lt;
import defpackage.m61;
import defpackage.mf;
import defpackage.nm;
import defpackage.np1;
import defpackage.o1;
import defpackage.ur0;
import defpackage.v51;
import defpackage.vm;
import defpackage.vr0;
import defpackage.x4;
import defpackage.x41;
import defpackage.y00;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CalendarWidget_2x2 extends vm implements View.OnClickListener {
    public static final /* synthetic */ int z = 0;
    public final Context k;
    public final Locale l;
    public final View m;
    public final RecyclerView n;
    public final LinearLayoutRound o;
    public final y00 p;
    public boolean q;
    public final Handler r;
    public final o1 s;
    public cw t;
    public final mf u;
    public boolean v;
    public final int w;
    public final TextViewCustomFont x;
    public final TextViewCustomFont y;

    public CalendarWidget_2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = false;
        this.r = new Handler();
        this.s = new o1(this, 11);
        this.u = new mf(this, new Handler(), 1);
        this.k = context;
        this.v = o();
        this.w = (int) (((double) ((t) context).getDeviceProfile().C) * 0.68d);
        this.q = false;
        this.l = hs0.m(getResources().getConfiguration()).a.get();
        View viewInflate = LayoutInflater.from(this.k).inflate(m61.calendar_widget_2x2, (ViewGroup) this, true);
        this.m = viewInflate;
        this.n = (RecyclerView) viewInflate.findViewById(v51.event_all);
        this.x = (TextViewCustomFont) this.m.findViewById(v51.calendar_day);
        this.y = (TextViewCustomFont) this.m.findViewById(v51.calendar_day_in_week);
        this.o = (LinearLayoutRound) findViewById(v51.calendar_widget_permission);
        ((TextViewCustomFont) this.m.findViewById(v51.button_request_calendar_permission)).setOnClickListener(this);
        this.n.setItemAnimator(new lt());
        this.p = new y00(this.k, 0, o());
        this.n.setLayoutManager(new LinearLayoutManager(1));
        this.n.setAdapter(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEvents() {
        this.q = false;
        try {
            new ur0(new j7(this, 5)).B(ee1.a).z(new vr0(new fz1(this, 6), x4.a(), 0));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            hg0.C(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @Override // defpackage.dm0
    public final void l() {
        cw cwVar = this.t;
        if (cwVar != null) {
            cwVar.b();
        }
    }

    @Override // defpackage.dm0
    public final void n() {
        Date time = Calendar.getInstance().getTime();
        String str = new SimpleDateFormat("dd", Locale.getDefault()).format(time);
        String str2 = new SimpleDateFormat("EEEE", Locale.getDefault()).format(time);
        this.x.setText(str);
        this.y.setText(str2);
        Context context = this.k;
        if (!ar1.i || np1.d(context, "android.permission.READ_CALENDAR") == 0) {
            this.o.setVisibility(8);
            this.k.getContentResolver().registerContentObserver(CalendarContract.Events.CONTENT_URI, true, this.u);
            if (!this.q) {
                Handler handler = this.r;
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(this.s, 5000L);
            }
        } else {
            this.o.setVisibility(0);
        }
        if (this.v != o()) {
            this.v = o();
            x();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(v51.icon_delete_widget);
        int i = -((t) this.k).getDeviceProfile().A;
        viewFindViewById.setTranslationX(((t) this.k).isRTL ? -i : i);
        viewFindViewById.setTranslationY(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == v51.button_request_calendar_permission) {
            Context context = this.k;
            if (context instanceof t) {
                t tVar = (t) context;
                if (ar1.i) {
                    if (tVar.shouldShowRequestPermissionRationale("android.permission.READ_CALENDAR")) {
                        np1.E(tVar, new String[]{"android.permission.READ_CALENDAR"}, 68);
                    } else {
                        e42.r(tVar, "android.permission.READ_CALENDAR");
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.k.getContentResolver().unregisterContentObserver(this.u);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        x();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    public final void x() {
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(v51.calendar_widget_content);
        nm nmVar = (nm) linearLayoutRound.getLayoutParams();
        int i = this.w;
        nmVar.setMargins(i, i, i, i);
        nm nmVar2 = (nm) this.o.getLayoutParams();
        int i2 = this.w;
        nmVar2.setMargins(i2, i2, i2, i2);
        TextViewCustomFont textViewCustomFont = (TextViewCustomFont) findViewById(v51.calendar_day);
        if (o()) {
            linearLayoutRound.setDarkModeBackgroundColor(getResources().getColor(x41.folder_color_dark));
            this.o.setBackgroundResource(l51.round_rect_qsb_dark);
            textViewCustomFont.setTextColor(-1);
        } else {
            linearLayoutRound.setDarkModeBackgroundColor(getResources().getColor(x41.folder_color));
            this.o.setBackgroundResource(l51.round_rect_widget_white);
            textViewCustomFont.setTextColor(-16777216);
        }
        y00 y00Var = this.p;
        if (y00Var != null) {
            y00Var.o = o();
            y00Var.f();
        }
    }
}
