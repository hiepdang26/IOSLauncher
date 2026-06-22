package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public final class qp implements Parcelable {
    public static final Parcelable.Creator<qp> CREATOR = new z1(5);
    public int A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public CharSequence K;
    public int L;
    public Uri M;
    public Bitmap.CompressFormat N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public Rect S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public boolean Y;
    public boolean Z;
    public CharSequence a0;
    public int b0;
    public int c0;
    public rp g;
    public float h;
    public float i;
    public float j;
    public sp k;
    public yp l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public float r;
    public boolean s;
    public int t;
    public int u;
    public float v;
    public int w;
    public float x;
    public float y;
    public float z;

    public qp() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.g = rp.g;
        this.h = 0.23f;
        this.i = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.j = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.k = sp.g;
        this.l = yp.g;
        this.m = true;
        this.n = true;
        this.o = true;
        this.p = false;
        this.q = 4;
        this.r = 0.1f;
        this.s = false;
        this.t = 1;
        this.u = 1;
        this.v = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.w = Color.argb(170, 255, 255, 255);
        this.x = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.y = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        this.z = TypedValue.applyDimension(1, 14.0f, displayMetrics);
        this.A = -1;
        this.B = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.C = Color.argb(170, 255, 255, 255);
        this.D = Color.argb(119, 0, 0, 0);
        this.E = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.F = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.G = 40;
        this.H = 40;
        this.I = 99999;
        this.J = 99999;
        this.K = "";
        this.L = 0;
        this.M = Uri.EMPTY;
        this.N = Bitmap.CompressFormat.JPEG;
        this.O = 90;
        this.P = 0;
        this.Q = 0;
        this.c0 = 1;
        this.R = false;
        this.S = null;
        this.T = -1;
        this.U = true;
        this.V = true;
        this.W = false;
        this.X = 90;
        this.Y = false;
        this.Z = false;
        this.a0 = null;
        this.b0 = 0;
    }

    public final void a() {
        if (this.q < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        }
        if (this.j < 0.0f) {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        }
        float f = this.r;
        if (f < 0.0f || f >= 0.5d) {
            throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
        }
        if (this.t <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.u <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.v < 0.0f) {
            throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
        }
        if (this.x < 0.0f) {
            throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
        }
        if (this.B < 0.0f) {
            throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
        }
        if (this.F < 0) {
            throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
        }
        int i = this.G;
        if (i < 0) {
            throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
        }
        int i2 = this.H;
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
        }
        if (this.I < i) {
            throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
        }
        if (this.J < i2) {
            throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
        }
        if (this.P < 0) {
            throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
        }
        if (this.Q < 0) {
            throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
        }
        int i3 = this.X;
        if (i3 < 0 || i3 > 360) {
            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g.ordinal());
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.i);
        parcel.writeFloat(this.j);
        parcel.writeInt(this.k.ordinal());
        parcel.writeInt(this.l.ordinal());
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.p ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.q);
        parcel.writeFloat(this.r);
        parcel.writeByte(this.s ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeFloat(this.v);
        parcel.writeInt(this.w);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.z);
        parcel.writeInt(this.A);
        parcel.writeFloat(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        TextUtils.writeToParcel(this.K, parcel, i);
        parcel.writeInt(this.L);
        parcel.writeParcelable(this.M, i);
        parcel.writeString(this.N.name());
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        parcel.writeInt(uo.v(this.c0));
        parcel.writeInt(this.R ? 1 : 0);
        parcel.writeParcelable(this.S, i);
        parcel.writeInt(this.T);
        parcel.writeByte(this.U ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.V ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.W ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.X);
        parcel.writeByte(this.Y ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Z ? (byte) 1 : (byte) 0);
        TextUtils.writeToParcel(this.a0, parcel, i);
        parcel.writeInt(this.b0);
    }
}
