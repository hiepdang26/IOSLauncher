package defpackage;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class d12 implements py0 {
    public final ha0 g;
    public final int h;
    public final b6 i;
    public final long j;
    public final long k;

    public d12(ha0 ha0Var, int i, b6 b6Var, long j, long j2) {
        this.g = ha0Var;
        this.h = i;
        this.i = b6Var;
        this.j = j;
        this.k = j2;
    }

    public static am a(v02 v02Var, eb ebVar, int i) {
        am telemetryConfiguration = ebVar.getTelemetryConfiguration();
        if (telemetryConfiguration != null && telemetryConfiguration.h) {
            int i2 = 0;
            int[] iArr = telemetryConfiguration.j;
            if (iArr == null) {
                int[] iArr2 = telemetryConfiguration.l;
                if (iArr2 != null) {
                    while (i2 < iArr2.length) {
                        if (iArr2[i2] == i) {
                            return null;
                        }
                        i2++;
                    }
                }
            } else {
                while (i2 < iArr.length) {
                    if (iArr[i2] != i) {
                        i2++;
                    }
                }
            }
            if (v02Var.r < telemetryConfiguration.k) {
                return telemetryConfiguration;
            }
        }
        return null;
    }

    @Override // defpackage.py0
    public final void onComplete(pm1 pm1Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        long jCurrentTimeMillis;
        int iElapsedRealtime;
        if (this.g.b()) {
            nc1 nc1Var = (nc1) mc1.r().h;
            if (nc1Var == null || nc1Var.h) {
                v02 v02Var = (v02) this.g.p.get(this.i);
                if (v02Var != null) {
                    Object obj = v02Var.h;
                    if (obj instanceof eb) {
                        eb ebVar = (eb) obj;
                        boolean z = this.j > 0;
                        int gCoreServiceId = ebVar.getGCoreServiceId();
                        if (nc1Var != null) {
                            z &= nc1Var.i;
                            int i6 = nc1Var.j;
                            int i7 = nc1Var.k;
                            i = nc1Var.g;
                            if (ebVar.hasConnectionInfo() && !ebVar.isConnecting()) {
                                am amVarA = a(v02Var, ebVar, this.h);
                                if (amVarA == null) {
                                    return;
                                }
                                boolean z2 = amVarA.i && this.j > 0;
                                i7 = amVarA.k;
                                z = z2;
                            }
                            i2 = i6;
                            i3 = i7;
                        } else {
                            i = 0;
                            i2 = 5000;
                            i3 = 100;
                        }
                        ha0 ha0Var = this.g;
                        if (pm1Var.d()) {
                            i4 = 0;
                            i5 = 0;
                        } else {
                            if (((od2) pm1Var).d) {
                                i4 = 100;
                            } else {
                                Exception excA = pm1Var.a();
                                if (excA instanceof v5) {
                                    Status status = ((v5) excA).g;
                                    int i8 = status.g;
                                    vl vlVar = status.j;
                                    i5 = vlVar == null ? -1 : vlVar.h;
                                    i4 = i8;
                                } else {
                                    i4 = 101;
                                }
                            }
                            i5 = -1;
                        }
                        if (z) {
                            long j2 = this.j;
                            jCurrentTimeMillis = System.currentTimeMillis();
                            j = j2;
                            iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.k);
                        } else {
                            j = 0;
                            jCurrentTimeMillis = 0;
                            iElapsedRealtime = -1;
                        }
                        eu0 eu0Var = new eu0(this.h, i4, i5, j, jCurrentTimeMillis, null, null, gCoreServiceId, iElapsedRealtime);
                        long j3 = i2;
                        t12 t12Var = ha0Var.t;
                        t12Var.sendMessage(t12Var.obtainMessage(18, new e12(eu0Var, i, j3, i3)));
                    }
                }
            }
        }
    }
}
