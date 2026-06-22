package defpackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.internal.ads.zzcab;

/* JADX INFO: loaded from: classes.dex */
public final class d72 {
    public final View a;
    public Activity b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final ViewTreeObserver.OnGlobalLayoutListener f;

    public d72(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.b = activity;
        this.a = view;
        this.f = onGlobalLayoutListener;
    }

    public final void a() {
        View decorView;
        if (this.c) {
            return;
        }
        Activity activity = this.b;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f;
        if (activity != null) {
            Window window = activity.getWindow();
            ViewTreeObserver viewTreeObserver = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
        zzcab zzcabVar = hd2.B.A;
        zzcab.zza(this.a, onGlobalLayoutListener);
        this.c = true;
    }
}
