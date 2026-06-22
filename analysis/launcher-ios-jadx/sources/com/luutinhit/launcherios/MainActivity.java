package com.luutinhit.launcherios;

import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcherios.activity.RatingActivity;
import com.luutinhit.launcherios.customsettings.SettingsView;
import defpackage.ar1;
import defpackage.be0;
import defpackage.c71;
import defpackage.e31;
import defpackage.e42;
import defpackage.l51;
import defpackage.m61;
import defpackage.np1;
import defpackage.nx0;
import defpackage.p3;
import defpackage.qw0;
import defpackage.t3;
import defpackage.u3;
import defpackage.ua;
import defpackage.v51;
import defpackage.w61;
import defpackage.x41;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends ua implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, qw0 {
    public static final /* synthetic */ int I = 0;
    public SharedPreferences B;
    public Context C;
    public DrawerLayout D;
    public NavigationView E;
    public AppCompatImageView F;
    public SettingsView G;
    public final ArrayList H = new ArrayList(Arrays.asList("widget_weather", "widget_favorite", "widget_suggestion"));

    public final void A(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Throwable unused) {
            Toast.makeText(this, w61.application_not_found, 0).show();
        }
    }

    public final void B() {
        if (ar1.i) {
            ArrayList arrayList = new ArrayList();
            if (!e42.g(this)) {
                arrayList.add("android.permission.READ_MEDIA_IMAGES");
            }
            if (!e42.h(this)) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            ArrayList arrayList2 = this.H;
            try {
                String string = this.B.getString("list_choose_widget", null);
                if (string != null) {
                    arrayList2 = new ArrayList(Arrays.asList(TextUtils.split(string, "‚‗‚")));
                }
            } catch (Throwable unused) {
            }
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                if (arrayList2.contains("widget_weather") && !e42.f(this)) {
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
                if (arrayList2.contains("widget_favorite") && ar1.i && np1.d(this, "android.permission.READ_CONTACTS") != 0) {
                    arrayList.add("android.permission.READ_CONTACTS");
                }
                if (arrayList2.contains("widget_calendar") && ar1.i && np1.d(this, "android.permission.READ_CALENDAR") != 0) {
                    arrayList.add("android.permission.READ_CALENDAR");
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            np1.E(this, (String[]) arrayList.toArray(new String[0]), 68);
        }
    }

    public final void C(boolean z) {
        int iK = np1.k(this, z ? x41.activity_background_dark : x41.activity_background);
        this.G.setItemBackground(z ? l51.item_press_state_dark : l51.item_press_state);
        this.D.setBackgroundColor(iK);
        ar1.A(this.D, z ? -1 : -16777216);
    }

    @Override // defpackage.ua, androidx.activity.a, android.app.Activity
    public final void onBackPressed() {
        y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            view.toString();
            int id = view.getId();
            if (id == v51.action_navigation) {
                DrawerLayout drawerLayout = this.D;
                if (drawerLayout != null) {
                    drawerLayout.openDrawer(8388611);
                    return;
                }
                return;
            }
            if (id == v51.action_like || id == v51.floating_button) {
                startActivity(new Intent(this.C, (Class<?>) RatingActivity.class));
                return;
            }
            if (id == v51.action_email) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("vnd.android.cursor.dir/email");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"andywill.itplus@gmail.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "[" + getString(w61.app_name) + "]");
                try {
                    startActivity(Intent.createChooser(intent, "Send mail..."));
                    return;
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(this, "There is no email client installed.", 0).show();
                    return;
                }
            }
            if (id == v51.action_share) {
                try {
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    String str = "https://play.google.com/store/apps/details?id=" + getPackageName();
                    intent2.putExtra("android.intent.extra.SUBJECT", getString(w61.download_app, getString(w61.app_name)));
                    intent2.putExtra("android.intent.extra.TEXT", str);
                    startActivity(Intent.createChooser(intent2, getString(w61.share_via)));
                } catch (Throwable th) {
                    th.getMessage();
                    Toast.makeText(this, w61.application_not_found, 0).show();
                }
            }
        }
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.C = getApplicationContext();
            setContentView(m61.activity_main);
            if (getPackageName().contains("luutinhit")) {
                if (this.C != null) {
                    this.D = (DrawerLayout) findViewById(v51.drawer_layout);
                    this.E = (NavigationView) findViewById(v51.nav_view);
                    this.F = (AppCompatImageView) findViewById(v51.header_layout);
                    this.G = (SettingsView) findViewById(v51.scroll_settings);
                    z(this.D, false);
                    findViewById(v51.action_like).setOnClickListener(this);
                    findViewById(v51.action_email).setOnClickListener(this);
                    findViewById(v51.action_share).setOnClickListener(this);
                    findViewById(v51.action_navigation).setOnClickListener(this);
                    findViewById(v51.floating_button).setOnClickListener(this);
                    this.B = e31.a(this.C);
                }
                B();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onDestroy() {
        Intent intent;
        try {
            if (ar1.x() || ar1.t()) {
                intent = new Intent(this, (Class<?>) IOSLauncher.class);
            } else {
                intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
            }
            startActivity(intent);
        } catch (Throwable unused) {
        }
        this.B.unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        SharedPreferences sharedPreferences = this.B;
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        NavigationView navigationView = this.E;
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
        SettingsView settingsView = this.G;
        if (settingsView != null) {
            settingsView.setOnOverScrollListener(new nx0(this, 18));
            if (this.B.getBoolean("dark_mode", false)) {
                C(true);
            }
        }
        if (!ar1.j || e42.h(this)) {
            return;
        }
        int wallpaperId = WallpaperManager.getInstance(this).getWallpaperId(1);
        this.B.getInt("wallpaper_id", 0);
        if (wallpaperId != this.B.getInt("wallpaper_id", 0)) {
            try {
                View viewInflate = getLayoutInflater().inflate(m61.dialog_suggest_blur_effect, (ViewGroup) null);
                t3 t3Var = new t3((Context) this, c71.Rounded_AppCompat_Dialog);
                p3 p3Var = (p3) t3Var.h;
                p3Var.t = viewInflate;
                p3Var.m = false;
                u3 u3VarD = t3Var.d();
                findViewById(v51.dialog_blur_effect_button_never).setVisibility(8);
                findViewById(v51.dialog_blur_effect_button_negative).setOnClickListener(new be0(u3VarD, 2));
                findViewById(v51.dialog_blur_effect_button_positive).setOnClickListener(new be0(u3VarD, 3));
                if (u3VarD.getWindow() != null) {
                    u3VarD.getWindow().setDimAmount(0.2f);
                }
                u3VarD.show();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    @Override // androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null || !str.equals("dark_mode")) {
            return;
        }
        C(sharedPreferences.getBoolean("dark_mode", false));
    }
}
