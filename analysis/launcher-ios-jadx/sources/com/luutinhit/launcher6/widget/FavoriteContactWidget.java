package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.editscreen.ConstraintLayoutRound;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.ar1;
import defpackage.cw;
import defpackage.e42;
import defpackage.ee1;
import defpackage.hg0;
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
import defpackage.x41;
import defpackage.y00;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FavoriteContactWidget extends vm implements View.OnClickListener {
    public static final /* synthetic */ int D = 0;
    public cw A;
    public final mf B;
    public final int C;
    public final Context k;
    public final View l;
    public final TextView m;
    public final AppCompatImageView n;
    public final RecyclerView o;
    public final RecyclerView p;
    public final TextViewCustomFont q;
    public final y00 r;
    public final y00 s;
    public ArrayList t;
    public ArrayList u;
    public boolean v;
    public boolean w;
    public boolean x;
    public final Handler y;
    public final o1 z;

    public FavoriteContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.x = false;
        this.y = new Handler();
        this.z = new o1(this, 21);
        this.B = new mf(this, new Handler(), 2);
        this.k = context;
        this.v = o();
        this.C = (int) (((double) ((t) context).getDeviceProfile().C) * 0.68d);
        this.x = false;
        View viewInflate = LayoutInflater.from(this.k).inflate(m61.favorite_contact_widget, (ViewGroup) this, true);
        this.l = viewInflate;
        this.o = (RecyclerView) viewInflate.findViewById(v51.favourite_contracts_one);
        this.p = (RecyclerView) this.l.findViewById(v51.favourite_contracts_all);
        this.n = (AppCompatImageView) this.l.findViewById(v51.more_icon);
        this.m = (TextView) this.l.findViewById(v51.contact_error);
        this.q = (TextViewCustomFont) this.l.findViewById(v51.button_request_contact_permission);
        this.n.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.o.setItemAnimator(new lt());
        this.p.setItemAnimator(new lt());
        RecyclerView recyclerView = this.o;
        y00 y00Var = new y00(this.k, 1, o());
        this.r = y00Var;
        recyclerView.setAdapter(y00Var);
        RecyclerView recyclerView2 = this.p;
        y00 y00Var2 = new y00(this.k, 1, o());
        this.s = y00Var2;
        recyclerView2.setAdapter(y00Var2);
        this.o.setLayoutManager(new GridLayoutManager(4, 0));
        this.p.setLayoutManager(new GridLayoutManager(4, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFavoriteContacts() {
        if (!(!ar1.i || np1.d(this.k, "android.permission.READ_CONTACTS") == 0)) {
            this.m.setVisibility(0);
            this.o.setVisibility(4);
            boolean z = this.k instanceof t;
            return;
        }
        this.x = false;
        try {
            new ur0(new j7(this, 6)).B(ee1.a).z(new vr0(new ow1(this, 13), x4.a(), 0));
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
        x();
        if (this.v != o()) {
            this.v = o();
            y();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(v51.icon_delete_widget);
        int i = -((t) this.k).getDeviceProfile().A;
        viewFindViewById.setTranslationX(((t) this.k).isRTL ? -i : i);
        viewFindViewById.setTranslationY(i);
        y();
        x();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == v51.more_icon) {
            boolean z = this.w;
            this.w = !z;
            if (z) {
                this.n.animate().withLayer().rotation(0.0f).setDuration(268L).start();
                u(this.p, false);
                return;
            } else {
                this.n.animate().withLayer().rotation(90.0f).setDuration(268L).start();
                u(this.p, true);
                return;
            }
        }
        if (view.getId() == v51.button_request_contact_permission) {
            Context context = this.k;
            if (context instanceof t) {
                t tVar = (t) context;
                if (ar1.i) {
                    if (tVar.shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
                        np1.E(tVar, new String[]{"android.permission.READ_CONTACTS"}, 68);
                    } else {
                        e42.r(tVar, "android.permission.READ_CONTACTS");
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
        if (ar1.i && np1.d(context, "android.permission.READ_CONTACTS") != 0) {
            this.m.setVisibility(0);
            this.q.setVisibility(0);
            return;
        }
        this.m.setVisibility(8);
        this.q.setVisibility(8);
        this.k.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_STREQUENT_URI, true, this.B);
        if (!this.x || ((arrayList = this.t) != null && arrayList.size() <= 0)) {
            Handler handler = this.y;
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(this.z, 1000L);
        }
    }

    public final void y() {
        ConstraintLayoutRound constraintLayoutRound = (ConstraintLayoutRound) findViewById(v51.favorite_contact_widget_content);
        nm nmVar = (nm) constraintLayoutRound.getLayoutParams();
        int i = this.C;
        nmVar.setMargins(i, i, i, i);
        constraintLayoutRound.setDarkModeBackgroundColor(o() ? getResources().getColor(x41.folder_color_dark) : getResources().getColor(x41.folder_color));
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(v51.favorite_contact_widget_permission);
        nm nmVar2 = (nm) linearLayoutRound.getLayoutParams();
        int i2 = this.C;
        nmVar2.setMargins(i2, i2, i2, i2);
        setTextAndBackgroundColor(linearLayoutRound);
    }
}
