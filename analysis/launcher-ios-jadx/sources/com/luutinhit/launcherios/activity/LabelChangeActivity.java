package com.luutinhit.launcherios.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.activity.LabelChangeActivity;
import defpackage.ar1;
import defpackage.be0;
import defpackage.cw;
import defpackage.e51;
import defpackage.ee1;
import defpackage.fz1;
import defpackage.hg0;
import defpackage.j7;
import defpackage.m61;
import defpackage.p3;
import defpackage.sg;
import defpackage.t3;
import defpackage.u3;
import defpackage.ua;
import defpackage.ur0;
import defpackage.v51;
import defpackage.v7;
import defpackage.vr0;
import defpackage.x4;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class LabelChangeActivity extends ua {
    public static final /* synthetic */ int H = 0;
    public LinearLayout B;
    public RealTimeBlurView C;
    public boolean D = false;
    public int E;
    public cw F;
    public sg G;

    public final void A(final int i, final String str, final String str2) {
        try {
            View viewInflate = getLayoutInflater().inflate(m61.dialog_change_label, (ViewGroup) null);
            final EditText editText = (EditText) viewInflate.findViewById(v51.ed_label);
            editText.setText(str2);
            editText.setSelection(str2.length());
            t3 t3Var = new t3(this);
            ((p3) t3Var.h).t = viewInflate;
            final u3 u3VarD = t3Var.d();
            if (!isFinishing()) {
                u3VarD.show();
            }
            viewInflate.findViewById(v51.bt_cancel).setOnClickListener(new be0(u3VarD, 1));
            viewInflate.findViewById(v51.bt_ok).setOnClickListener(new View.OnClickListener() { // from class: hj0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i2 = LabelChangeActivity.H;
                    LabelChangeActivity labelChangeActivity = this.g;
                    labelChangeActivity.getClass();
                    String strValueOf = String.valueOf(editText.getText());
                    if (!str2.equals(strValueOf)) {
                        sg sgVar = labelChangeActivity.G;
                        ArrayList arrayList = sgVar.k;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            int i3 = i;
                            if (size > i3) {
                                ((y6) sgVar.k.get(i3)).c = strValueOf;
                                sgVar.g(i3);
                            }
                        }
                        Intent intent = new Intent("com.luutinhit.launcherios.ACTION_UPDATE_LABEL");
                        intent.putExtra("EXTRA_COMPONENT_NAME", str);
                        intent.putExtra("EXTRA_APP_LABEL", strValueOf);
                        labelChangeActivity.sendBroadcast(intent);
                        labelChangeActivity.D = true;
                    }
                    u3 u3Var = u3VarD;
                    if (u3Var != null) {
                        u3Var.dismiss();
                    }
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_change_label);
        z(findViewById(v51.root_layout), true);
        this.C = (RealTimeBlurView) findViewById(v51.blurring_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(v51.list_apps);
        recyclerView.setNestedScrollingEnabled(false);
        this.B = (LinearLayout) findViewById(v51.progress_layout);
        this.E = getResources().getDimensionPixelSize(e51.item_hidden_app_size);
        this.C.setBlurredView((OverScrollLayout) findViewById(v51.overscroll_layout));
        recyclerView.getViewTreeObserver().addOnScrollChangedListener(new v7(this, 2));
        new LinearLayoutManager(1).f1(1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.f1(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        sg sgVar = new sg(2);
        this.G = sgVar;
        recyclerView.setAdapter(sgVar);
        this.G.l = this;
        this.B.setVisibility(0);
        try {
            new ur0(new j7(this, 9)).B(ee1.a).z(new vr0(new fz1(this, 20), x4.a(), 0));
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
        cw cwVar = this.F;
        if (cwVar != null) {
            cwVar.b();
        }
        super.onDestroy();
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onStop() {
        if (this.D) {
            ar1.z(this);
        }
        super.onStop();
    }
}
