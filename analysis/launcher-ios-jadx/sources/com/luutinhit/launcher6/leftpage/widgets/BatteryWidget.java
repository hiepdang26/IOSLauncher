package com.luutinhit.launcher6.leftpage.widgets;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.t;
import defpackage.ac;
import defpackage.ar1;
import defpackage.cw;
import defpackage.e51;
import defpackage.l51;
import defpackage.m61;
import defpackage.nm;
import defpackage.o1;
import defpackage.q91;
import defpackage.uo;
import defpackage.v51;
import defpackage.vg1;
import defpackage.vm;
import defpackage.x41;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BatteryWidget extends vm {
    public static final /* synthetic */ int t = 0;
    public final Context k;
    public final View l;
    public final RecyclerView m;
    public final q91 n;
    public ArrayList o;
    public cw p;
    public final Handler q;
    public final o1 r;
    public final int s;

    public BatteryWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new ArrayList();
        this.q = new Handler();
        this.r = new o1(this, 6);
        this.k = context;
        this.s = (int) (((double) ((t) context).getDeviceProfile().C) * 0.8d);
        View viewInflate = LayoutInflater.from(context).inflate(m61.battery_widget, (ViewGroup) this, true);
        this.l = viewInflate;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(v51.list_devices);
        this.m = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView2 = this.m;
        vg1 vg1Var = new vg1();
        vg1Var.g = context.getResources().getDrawable(l51.divider);
        vg1Var.h = ar1.v(context.getResources());
        vg1Var.i = context.getResources().getDimensionPixelSize(e51.divider_margin);
        recyclerView2.k(vg1Var);
        boolean zO = o();
        q91 q91Var = new q91();
        q91Var.k = zO;
        this.n = q91Var;
        this.m.setAdapter(q91Var);
    }

    private List<ac> getBatteries() {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.clear();
        ac currentPhoneItem = getCurrentPhoneItem();
        if (currentPhoneItem != null) {
            this.o.add(currentPhoneItem);
        }
        if (ar1.p) {
            Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
            bondedDevices.size();
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                if (bluetoothDevice != null && bluetoothDevice.getName() != null) {
                    bluetoothDevice.getName();
                    x(bluetoothDevice);
                    ac acVar = new ac();
                    acVar.a = this.k.getDrawable(l51.ic_bluetooth);
                    acVar.b = bluetoothDevice.getName();
                    int iX = x(bluetoothDevice);
                    if (iX >= 0) {
                        acVar.c = uo.h(String.valueOf(iX), "%");
                        acVar.d = y(iX, false);
                        this.o.add(acVar);
                    }
                }
            }
        }
        this.o.size();
        return this.o;
    }

    private ac getCurrentPhoneItem() {
        try {
            ac acVar = new ac();
            acVar.a = this.k.getDrawable(l51.ic_phone);
            acVar.b = "iPhone";
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            Intent intentRegisterReceiver = ar1.j ? this.k.registerReceiver(null, intentFilter, 2) : this.k.registerReceiver(null, intentFilter);
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
            boolean z = intExtra == 2 || intExtra == 5;
            int intExtra2 = (int) (((intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1) / (intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1)) * 100.0f);
            acVar.c = intExtra2 + "%";
            acVar.d = y(intExtra2, z);
            return acVar;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static /* synthetic */ List w(BatteryWidget batteryWidget) {
        Thread.currentThread().getName();
        return batteryWidget.getBatteries();
    }

    public static int x(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("getBatteryLevel", null);
            method.setAccessible(true);
            return ((Integer) method.invoke(bluetoothDevice, null)).intValue();
        } catch (Throwable unused) {
            return 100;
        }
    }

    @Override // defpackage.dm0
    public final void l() {
        cw cwVar = this.p;
        if (cwVar != null) {
            cwVar.b();
        }
    }

    @Override // defpackage.dm0
    public final void n() {
        Handler handler = this.q;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.r, 2000L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(v51.icon_delete_widget);
        int i = -((t) this.k).getDeviceProfile().A;
        viewFindViewById.setTranslationX(((t) this.k).isRTL ? -i : i);
        viewFindViewById.setTranslationY(i);
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(v51.battery_widget_content);
        nm nmVar = (nm) linearLayoutRound.getLayoutParams();
        int i2 = this.s;
        nmVar.setMargins(i2, i2, i2, i2);
        linearLayoutRound.setDarkModeBackgroundColor(o() ? getResources().getColor(x41.folder_color_dark) : getResources().getColor(x41.folder_color));
        Handler handler = this.q;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.r, 2000L);
    }

    public final Drawable y(int i, boolean z) {
        if (z) {
            if (i <= 5) {
                return this.k.getDrawable(l51.ic_battery_charging_0);
            }
            if (i <= 10) {
                return this.k.getDrawable(l51.ic_battery_charging_10);
            }
            if (i <= 20) {
                return this.k.getDrawable(l51.ic_battery_charging_20);
            }
            if (i <= 30) {
                return this.k.getDrawable(l51.ic_battery_charging_30);
            }
            if (i <= 40) {
                return this.k.getDrawable(l51.ic_battery_charging_40);
            }
            if (i <= 50) {
                return this.k.getDrawable(l51.ic_battery_charging_50);
            }
            if (i <= 60) {
                return this.k.getDrawable(l51.ic_battery_charging_60);
            }
            if (i <= 70) {
                return this.k.getDrawable(l51.ic_battery_charging_70);
            }
            if (i <= 80) {
                return this.k.getDrawable(l51.ic_battery_charging_80);
            }
            if (i <= 90) {
                return this.k.getDrawable(l51.ic_battery_charging_90);
            }
            if (i <= 100) {
                return this.k.getDrawable(l51.ic_battery_charging_100);
            }
        } else {
            if (i <= 5) {
                return this.k.getDrawable(l51.ic_battery_0);
            }
            if (i <= 10) {
                return this.k.getDrawable(l51.ic_battery_10);
            }
            if (i <= 20) {
                return this.k.getDrawable(l51.ic_battery_20);
            }
            if (i <= 30) {
                return this.k.getDrawable(l51.ic_battery_30);
            }
            if (i <= 40) {
                return this.k.getDrawable(l51.ic_battery_40);
            }
            if (i <= 50) {
                return this.k.getDrawable(l51.ic_battery_50);
            }
            if (i <= 60) {
                return this.k.getDrawable(l51.ic_battery_60);
            }
            if (i <= 70) {
                return this.k.getDrawable(l51.ic_battery_70);
            }
            if (i <= 80) {
                return this.k.getDrawable(l51.ic_battery_80);
            }
            if (i <= 90) {
                return this.k.getDrawable(l51.ic_battery_90);
            }
            if (i <= 100) {
                return this.k.getDrawable(l51.ic_battery_100);
            }
        }
        return this.k.getDrawable(l51.ic_battery_100);
    }
}
