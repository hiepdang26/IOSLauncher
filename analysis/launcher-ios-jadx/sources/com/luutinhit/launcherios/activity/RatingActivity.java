package com.luutinhit.launcherios.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import com.luutinhit.launcherios.activity.RatingActivity;
import defpackage.c71;
import defpackage.e31;
import defpackage.e6;
import defpackage.m61;
import defpackage.np1;
import defpackage.p3;
import defpackage.t3;
import defpackage.u3;
import defpackage.v51;
import defpackage.w61;
import defpackage.x41;

/* JADX INFO: loaded from: classes.dex */
public class RatingActivity extends e6 implements View.OnClickListener {
    public static final /* synthetic */ int N = 0;
    public u3 B;
    public View C;
    public SharedPreferences D;
    public Context E;
    public TextView F;
    public TextView G;
    public TextView H;
    public RatingBar I;
    public ImageView J;
    public EditText K;
    public LinearLayout L;
    public LinearLayout M;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == v51.dialog_rating_button_never) {
                try {
                    SharedPreferences.Editor editorEdit = this.D.edit();
                    editorEdit.putBoolean("not_show_exit_dialog", true);
                    editorEdit.apply();
                } catch (Throwable th) {
                    th.getMessage();
                }
                u3 u3Var = this.B;
                if (u3Var != null) {
                    u3Var.dismiss();
                    return;
                }
                return;
            }
            if (id != v51.dialog_rating_button_positive) {
                if (id == v51.dialog_rating_button_feedback_submit) {
                    Toast.makeText(this.E, w61.rating_dialog_thank_you, 0).show();
                    u3 u3Var2 = this.B;
                    if (u3Var2 != null) {
                        u3Var2.dismiss();
                        return;
                    }
                    return;
                }
                if (id == v51.dialog_rating_button_negative || id == v51.dialog_rating_button_feedback_cancel) {
                    u3 u3Var3 = this.B;
                    if (u3Var3 != null) {
                        u3Var3.dismiss();
                        return;
                    }
                    return;
                }
                u3 u3Var4 = this.B;
                if (u3Var4 != null) {
                    u3Var4.dismiss();
                    return;
                }
                return;
            }
            RatingBar ratingBar = this.I;
            if (ratingBar == null || ratingBar.getRating() < 5.0f) {
                this.G.setVisibility(0);
                this.K.setVisibility(0);
                this.M.setVisibility(0);
                this.L.setVisibility(8);
                this.J.setVisibility(8);
                this.F.setVisibility(8);
                this.H.setVisibility(8);
                this.I.setVisibility(8);
            } else {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
                    intent.addFlags(268435456);
                    this.E.startActivity(intent);
                } catch (Throwable th2) {
                    try {
                        th2.getMessage();
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
                        intent2.addFlags(268435456);
                        this.E.startActivity(intent2);
                    } catch (Throwable unused) {
                        Toast.makeText(this.E, w61.application_not_found, 0).show();
                    }
                }
            }
            try {
                SharedPreferences.Editor editorEdit2 = this.D.edit();
                editorEdit2.putBoolean("not_show_exit_dialog", true);
                editorEdit2.apply();
            } catch (Throwable th3) {
                th3.getMessage();
            }
        }
    }

    @Override // defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (Build.VERSION.SDK_INT < 26) {
                setRequestedOrientation(1);
            }
            Context applicationContext = getApplicationContext();
            this.E = applicationContext;
            this.D = e31.a(applicationContext);
            View viewInflate = getLayoutInflater().inflate(m61.dialog_rating, (ViewGroup) null);
            this.C = viewInflate;
            this.F = (TextView) viewInflate.findViewById(v51.dialog_rating_title);
            this.H = (TextView) this.C.findViewById(v51.dialog_rating_app_name);
            AppCompatButton appCompatButton = (AppCompatButton) this.C.findViewById(v51.dialog_rating_button_never);
            AppCompatButton appCompatButton2 = (AppCompatButton) this.C.findViewById(v51.dialog_rating_button_negative);
            AppCompatButton appCompatButton3 = (AppCompatButton) this.C.findViewById(v51.dialog_rating_button_positive);
            this.G = (TextView) this.C.findViewById(v51.dialog_rating_feedback_title);
            AppCompatButton appCompatButton4 = (AppCompatButton) this.C.findViewById(v51.dialog_rating_button_feedback_submit);
            AppCompatButton appCompatButton5 = (AppCompatButton) this.C.findViewById(v51.dialog_rating_button_feedback_cancel);
            this.I = (RatingBar) this.C.findViewById(v51.dialog_rating_rating_bar);
            this.J = (ImageView) this.C.findViewById(v51.dialog_rating_icon);
            this.K = (EditText) this.C.findViewById(v51.dialog_rating_feedback);
            this.L = (LinearLayout) this.C.findViewById(v51.dialog_rating_buttons);
            this.M = (LinearLayout) this.C.findViewById(v51.dialog_rating_feedback_buttons);
            y();
            appCompatButton.setOnClickListener(this);
            appCompatButton2.setOnClickListener(this);
            appCompatButton3.setOnClickListener(this);
            appCompatButton4.setOnClickListener(this);
            appCompatButton5.setOnClickListener(this);
        } catch (Throwable th) {
            th.getMessage();
            finish();
        }
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        u3 u3Var = this.B;
        if (u3Var != null && u3Var.isShowing()) {
            this.B.dismiss();
        }
        this.B = null;
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onPause() {
        super.onPause();
        finish();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [x71] */
    /* JADX WARN: Type inference failed for: r1v4, types: [y71] */
    @Override // defpackage.e6, android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            u3 u3Var = this.B;
            if (u3Var != null && u3Var.isShowing()) {
                this.B.dismiss();
            }
            t3 t3Var = new t3((Context) this, c71.Rounded_AppCompat_Dialog);
            View view = this.C;
            p3 p3Var = (p3) t3Var.h;
            p3Var.t = view;
            p3Var.m = false;
            p3Var.n = new DialogInterface.OnCancelListener() { // from class: x71
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    int i = RatingActivity.N;
                    this.g.finish();
                }
            };
            p3Var.o = new DialogInterface.OnDismissListener() { // from class: y71
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    int i = RatingActivity.N;
                    this.g.finish();
                }
            };
            this.B = t3Var.d();
            if (isFinishing()) {
                return;
            }
            if (this.B.getWindow() != null) {
                this.B.getWindow().setDimAmount(0.2f);
            }
            this.B.show();
        } catch (Throwable th) {
            th.getMessage();
            finish();
        }
    }

    public final void y() {
        LayerDrawable layerDrawable = (LayerDrawable) this.I.getProgressDrawable();
        Drawable drawable = layerDrawable.getDrawable(2);
        int iK = np1.k(this.E, x41.yellow);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        drawable.setColorFilter(iK, mode);
        layerDrawable.getDrawable(1).setColorFilter(np1.k(this.E, x41.yellow), mode);
        layerDrawable.getDrawable(0).setColorFilter(np1.k(this.E, x41.grey_200), mode);
    }
}
