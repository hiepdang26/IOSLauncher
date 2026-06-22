package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;
import com.luutinhit.wallpaper.livewallpaper.LiveWallpaperRenderer;
import com.luutinhit.wallpaper.livewallpaper.LiveWallpaperService;

/* JADX INFO: loaded from: classes.dex */
public final class so0 extends WallpaperService.Engine implements po0, SharedPreferences.OnSharedPreferenceChangeListener {
    public b80 g;
    public wa h;
    public ws i;
    public gu j;
    public int k;
    public SharedPreferences l;
    public LiveWallpaperRenderer m;
    public oc1 n;
    public ro0 o;
    public boolean p;
    public boolean q;
    public final /* synthetic */ LiveWallpaperService r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public so0(LiveWallpaperService liveWallpaperService) {
        super(liveWallpaperService);
        this.r = liveWallpaperService;
        this.p = false;
        this.q = false;
    }

    public final void a() {
        super.onDestroy();
        b80 b80Var = this.g;
        synchronized (b80Var.g) {
            b80Var.i = true;
            b80Var.g.notifyAll();
        }
        try {
            b80Var.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void b() {
        b80 b80Var = this.g;
        synchronized (b80Var.g) {
            b80Var.u = true;
            b80Var.g.notifyAll();
        }
    }

    public final void c(boolean z) {
        if (this.p == z) {
            return;
        }
        this.p = z;
        LiveWallpaperService liveWallpaperService = this.r;
        PowerManager powerManager = (PowerManager) liveWallpaperService.getSystemService("power");
        if (!this.p) {
            liveWallpaperService.unregisterReceiver(this.o);
            boolean zIsPowerSaveMode = powerManager.isPowerSaveMode();
            this.q = zIsPowerSaveMode;
            if (zIsPowerSaveMode && isVisible()) {
                this.n.a();
                return;
            }
            return;
        }
        this.o = new ro0(this, powerManager);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        if (ar1.j) {
            liveWallpaperService.registerReceiver(this.o, intentFilter, 2);
        } else {
            liveWallpaperService.registerReceiver(this.o, intentFilter);
        }
        boolean zIsPowerSaveMode2 = powerManager.isPowerSaveMode();
        this.q = zIsPowerSaveMode2;
        if (zIsPowerSaveMode2 && isVisible()) {
            this.n.b();
            this.m.setOrientationAngle(0.0f, 0.0f);
        }
    }

    @jk1
    public void handleSomethingElse(String str) {
        boolean zEqualsIgnoreCase = str.equalsIgnoreCase("OPEN_ANIM");
        int i = this.r.g;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt((zEqualsIgnoreCase ? 0 : 20) + i, i + (zEqualsIgnoreCase ? 20 : 0));
        valueAnimatorOfInt.setDuration(368L);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new qo0(this, 0));
        valueAnimatorOfInt.start();
    }

    @Override // android.service.wallpaper.WallpaperService.Engine
    public final void onCreate(SurfaceHolder surfaceHolder) {
        super.onCreate(surfaceHolder);
        r00.b().i(this);
        if (this.g != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
        this.k = 2;
        wa waVar = new wa(8, 8, 8, 0, 2);
        if (this.g != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
        this.h = waVar;
        LiveWallpaperRenderer liveWallpaperRenderer = new LiveWallpaperRenderer(this.r.getApplicationContext(), this);
        this.m = liveWallpaperRenderer;
        if (this.g != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
        if (this.h == null) {
            xa xaVar = new xa(4, 4, 4, 16, this.k);
            xaVar.b = 5;
            xaVar.c = 6;
            xaVar.d = 5;
            this.h = xaVar;
        }
        if (this.i == null) {
            int i = this.k;
            ws wsVar = new ws();
            wsVar.a = i;
            this.i = wsVar;
        }
        if (this.j == null) {
            this.j = new gu();
        }
        b80 b80Var = new b80(liveWallpaperRenderer, this.h, this.i, this.j);
        this.g = b80Var;
        b80Var.start();
        b80 b80Var2 = this.g;
        b80Var2.getClass();
        synchronized (b80Var2.g) {
            b80Var2.t = 0;
        }
        Context applicationContext = this.r.getApplicationContext();
        oc1 oc1Var = new oc1();
        oc1Var.e = false;
        oc1Var.a = this;
        SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
        oc1Var.b = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        oc1Var.c = defaultSensor;
        if (defaultSensor == null) {
            Toast.makeText(applicationContext, applicationContext.getText(w61.toast_sensor_error), 1).show();
        }
        this.n = oc1Var;
        LiveWallpaperService liveWallpaperService = this.r;
        SharedPreferences sharedPreferences = liveWallpaperService.getSharedPreferences(e31.b(liveWallpaperService), 0);
        this.l = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.r.g = this.l.getInt("range", 10);
        this.m.setBiasRange(this.r.g);
        this.m.setDelay(21 - this.l.getInt("deny", 10));
        this.m.setScrollMode(this.l.getBoolean("scroll", false));
        this.m.setIsDefaultWallpaper(this.l.getInt("default_picture", 0) == 0);
        c(this.l.getBoolean("power_saver", true));
    }

    @Override // android.service.wallpaper.WallpaperService.Engine
    public final void onDestroy() {
        try {
            r00.b().k(this);
            try {
                SharedPreferences sharedPreferences = this.l;
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putBoolean("parallax_zoom_animations", false);
                    editorEdit.apply();
                }
            } catch (Throwable th) {
                th.getMessage();
            }
            try {
                oc1 oc1Var = this.n;
                if (oc1Var != null) {
                    oc1Var.b();
                }
                ro0 ro0Var = this.o;
                if (ro0Var != null) {
                    this.r.unregisterReceiver(ro0Var);
                }
            } catch (Throwable th2) {
                th2.getMessage();
            }
            this.l.unregisterOnSharedPreferenceChangeListener(this);
            LiveWallpaperRenderer liveWallpaperRenderer = this.m;
            if (liveWallpaperRenderer != null) {
                liveWallpaperRenderer.release();
            }
            a();
        } catch (Throwable th3) {
            th3.getMessage();
        }
    }

    @Override // android.service.wallpaper.WallpaperService.Engine
    public final void onOffsetsChanged(float f, float f2, float f3, float f4, int i, int i2) {
        if (isPreview()) {
            return;
        }
        this.m.setOffset(f, f2);
        this.m.setOffsetStep(f3, f4);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.getClass();
        switch (str) {
            case "scroll":
                this.m.setScrollMode(sharedPreferences.getBoolean(str, false));
                break;
            case "default_picture":
                this.m.setIsDefaultWallpaper(sharedPreferences.getInt(str, 0) == 0);
                break;
            case "delay":
                this.m.setDelay(21 - sharedPreferences.getInt(str, 10));
                break;
            case "range":
                int i = sharedPreferences.getInt(str, 10);
                LiveWallpaperService liveWallpaperService = this.r;
                liveWallpaperService.g = i;
                this.m.setBiasRange(liveWallpaperService.g);
                break;
            case "power_saver":
                c(sharedPreferences.getBoolean(str, true));
                break;
        }
    }

    @Override // android.service.wallpaper.WallpaperService.Engine
    public final void onSurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        b80 b80Var = this.g;
        synchronized (b80Var.g) {
            b80Var.r = i2;
            b80Var.s = i3;
            b80Var.n = true;
            b80Var.g.notifyAll();
        }
        super.onSurfaceChanged(surfaceHolder, i, i2, i3);
    }

    @Override // android.service.wallpaper.WallpaperService.Engine
    public final void onSurfaceCreated(SurfaceHolder surfaceHolder) {
        b80 b80Var = this.g;
        b80Var.h = surfaceHolder;
        synchronized (b80Var.g) {
            b80Var.o = true;
            b80Var.g.notifyAll();
        }
        super.onSurfaceCreated(surfaceHolder);
    }

    @Override // android.service.wallpaper.WallpaperService.Engine
    public final void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
        b80 b80Var = this.g;
        synchronized (b80Var.g) {
            b80Var.o = false;
            b80Var.g.notifyAll();
            while (!b80Var.p && b80Var.isAlive() && !b80Var.i) {
                try {
                    b80Var.g.wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        super.onSurfaceDestroyed(surfaceHolder);
    }

    @Override // android.service.wallpaper.WallpaperService.Engine
    public final void onVisibilityChanged(boolean z) {
        if (this.p && this.q) {
            if (z) {
                this.m.startTransition();
                return;
            } else {
                this.m.stopTransition();
                return;
            }
        }
        if (z) {
            this.n.a();
            this.m.startTransition();
        } else {
            this.n.b();
            this.m.stopTransition();
        }
    }
}
