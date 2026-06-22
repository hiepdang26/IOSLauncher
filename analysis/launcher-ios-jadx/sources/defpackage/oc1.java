package defpackage;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes.dex */
public final class oc1 implements SensorEventListener {
    public so0 a;
    public SensorManager b;
    public Sensor c;
    public float[] d;
    public boolean e;

    public final void a() {
        if (this.e) {
            return;
        }
        this.b.registerListener(this, this.c, 16666);
        this.e = true;
    }

    public final void b() {
        if (this.e) {
            this.b.unregisterListener(this);
            this.e = false;
            this.d = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = new float[9];
        SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
        float[] fArr2 = this.d;
        if (fArr2 == null) {
            this.d = fArr;
            return;
        }
        float[] fArr3 = new float[3];
        SensorManager.getAngleChange(fArr3, fArr, fArr2);
        so0 so0Var = this.a;
        if (so0Var.r.getResources().getConfiguration().orientation == 2) {
            so0Var.m.setOrientationAngle(fArr3[1], fArr3[2]);
        } else {
            so0Var.m.setOrientationAngle(-fArr3[2], fArr3[1]);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
