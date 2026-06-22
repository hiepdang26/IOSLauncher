package defpackage;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class or0<S> extends ev {
    public CharSequence A0;
    public CheckableImageButton B0;
    public rr0 C0;
    public Button D0;
    public boolean E0;
    public final LinkedHashSet n0;
    public final LinkedHashSet o0;
    public int p0;
    public a21 q0;
    public lf r0;
    public ir0 s0;
    public int t0;
    public CharSequence u0;
    public boolean v0;
    public int w0;
    public int x0;
    public CharSequence y0;
    public int z0;

    public or0() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.n0 = new LinkedHashSet();
        this.o0 = new LinkedHashSet();
    }

    public static int W(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(d51.mtrl_calendar_content_padding);
        Calendar calendarB = sq1.b();
        calendarB.set(5, 1);
        Calendar calendarA = sq1.a(calendarB);
        calendarA.get(2);
        calendarA.get(1);
        int maximum = calendarA.getMaximum(7);
        calendarA.getActualMaximum(5);
        calendarA.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(d51.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(d51.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean X(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(z71.o(context, ir0.class.getCanonicalName(), q41.materialCalendarStyle), new int[]{i});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    @Override // defpackage.ev, defpackage.w50
    public final void G(Bundle bundle) {
        super.G(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.p0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        lf lfVar = this.r0;
        kf kfVar = new kf();
        int i = kf.b;
        int i2 = kf.b;
        long j = lfVar.g.l;
        long j2 = lfVar.h.l;
        kfVar.a = Long.valueOf(lfVar.j.l);
        pu0 pu0Var = this.s0.c0;
        if (pu0Var != null) {
            kfVar.a = Long.valueOf(pu0Var.l);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", lfVar.i);
        pu0 pu0VarC = pu0.c(j);
        pu0 pu0VarC2 = pu0.c(j2);
        ls lsVar = (ls) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = kfVar.a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new lf(pu0VarC, pu0VarC2, lsVar, l != null ? pu0.c(l.longValue()) : null));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.t0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.u0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.x0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.y0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.z0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.A0);
    }

    @Override // defpackage.ev, defpackage.w50
    public final void H() {
        super.H();
        Dialog dialog = this.i0;
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        Window window = dialog.getWindow();
        if (this.v0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.C0);
            if (!this.E0) {
                View viewFindViewById = O().findViewById(u51.fullscreen_header);
                Integer numValueOf = viewFindViewById.getBackground() instanceof ColorDrawable ? Integer.valueOf(((ColorDrawable) viewFindViewById.getBackground()).getColor()) : null;
                int i = Build.VERSION.SDK_INT;
                boolean z = numValueOf == null || numValueOf.intValue() == 0;
                int iF = bf1.f(window.getContext(), R.attr.colorBackground, -16777216);
                if (z) {
                    numValueOf = Integer.valueOf(iF);
                }
                if (i >= 35) {
                    o0.d(window, false);
                } else if (i >= 30) {
                    o0.c(window, false);
                } else {
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
                }
                int iH = i < 23 ? ik.h(bf1.f(window.getContext(), R.attr.statusBarColor, -16777216), 128) : 0;
                int iH2 = i < 27 ? ik.h(bf1.f(window.getContext(), R.attr.navigationBarColor, -16777216), 128) : 0;
                window.setStatusBarColor(iH);
                window.setNavigationBarColor(iH2);
                int iIntValue = numValueOf.intValue();
                boolean z2 = (iH != 0 && ik.d(iH) > 0.5d) || (iH == 0 && (iIntValue != 0 && (ik.d(iIntValue) > 0.5d ? 1 : (ik.d(iIntValue) == 0.5d ? 0 : -1)) > 0));
                boolean z3 = (iH2 != 0 && ik.d(iH2) > 0.5d) || (iH2 == 0 && (iF != 0 && (ik.d(iF) > 0.5d ? 1 : (ik.d(iF) == 0.5d ? 0 : -1)) > 0));
                window.getDecorView();
                int i2 = Build.VERSION.SDK_INT;
                p02 qy1Var = i2 >= 35 ? new qy1(window) : i2 >= 30 ? new py1(window) : i2 >= 26 ? new oy1(window) : i2 >= 23 ? new ny1(window) : new my1(window);
                qy1Var.w(z2);
                qy1Var.v(z3);
                mr0 mr0Var = new mr0(viewFindViewById, viewFindViewById.getLayoutParams().height, viewFindViewById.getPaddingTop());
                WeakHashMap weakHashMap = qs1.a;
                hs1.m(viewFindViewById, mr0Var);
                this.E0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = s().getDimensionPixelOffset(d51.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.C0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            View decorView2 = window.getDecorView();
            Dialog dialog2 = this.i0;
            if (dialog2 == null) {
                throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
            }
            decorView2.setOnTouchListener(new dg0(dialog2, rect));
        }
        N();
        int i3 = this.p0;
        if (i3 == 0) {
            V();
            throw null;
        }
        V();
        lf lfVar = this.r0;
        ir0 ir0Var = new ir0();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", lfVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", lfVar.j);
        ir0Var.Q(bundle);
        this.s0 = ir0Var;
        a21 a21Var = ir0Var;
        if (this.B0.g) {
            V();
            lf lfVar2 = this.r0;
            sr0 sr0Var = new sr0();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i3);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", lfVar2);
            sr0Var.Q(bundle2);
            a21Var = sr0Var;
        }
        this.q0 = a21Var;
        V();
        throw null;
    }

    @Override // defpackage.ev, defpackage.w50
    public final void I() {
        this.q0.Z.clear();
        super.I();
    }

    @Override // defpackage.ev
    public final Dialog U() {
        Context contextN = N();
        N();
        int i = this.p0;
        if (i == 0) {
            V();
            throw null;
        }
        Dialog dialog = new Dialog(contextN, i);
        Context context = dialog.getContext();
        this.v0 = X(context, R.attr.windowFullscreen);
        int iO = z71.o(context, or0.class.getCanonicalName(), q41.colorSurface);
        rr0 rr0Var = new rr0(context, null, q41.materialCalendarStyle, b71.Widget_MaterialComponents_MaterialCalendar);
        this.C0 = rr0Var;
        rr0Var.i(context);
        this.C0.k(ColorStateList.valueOf(iO));
        rr0 rr0Var2 = this.C0;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = qs1.a;
        rr0Var2.j(hs1.e(decorView));
        return dialog;
    }

    public final void V() {
        if (this.m.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
    }

    @Override // defpackage.ev, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.n0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // defpackage.ev, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.o0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.L;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // defpackage.ev, defpackage.w50
    public final void y(Bundle bundle) {
        super.y(bundle);
        if (bundle == null) {
            bundle = this.m;
        }
        this.p0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.r0 = (lf) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.t0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.u0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.w0 = bundle.getInt("INPUT_MODE_KEY");
        this.x0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.y0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.z0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.A0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
    }

    @Override // defpackage.w50
    public final View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.v0 ? l61.mtrl_picker_fullscreen : l61.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.v0) {
            viewInflate.findViewById(u51.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(W(context), -2));
        } else {
            viewInflate.findViewById(u51.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(W(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(u51.mtrl_picker_header_selection_text);
        WeakHashMap weakHashMap = qs1.a;
        textView.setAccessibilityLiveRegion(1);
        this.B0 = (CheckableImageButton) viewInflate.findViewById(u51.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) viewInflate.findViewById(u51.mtrl_picker_title_text);
        CharSequence charSequence = this.u0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.t0);
        }
        this.B0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.B0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, hg0.o(context, k51.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], hg0.o(context, k51.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.B0.setChecked(this.w0 != 0);
        qs1.p(this.B0, null);
        CheckableImageButton checkableImageButton2 = this.B0;
        this.B0.setContentDescription(checkableImageButton2.g ? checkableImageButton2.getContext().getString(v61.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(v61.mtrl_picker_toggle_to_text_input_mode));
        this.B0.setOnClickListener(new nr0(this));
        this.D0 = (Button) viewInflate.findViewById(u51.confirm_button);
        V();
        throw null;
    }
}
