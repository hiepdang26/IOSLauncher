package com.luutinhit.launcherios.activity;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.a;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import defpackage.ar1;
import defpackage.b8;
import defpackage.bo1;
import defpackage.c2;
import defpackage.c8;
import defpackage.co0;
import defpackage.d2;
import defpackage.e42;
import defpackage.e51;
import defpackage.g41;
import defpackage.hb;
import defpackage.k7;
import defpackage.m6;
import defpackage.m61;
import defpackage.mv1;
import defpackage.na1;
import defpackage.nv1;
import defpackage.pv1;
import defpackage.q61;
import defpackage.qv1;
import defpackage.r1;
import defpackage.ua;
import defpackage.v51;
import defpackage.w61;
import defpackage.xy0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class WallpaperActivity extends ua implements xy0, View.OnClickListener {
    public static final /* synthetic */ int W = 0;
    public Context B;
    public bo1 C;
    public ViewPager D;
    public ConstraintLayout E;
    public ConstraintLayout F;
    public LinearLayout G;
    public AppCompatImageView H;
    public AppCompatImageView I;
    public Animation J;
    public co0 K;
    public b8 L;
    public int M;
    public int N;
    public RealTimeBlurView Q;
    public WallpaperManager T;
    public Uri O = null;
    public final ArrayList P = new ArrayList();
    public final Handler R = new Handler();
    public final mv1 S = new mv1(this, 0);
    public final m6 U = new m6(this, 6);
    public final d2 V = this.o.d("activity_rq#" + this.n.getAndIncrement(), this, new c2(1), new nv1(this));

    public static void A(WallpaperActivity wallpaperActivity) {
        C(wallpaperActivity.E);
        C(wallpaperActivity.F);
        wallpaperActivity.G.animate().withLayer().alpha(0.0f).setDuration(168L).start();
        wallpaperActivity.G.postDelayed(new mv1(wallpaperActivity, 2), 169L);
        wallpaperActivity.H.clearAnimation();
        wallpaperActivity.T.getDesiredMinimumWidth();
        wallpaperActivity.T.getDesiredMinimumHeight();
    }

    public static void B(final WallpaperActivity wallpaperActivity, final Bitmap bitmap) {
        final Bitmap bitmapCopy;
        final int i = 0;
        new Thread(new Runnable(wallpaperActivity) { // from class: ov1
            public final /* synthetic */ WallpaperActivity h;

            {
                this.h = wallpaperActivity;
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                ConstraintLayout constraintLayout;
                mv1 mv1Var;
                WallpaperActivity wallpaperActivity2 = this.h;
                Bitmap bitmap2 = bitmap;
                switch (i) {
                    case 0:
                        int i2 = WallpaperActivity.W;
                        try {
                            wallpaperActivity2.T.suggestDesiredDimensions(wallpaperActivity2.M, wallpaperActivity2.N);
                            if (ar1.f) {
                                wallpaperActivity2.T.setBitmap(bitmap2, new Rect(0, 0, wallpaperActivity2.M, wallpaperActivity2.N), true, 1);
                            } else {
                                wallpaperActivity2.T.setBitmap(bitmap2);
                            }
                            if (ar1.j) {
                                wallpaperActivity2.T.getWallpaperId(1);
                                wallpaperActivity2.C.f(wallpaperActivity2.T.getWallpaperId(1), "wallpaper_id");
                            }
                            constraintLayout = wallpaperActivity2.E;
                            mv1Var = new mv1(wallpaperActivity2, 1);
                            break;
                        } catch (Throwable th) {
                            try {
                                th.getMessage();
                                constraintLayout = wallpaperActivity2.E;
                                mv1Var = new mv1(wallpaperActivity2, 1);
                            } catch (Throwable th2) {
                                wallpaperActivity2.E.post(new mv1(wallpaperActivity2, 1));
                                throw th2;
                            }
                        }
                        constraintLayout.post(mv1Var);
                        return;
                    default:
                        int i3 = WallpaperActivity.W;
                        FileOutputStream fileOutputStream = null;
                        try {
                            try {
                                File dir = wallpaperActivity2.B.getDir("image", 0);
                                if (dir.exists() || dir.mkdirs()) {
                                    File file = new File(dir, "wallpaper");
                                    if (file.exists() && !file.delete()) {
                                        file.getAbsolutePath();
                                    }
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                                        fileOutputStream2.flush();
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e) {
                                            e = e;
                                            e.getMessage();
                                        }
                                    } catch (IOException e2) {
                                        fileOutputStream = fileOutputStream2;
                                        e = e2;
                                        e.getMessage();
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e3) {
                                                e = e3;
                                                e.getMessage();
                                            }
                                        }
                                    } catch (Exception e4) {
                                        fileOutputStream = fileOutputStream2;
                                        e = e4;
                                        e.getMessage();
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e5) {
                                                e = e5;
                                                e.getMessage();
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        fileOutputStream = fileOutputStream2;
                                        th = th3;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e6) {
                                                e6.getMessage();
                                            }
                                            break;
                                        }
                                        bitmap2.recycle();
                                        throw th;
                                    }
                                } else {
                                    dir.getAbsolutePath();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            break;
                        } catch (IOException e7) {
                            e = e7;
                        } catch (Exception e8) {
                            e = e8;
                        }
                        bitmap2.recycle();
                        return;
                }
            }
        }).start();
        if (!ar1.j || bitmap.isRecycled() || (bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false)) == null) {
            return;
        }
        final int i2 = 1;
        new Thread(new Runnable(wallpaperActivity) { // from class: ov1
            public final /* synthetic */ WallpaperActivity h;

            {
                this.h = wallpaperActivity;
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                ConstraintLayout constraintLayout;
                mv1 mv1Var;
                WallpaperActivity wallpaperActivity2 = this.h;
                Bitmap bitmap2 = bitmapCopy;
                switch (i2) {
                    case 0:
                        int i22 = WallpaperActivity.W;
                        try {
                            wallpaperActivity2.T.suggestDesiredDimensions(wallpaperActivity2.M, wallpaperActivity2.N);
                            if (ar1.f) {
                                wallpaperActivity2.T.setBitmap(bitmap2, new Rect(0, 0, wallpaperActivity2.M, wallpaperActivity2.N), true, 1);
                            } else {
                                wallpaperActivity2.T.setBitmap(bitmap2);
                            }
                            if (ar1.j) {
                                wallpaperActivity2.T.getWallpaperId(1);
                                wallpaperActivity2.C.f(wallpaperActivity2.T.getWallpaperId(1), "wallpaper_id");
                            }
                            constraintLayout = wallpaperActivity2.E;
                            mv1Var = new mv1(wallpaperActivity2, 1);
                            break;
                        } catch (Throwable th) {
                            try {
                                th.getMessage();
                                constraintLayout = wallpaperActivity2.E;
                                mv1Var = new mv1(wallpaperActivity2, 1);
                            } catch (Throwable th2) {
                                wallpaperActivity2.E.post(new mv1(wallpaperActivity2, 1));
                                throw th2;
                            }
                        }
                        constraintLayout.post(mv1Var);
                        return;
                    default:
                        int i3 = WallpaperActivity.W;
                        FileOutputStream fileOutputStream = null;
                        try {
                            try {
                                File dir = wallpaperActivity2.B.getDir("image", 0);
                                if (dir.exists() || dir.mkdirs()) {
                                    File file = new File(dir, "wallpaper");
                                    if (file.exists() && !file.delete()) {
                                        file.getAbsolutePath();
                                    }
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                                        fileOutputStream2.flush();
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e) {
                                            e = e;
                                            e.getMessage();
                                        }
                                    } catch (IOException e2) {
                                        fileOutputStream = fileOutputStream2;
                                        e = e2;
                                        e.getMessage();
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e3) {
                                                e = e3;
                                                e.getMessage();
                                            }
                                        }
                                    } catch (Exception e4) {
                                        fileOutputStream = fileOutputStream2;
                                        e = e4;
                                        e.getMessage();
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e5) {
                                                e = e5;
                                                e.getMessage();
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        fileOutputStream = fileOutputStream2;
                                        th = th3;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e6) {
                                                e6.getMessage();
                                            }
                                            break;
                                        }
                                        bitmap2.recycle();
                                        throw th;
                                    }
                                } else {
                                    dir.getAbsolutePath();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            break;
                        } catch (IOException e7) {
                            e = e7;
                        } catch (Exception e8) {
                            e = e8;
                        }
                        bitmap2.recycle();
                        return;
                }
            }
        }).start();
    }

    public static boolean C(ConstraintLayout constraintLayout) {
        if (constraintLayout == null || constraintLayout.getVisibility() != 0) {
            return false;
        }
        constraintLayout.animate().withLayer().alpha(0.0f).setDuration(268L).start();
        constraintLayout.postDelayed(new r1(constraintLayout, 28), 269L);
        return true;
    }

    public final void D() {
        this.G.setAlpha(0.0f);
        this.G.setVisibility(0);
        this.G.animate().withLayer().alpha(1.0f).setDuration(168L).start();
        this.H.startAnimation(this.J);
    }

    @Override // defpackage.e6, androidx.activity.a, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2;
        if (i2 == -1) {
            if (i == 0) {
                if (ar1.x() || ar1.t()) {
                    intent2 = new Intent(this, (Class<?>) IOSLauncher.class);
                } else {
                    intent2 = new Intent("android.intent.action.MAIN");
                    intent2.addCategory("android.intent.category.HOME");
                }
                startActivity(intent2);
            } else if (i == 1 && intent != null) {
                this.O = intent.getData();
                ((na1) ((na1) a.e(this.B).l().O(this.O).c()).p(this.M, this.N)).L(this.I);
                this.F.setAlpha(0.0f);
                this.F.setVisibility(0);
                this.F.animate().withLayer().alpha(1.0f).setDuration(268L).start();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // defpackage.ua, androidx.activity.a, android.app.Activity
    public final void onBackPressed() {
        if (C(this.E) || C(this.F)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id != v51.confirm_button) {
                if (id == v51.confirm_pick_button) {
                    D();
                    na1 na1Var = (na1) ((na1) a.e(this.B).l().O(this.O).c()).p(this.M, this.N);
                    na1Var.K(new pv1(this, 2), na1Var);
                    return;
                }
                return;
            }
            if (this.D != null) {
                D();
                int currentItem = this.D.getCurrentItem();
                if (currentItem < 3) {
                    na1 na1Var2 = (na1) ((na1) a.e(this.B).l().Q(Integer.valueOf(currentItem == 2 ? q61.wallpaper_default_3 : q61.wallpaper_default_1)).c()).p(this.M, this.N);
                    na1Var2.K(new pv1(this, 0), na1Var2);
                } else {
                    na1 na1Var3 = (na1) ((na1) a.e(this.B).l().R(((qv1) this.P.get(currentItem - 3)).a).c()).p(this.M, this.N);
                    na1Var3.K(new pv1(this, 1), na1Var3);
                }
            }
        }
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.wallpaper_activity);
        z(findViewById(v51.root_layout), true);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            if (ar1.o) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            this.M = Math.min(point.x, point.y);
            this.N = Math.max(point.x, point.y);
        }
        Context applicationContext = getApplicationContext();
        this.B = applicationContext;
        this.C = new bo1(applicationContext);
        this.T = WallpaperManager.getInstance(this.B);
        this.Q = (RealTimeBlurView) findViewById(v51.blurring_view);
        this.H = (AppCompatImageView) findViewById(v51.progress);
        this.E = (ConstraintLayout) findViewById(v51.wallpaper_preview);
        this.F = (ConstraintLayout) findViewById(v51.wallpaper_pick_preview);
        this.I = (AppCompatImageView) findViewById(v51.image_pick_view);
        this.D = (ViewPager) findViewById(v51.view_pager);
        TextViewCustomFont textViewCustomFont = (TextViewCustomFont) findViewById(v51.confirm_button);
        TextViewCustomFont textViewCustomFont2 = (TextViewCustomFont) findViewById(v51.confirm_pick_button);
        this.G = (LinearLayout) findViewById(v51.progress_layout);
        this.J = AnimationUtils.loadAnimation(this, g41.ios_spinner_rotate);
        co0 co0Var = new co0(this);
        this.K = co0Var;
        this.D.setAdapter(co0Var);
        textViewCustomFont.setOnClickListener(this);
        textViewCustomFont2.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(v51.grid_wallpaper);
        recyclerView.setNestedScrollingEnabled(false);
        OverScrollLayout overScrollLayout = (OverScrollLayout) findViewById(v51.overscroll_layout);
        overScrollLayout.setOnOverScrollFinishListener(this);
        this.Q.setBlurredView(overScrollLayout);
        recyclerView.l(new hb(this, 4));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(3);
        recyclerView.setLayoutManager(gridLayoutManager);
        b8 b8Var = new b8();
        b8Var.k = new ArrayList();
        b8Var.l = this;
        b8Var.m = LayoutInflater.from(this);
        this.L = b8Var;
        b8Var.n = this;
        recyclerView.setAdapter(b8Var);
        gridLayoutManager.K = new c8(this, gridLayoutManager, 1);
        recyclerView.k(new k7(getResources().getDimensionPixelSize(e51.column_spacing), 1));
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        boolean z = ar1.j;
        m6 m6Var = this.U;
        if (z) {
            registerReceiver(m6Var, intentFilter, 2);
        } else {
            registerReceiver(m6Var, intentFilter);
        }
        int i = Build.VERSION.SDK_INT;
        Handler handler = this.R;
        mv1 mv1Var = this.S;
        if (i >= 33) {
            handler.postDelayed(mv1Var, 500L);
            return;
        }
        if (!e42.h(this)) {
            e42.p(this);
        }
        if (e42.h(this)) {
            handler.postDelayed(mv1Var, 500L);
        }
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onDestroy() {
        m6 m6Var = this.U;
        if (m6Var != null) {
            unregisterReceiver(m6Var);
        }
        super.onDestroy();
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
                if (((Integer) map.get("android.permission.READ_EXTERNAL_STORAGE")).intValue() == 0 && ((Integer) map.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() == 0) {
                    this.R.postDelayed(this.S, 500L);
                } else {
                    Toast.makeText(this, w61.required_storage_permission, 1).show();
                }
            } catch (Throwable unused) {
                Toast.makeText(this, w61.required_storage_permission, 1).show();
            }
        }
    }
}
