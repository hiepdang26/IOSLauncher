package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.cardview.widget.CardView;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.bumptech.glide.manager.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class ka0 implements mu0, vp0, wm0, zz, pv, t21, j20, z20, nb1, wa1, h20 {
    public static ka0 h;
    public static volatile ka0 l;
    public static ka0 p;
    public static ka0 q;
    public final /* synthetic */ int g;
    public static final ka0 i = new ka0(1);
    public static final ka0 j = new ka0(2);
    public static final Object k = new Object();
    public static final ka0 m = new ka0(4);
    public static final ka0 n = new ka0(5);
    public static final ka0 o = new ka0(6);

    public /* synthetic */ ka0(int i2) {
        this.g = i2;
    }

    public static ka0 j() {
        ka0 ka0Var;
        synchronized (k) {
            try {
                if (l == null) {
                    l = new ka0(3);
                }
                ka0Var = l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ka0Var;
    }

    public static void m(Context context) {
        hg0.i(context);
        synchronized (ka0.class) {
            try {
                if (h == null) {
                    ec2.a(context);
                    ka0 ka0Var = new ka0(0);
                    context.getApplicationContext();
                    h = ka0Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int o(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            return iIntValue < 500 ? 2 : 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        return iIntValue < 1000 ? 5 : 6;
    }

    public static String r(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public static final kb2 u(PackageInfo packageInfo, kb2... kb2VarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        pb2 pb2Var = new pb2(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < kb2VarArr.length; i2++) {
            if (kb2VarArr[i2].equals(pb2Var)) {
                return kb2VarArr[i2];
            }
        }
        return null;
    }

    public static final boolean v(PackageInfo packageInfo) {
        PackageInfo packageInfo2;
        boolean z;
        if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            } else {
                z = true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
            z = true;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z ? u(packageInfo2, bc2.a) : u(packageInfo2, bc2.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.z20
    public Class a() {
        return ParcelFileDescriptor.class;
    }

    @Override // defpackage.z20
    public void b(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }

    @Override // defpackage.vp0
    public void c(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(o(level), "EventBus", str);
        }
    }

    @Override // defpackage.h20
    public Object create() {
        return new rp0();
    }

    @Override // defpackage.pv
    public File e(bj0 bj0Var) {
        return null;
    }

    @Override // defpackage.zz
    public boolean f(Object obj, File file, g01 g01Var) throws Throwable {
        try {
            cf.d((ByteBuffer) obj, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }

    @Override // defpackage.wm0
    public void h(cn0 cn0Var) {
        cn0Var.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    @Override // defpackage.nb1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.eb1 l(defpackage.eb1 r5, defpackage.g01 r6) {
        /*
            r4 = this;
            java.lang.Object r5 = r5.get()
            l80 r5 = (defpackage.l80) r5
            j5 r5 = r5.g
            java.lang.Object r5 = r5.b
            r80 r5 = (defpackage.r80) r5
            wi1 r5 = r5.a
            java.nio.ByteBuffer r5 = r5.d
            java.nio.ByteBuffer r5 = r5.asReadOnlyBuffer()
            a5 r6 = new a5
            java.util.concurrent.atomic.AtomicReference r0 = defpackage.cf.a
            boolean r0 = r5.isReadOnly()
            if (r0 != 0) goto L36
            boolean r0 = r5.hasArray()
            if (r0 == 0) goto L36
            bf r0 = new bf
            byte[] r1 = r5.array()
            int r2 = r5.arrayOffset()
            int r3 = r5.limit()
            r0.<init>(r1, r2, r3)
            goto L37
        L36:
            r0 = 0
        L37:
            if (r0 == 0) goto L4b
            int r1 = r0.a
            if (r1 != 0) goto L4b
            java.lang.Object r1 = r0.c
            byte[] r1 = (byte[]) r1
            int r1 = r1.length
            int r0 = r0.b
            if (r0 != r1) goto L4b
            byte[] r5 = r5.array()
            goto L60
        L4b:
            java.nio.ByteBuffer r5 = r5.asReadOnlyBuffer()
            int r0 = r5.limit()
            byte[] r0 = new byte[r0]
            r1 = 0
            java.nio.Buffer r1 = r5.position(r1)
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            r5.get(r0)
            r5 = r0
        L60:
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ka0.l(eb1, g01):eb1");
    }

    @Override // defpackage.t21
    public CharSequence n(Preference preference) {
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        if (!TextUtils.isEmpty(editTextPreference.Y)) {
            return editTextPreference.Y;
        }
        return editTextPreference.g.getString(r61.not_set);
    }

    @Override // defpackage.z20
    public Object p(File file) {
        return ParcelFileDescriptor.open(file, 268435456);
    }

    public void q(q11 q11Var, float f) {
        pc1 pc1Var = (pc1) ((Drawable) q11Var.h);
        CardView cardView = (CardView) q11Var.i;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f != pc1Var.e || pc1Var.f != useCompatPadding || pc1Var.g != preventCornerOverlap) {
            pc1Var.e = f;
            pc1Var.f = useCompatPadding;
            pc1Var.g = preventCornerOverlap;
            pc1Var.b(null);
            pc1Var.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            q11Var.O(0, 0, 0, 0);
            return;
        }
        pc1 pc1Var2 = (pc1) ((Drawable) q11Var.h);
        float f2 = pc1Var2.e;
        float f3 = pc1Var2.a;
        int iCeil = (int) Math.ceil(qc1.a(f2, f3, cardView.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(qc1.b(f2, f3, cardView.getPreventCornerOverlap()));
        q11Var.O(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        switch (this.g) {
            case 5:
                return aq1.b;
            default:
                return new re(new iy(), 0);
        }
    }

    @Override // defpackage.vp0
    public void t(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int iO = o(level);
            StringBuilder sbM = k31.m(str, "\n");
            sbM.append(Log.getStackTraceString(th));
            Log.println(iO, "EventBus", sbM.toString());
        }
    }

    public String toString() {
        switch (this.g) {
            case 22:
                return "EmptyAction";
            default:
                return super.toString();
        }
    }

    public ka0(a aVar, h60 h60Var) {
        this.g = 25;
    }

    @Override // defpackage.j20
    public void d(Object obj) {
    }

    @Override // defpackage.wm0
    public void g(cn0 cn0Var) {
    }

    @Override // defpackage.pv
    public void i(bj0 bj0Var, wb2 wb2Var) {
    }
}
