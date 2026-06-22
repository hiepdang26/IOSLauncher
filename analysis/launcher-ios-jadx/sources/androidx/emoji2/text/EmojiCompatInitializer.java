package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.a;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import defpackage.d50;
import defpackage.en0;
import defpackage.ml;
import defpackage.n4;
import defpackage.rt;
import defpackage.wb;
import defpackage.zy;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    @Override // androidx.startup.Initializer
    public final Boolean create(Context context) {
        d50 d50Var = new d50(new wb(context, 1));
        d50Var.a = 1;
        if (zy.j == null) {
            synchronized (zy.i) {
                try {
                    if (zy.j == null) {
                        zy.j = new zy(d50Var);
                    }
                } finally {
                }
            }
        }
        final a aVarL = ((en0) AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).l();
        aVarL.a(new rt(this) { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // defpackage.rt
            public final void onResume() {
                (Build.VERSION.SDK_INT >= 28 ? ml.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new n4(1), 500L);
                aVarL.f(this);
            }
        });
        return Boolean.TRUE;
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
