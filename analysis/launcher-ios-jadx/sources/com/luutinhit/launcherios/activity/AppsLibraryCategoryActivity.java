package com.luutinhit.launcherios.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import defpackage.ar1;
import defpackage.cw;
import defpackage.e31;
import defpackage.e51;
import defpackage.ee1;
import defpackage.hg0;
import defpackage.j7;
import defpackage.m61;
import defpackage.nx0;
import defpackage.sg;
import defpackage.ua;
import defpackage.ur0;
import defpackage.v51;
import defpackage.v7;
import defpackage.vr0;
import defpackage.x4;

/* JADX INFO: loaded from: classes.dex */
public class AppsLibraryCategoryActivity extends ua {
    public static final /* synthetic */ int J = 0;
    public RecyclerView B;
    public LinearLayout C;
    public RealTimeBlurView D;
    public int F;
    public cw G;
    public SharedPreferences I;
    public boolean E = false;
    public final sg H = new sg(0);

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_apps_library_category);
        this.I = getSharedPreferences(e31.b(this), 0);
        this.D = (RealTimeBlurView) findViewById(v51.blurring_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(v51.list_apps);
        this.B = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        z(findViewById(v51.root_view), true);
        this.C = (LinearLayout) findViewById(v51.progress_layout);
        this.F = getResources().getDimensionPixelSize(e51.item_hidden_app_size);
        this.D.setBlurredView((OverScrollLayout) findViewById(v51.overscroll_layout));
        this.B.getViewTreeObserver().addOnScrollChangedListener(new v7(this, 0));
        new LinearLayoutManager(1).f1(1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.f1(1);
        this.B.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.B;
        sg sgVar = this.H;
        recyclerView2.setAdapter(sgVar);
        sgVar.l = this;
        this.C.setVisibility(0);
        try {
            new ur0(new j7(this, 1)).B(ee1.a).z(new vr0(new nx0(this, 4), x4.a(), 0));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            hg0.C(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onDestroy() {
        cw cwVar = this.G;
        if (cwVar != null) {
            cwVar.b();
        }
        super.onDestroy();
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            SharedPreferences.Editor editorEdit = this.I.edit();
            editorEdit.putBoolean("app_library_dialog_guide", false);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onStop() {
        if (this.E) {
            ar1.z(this);
        }
        super.onStop();
    }
}
