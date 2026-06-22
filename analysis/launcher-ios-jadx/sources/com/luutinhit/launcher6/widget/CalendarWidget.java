package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.os.Handler;
import android.provider.CalendarContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.ar1;
import defpackage.cw;
import defpackage.e42;
import defpackage.e51;
import defpackage.ee1;
import defpackage.hg0;
import defpackage.hs0;
import defpackage.j7;
import defpackage.lt;
import defpackage.m61;
import defpackage.mf;
import defpackage.nm;
import defpackage.np1;
import defpackage.o1;
import defpackage.ow1;
import defpackage.ur0;
import defpackage.v51;
import defpackage.vm;
import defpackage.vr0;
import defpackage.x4;
import defpackage.y00;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CalendarWidget extends vm implements View.OnClickListener {
    public static final /* synthetic */ int F = 0;
    public cw A;
    public final mf B;
    public final int C;
    public final TextViewCustomFont D;
    public final TextViewCustomFont E;
    public final Context k;
    public final Locale l;
    public final View m;
    public final AppCompatImageView n;
    public final TextView o;
    public final TextView p;
    public final RecyclerView q;
    public final RecyclerView r;
    public final y00 s;
    public final y00 t;
    public ArrayList u;
    public ArrayList v;
    public boolean w;
    public boolean x;
    public final Handler y;
    public final o1 z;

    public CalendarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.x = false;
        this.y = new Handler();
        this.z = new o1(this, 10);
        this.B = new mf(this, new Handler(), 0);
        this.k = context;
        this.C = (int) (((double) ((t) context).getDeviceProfile().C) * 0.68d);
        this.x = false;
        this.l = hs0.m(getResources().getConfiguration()).a.get();
        View viewInflate = LayoutInflater.from(this.k).inflate(m61.calendar_widget, (ViewGroup) this, true);
        this.m = viewInflate;
        this.q = (RecyclerView) viewInflate.findViewById(v51.event_one);
        this.r = (RecyclerView) this.m.findViewById(v51.event_all);
        this.n = (AppCompatImageView) this.m.findViewById(v51.more_icon);
        getResources().getDimensionPixelSize(e51.small_icon_size);
        getResources().getDimensionPixelOffset(e51.small_icon_round_corner);
        this.D = (TextViewCustomFont) this.m.findViewById(v51.calendar_day);
        this.E = (TextViewCustomFont) this.m.findViewById(v51.calendar_day_in_week);
        this.o = (TextView) this.m.findViewById(v51.calendar_error);
        this.p = (TextView) this.m.findViewById(v51.button_request_calendar_permission);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setItemAnimator(new lt());
        this.r.setItemAnimator(new lt());
        RecyclerView recyclerView = this.q;
        y00 y00Var = new y00(this.k, 0, o());
        this.s = y00Var;
        recyclerView.setAdapter(y00Var);
        RecyclerView recyclerView2 = this.r;
        y00 y00Var2 = new y00(this.k, 0, o());
        this.t = y00Var2;
        recyclerView2.setAdapter(y00Var2);
        this.q.setLayoutManager(new LinearLayoutManager(1));
        this.r.setLayoutManager(new LinearLayoutManager(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEvents() {
        this.x = false;
        try {
            new ur0(new j7(this, 4)).B(ee1.a).z(new vr0(new ow1(this, 6), x4.a(), 0));
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
        cw cwVar = this.A;
        if (cwVar != null) {
            cwVar.b();
        }
    }

    @Override // defpackage.dm0
    public final void n() {
        y();
        x();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(v51.icon_delete_widget);
        int i = -((t) this.k).getDeviceProfile().A;
        viewFindViewById.setTranslationX(((t) this.k).isRTL ? -i : i);
        viewFindViewById.setTranslationY(i);
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(v51.calendar_widget_content);
        nm nmVar = (nm) linearLayoutRound.getLayoutParams();
        int i2 = this.C;
        nmVar.setMargins(i2, i2, i2, i2);
        setTextAndBackgroundColor(linearLayoutRound);
        LinearLayoutRound linearLayoutRound2 = (LinearLayoutRound) findViewById(v51.calendar_widget_permission);
        nm nmVar2 = (nm) linearLayoutRound2.getLayoutParams();
        int i3 = this.C;
        nmVar2.setMargins(i3, i3, i3, i3);
        setTextAndBackgroundColor(linearLayoutRound2);
        x();
        y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == v51.more_icon) {
            boolean z = this.w;
            this.w = !z;
            if (z) {
                this.n.animate().withLayer().rotation(0.0f).setDuration(268L).start();
                u(this.r, false);
                return;
            } else {
                this.n.animate().withLayer().rotation(90.0f).setDuration(268L).start();
                u(this.r, true);
                return;
            }
        }
        if (id == v51.button_request_calendar_permission) {
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
            this.k.getContentResolver().unregisterContentObserver(this.B);
        } catch (Throwable unused) {
        }
    }

    public final void x() {
        ArrayList arrayList;
        Context context = this.k;
        if (ar1.i && np1.d(context, "android.permission.READ_CALENDAR") != 0) {
            this.p.setVisibility(0);
            this.o.setVisibility(0);
            return;
        }
        this.p.setVisibility(8);
        this.o.setVisibility(8);
        this.k.getContentResolver().registerContentObserver(CalendarContract.Events.CONTENT_URI, true, this.B);
        if (!this.x || ((arrayList = this.u) != null && arrayList.size() <= 0)) {
            Handler handler = this.y;
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(this.z, 5000L);
        }
    }

    public final void y() {
        Date time = Calendar.getInstance().getTime();
        String str = new SimpleDateFormat("dd", Locale.getDefault()).format(time);
        String str2 = new SimpleDateFormat("EEEE", Locale.getDefault()).format(time);
        this.D.setText(str);
        this.E.setText(str2);
    }
}
