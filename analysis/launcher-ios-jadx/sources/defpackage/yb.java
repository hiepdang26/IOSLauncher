package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class yb extends yd {
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ yb(Context context, qm0 qm0Var, int i) {
        super(context, qm0Var);
        this.g = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    @Override // defpackage.fn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a() {
        /*
            r8 = this;
            r0 = -1
            java.lang.String r1 = "status"
            java.lang.String r2 = "android.intent.action.BATTERY_CHANGED"
            r3 = 0
            r4 = 1
            r5 = 0
            android.content.Context r6 = r8.b
            int r7 = r8.g
            switch(r7) {
                case 0: goto L84;
                case 1: goto L4b;
                default: goto Lf;
            }
        Lf:
            android.content.IntentFilter r0 = r8.e()
            android.content.Intent r0 = r6.registerReceiver(r5, r0)
            if (r0 == 0) goto L3e
            java.lang.String r1 = r0.getAction()
            if (r1 != 0) goto L20
            goto L3e
        L20:
            java.lang.String r0 = r0.getAction()
            if (r0 == 0) goto L46
            int r1 = r0.hashCode()
            r2 = -1181163412(0xffffffffb998e06c, float:-2.9158907E-4)
            if (r1 == r2) goto L40
            r2 = -730838620(0xffffffffd47049a4, float:-4.1281105E12)
            if (r1 == r2) goto L35
            goto L46
        L35:
            java.lang.String r1 = "android.intent.action.DEVICE_STORAGE_OK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3e
            goto L46
        L3e:
            r3 = 1
            goto L46
        L40:
            java.lang.String r1 = "android.intent.action.DEVICE_STORAGE_LOW"
            boolean r0 = r0.equals(r1)
        L46:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            return r0
        L4b:
            android.content.IntentFilter r7 = new android.content.IntentFilter
            r7.<init>(r2)
            android.content.Intent r2 = r6.registerReceiver(r5, r7)
            if (r2 != 0) goto L62
            ka0 r0 = defpackage.ka0.j()
            int r1 = defpackage.bc.a
            r0.getClass()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L83
        L62:
            int r1 = r2.getIntExtra(r1, r0)
            java.lang.String r5 = "level"
            int r5 = r2.getIntExtra(r5, r0)
            java.lang.String r6 = "scale"
            int r0 = r2.getIntExtra(r6, r0)
            float r2 = (float) r5
            float r0 = (float) r0
            float r2 = r2 / r0
            if (r1 == r4) goto L7e
            r0 = 1041865114(0x3e19999a, float:0.15)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L7f
        L7e:
            r3 = 1
        L7f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
        L83:
            return r0
        L84:
            android.content.IntentFilter r7 = new android.content.IntentFilter
            r7.<init>(r2)
            android.content.Intent r2 = r6.registerReceiver(r5, r7)
            if (r2 != 0) goto L9b
            ka0 r0 = defpackage.ka0.j()
            int r1 = defpackage.zb.a
            r0.getClass()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto Lba
        L9b:
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r5 < r6) goto Lad
            int r0 = r2.getIntExtra(r1, r0)
            r1 = 2
            if (r0 == r1) goto Lab
            r1 = 5
            if (r0 != r1) goto Lb6
        Lab:
            r3 = 1
            goto Lb6
        Lad:
            java.lang.String r0 = "plugged"
            int r0 = r2.getIntExtra(r0, r3)
            if (r0 == 0) goto Lb6
            goto Lab
        Lb6:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
        Lba:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yb.a():java.lang.Object");
    }

    @Override // defpackage.yd
    public final IntentFilter e() {
        switch (this.g) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                if (Build.VERSION.SDK_INT >= 23) {
                    intentFilter.addAction("android.os.action.CHARGING");
                    intentFilter.addAction("android.os.action.DISCHARGING");
                } else {
                    intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                    intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                }
                return intentFilter;
            case 1:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.BATTERY_OKAY");
                intentFilter2.addAction("android.intent.action.BATTERY_LOW");
                return intentFilter2;
            default:
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_OK");
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_LOW");
                return intentFilter3;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // defpackage.yd
    public final void f(Intent intent) {
        switch (this.g) {
            case 0:
                String action = intent.getAction();
                if (action != null) {
                    ka0 ka0VarJ = ka0.j();
                    int i = zb.a;
                    ka0VarJ.getClass();
                    switch (action.hashCode()) {
                        case -1886648615:
                            if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                b(Boolean.FALSE);
                                break;
                            }
                            break;
                        case -54942926:
                            if (action.equals("android.os.action.DISCHARGING")) {
                                b(Boolean.FALSE);
                                break;
                            }
                            break;
                        case 948344062:
                            if (action.equals("android.os.action.CHARGING")) {
                                b(Boolean.TRUE);
                                break;
                            }
                            break;
                        case 1019184907:
                            if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                                b(Boolean.TRUE);
                                break;
                            }
                            break;
                    }
                }
                break;
            case 1:
                if (intent.getAction() != null) {
                    ka0 ka0VarJ2 = ka0.j();
                    int i2 = bc.a;
                    intent.getAction();
                    ka0VarJ2.getClass();
                    String action2 = intent.getAction();
                    if (action2 != null) {
                        int iHashCode = action2.hashCode();
                        if (iHashCode != -1980154005) {
                            if (iHashCode == 490310653 && action2.equals("android.intent.action.BATTERY_LOW")) {
                                b(Boolean.FALSE);
                            }
                            break;
                        } else if (action2.equals("android.intent.action.BATTERY_OKAY")) {
                            b(Boolean.TRUE);
                            break;
                        }
                    }
                }
                break;
            default:
                if (intent.getAction() != null) {
                    ka0 ka0VarJ3 = ka0.j();
                    int i3 = sj1.a;
                    intent.getAction();
                    ka0VarJ3.getClass();
                    String action3 = intent.getAction();
                    if (action3 != null) {
                        int iHashCode2 = action3.hashCode();
                        if (iHashCode2 != -1181163412) {
                            if (iHashCode2 == -730838620 && action3.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                                b(Boolean.TRUE);
                            }
                            break;
                        } else if (action3.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                            b(Boolean.FALSE);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
