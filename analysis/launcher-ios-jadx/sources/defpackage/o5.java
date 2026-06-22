package defpackage;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.luutinhit.launcher6.widget.widgetprovider.config.PictureAppWidgetProviderConfigureActivity;
import com.luutinhit.launcherios.activity.AnimationsActivity;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o5 implements dl1, ud, k11, uh1, f90, i90, b2, se1, vh1, vk1 {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ o5(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // defpackage.f90, defpackage.i90
    public void a(Bitmap bitmap) {
        switch (this.g) {
            case 4:
                ((h90) this.h).setFullBitmap(bitmap);
                break;
            default:
                ((l90) this.h).k(bitmap);
                break;
        }
    }

    @Override // defpackage.k11
    public void b(m11 m11Var) {
        fd fdVar = (fd) this.h;
        fdVar.getClass();
        if (m11Var != null) {
            try {
                l11 l11Var = m11Var.d;
                if (l11Var != null) {
                    int i = l11Var != null ? l11Var.d : -16777216;
                    ik.d(i);
                    if (ik.d(i) > 0.8d) {
                        jk0.a().g.updateIconTextColor(-12303292);
                        return;
                    } else {
                        jk0.a().g.updateIconTextColor(-1);
                        return;
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
                return;
            }
        }
        ar1.q.execute(fdVar.q);
    }

    public boolean c(ow1 ow1Var, int i, Bundle bundle) {
        un fz1Var;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((tf0) ow1Var.h).e();
                Parcelable parcelable = (Parcelable) ((tf0) ow1Var.h).c();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception unused) {
                return false;
            }
        }
        ClipDescription description = ((tf0) ow1Var.h).getDescription();
        tf0 tf0Var = (tf0) ow1Var.h;
        ClipData clipData = new ClipData(description, new ClipData.Item(tf0Var.d()));
        if (i2 >= 31) {
            fz1Var = new fz1(clipData, 2);
        } else {
            vn vnVar = new vn();
            vnVar.h = clipData;
            vnVar.i = 2;
            fz1Var = vnVar;
        }
        fz1Var.v(tf0Var.g());
        fz1Var.k(bundle);
        return qs1.l((AppCompatEditText) this.h, fz1Var.g()) == null;
    }

    @Override // defpackage.vk1
    public wk1 d(xh xhVar) {
        Context context = (Context) this.h;
        ei eiVar = (ei) xhVar.e;
        qg0.l(eiVar, "callback");
        String str = (String) xhVar.d;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
        }
        return new x60(context, str, eiVar, true, true);
    }

    @Override // defpackage.dl1
    public void e(boolean z) {
        Bitmap bitmapDecodeStream;
        boolean z2 = false;
        int i = AnimationsActivity.H;
        AnimationsActivity animationsActivity = (AnimationsActivity) this.h;
        animationsActivity.A("parallax_zoom_animations", z);
        if (z) {
            animationsActivity.E.postDelayed(animationsActivity.G, 200L);
            return;
        }
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(new FileInputStream(new File(new ContextWrapper(animationsActivity).getDir("image", 0), "wallpaper")));
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDecodeStream = null;
        }
        new Thread(new w1(animationsActivity, bitmapDecodeStream, 3, z2)).start();
    }

    @Override // defpackage.se1
    public void h(View view) {
        int i = SearchViewLayout.C;
        SearchViewLayout searchViewLayout = (SearchViewLayout) this.h;
        searchViewLayout.getClass();
        try {
            searchViewLayout.i.startAppShortcutOrInfoActivity(view);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.b2
    public void i(Object obj) {
        Intent intent;
        a2 a2Var = (a2) obj;
        int i = PictureAppWidgetProviderConfigureActivity.E;
        PictureAppWidgetProviderConfigureActivity pictureAppWidgetProviderConfigureActivity = (PictureAppWidgetProviderConfigureActivity) this.h;
        pictureAppWidgetProviderConfigureActivity.getClass();
        if (a2Var.g != -1 || (intent = a2Var.h) == null || intent.getData() == null) {
            return;
        }
        try {
            MediaStore.Images.Media.getBitmap(pictureAppWidgetProviderConfigureActivity.getContentResolver(), intent.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
