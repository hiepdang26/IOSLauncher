package defpackage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.activity.AppsLibraryCategoryActivity;

/* JADX INFO: loaded from: classes.dex */
public final class qg implements View.OnClickListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ AppsLibraryCategoryActivity h;
    public final /* synthetic */ rg i;

    public qg(rg rgVar, int i, AppsLibraryCategoryActivity appsLibraryCategoryActivity) {
        this.i = rgVar;
        this.g = i;
        this.h = appsLibraryCategoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        rg rgVar = this.i;
        int iE = rgVar.e();
        sg sgVar = rgVar.D;
        int i = ((y6) sgVar.k.get(iE)).e;
        final String str = ((y6) sgVar.k.get(iE)).d;
        String str2 = ((y6) sgVar.k.get(this.g)).c;
        final AppsLibraryCategoryActivity appsLibraryCategoryActivity = this.h;
        appsLibraryCategoryActivity.getClass();
        AlertDialog.Builder builder = new AlertDialog.Builder(appsLibraryCategoryActivity, c71.Rounded_AppCompat_Dialog);
        builder.setTitle(w61.category);
        final TextViewCustomFont textViewCustomFont = rgVar.C;
        builder.setSingleChoiceItems(new String[]{appsLibraryCategoryActivity.getString(w61.game), appsLibraryCategoryActivity.getString(w61.audio), appsLibraryCategoryActivity.getString(w61.video), appsLibraryCategoryActivity.getString(w61.image), appsLibraryCategoryActivity.getString(w61.social), appsLibraryCategoryActivity.getString(w61.news), appsLibraryCategoryActivity.getString(w61.maps), appsLibraryCategoryActivity.getString(w61.productivity), appsLibraryCategoryActivity.getString(w61.other)}, i - 1, new DialogInterface.OnClickListener() { // from class: w7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                String str3 = str;
                int i3 = AppsLibraryCategoryActivity.J;
                AppsLibraryCategoryActivity appsLibraryCategoryActivity2 = appsLibraryCategoryActivity;
                int i4 = i2 + 1;
                textViewCustomFont.setText(sg.p(i4, appsLibraryCategoryActivity2.getResources()));
                try {
                    Intent intent = new Intent("com.luutinhit.launcherios.ACTION_UPDATE_CATEGORY");
                    intent.putExtra("EXTRA_COMPONENT_NAME", str3);
                    intent.putExtra("EXTRA_APP_CATEGORY", i4);
                    appsLibraryCategoryActivity2.sendBroadcast(intent);
                    appsLibraryCategoryActivity2.E = true;
                } catch (Throwable th) {
                    th.getMessage();
                }
                dialogInterface.dismiss();
            }
        });
        if (appsLibraryCategoryActivity.isFinishing()) {
            return;
        }
        builder.show();
    }
}
