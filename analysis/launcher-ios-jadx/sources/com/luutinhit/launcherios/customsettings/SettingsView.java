package com.luutinhit.launcherios.customsettings;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.activity.AnimationsActivity;
import com.luutinhit.launcherios.activity.AppsLibraryCategoryActivity;
import com.luutinhit.launcherios.activity.BlurConfigActivity;
import com.luutinhit.launcherios.activity.EditWidgetActivity;
import com.luutinhit.launcherios.activity.HiddenAppsActivity;
import com.luutinhit.launcherios.activity.IconChangeActivity;
import com.luutinhit.launcherios.activity.LabelChangeActivity;
import com.luutinhit.launcherios.activity.LiquidGlassConfigActivity;
import com.luutinhit.launcherios.activity.RatingActivity;
import com.luutinhit.launcherios.activity.UtilitiesActivity;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import com.luutinhit.launcherios.activity.WeatherConfigActivity;
import defpackage.ar1;
import defpackage.g41;
import defpackage.jq0;
import defpackage.m61;
import defpackage.nx0;
import defpackage.o61;
import defpackage.of1;
import defpackage.og0;
import defpackage.p3;
import defpackage.pd;
import defpackage.qf1;
import defpackage.rf1;
import defpackage.s2;
import defpackage.t3;
import defpackage.tf1;
import defpackage.u3;
import defpackage.v51;
import defpackage.w61;
import defpackage.za1;
import java.io.File;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SettingsView extends pd implements View.OnClickListener {
    public static final /* synthetic */ int g0 = 0;
    public final MainActivity b0;
    public final Context c0;
    public u3 d0;
    public final PackageManager e0;
    public og0 f0;

    public SettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Context context2 = getContext();
        this.c0 = context2;
        if (context2 != null) {
            if (context2 instanceof MainActivity) {
                this.b0 = (MainActivity) context2;
            }
            this.e0 = context2.getPackageManager();
            new Thread(new of1(this, 0)).start();
        }
        LayoutInflater.from(context).inflate(m61.settings_view, (ViewGroup) this, true);
        SettingsItem settingsItem = (SettingsItem) findViewById(v51.notification_badges);
        findViewById(v51.lock_screen).setOnClickListener(this);
        findViewById(v51.assistive_touch).setOnClickListener(this);
        findViewById(v51.control_center).setOnClickListener(this);
        settingsItem.setOnClickListener(this);
        findViewById(v51.config_liquid_glass).setOnClickListener(this);
        findViewById(v51.choose_wallpaper).setOnClickListener(this);
        findViewById(v51.config_weather).setOnClickListener(this);
        findViewById(v51.hidden_apps).setOnClickListener(this);
        findViewById(v51.config_blur).setOnClickListener(this);
        findViewById(v51.utilities).setOnClickListener(this);
        findViewById(v51.change_icon).setOnClickListener(this);
        findViewById(v51.change_label).setOnClickListener(this);
        findViewById(v51.app_library).setOnClickListener(this);
        findViewById(v51.config_widget).setOnClickListener(this);
        findViewById(v51.config_animation).setOnClickListener(this);
        findViewById(v51.make_default_launcher).setOnClickListener(this);
        findViewById(v51.rate).setOnClickListener(this);
        findViewById(v51.download).setOnClickListener(this);
        if (ar1.p) {
            try {
                String packageName = context2.getPackageName();
                String string = Settings.Secure.getString(context2.getContentResolver(), "enabled_notification_listeners");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                for (String str : string.split(":")) {
                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                    if (componentNameUnflattenFromString != null && TextUtils.equals(packageName, componentNameUnflattenFromString.getPackageName())) {
                        settingsItem.setVisibility(8);
                        return;
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public static void r(SettingsView settingsView, int i) {
        if (i == 0) {
            settingsView.s("com.luutinhit.lockscreennotificationsios");
            return;
        }
        if (i == 1) {
            settingsView.s("com.luutinhit.assistivetouch");
        } else if (i != 2) {
            settingsView.getClass();
        } else {
            settingsView.s("com.luutinhit.controlcenter");
        }
    }

    public static void v(LinearLayout linearLayout, int i) {
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt instanceof SettingsItem) {
                childAt.setBackgroundResource(i);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            int i = v51.rate;
            Context context = this.c0;
            if (id == i) {
                context.startActivity(new Intent(context, (Class<?>) RatingActivity.class));
                return;
            }
            int i2 = v51.download;
            MainActivity mainActivity = this.b0;
            if (id == i2) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://dev?id=5295002497598445111"));
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th) {
                    th.getMessage();
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/dev?id=5295002497598445111"));
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                }
            } else if (id == v51.lock_screen) {
                if (t("com.luutinhit.lockscreennotificationsios")) {
                    try {
                        Intent intent3 = new Intent();
                        intent3.setComponent(new ComponentName("com.luutinhit.lockscreennotificationsios", "com.luutinhit.lockscreennotificationsios.MainActivity"));
                        intent3.putExtra("hideLayoutIntro", true);
                        intent3.putExtra("not_show_rating_dialog", true);
                        context.startActivity(intent3);
                        if (mainActivity != null) {
                            mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                        }
                    } catch (Throwable th2) {
                        th2.getMessage();
                        x("com.luutinhit.lockscreennotificationsios");
                    }
                } else {
                    w(0, w61.download_lock_screen);
                }
            } else if (id == v51.assistive_touch) {
                if (t("com.luutinhit.assistivetouch")) {
                    try {
                        Intent intent4 = new Intent();
                        intent4.setComponent(new ComponentName("com.luutinhit.assistivetouch", "com.luutinhit.assistivetouch.MainActivity"));
                        intent4.putExtra("hideLayoutIntro", true);
                        intent4.putExtra("not_show_rating_dialog", true);
                        context.startActivity(intent4);
                        if (mainActivity != null) {
                            mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                        }
                    } catch (Throwable th3) {
                        th3.getMessage();
                        x("com.luutinhit.assistivetouch");
                    }
                } else {
                    w(1, w61.download_assistive_touch);
                }
            } else if (id == v51.control_center) {
                if (t("com.luutinhit.controlcenter")) {
                    try {
                        Intent intent5 = new Intent();
                        intent5.setComponent(new ComponentName("com.luutinhit.controlcenter", "com.luutinhit.controlcenter.MainActivity"));
                        intent5.putExtra("hideLayoutIntro", true);
                        intent5.putExtra("not_show_rating_dialog", true);
                        context.startActivity(intent5);
                        if (mainActivity != null) {
                            mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                        }
                    } catch (Throwable th4) {
                        th4.getMessage();
                        x("com.luutinhit.controlcenter");
                    }
                } else {
                    w(2, w61.download_control_center);
                }
            } else if (id == v51.choose_wallpaper) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) WallpaperActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th5) {
                    Toast.makeText(context, "startWallpapers Error: " + th5.getMessage(), 1).show();
                }
            } else if (id == v51.config_liquid_glass) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) LiquidGlassConfigActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th6) {
                    Toast.makeText(context, "Liquid Glass error: " + th6.getMessage(), 1).show();
                }
            } else if (id == v51.config_animation) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) AnimationsActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th7) {
                    Toast.makeText(context, "startWallpapers Error: " + th7.getMessage(), 1).show();
                }
            } else if (id == v51.notification_badges) {
                try {
                    context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th8) {
                    Toast.makeText(context, "Error: " + th8.getMessage(), 1).show();
                }
            } else if (id == v51.config_widget) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) EditWidgetActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th9) {
                    Toast.makeText(context, "Error: " + th9.getMessage(), 1).show();
                }
            } else if (id == v51.config_weather) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) WeatherConfigActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th10) {
                    Toast.makeText(context, "Error: " + th10.getMessage(), 1).show();
                }
            } else if (id == v51.hidden_apps) {
                try {
                    String path = context.getDatabasePath("app_icons.db").getPath();
                    if (path == null || path.isEmpty() || !new File(path).exists()) {
                        context.startActivity(new Intent(context, (Class<?>) IOSLauncher.class));
                        Toast.makeText(context, w61.start_ios_launcher_firstly, 1).show();
                    } else {
                        context.startActivity(new Intent(context, (Class<?>) HiddenAppsActivity.class));
                        if (mainActivity != null) {
                            mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                        }
                    }
                } catch (Throwable th11) {
                    Toast.makeText(context, "Error: " + th11.getMessage(), 1).show();
                }
            } else if (id == v51.config_blur) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) BlurConfigActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th12) {
                    Toast.makeText(context, "Blur error: " + th12.getMessage(), 1).show();
                }
            } else if (id == v51.utilities) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) UtilitiesActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th13) {
                    Toast.makeText(context, "startUtilities Error: " + th13.getMessage(), 1).show();
                }
            } else if (id == v51.change_icon) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) IconChangeActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th14) {
                    Toast.makeText(context, "startChangeIcon Error: " + th14.getMessage(), 1).show();
                }
            } else if (id == v51.change_label) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) LabelChangeActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th15) {
                    Toast.makeText(context, "startChangeLabel Error: " + th15.getMessage(), 1).show();
                }
            } else if (id == v51.app_library) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) AppsLibraryCategoryActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(g41.right_to_left, g41.right_to_left_exit);
                    }
                } catch (Throwable th16) {
                    Toast.makeText(context, "startChangeLabel Error: " + th16.getMessage(), 1).show();
                }
            } else if (id == v51.make_default_launcher) {
                new za1(context).a();
            }
            Objects.toString(this.f0);
            try {
                og0 og0Var = this.f0;
                if (og0Var != null) {
                    og0Var.show(mainActivity);
                }
            } catch (Throwable th17) {
                th17.getMessage();
            }
        }
    }

    public final void s(String str) {
        Context context = this.c0;
        try {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(str)));
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Throwable unused) {
                Toast.makeText(context, w61.application_not_found, 0).show();
            }
        } catch (ActivityNotFoundException unused2) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=".concat(str)));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    public void setItemBackground(int i) {
        v((LinearLayout) findViewById(v51.settings_group_suggest_apps), i);
        v((LinearLayout) findViewById(v51.settings_group_settings_app), i);
        v((LinearLayout) findViewById(v51.settings_group_rating_app), i);
    }

    public final boolean t(String str) {
        try {
            return this.e0.getPackageInfo(str, 0).packageName.equals(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void u() {
        try {
            s2 s2Var = new s2(new nx0(2));
            Context context = this.c0;
            og0.load(context, context.getString(w61.ad_unit_id), s2Var, new tf1(this));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void w(int i, int i2) {
        MainActivity mainActivity = this.b0;
        try {
            View viewInflate = mainActivity.getLayoutInflater().inflate(m61.download_tool_dialog, (ViewGroup) null);
            if (viewInflate instanceof AppCompatImageView) {
                if (i == 0) {
                    ((AppCompatImageView) viewInflate).setImageResource(o61.lock_screen_background);
                } else if (i == 1) {
                    ((AppCompatImageView) viewInflate).setImageResource(o61.assistive_touch_background);
                } else if (i == 2) {
                    ((AppCompatImageView) viewInflate).setImageResource(o61.control_center_background);
                }
                viewInflate.setOnClickListener(new qf1(this, i));
                t3 t3Var = new t3(mainActivity);
                p3 p3Var = (p3) t3Var.h;
                p3Var.d = p3Var.a.getText(w61.download);
                p3Var.f = p3Var.a.getText(i2);
                p3Var.t = viewInflate;
                rf1 rf1Var = new rf1(this, i);
                p3Var.g = p3Var.a.getText(R.string.ok);
                p3Var.h = rf1Var;
                jq0 jq0Var = new jq0(1);
                p3Var.i = p3Var.a.getText(R.string.cancel);
                p3Var.j = jq0Var;
                this.d0 = t3Var.d();
            }
            u3 u3Var = this.d0;
            if (u3Var != null) {
                u3Var.show();
            }
        } catch (Throwable unused) {
        }
    }

    public final void x(String str) {
        Context context = this.c0;
        try {
            Intent launchIntentForPackage = this.e0.getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
            }
            context.startActivity(launchIntentForPackage);
        } catch (Throwable unused) {
            Toast.makeText(context, w61.application_not_found, 0).show();
        }
    }
}
