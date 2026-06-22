package com.luutinhit.launcherios.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import defpackage.bo1;
import defpackage.bz0;
import defpackage.g41;
import defpackage.gh0;
import defpackage.hg0;
import defpackage.ih0;
import defpackage.kh0;
import defpackage.m61;
import defpackage.m91;
import defpackage.nh0;
import defpackage.py;
import defpackage.qy;
import defpackage.ua;
import defpackage.v51;
import defpackage.vh0;
import defpackage.y00;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class EditWidgetActivity extends ua implements ih0, nh0, bz0 {
    public static final Handler S = new Handler();
    public Context B;
    public bo1 C;
    public vh0 D;
    public RecyclerView F;
    public RecyclerView G;
    public LinearLayout H;
    public AppCompatImageView I;
    public Animation J;
    public kh0 M;
    public y00 N;
    public OverScrollLayout P;
    public int E = 0;
    public ArrayList K = new ArrayList();
    public final ArrayList L = new ArrayList();
    public ArrayList O = new ArrayList();
    public ArrayList Q = new ArrayList();
    public final py R = new py(this, 0);

    public final ArrayList A() {
        try {
            String string = this.C.a.getString("list_choose_widget", null);
            return string != null ? new ArrayList(Arrays.asList(TextUtils.split(string, "‚‗‚"))) : new ArrayList(Arrays.asList("widget_weather", "widget_favorite", "widget_suggestion"));
        } catch (Throwable unused) {
            return new ArrayList(Arrays.asList("widget_weather", "widget_favorite", "widget_suggestion"));
        }
    }

    public final void B() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = this.O;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            int i = 0;
            while (true) {
                arrayList = this.L;
                if (i >= size) {
                    break;
                }
                Object obj = arrayList3.get(i);
                i++;
                String str = (String) obj;
                ArrayList arrayList4 = this.K;
                if (arrayList4 != null) {
                    int size2 = arrayList4.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList4.get(i2);
                        i2++;
                        gh0 gh0Var = (gh0) obj2;
                        if (gh0Var != null && str != null && str.equals(gh0Var.c)) {
                            arrayList.add(gh0Var);
                        }
                    }
                }
            }
            Objects.toString(arrayList);
            if (arrayList != null && (arrayList2 = this.K) != null) {
                arrayList2.removeAll(arrayList);
            }
            this.E = this.O.size();
        }
    }

    public final void C() {
        gh0 gh0Var;
        if (this.N != null) {
            ArrayList arrayList = this.O;
            if (arrayList == null) {
                this.O = new ArrayList();
            } else {
                arrayList.clear();
            }
            for (int i = 0; i < ((ArrayList) this.N.p).size(); i++) {
                ArrayList arrayList2 = (ArrayList) this.N.p;
                if (arrayList2 != null && (gh0Var = (gh0) arrayList2.get(i)) != null) {
                    this.O.add(gh0Var.c);
                }
            }
            this.C.i("list_choose_widget", this.O);
        }
    }

    @Override // defpackage.nh0
    public final void b() {
        Handler handler = S;
        py pyVar = this.R;
        handler.removeCallbacks(pyVar);
        handler.postDelayed(pyVar, 500L);
    }

    @Override // defpackage.bz0
    public final void c() {
        OverScrollLayout overScrollLayout = this.P;
        if (overScrollLayout != null) {
            overScrollLayout.setDisallowInterceptTouchEvent(false);
        }
    }

    @Override // defpackage.nh0
    public final void f(int i, String str, String str2, Bitmap bitmap) {
        gh0 gh0Var = new gh0(i, str, str2, bitmap);
        this.E--;
        kh0 kh0Var = this.M;
        int iP = kh0Var.p(i);
        kh0Var.k.add(iP, gh0Var);
        kh0Var.g.e(iP, 1);
        Handler handler = S;
        py pyVar = this.R;
        handler.removeCallbacks(pyVar);
        handler.postDelayed(pyVar, 500L);
    }

    @Override // defpackage.bz0
    public final void g(m91 m91Var) {
        OverScrollLayout overScrollLayout = this.P;
        if (overScrollLayout != null) {
            overScrollLayout.setDisallowInterceptTouchEvent(true);
        }
        vh0 vh0Var = this.D;
        if (vh0Var != null) {
            vh0Var.t(m91Var);
        }
    }

    @Override // defpackage.ih0
    public final void i(int i, String str, String str2, Bitmap bitmap) {
        gh0 gh0Var = new gh0(i, str, str2, bitmap);
        int i2 = this.E;
        this.E = i2 + 1;
        y00 y00Var = this.N;
        ((ArrayList) y00Var.p).add(i2, gh0Var);
        y00Var.g.e(i2, 1);
        Handler handler = S;
        py pyVar = this.R;
        handler.removeCallbacks(pyVar);
        handler.postDelayed(pyVar, 500L);
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_edit_widget);
        z(findViewById(v51.root_layout), true);
        this.B = getApplicationContext();
        this.C = new bo1(this);
        try {
            ((LinearLayout) findViewById(v51.linear_layout)).getLayoutTransition().enableTransitionType(4);
        } catch (Throwable th) {
            th.getMessage();
        }
        this.G = (RecyclerView) findViewById(v51.list_choose);
        RecyclerView recyclerView = (RecyclerView) findViewById(v51.list_apps);
        this.F = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.I = (AppCompatImageView) findViewById(v51.progress);
        this.H = (LinearLayout) findViewById(v51.progress_layout);
        this.J = AnimationUtils.loadAnimation(this, g41.ios_spinner_rotate);
        this.P = (OverScrollLayout) findViewById(v51.overscroll_layout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.f1(1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(1);
        linearLayoutManager2.f1(1);
        this.G.setLayoutManager(linearLayoutManager);
        this.F.setLayoutManager(linearLayoutManager2);
        this.G.setNestedScrollingEnabled(false);
        this.O = A();
        new qy(this, 0).execute(new Void[0]);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        hg0.t(this);
        int i = g41.empty_anim;
        overridePendingTransition(i, i);
        return true;
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onPause() {
        ArrayList arrayList;
        C();
        ArrayList arrayList2 = this.Q;
        if (arrayList2 != null && (arrayList = this.O) != null && !arrayList2.equals(arrayList)) {
            sendBroadcast(new Intent("com.luutinhit.launcherios.ACTION_RELOAD_WIDGET"));
        }
        super.onPause();
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onResume() {
        this.Q = A();
        super.onResume();
    }
}
