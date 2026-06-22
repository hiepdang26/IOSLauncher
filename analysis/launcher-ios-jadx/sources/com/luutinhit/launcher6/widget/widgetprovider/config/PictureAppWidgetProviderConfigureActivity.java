package com.luutinhit.launcher6.widget.widgetprovider.config;

import android.appwidget.AppWidgetManager;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.widgetprovider.PictureAppWidgetProvider;
import com.luutinhit.launcherios.cropper.CropImageActivity;
import defpackage.ar1;
import defpackage.c2;
import defpackage.e31;
import defpackage.e42;
import defpackage.e51;
import defpackage.e6;
import defpackage.jk0;
import defpackage.o5;
import defpackage.op;
import defpackage.qp;
import defpackage.rp;
import defpackage.sp;
import defpackage.w61;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class PictureAppWidgetProviderConfigureActivity extends e6 {
    public static final /* synthetic */ int E = 0;
    public SharedPreferences B;
    public int C = 0;
    public float D;

    public PictureAppWidgetProviderConfigureActivity() {
        this.o.d("activity_rq#" + this.n.getAndIncrement(), this, new c2(1), new o5(this, 7));
    }

    @Override // defpackage.e6, androidx.activity.a, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 203 && intent != null && (uri = ((op) intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT")).h) != null) {
            uri.toString();
            int i3 = this.C;
            String string = uri.toString();
            SharedPreferences.Editor editorEdit = this.B.edit();
            editorEdit.putString("appwidget_" + i3, string);
            editorEdit.apply();
            PictureAppWidgetProvider.a(this, AppWidgetManager.getInstance(this), this.C);
            Intent intent2 = new Intent();
            intent2.putExtra("appWidgetId", this.C);
            setResult(-1, intent2);
        }
        finish();
    }

    @Override // defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.B = getSharedPreferences(e31.b(this), 0);
        setResult(0);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.C = extras.getInt("appWidgetId", 0);
        }
        if (this.C == 0) {
            finish();
            return;
        }
        this.D = getResources().getDimensionPixelSize(e51.icon_round_corner);
        y("appwidget_" + this.C);
    }

    @Override // defpackage.e6, androidx.activity.a, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 68) {
            try {
                HashMap map = new HashMap();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    map.put(strArr[i2], Integer.valueOf(iArr[i2]));
                }
                if (((Integer) map.get("android.permission.READ_EXTERNAL_STORAGE")).intValue() != 0 || ((Integer) map.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() != 0) {
                    Toast.makeText(this, w61.required_storage_permission, 1).show();
                    return;
                }
                y("appwidget_" + this.C);
            } catch (Throwable unused) {
                Toast.makeText(this, w61.required_storage_permission, 1).show();
            }
        }
    }

    public final void y(String str) {
        Uri uriFromFile;
        boolean z = ar1.j;
        if (!z ? e42.h(this) : e42.g(this)) {
            Toast.makeText(this, w61.required_storage_permission, 1).show();
            if (z) {
                e42.o(this);
                return;
            } else {
                e42.p(this);
                return;
            }
        }
        int i = (jk0.a().e.r.C * 6) + (jk0.a().e.h * 4);
        if (i < 0) {
            i = t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT;
        }
        qp qpVar = new qp();
        qpVar.t = 1;
        qpVar.u = 1;
        qpVar.s = true;
        qpVar.k = sp.h;
        qpVar.K = getString(w61.pick_image);
        qpVar.h = this.D / i;
        qpVar.g = rp.h;
        qpVar.N = Bitmap.CompressFormat.JPEG;
        qpVar.O = 100;
        qpVar.P = i;
        qpVar.Q = i;
        qpVar.c0 = 3;
        try {
            uriFromFile = Uri.fromFile(new File(new ContextWrapper(this).getDir("image", 0), str.replace("/", "_") + ".jpg"));
        } catch (Throwable unused) {
            uriFromFile = null;
        }
        qpVar.M = uriFromFile;
        qpVar.a();
        qpVar.a();
        Intent intent = new Intent();
        intent.setClass(this, CropImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("CROP_IMAGE_EXTRA_SOURCE", null);
        bundle.putParcelable("CROP_IMAGE_EXTRA_OPTIONS", qpVar);
        intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", bundle);
        startActivityForResult(intent, 203);
    }
}
