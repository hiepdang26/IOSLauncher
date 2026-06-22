package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.profileinstaller.ProfileVerifier;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class jw {
    public static final e01 f = e01.a(ps.i, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");
    public static final e01 g = new e01("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, e01.e);
    public static final e01 h;
    public static final e01 i;
    public static final Set j;
    public static final iy k;
    public static final ArrayDeque l;
    public final oc a;
    public final DisplayMetrics b;
    public final cq0 c;
    public final ArrayList d;
    public final gb0 e = gb0.a();

    static {
        hw hwVar = hw.b;
        Boolean bool = Boolean.FALSE;
        h = e01.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        i = e01.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        k = new iy();
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = vq1.a;
        l = new ArrayDeque(0);
    }

    public jw(ArrayList arrayList, DisplayMetrics displayMetrics, oc ocVar, cq0 cq0Var) {
        this.d = arrayList;
        n90.h(displayMetrics, "Argument must not be null");
        this.b = displayMetrics;
        n90.h(ocVar, "Argument must not be null");
        this.a = ocVar;
        n90.h(cq0Var, "Argument must not be null");
        this.c = cq0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap c(defpackage.wb2 r8, android.graphics.BitmapFactory.Options r9, defpackage.iw r10, defpackage.oc r11) {
        /*
            boolean r0 = r9.inJustDecodeBounds
            if (r0 != 0) goto L20
            r10.f()
            int r0 = r8.g
            switch(r0) {
                case 15: goto L20;
                case 16: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L20
        Ld:
            java.lang.Object r0 = r8.h
            fz1 r0 = (defpackage.fz1) r0
            java.lang.Object r0 = r0.h
            k81 r0 = (defpackage.k81) r0
            monitor-enter(r0)
            byte[] r1 = r0.g     // Catch: java.lang.Throwable -> L1d
            int r1 = r1.length     // Catch: java.lang.Throwable -> L1d
            r0.i = r1     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)
            goto L20
        L1d:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            throw r8
        L20:
            int r0 = r9.outWidth
            int r1 = r9.outHeight
            java.lang.String r2 = r9.outMimeType
            java.util.concurrent.locks.Lock r3 = defpackage.to1.b
            r3.lock()
            android.graphics.Bitmap r8 = r8.o(r9)     // Catch: java.lang.IllegalArgumentException -> L33 java.lang.Throwable -> L74
            r3.unlock()
            return r8
        L33:
            r3 = move-exception
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L74
            java.lang.String r5 = "Exception decoding bitmap, outWidth: "
            java.lang.String r6 = ", outHeight: "
            java.lang.String r7 = ", outMimeType: "
            java.lang.StringBuilder r0 = defpackage.uo.n(r5, r0, r6, r1, r7)     // Catch: java.lang.Throwable -> L74
            r0.append(r2)     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = ", inBitmap: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L74
            android.graphics.Bitmap r1 = r9.inBitmap     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = d(r1)     // Catch: java.lang.Throwable -> L74
            r0.append(r1)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L74
            r4.<init>(r0, r3)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "Downsampler"
            r1 = 3
            android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L74
            android.graphics.Bitmap r0 = r9.inBitmap     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L73
            r11.j(r0)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L74
            r0 = 0
            r9.inBitmap = r0     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L74
            android.graphics.Bitmap r8 = c(r8, r9, r10, r11)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L74
            java.util.concurrent.locks.Lock r9 = defpackage.to1.b
            r9.unlock()
            return r8
        L72:
            throw r4     // Catch: java.lang.Throwable -> L74
        L73:
            throw r4     // Catch: java.lang.Throwable -> L74
        L74:
            r8 = move-exception
            java.util.concurrent.locks.Lock r9 = defpackage.to1.b
            r9.unlock()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jw.c(wb2, android.graphics.BitmapFactory$Options, iw, oc):android.graphics.Bitmap");
    }

    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void e(BitmapFactory.Options options) {
        f(options);
        ArrayDeque arrayDeque = l;
        synchronized (arrayDeque) {
            arrayDeque.offer(options);
        }
    }

    public static void f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final pc a(wb2 wb2Var, int i2, int i3, g01 g01Var, iw iwVar) {
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.c.d(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST, byte[].class);
        synchronized (jw.class) {
            ArrayDeque arrayDeque = l;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                f(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        ps psVar = (ps) g01Var.c(f);
        h31 h31Var = (h31) g01Var.c(g);
        hw hwVar = (hw) g01Var.c(hw.g);
        boolean zBooleanValue = ((Boolean) g01Var.c(h)).booleanValue();
        e01 e01Var = i;
        try {
            return pc.b(this.a, b(wb2Var, options2, hwVar, psVar, h31Var, g01Var.c(e01Var) != null && ((Boolean) g01Var.c(e01Var)).booleanValue(), i2, i3, zBooleanValue, iwVar));
        } finally {
            e(options2);
            this.c.h(bArr);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x033f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0384 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x049d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0132 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0134  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(defpackage.wb2 r32, android.graphics.BitmapFactory.Options r33, defpackage.hw r34, defpackage.ps r35, defpackage.h31 r36, boolean r37, int r38, int r39, boolean r40, defpackage.iw r41) {
        /*
            Method dump skipped, instruction units count: 1262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jw.b(wb2, android.graphics.BitmapFactory$Options, hw, ps, h31, boolean, int, int, boolean, iw):android.graphics.Bitmap");
    }
}
