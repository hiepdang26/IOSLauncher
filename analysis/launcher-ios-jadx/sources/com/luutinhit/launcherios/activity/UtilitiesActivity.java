package com.luutinhit.launcherios.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcherios.customsettings.SwitchView;
import defpackage.ar1;
import defpackage.e31;
import defpackage.g41;
import defpackage.m61;
import defpackage.nm;
import defpackage.ua;
import defpackage.v51;

/* JADX INFO: loaded from: classes.dex */
public class UtilitiesActivity extends ua implements SeekBar.OnSeekBarChangeListener {
    public SharedPreferences B;
    public SwitchView C;
    public SwitchView D;
    public SwitchView E;
    public SwitchView F;
    public ConstraintLayout G;
    public ConstraintLayout H;
    public ConstraintLayout I;
    public ConstraintLayout J;
    public ConstraintLayout K;
    public ConstraintLayout L;
    public ConstraintLayout M;
    public ConstraintLayout N;
    public View O;
    public AppCompatSeekBar P;
    public AppCompatImageView Q;
    public float R;
    public float S;
    public float T;
    public float U;
    public float V = 0.02f;
    public int W;
    public int X;
    public AppCompatImageView Y;
    public AppCompatImageView Z;

    public static void A(UtilitiesActivity utilitiesActivity, String str, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = utilitiesActivity.B.edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void B(int i) {
        if (i == 5) {
            this.Y.setColorFilter(-11806877);
            this.Z.setColorFilter(9079434);
        } else if (i == 6) {
            this.Z.setColorFilter(-11806877);
            this.Y.setColorFilter(9079434);
        }
        SharedPreferences.Editor editorEdit = this.B.edit();
        editorEdit.putInt("use_grid_size", i);
        editorEdit.apply();
        this.W = i;
    }

    public final void C(float f) {
        AppCompatImageView appCompatImageView = this.Q;
        if (appCompatImageView != null) {
            nm nmVar = (nm) appCompatImageView.getLayoutParams();
            int i = (int) ((this.R / 4.0f) * f);
            ((ViewGroup.MarginLayoutParams) nmVar).height = i;
            ((ViewGroup.MarginLayoutParams) nmVar).width = i;
            this.Q.setLayoutParams(nmVar);
            this.Q.invalidate();
        }
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == v51.item_dark_mode || id == v51.dark_mode) {
                this.C.b(!r5.n);
                return;
            }
            if (id == v51.item_padding_bottom || id == v51.padding_bottom) {
                this.D.b(!r5.n);
                return;
            }
            if (id == v51.item_auto_rearrange) {
                this.E.b(!r5.n);
                return;
            }
            if (id == v51.item_iphone_8_style) {
                this.F.b(!r5.n);
                return;
            }
            if (id == v51.layout_5x4) {
                B(5);
                return;
            }
            if (id == v51.layout_6x4) {
                B(6);
                return;
            }
            if (id == v51.item_navigation_bar) {
                try {
                    startActivity(new Intent(this, (Class<?>) StatusBarAndNotificationActivity.class));
                    overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                } catch (Throwable th) {
                    Toast.makeText(this, "StartActivity " + StatusBarAndNotificationActivity.class.getName() + "  Error: " + th.getMessage(), 1).show();
                }
            }
        }
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_utilities);
        z(findViewById(v51.root_layout), true);
        this.B = getSharedPreferences(e31.b(this), 0);
        this.O = findViewById(v51.blurring_view);
        this.G = (ConstraintLayout) findViewById(v51.root_layout);
        this.H = (ConstraintLayout) findViewById(v51.item_dark_mode);
        this.I = (ConstraintLayout) findViewById(v51.item_padding_bottom);
        this.J = (ConstraintLayout) findViewById(v51.item_auto_rearrange);
        this.K = (ConstraintLayout) findViewById(v51.item_iphone_8_style);
        this.L = (ConstraintLayout) findViewById(v51.layout_icon_size);
        this.M = (ConstraintLayout) findViewById(v51.layout_screen_grid);
        this.N = (ConstraintLayout) findViewById(v51.item_navigation_bar);
        this.C = (SwitchView) findViewById(v51.dark_mode);
        this.D = (SwitchView) findViewById(v51.padding_bottom);
        this.E = (SwitchView) findViewById(v51.auto_rearrange);
        this.F = (SwitchView) findViewById(v51.iphone_8_style);
        this.P = (AppCompatSeekBar) findViewById(v51.seekbar_icon_size);
        this.Q = (AppCompatImageView) findViewById(v51.icon_size_demo);
        this.Y = (AppCompatImageView) findViewById(v51.layout_5x4);
        this.Z = (AppCompatImageView) findViewById(v51.layout_6x4);
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (this.S == this.U && this.W == this.X) {
            return;
        }
        ar1.z(this);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            float f = i < 10 ? this.T - ((10 - i) * this.V) : this.T + ((i - 10) * this.V);
            this.S = f;
            C(f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    @Override // defpackage.ua, defpackage.e6, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStart() {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcherios.activity.UtilitiesActivity.onStart():void");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        SharedPreferences.Editor editorEdit = this.B.edit();
        editorEdit.putFloat("icon_padding_edge", this.S);
        editorEdit.putInt("icon_padding_edge_progress", seekBar.getProgress());
        editorEdit.apply();
    }
}
