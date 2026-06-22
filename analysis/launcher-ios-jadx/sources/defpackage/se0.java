package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcherios.activity.IconChangeActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class se0 extends m91 implements View.OnClickListener {
    public final TextView A;
    public final AppCompatImageView B;
    public final /* synthetic */ sg C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se0(sg sgVar, View view) {
        super(view);
        this.C = sgVar;
        this.A = (TextView) view.findViewById(v51.label);
        this.B = (AppCompatImageView) view.findViewById(v51.icon_app);
        view.findViewById(v51.edit).setOnClickListener(this);
        view.findViewById(v51.reload).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Drawable applicationIcon;
        sg sgVar = this.C;
        if (((IconChangeActivity) sgVar.l) == null || sgVar.k == null) {
            return;
        }
        int iE = e();
        int i = ((y6) sgVar.k.get(iE)).a;
        String str = ((y6) sgVar.k.get(iE)).c;
        String str2 = ((y6) sgVar.k.get(iE)).d;
        IconChangeActivity iconChangeActivity = (IconChangeActivity) sgVar.l;
        AppCompatImageView appCompatImageView = this.B;
        iconChangeActivity.getClass();
        if (view != null) {
            try {
                int id = view.getId();
                if (id == v51.edit) {
                    iconChangeActivity.A(appCompatImageView, str2, iE);
                    return;
                }
                if (id == v51.reload) {
                    Intent intent = new Intent("com.luutinhit.launcherios.ACTION_RELOAD_ICON");
                    intent.putExtra("EXTRA_COMPONENT_NAME", str2);
                    intent.putExtra("EXTRA_ICON_ID", -1);
                    iconChangeActivity.sendBroadcast(intent);
                    Context context = iconChangeActivity.B;
                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str2);
                    if (componentNameUnflattenFromString != null) {
                        String packageName = componentNameUnflattenFromString.getPackageName();
                        try {
                            applicationIcon = iconChangeActivity.getPackageManager().getApplicationIcon(packageName);
                            if (applicationIcon == null) {
                                applicationIcon = iconChangeActivity.getPackageManager().getApplicationInfo(packageName, 128).loadIcon(iconChangeActivity.getPackageManager());
                            }
                        } catch (Throwable th) {
                            th.getMessage();
                            applicationIcon = null;
                        }
                    } else {
                        applicationIcon = null;
                    }
                    Bitmap bitmapP = ar1.p(context, ar1.h(applicationIcon, iconChangeActivity.B));
                    if (bitmapP != null) {
                        sg sgVar2 = iconChangeActivity.D;
                        Bitmap bitmapP2 = ar1.p(iconChangeActivity.B, bitmapP);
                        ArrayList arrayList = sgVar2.k;
                        if (arrayList == null || arrayList.size() <= iE) {
                            return;
                        }
                        ((y6) sgVar2.k.get(iE)).b = bitmapP2;
                        sgVar2.g(iE);
                    }
                }
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
    }
}
