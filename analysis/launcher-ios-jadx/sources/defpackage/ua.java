package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ua extends e6 {
    @Override // androidx.activity.a, android.app.Activity
    public void onBackPressed() {
        try {
            super.onBackPressed();
            overridePendingTransition(g41.left_to_right_enter, g41.left_to_right);
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(512, 512);
        }
        super.onCreate(bundle);
    }

    @Override // defpackage.e6, android.app.Activity
    public void onStart() {
        View viewFindViewById = findViewById(v51.action_back);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new ta(this));
        }
        super.onStart();
    }

    public final void y() {
        try {
            super.onBackPressed();
        } catch (Throwable unused) {
            finish();
        }
    }

    public final void z(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(z ? 12290 : 4098);
        }
        s9 s9Var = new s9();
        WeakHashMap weakHashMap = qs1.a;
        hs1.m(view, s9Var);
    }
}
