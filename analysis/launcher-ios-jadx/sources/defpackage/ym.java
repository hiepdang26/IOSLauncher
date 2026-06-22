package defpackage;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ym {
    public int[] a;
    public int[] b;
    public int c;
    public int[] d;
    public float[] e;
    public int f;
    public int[] g;
    public String[] h;
    public int i;
    public int[] j;
    public boolean[] k;
    public int l;

    public final void a(float f, int i) {
        int i2 = this.f;
        int[] iArr = this.d;
        if (i2 >= iArr.length) {
            this.d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.e;
            this.e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.d;
        int i3 = this.f;
        iArr2[i3] = i;
        float[] fArr2 = this.e;
        this.f = i3 + 1;
        fArr2[i3] = f;
    }

    public final void b(int i, int i2) {
        int i3 = this.c;
        int[] iArr = this.a;
        if (i3 >= iArr.length) {
            this.a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.b;
            this.b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.a;
        int i4 = this.c;
        iArr3[i4] = i;
        int[] iArr4 = this.b;
        this.c = i4 + 1;
        iArr4[i4] = i2;
    }

    public final void c(int i, String str) {
        int i2 = this.i;
        int[] iArr = this.g;
        if (i2 >= iArr.length) {
            this.g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.h;
            this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.g;
        int i3 = this.i;
        iArr2[i3] = i;
        String[] strArr2 = this.h;
        this.i = i3 + 1;
        strArr2[i3] = str;
    }

    public final void d(int i, boolean z) {
        int i2 = this.l;
        int[] iArr = this.j;
        if (i2 >= iArr.length) {
            this.j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.k;
            this.k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.j;
        int i3 = this.l;
        iArr2[i3] = i;
        boolean[] zArr2 = this.k;
        this.l = i3 + 1;
        zArr2[i3] = z;
    }

    public final void e(zm zmVar) {
        for (int i = 0; i < this.c; i++) {
            int i2 = this.a[i];
            int i3 = this.b[i];
            if (i2 == 6) {
                zmVar.e.D = i3;
            } else if (i2 == 7) {
                zmVar.e.E = i3;
            } else if (i2 == 8) {
                zmVar.e.K = i3;
            } else if (i2 == 27) {
                zmVar.e.F = i3;
            } else if (i2 == 28) {
                zmVar.e.H = i3;
            } else if (i2 == 41) {
                zmVar.e.W = i3;
            } else if (i2 == 42) {
                zmVar.e.X = i3;
            } else if (i2 == 61) {
                zmVar.e.A = i3;
            } else if (i2 == 62) {
                zmVar.e.B = i3;
            } else if (i2 == 72) {
                zmVar.e.g0 = i3;
            } else if (i2 == 73) {
                zmVar.e.h0 = i3;
            } else if (i2 == 88) {
                zmVar.d.l = i3;
            } else if (i2 == 89) {
                zmVar.d.m = i3;
            } else if (i2 == 2) {
                zmVar.e.J = i3;
            } else if (i2 == 31) {
                zmVar.e.L = i3;
            } else if (i2 == 34) {
                zmVar.e.I = i3;
            } else if (i2 == 38) {
                zmVar.a = i3;
            } else if (i2 == 64) {
                zmVar.d.b = i3;
            } else if (i2 == 66) {
                zmVar.d.f = i3;
            } else if (i2 == 76) {
                zmVar.d.e = i3;
            } else if (i2 == 78) {
                zmVar.c.c = i3;
            } else if (i2 == 97) {
                zmVar.e.p0 = i3;
            } else if (i2 == 93) {
                zmVar.e.M = i3;
            } else if (i2 != 94) {
                switch (i2) {
                    case 11:
                        zmVar.e.Q = i3;
                        break;
                    case 12:
                        zmVar.e.R = i3;
                        break;
                    case 13:
                        zmVar.e.N = i3;
                        break;
                    case 14:
                        zmVar.e.P = i3;
                        break;
                    case 15:
                        zmVar.e.S = i3;
                        break;
                    case 16:
                        zmVar.e.O = i3;
                        break;
                    case 17:
                        zmVar.e.e = i3;
                        break;
                    case 18:
                        zmVar.e.f = i3;
                        break;
                    default:
                        switch (i2) {
                            case zzbbc.zzt.zzm /* 21 */:
                                zmVar.e.d = i3;
                                break;
                            case 22:
                                zmVar.c.b = i3;
                                break;
                            case 23:
                                zmVar.e.c = i3;
                                break;
                            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                                zmVar.e.G = i3;
                                break;
                            default:
                                switch (i2) {
                                    case 54:
                                        zmVar.e.Y = i3;
                                        break;
                                    case 55:
                                        zmVar.e.Z = i3;
                                        break;
                                    case 56:
                                        zmVar.e.a0 = i3;
                                        break;
                                    case 57:
                                        zmVar.e.b0 = i3;
                                        break;
                                    case 58:
                                        zmVar.e.c0 = i3;
                                        break;
                                    case 59:
                                        zmVar.e.d0 = i3;
                                        break;
                                    default:
                                        switch (i2) {
                                            case 82:
                                                zmVar.d.c = i3;
                                                break;
                                            case 83:
                                                zmVar.f.i = i3;
                                                break;
                                            case 84:
                                                zmVar.d.j = i3;
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                zmVar.e.T = i3;
            }
        }
        for (int i4 = 0; i4 < this.f; i4++) {
            int i5 = this.d[i4];
            float f = this.e[i4];
            if (i5 == 19) {
                zmVar.e.g = f;
            } else if (i5 == 20) {
                zmVar.e.x = f;
            } else if (i5 == 37) {
                zmVar.e.y = f;
            } else if (i5 == 60) {
                zmVar.f.b = f;
            } else if (i5 == 63) {
                zmVar.e.C = f;
            } else if (i5 == 79) {
                zmVar.d.g = f;
            } else if (i5 == 85) {
                zmVar.d.i = f;
            } else if (i5 == 39) {
                zmVar.e.V = f;
            } else if (i5 != 40) {
                switch (i5) {
                    case 43:
                        zmVar.c.d = f;
                        break;
                    case 44:
                        dn dnVar = zmVar.f;
                        dnVar.n = f;
                        dnVar.m = true;
                        break;
                    case 45:
                        zmVar.f.c = f;
                        break;
                    case 46:
                        zmVar.f.d = f;
                        break;
                    case 47:
                        zmVar.f.e = f;
                        break;
                    case 48:
                        zmVar.f.f = f;
                        break;
                    case 49:
                        zmVar.f.g = f;
                        break;
                    case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                        zmVar.f.h = f;
                        break;
                    case 51:
                        zmVar.f.j = f;
                        break;
                    case 52:
                        zmVar.f.k = f;
                        break;
                    case 53:
                        zmVar.f.l = f;
                        break;
                    default:
                        switch (i5) {
                            case 67:
                                zmVar.d.h = f;
                                break;
                            case 68:
                                zmVar.c.e = f;
                                break;
                            case 69:
                                zmVar.e.e0 = f;
                                break;
                            case 70:
                                zmVar.e.f0 = f;
                                break;
                        }
                        break;
                }
            } else {
                zmVar.e.U = f;
            }
        }
        for (int i6 = 0; i6 < this.i; i6++) {
            int i7 = this.g[i6];
            String str = this.h[i6];
            if (i7 == 5) {
                zmVar.e.z = str;
            } else if (i7 == 65) {
                zmVar.d.d = str;
            } else if (i7 == 74) {
                an anVar = zmVar.e;
                anVar.k0 = str;
                anVar.j0 = null;
            } else if (i7 == 77) {
                zmVar.e.l0 = str;
            } else if (i7 == 90) {
                zmVar.d.k = str;
            }
        }
        for (int i8 = 0; i8 < this.l; i8++) {
            int i9 = this.j[i8];
            boolean z = this.k[i8];
            if (i9 == 44) {
                zmVar.f.m = z;
            } else if (i9 == 75) {
                zmVar.e.o0 = z;
            } else if (i9 == 80) {
                zmVar.e.m0 = z;
            } else if (i9 == 81) {
                zmVar.e.n0 = z;
            }
        }
    }
}
