package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.t;
import defpackage.cw;
import defpackage.ee1;
import defpackage.hg0;
import defpackage.i7;
import defpackage.j7;
import defpackage.k7;
import defpackage.lt;
import defpackage.m61;
import defpackage.mc1;
import defpackage.nm;
import defpackage.r1;
import defpackage.ur0;
import defpackage.v51;
import defpackage.vm;
import defpackage.vr0;
import defpackage.x4;

/* JADX INFO: loaded from: classes.dex */
public class AppSuggestionsWidget extends vm {
    public static final /* synthetic */ int s = 0;
    public final Context k;
    public RecyclerView l;
    public i7 m;
    public final Handler n;
    public final r1 o;
    public cw p;
    public final int q;
    public boolean r;

    public AppSuggestionsWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new Handler();
        this.o = new r1(this, 1);
        this.k = context;
        this.r = o();
        this.q = ((t) context).getDeviceProfile().C;
        LayoutInflater.from(this.k).inflate(m61.app_suggestions_widget, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAppSuggestions() {
        try {
            new ur0(new j7(this, 0)).B(ee1.a).z(new vr0(new mc1(this, 4), x4.a(), 0));
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
        cw cwVar = this.p;
        if (cwVar != null) {
            cwVar.b();
        }
    }

    @Override // defpackage.dm0
    public final void n() {
        Handler handler = this.n;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.o, 1000L);
        if (this.r != o()) {
            this.r = o();
            nm nmVar = (nm) this.l.getLayoutParams();
            int i = (int) (((double) this.q) * 0.68d);
            nmVar.setMargins(i, i, i, i);
            setTextAndBackgroundColor(this.l);
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

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        RecyclerView recyclerView = (RecyclerView) findViewById(v51.app_suggestions_widget_content);
        this.l = recyclerView;
        recyclerView.setItemAnimator(new lt());
        i7 i7Var = new i7(this.k);
        this.m = i7Var;
        this.l.setAdapter(i7Var);
        this.l.setLayoutManager(new GridLayoutManager(4));
        this.l.k(new k7((int) (((double) this.q) * 1.32d)));
        nm nmVar = (nm) this.l.getLayoutParams();
        int i = (int) (((double) this.q) * 0.68d);
        nmVar.setMargins(i, i, i, i);
        setTextAndBackgroundColor(this.l);
        Handler handler = this.n;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.o, 1000L);
    }
}
