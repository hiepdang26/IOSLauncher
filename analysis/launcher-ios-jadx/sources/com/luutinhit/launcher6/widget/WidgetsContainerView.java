package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.TtsSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.ExtendedEditText;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.SpeedLinearLayoutManager;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcher6.widget.view.SlidingUpWidgetsCellAppStyle;
import defpackage.ar1;
import defpackage.dm0;
import defpackage.ee1;
import defpackage.ew1;
import defpackage.f8;
import defpackage.fg0;
import defpackage.fl0;
import defpackage.g8;
import defpackage.gx1;
import defpackage.hb;
import defpackage.hg0;
import defpackage.j8;
import defpackage.jk0;
import defpackage.l51;
import defpackage.mw;
import defpackage.o5;
import defpackage.oe0;
import defpackage.ph0;
import defpackage.px1;
import defpackage.qx1;
import defpackage.s9;
import defpackage.sh1;
import defpackage.uq;
import defpackage.ur0;
import defpackage.v51;
import defpackage.vq;
import defpackage.vr0;
import defpackage.w61;
import defpackage.x4;
import defpackage.xw;
import defpackage.yr0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WidgetsContainerView extends sh1 implements View.OnLongClickListener, View.OnClickListener, xw, fg0 {
    public static final /* synthetic */ int i0 = 0;
    public final t P;
    public final mw Q;
    public final oe0 R;
    public final Rect S;
    public RecyclerView T;
    public final px1 U;
    public SpeedLinearLayoutManager V;
    public AppCompatImageView W;
    public ExtendedEditText a0;
    public qx1 b0;
    public Toast c0;
    public gx1 d0;
    public final InputMethodManager e0;
    public boolean f0;
    public LinearLayoutRound g0;
    public final j8 h0;

    public WidgetsContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = new Rect();
        this.h0 = new j8(this, 4);
        t tVar = (t) context;
        this.P = tVar;
        this.Q = tVar.getDragController();
        this.U = new px1(context, this, this, this, tVar);
        this.R = jk0.a().b;
        this.e0 = (InputMethodManager) context.getSystemService("input_method");
        this.f0 = tVar.isDarkMode;
    }

    private gx1 getWidgetPreviewLoader() {
        if (this.d0 == null) {
            this.d0 = jk0.a().c;
        }
        return this.d0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        InputMethodManager inputMethodManager = this.e0;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        super.clearFocus();
        try {
            this.a0.setText("");
            qx1 qx1Var = this.b0;
            if (qx1Var != null) {
                HashMap map = qx1Var.d;
                map.clear();
                map.putAll(qx1Var.c);
                ArrayList arrayList = qx1Var.b;
                arrayList.clear();
                arrayList.addAll(qx1Var.a);
                px1 px1Var = this.U;
                qx1 qx1Var2 = this.b0;
                px1Var.l = qx1Var2;
                px1Var.s = new boolean[qx1Var2.b.size()];
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.xw
    public float getIntrinsicIconScaleFactor() {
        return 0.0f;
    }

    @Override // defpackage.xw
    public final boolean i() {
        return true;
    }

    public final void j(CharSequence charSequence) {
        try {
            new yr0(new ur0(new f8(this, charSequence, 4)).B(ee1.a), new s9(), 0).z(new vr0(new ew1(this, 2), x4.a(), 0));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            hg0.C(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final void k() {
        Toast toast = this.c0;
        if (toast != null) {
            toast.cancel();
        }
        CharSequence text = getContext().getText(w61.long_press_widget_to_add);
        String string = getContext().getString(w61.long_accessible_way_to_add);
        if (ar1.m) {
            SpannableString spannableString = new SpannableString(text);
            spannableString.setSpan(new TtsSpan.TextBuilder(string).build(), 0, spannableString.length(), 18);
            text = spannableString;
        }
        Toast toastMakeText = Toast.makeText(getContext(), text, 0);
        this.c0 = toastMakeText;
        toastMakeText.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    @Override // defpackage.xw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.view.View r6, defpackage.nx r7, boolean r8) {
        /*
            r5 = this;
            com.luutinhit.launcher6.t r0 = r5.P
            r1 = 0
            r2 = 1
            if (r8 == 0) goto L14
            com.luutinhit.launcher6.Workspace r3 = r0.getWorkspace()
            if (r6 == r3) goto L19
            boolean r3 = r6 instanceof com.luutinhit.launcher6.DeleteDropTarget
            if (r3 != 0) goto L19
            boolean r3 = r6 instanceof com.luutinhit.launcher6.Folder
            if (r3 != 0) goto L19
        L14:
            r3 = 300(0x12c, float:4.2E-43)
            r0.exitSpringLoadedDragModeDelayed(r2, r3, r1)
        L19:
            r3 = 0
            r0.unlockScreenOrientation(r3)
            if (r8 != 0) goto L47
            boolean r8 = r6 instanceof com.luutinhit.launcher6.Workspace
            if (r8 == 0) goto L3f
            int r8 = r0.getCurrentWorkspaceScreen()
            com.luutinhit.launcher6.Workspace r6 = (com.luutinhit.launcher6.Workspace) r6
            android.view.View r6 = r6.getChildAt(r8)
            com.luutinhit.launcher6.CellLayout r6 = (com.luutinhit.launcher6.CellLayout) r6
            java.lang.Object r8 = r7.g
            qh0 r8 = (defpackage.qh0) r8
            if (r6 == 0) goto L3f
            int r4 = r8.m
            int r8 = r8.n
            boolean r6 = r6.o(r1, r4, r8)
            r6 = r6 ^ r2
            goto L40
        L3f:
            r6 = 0
        L40:
            if (r6 == 0) goto L45
            r0.showOutOfSpaceMessage(r3)
        L45:
            r7.l = r3
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.widget.WidgetsContainerView.l(android.view.View, nx, boolean):void");
    }

    @Override // defpackage.xw
    public final boolean m() {
        return false;
    }

    @Override // defpackage.sh1, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        SlidingUpWidgetsCellAppStyle slidingUpWidgetsCellAppStyle;
        super.onAttachedToWindow();
        t tVar = this.P;
        if (tVar == null || (slidingUpWidgetsCellAppStyle = tVar.mWidgetsAppStyle) == null) {
            return;
        }
        Objects.toString(slidingUpWidgetsCellAppStyle);
        tVar.mWidgetsAppStyle.setOnAddWidgetButtonClickListener(new o5(this, 9));
        tVar.mWidgetsAppStyle.a(new uq(this, 1));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar = this.P;
        if (tVar.isWidgetsViewVisible()) {
            tVar.getWorkspace().getClass();
            boolean z = view instanceof dm0;
            k();
        }
    }

    @Override // defpackage.sh1, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(v51.widgets_view_content);
        this.g0 = linearLayoutRound;
        linearLayoutRound.setDarkModeBackgroundColor(this.f0 ? -14935012 : -2565928);
        this.T = (RecyclerView) findViewById(v51.widgets_list_view);
        t tVar = this.P;
        SpeedLinearLayoutManager speedLinearLayoutManager = new SpeedLinearLayoutManager(1);
        this.V = speedLinearLayoutManager;
        this.T.setLayoutManager(speedLinearLayoutManager);
        RecyclerView recyclerView = this.T;
        px1 px1Var = this.U;
        recyclerView.setAdapter(px1Var);
        px1Var.q = this.f0;
        this.W = (AppCompatImageView) findViewById(v51.action_clear);
        ExtendedEditText extendedEditText = (ExtendedEditText) findViewById(v51.search_widget);
        this.a0 = extendedEditText;
        extendedEditText.addTextChangedListener(this.h0);
        this.T.l(new hb(this, 5));
        ph0 ph0Var = new ph0();
        TypedArray typedArrayObtainStyledAttributes = tVar.obtainStyledAttributes(ph0.i);
        ph0Var.h = tVar.getDrawable(l51.divider_white);
        typedArrayObtainStyledAttributes.recycle();
        this.T.k(ph0Var);
        final int i = 0;
        this.W.setOnClickListener(new View.OnClickListener(this) { // from class: lx1
            public final /* synthetic */ WidgetsContainerView h;

            {
                this.h = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetsContainerView widgetsContainerView = this.h;
                switch (i) {
                    case 0:
                        widgetsContainerView.a0.setText("");
                        widgetsContainerView.j("");
                        break;
                    default:
                        int i2 = WidgetsContainerView.i0;
                        widgetsContainerView.setPanelState(rh1.h);
                        break;
                }
            }
        });
        final int i2 = 1;
        findViewById(v51.out_side_widgets_view).setOnClickListener(new View.OnClickListener(this) { // from class: lx1
            public final /* synthetic */ WidgetsContainerView h;

            {
                this.h = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetsContainerView widgetsContainerView = this.h;
                switch (i2) {
                    case 0:
                        widgetsContainerView.a0.setText("");
                        widgetsContainerView.j("");
                        break;
                    default:
                        int i22 = WidgetsContainerView.i0;
                        widgetsContainerView.setPanelState(rh1.h);
                        break;
                }
            }
        });
        a(new vq(this, 2));
        this.T.setOnTouchListener(new g8(this, i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x021f  */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onLongClick(android.view.View r20) {
        /*
            Method dump skipped, instruction units count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.widget.WidgetsContainerView.onLongClick(android.view.View):boolean");
    }

    public void setDarkMode(boolean z) {
        this.f0 = z;
        LinearLayoutRound linearLayoutRound = this.g0;
        if (linearLayoutRound != null) {
            linearLayoutRound.setDarkModeBackgroundColor(z ? -14935012 : -2565928);
        }
        px1 px1Var = this.U;
        if (px1Var != null) {
            px1Var.q = z;
        }
    }

    @Override // defpackage.sh1
    public void setDragView(View view) {
        super.setDragView(view);
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.S;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        setPadding(0, 0, 0, 0);
    }

    public final void setSearchBarBounds(Rect rect) {
        post(new fl0(this, 20));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            setAlpha(1.0f);
        } else {
            this.W.setVisibility(8);
        }
        super.setVisibility(i);
    }
}
