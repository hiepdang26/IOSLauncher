package defpackage;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class yr1 implements ib1 {
    public static final e01 d = new e01("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new ze());
    public static final e01 e = new e01("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new ow1(29));
    public static final m21 f = new m21();
    public static final List g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));
    public final xr1 a;
    public final oc b;
    public final m21 c = f;

    public yr1(oc ocVar, xr1 xr1Var) {
        this.b = ocVar;
        this.a = xr1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.ib1
    public final eb1 a(Object obj, int i, int i2, g01 g01Var) throws Exception {
        long jLongValue = ((Long) g01Var.c(d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException(uo.f("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", jLongValue));
        }
        Integer num = (Integer) g01Var.c(e);
        if (num == null) {
            num = 2;
        }
        hw hwVar = (hw) g01Var.c(hw.g);
        if (hwVar == null) {
            hwVar = hw.f;
        }
        hw hwVar2 = hwVar;
        this.c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.a.c(mediaMetadataRetriever, obj);
            try {
                Bitmap bitmapC = c(obj, mediaMetadataRetriever, jLongValue, num.intValue(), i, i2, hwVar2);
                if (Build.VERSION.SDK_INT < 29) {
                    mediaMetadataRetriever.release();
                } else if (mediaMetadataRetriever instanceof AutoCloseable) {
                    mediaMetadataRetriever.close();
                } else if (mediaMetadataRetriever instanceof ExecutorService) {
                    e.y((ExecutorService) mediaMetadataRetriever);
                } else {
                    mediaMetadataRetriever.release();
                }
                return pc.b(this.b, bitmapC);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                if (Build.VERSION.SDK_INT < 29) {
                    mediaMetadataRetriever.release();
                    throw th2;
                }
                if (mediaMetadataRetriever instanceof AutoCloseable) {
                    mediaMetadataRetriever.close();
                    throw th2;
                }
                if (mediaMetadataRetriever instanceof ExecutorService) {
                    e.y((ExecutorService) mediaMetadataRetriever);
                    throw th2;
                }
                mediaMetadataRetriever.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // defpackage.ib1
    public final boolean b(Object obj, g01 g01Var) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0111 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0113 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0161 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap c(java.lang.Object r14, android.media.MediaMetadataRetriever r15, long r16, int r18, int r19, int r20, defpackage.hw r21) {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yr1.c(java.lang.Object, android.media.MediaMetadataRetriever, long, int, int, int, hw):android.graphics.Bitmap");
    }
}
