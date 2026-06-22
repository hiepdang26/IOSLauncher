package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import defpackage.an;
import defpackage.en;
import defpackage.l61;
import defpackage.qs1;
import defpackage.u51;
import defpackage.vn1;
import defpackage.zm;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int h = 0;
    public final MaterialButtonToggleGroup g;

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        d dVar = new d(this);
        LayoutInflater.from(context).inflate(l61.material_timepicker, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(u51.material_clock_period_toggle);
        this.g = materialButtonToggleGroup;
        materialButtonToggleGroup.i.add(new e());
        Chip chip = (Chip) findViewById(u51.material_minute_tv);
        Chip chip2 = (Chip) findViewById(u51.material_hour_tv);
        vn1 vn1Var = new vn1(new GestureDetector(getContext(), new f(this)), 0);
        chip.setOnTouchListener(vn1Var);
        chip2.setOnTouchListener(vn1Var);
        chip.setTag(u51.selection_type, 12);
        chip2.setTag(u51.selection_type, 10);
        chip.setOnClickListener(dVar);
        chip2.setOnClickListener(dVar);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }

    public final void l() {
        zm zmVar;
        if (this.g.getVisibility() == 0) {
            en enVar = new en();
            enVar.f(this);
            WeakHashMap weakHashMap = qs1.a;
            char c = getLayoutDirection() == 0 ? (char) 2 : (char) 1;
            int i = u51.material_clock_display;
            HashMap map = enVar.g;
            if (map.containsKey(Integer.valueOf(i)) && (zmVar = (zm) map.get(Integer.valueOf(i))) != null) {
                an anVar = zmVar.e;
                switch (c) {
                    case 1:
                        anVar.j = -1;
                        anVar.i = -1;
                        anVar.G = -1;
                        anVar.N = RtlSpacingHelper.UNDEFINED;
                        break;
                    case 2:
                        anVar.l = -1;
                        anVar.k = -1;
                        anVar.H = -1;
                        anVar.P = RtlSpacingHelper.UNDEFINED;
                        break;
                    case 3:
                        anVar.n = -1;
                        anVar.m = -1;
                        anVar.I = 0;
                        anVar.O = RtlSpacingHelper.UNDEFINED;
                        break;
                    case 4:
                        anVar.o = -1;
                        anVar.p = -1;
                        anVar.J = 0;
                        anVar.Q = RtlSpacingHelper.UNDEFINED;
                        break;
                    case 5:
                        anVar.q = -1;
                        anVar.r = -1;
                        anVar.s = -1;
                        anVar.M = 0;
                        anVar.T = RtlSpacingHelper.UNDEFINED;
                        break;
                    case 6:
                        anVar.t = -1;
                        anVar.u = -1;
                        anVar.L = 0;
                        anVar.S = RtlSpacingHelper.UNDEFINED;
                        break;
                    case 7:
                        anVar.v = -1;
                        anVar.w = -1;
                        anVar.K = 0;
                        anVar.R = RtlSpacingHelper.UNDEFINED;
                        break;
                    case '\b':
                        anVar.C = -1.0f;
                        anVar.B = -1;
                        anVar.A = -1;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown constraint");
                }
            }
            enVar.b(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        l();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            l();
        }
    }
}
