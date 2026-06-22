package defpackage;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.luutinhit.launcherios.activity.FakeLauncher;

/* JADX INFO: loaded from: classes.dex */
public final class za1 {
    public final Context a;
    public AlertDialog b;

    public za1(Context context) {
        this.a = context;
    }

    public static void b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, (Class<?>) FakeLauncher.class);
        packageManager.setComponentEnabledSetting(componentName, 1, 1);
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
        packageManager.setComponentEnabledSetting(componentName, 2, 1);
    }

    public final void a() {
        Context context = this.a;
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            c(context.getPackageManager().resolveActivity(intent, 0));
        } catch (Throwable unused) {
            b(context);
        }
    }

    public final void c(ResolveInfo resolveInfo) {
        CharSequence string;
        Intent intent;
        Context context = this.a;
        try {
            String string2 = context.getString(w61.app_name);
            if (context.getPackageManager().resolveActivity(new Intent("android.settings.HOME_SETTINGS"), 0) == null) {
                string = context.getString(w61.change_default_home_dialog_body, string2);
                intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", resolveInfo.activityInfo.packageName, null));
            } else {
                Intent intent2 = new Intent("android.settings.HOME_SETTINGS");
                SpannableString spannableString = new SpannableString(context.getString(w61.change_default_home_dialog_body, string2));
                spannableString.setSpan(new TtsSpan.TextBuilder(context.getString(w61.change_default_home_dialog_body, string2)).build(), 0, spannableString.length(), 18);
                string = spannableString;
                intent = intent2;
            }
            View viewInflate = LayoutInflater.from(context).inflate(m61.dialog_set_default_launcher, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(v51.dialog_set_default_title)).setText(string);
            Button button = (Button) viewInflate.findViewById(v51.dialog_set_default_button_negative);
            Button button2 = (Button) viewInflate.findViewById(v51.dialog_set_default_button_positive);
            this.b = new AlertDialog.Builder(context, c71.Rounded_AppCompat_Dialog).setView(viewInflate).setCancelable(true).create();
            button.setOnClickListener(new g7(this, 10));
            button2.setOnClickListener(new ce0(this, intent, 2));
            AlertDialog alertDialog = this.b;
            if (alertDialog != null) {
                alertDialog.show();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
