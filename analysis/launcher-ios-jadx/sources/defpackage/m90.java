package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.PopupWindow;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class m90 {
    public static final n4 b;
    public static final b21 d;
    public static final v20 f;
    public static final v20[] g;
    public static Method h;
    public static boolean i;
    public static Field j;
    public static boolean k;
    public static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final ta1 c = new ta1(1);
    public static final m21 e = new m21();

    static {
        int i2 = 2;
        b = new n4(i2);
        d = new b21(i2);
        v20 v20Var = new v20("additional_video_csi");
        f = v20Var;
        g = new v20[]{v20Var};
    }

    public static final bo a(yo yoVar) {
        if (yoVar.n(iy.i) == null) {
            yoVar = yoVar.k(new ii0());
        }
        return new bo(yoVar);
    }

    public static un0 b(un0 un0Var) {
        un0Var.f();
        un0Var.i = true;
        return un0Var.h > 0 ? un0Var : un0.j;
    }

    public static void c(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public static int d(i91 i91Var, wy wyVar, View view, View view2, u81 u81Var, boolean z) {
        if (u81Var.v() == 0 || i91Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(u81.J(view) - u81.J(view2)) + 1;
        }
        return Math.min(wyVar.l(), wyVar.b(view2) - wyVar.e(view));
    }

    public static int e(i91 i91Var, wy wyVar, View view, View view2, u81 u81Var, boolean z, boolean z2) {
        if (u81Var.v() == 0 || i91Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (i91Var.b() - Math.max(u81.J(view), u81.J(view2))) - 1) : Math.max(0, Math.min(u81.J(view), u81.J(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(wyVar.b(view2) - wyVar.e(view)) / (Math.abs(u81.J(view) - u81.J(view2)) + 1))) + (wyVar.k() - wyVar.e(view)));
        }
        return iMax;
    }

    public static int f(i91 i91Var, wy wyVar, View view, View view2, u81 u81Var, boolean z) {
        if (u81Var.v() == 0 || i91Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return i91Var.b();
        }
        return (int) (((wyVar.b(view2) - wyVar.e(view)) / (Math.abs(u81.J(view) - u81.J(view2)) + 1)) * i91Var.b());
    }

    public static final Object g(s70 s70Var, zk1 zk1Var) {
        he1 he1Var = new he1(zk1Var.getContext(), zk1Var);
        return os.s(he1Var, he1Var, s70Var);
    }

    public static int h(int i2) {
        return (int) (i2 * Resources.getSystem().getDisplayMetrics().density);
    }

    public static final zy1 i(lz1 lz1Var) {
        qg0.l(lz1Var, "<this>");
        return new zy1(lz1Var.a, lz1Var.t);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class k(aj0 aj0Var) {
        qg0.l(aj0Var, "<this>");
        Class clsA = ((yi) aj0Var).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    public static int m(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        c("glGenTextures");
        int i2 = iArr[0];
        if (i2 != 0) {
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            c("texImage2D");
        }
        int i3 = iArr[0];
        if (i3 != 0) {
            return i3;
        }
        throw new RuntimeException("Error loading texture (empty texture handle).");
    }

    public static void n(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = (Animator) arrayList.get(i2);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        arrayList.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(arrayList);
    }

    public static cu0 o(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j2;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i2 = byteBufferDuplicate.getShort() & 65535;
        if (i2 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                j2 = -1;
                break;
            }
            int i4 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j2 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i4) {
                break;
            }
            i3++;
        }
        if (j2 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j2 - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j3 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i5 = 0; i5 < j3; i5++) {
                int i6 = byteBufferDuplicate.getInt();
                long j4 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i6 || 1701669481 == i6) {
                    byteBufferDuplicate.position((int) (j4 + j2));
                    cu0 cu0Var = new cu0();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    cu0Var.j = byteBufferDuplicate;
                    cu0Var.g = iPosition;
                    int i7 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    cu0Var.h = i7;
                    cu0Var.i = ((ByteBuffer) cu0Var.j).getShort(i7);
                    return cu0Var;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static void r(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            t1.s(popupWindow, z);
            return;
        }
        if (!k) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                j = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            k = true;
        }
        Field field = j;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public static void s(PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            t1.t(popupWindow, i2);
            return;
        }
        if (!i) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                h = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            i = true;
        }
        Method method = h;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception unused2) {
            }
        }
    }

    public abstract InputFilter[] j(InputFilter[] inputFilterArr);

    public abstract boolean l();

    public abstract void p(boolean z);

    public abstract void q(boolean z);

    public abstract TransformationMethod t(TransformationMethod transformationMethod);
}
