package com.luutinhit.launcherios.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import defpackage.bc0;
import defpackage.bo1;
import defpackage.bz0;
import defpackage.cc0;
import defpackage.g41;
import defpackage.gh0;
import defpackage.hg0;
import defpackage.ih0;
import defpackage.kh0;
import defpackage.m61;
import defpackage.m91;
import defpackage.nh0;
import defpackage.qy;
import defpackage.ua;
import defpackage.v51;
import defpackage.vh0;
import defpackage.y00;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class HiddenAppsActivity extends ua implements ih0, nh0, bz0 {
    public static final Handler T = new Handler();
    public Context C;
    public bo1 D;
    public vh0 E;
    public RecyclerView G;
    public RecyclerView H;
    public LinearLayout I;
    public AppCompatImageView J;
    public Animation K;
    public kh0 N;
    public y00 O;
    public RealTimeBlurView Q;
    public final String B = "HiddenAppsActivity";
    public int F = 0;
    public ArrayList L = new ArrayList();
    public final ArrayList M = new ArrayList();
    public ArrayList P = new ArrayList();
    public ArrayList R = new ArrayList();
    public final bc0 S = new bc0(this, 0);

    public final void A() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = this.P;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            int i = 0;
            while (true) {
                arrayList = this.M;
                if (i >= size) {
                    break;
                }
                Object obj = arrayList3.get(i);
                i++;
                String str = (String) obj;
                ArrayList arrayList4 = this.L;
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
            if (arrayList != null && (arrayList2 = this.L) != null) {
                arrayList2.removeAll(arrayList);
            }
            this.F = this.P.size();
        }
    }

    public final void B() {
        gh0 gh0Var;
        if (this.O != null) {
            ArrayList arrayList = this.P;
            if (arrayList == null) {
                this.P = new ArrayList();
            } else {
                arrayList.clear();
            }
            for (int i = 0; i < ((ArrayList) this.O.p).size(); i++) {
                ArrayList arrayList2 = (ArrayList) this.O.p;
                if (arrayList2 != null && (gh0Var = (gh0) arrayList2.get(i)) != null) {
                    this.P.add(gh0Var.c);
                }
            }
            this.D.i("list_hidden_apps", this.P);
        }
    }

    @Override // defpackage.nh0
    public final void b() {
        Handler handler = T;
        bc0 bc0Var = this.S;
        handler.removeCallbacks(bc0Var);
        handler.postDelayed(bc0Var, 500L);
    }

    @Override // defpackage.bz0
    public final void c() {
    }

    @Override // defpackage.nh0
    public final void f(int i, String str, String str2, Bitmap bitmap) {
        gh0 gh0Var = new gh0(i, str, str2, bitmap);
        this.F--;
        kh0 kh0Var = this.N;
        int iP = kh0Var.p(i);
        kh0Var.k.add(iP, gh0Var);
        kh0Var.g.e(iP, 1);
        Handler handler = T;
        bc0 bc0Var = this.S;
        handler.removeCallbacks(bc0Var);
        handler.postDelayed(bc0Var, 500L);
    }

    @Override // defpackage.bz0
    public final void g(m91 m91Var) {
        vh0 vh0Var = this.E;
        if (vh0Var != null) {
            vh0Var.t(m91Var);
        }
    }

    @Override // defpackage.ih0
    public final void i(int i, String str, String str2, Bitmap bitmap) {
        gh0 gh0Var = new gh0(i, str, str2, bitmap);
        int i2 = this.F;
        this.F = i2 + 1;
        y00 y00Var = this.O;
        ((ArrayList) y00Var.p).add(i2, gh0Var);
        y00Var.g.e(i2, 1);
        Handler handler = T;
        bc0 bc0Var = this.S;
        handler.removeCallbacks(bc0Var);
        handler.postDelayed(bc0Var, 500L);
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_hidden_apps);
        z(findViewById(v51.root_layout), true);
        this.C = getApplicationContext();
        this.D = new bo1(this);
        try {
            ((LinearLayout) findViewById(v51.linear_layout)).getLayoutTransition().enableTransitionType(4);
        } catch (Throwable th) {
            th.getMessage();
        }
        this.Q = (RealTimeBlurView) findViewById(v51.blurring_view);
        this.H = (RecyclerView) findViewById(v51.list_choose);
        RecyclerView recyclerView = (RecyclerView) findViewById(v51.list_apps);
        this.G = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.J = (AppCompatImageView) findViewById(v51.progress);
        this.I = (LinearLayout) findViewById(v51.progress_layout);
        this.K = AnimationUtils.loadAnimation(this, g41.ios_spinner_rotate);
        this.Q.setBlurredView((OverScrollLayout) findViewById(v51.overscroll_layout));
        findViewById(v51.scroll_view).getViewTreeObserver().addOnScrollChangedListener(new cc0(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.f1(1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(1);
        linearLayoutManager2.f1(1);
        this.H.setLayoutManager(linearLayoutManager);
        this.G.setLayoutManager(linearLayoutManager2);
        this.H.setNestedScrollingEnabled(false);
        this.P = this.D.d("list_hidden_apps");
        new qy(this, 1).execute(new Void[0]);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        hg0.t(this);
        overridePendingTransition(g41.empty_anim, g41.left_to_right);
        return true;
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onPause() {
        ArrayList arrayList;
        B();
        ArrayList arrayList2 = this.R;
        if (arrayList2 != null && (arrayList = this.P) != null && !arrayList2.equals(arrayList)) {
            Intent intent = new Intent("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE");
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = this.R;
            int size = arrayList4.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList4.get(i);
                i++;
                String str = (String) obj;
                if (!this.P.contains(str)) {
                    arrayList3.add(str);
                }
            }
            intent.putExtra("HIDDEN_APPS_UPDATED", (String[]) arrayList3.toArray(new String[0]));
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = this.P;
            int size2 = arrayList6.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList6.get(i2);
                i2++;
                String str2 = (String) obj2;
                if (!this.R.contains(str2)) {
                    arrayList5.add(str2);
                }
            }
            intent.putExtra("HIDDEN_APPS_REMOVED", (String[]) arrayList5.toArray(new String[0]));
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
        }
        super.onPause();
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onResume() {
        this.R = this.D.d("list_hidden_apps");
        super.onResume();
    }
}
