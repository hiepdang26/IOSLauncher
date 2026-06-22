package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Shader;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class xk {
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object d;

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f6, code lost:
    
        if (r3.size() <= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f8, code lost:
    
        r0 = new defpackage.q11(r3, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01fe, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01ff, code lost:
    
        if (r0 == null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0203, code lost:
    
        if (r19 == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0205, code lost:
    
        r0 = new defpackage.q11(r6, r7, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x020b, code lost:
    
        r0 = new defpackage.q11(r6, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0211, code lost:
    
        if (r8 == 1) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0214, code lost:
    
        if (r8 == 2) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0218, code lost:
    
        if (r11 == 1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x021a, code lost:
    
        if (r11 == 2) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x021c, code lost:
    
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0221, code lost:
    
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0224, code lost:
    
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0227, code lost:
    
        r13 = new android.graphics.LinearGradient(r22, r25, r16, r17, (int[]) r0.h, (float[]) r0.i, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x023b, code lost:
    
        r13 = new android.graphics.SweepGradient(r5, r10, (int[]) r0.h, (float[]) r0.i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x024d, code lost:
    
        if (r24 <= 0.0f) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0253, code lost:
    
        if (r11 == 1) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0255, code lost:
    
        if (r11 == 2) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0257, code lost:
    
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x025a, code lost:
    
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x025d, code lost:
    
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x025f, code lost:
    
        r13 = new android.graphics.RadialGradient(r5, r10, r24, (int[]) r0.h, (float[]) r0.i, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x027f, code lost:
    
        return new defpackage.xk(r13, (android.content.res.ColorStateList) null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0287, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.xk a(int r26, android.content.res.Resources.Theme r27, android.content.res.Resources r28) {
        /*
            Method dump skipped, instruction units count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xk.a(int, android.content.res.Resources$Theme, android.content.res.Resources):xk");
    }

    public static xk c(String str) throws ProtocolException {
        int i;
        String strSubstring;
        boolean zStartsWith = str.startsWith("HTTP/1.");
        z31 z31Var = z31.HTTP_1_0;
        if (zStartsWith) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                z31Var = z31.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i3 = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i + 4);
            }
            return new xk(z31Var, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public boolean b() {
        ColorStateList colorStateList;
        return ((Shader) this.c) == null && (colorStateList = (ColorStateList) this.d) != null && colorStateList.isStateful();
    }

    public String toString() {
        switch (this.a) {
            case 3:
                StringBuilder sb = new StringBuilder();
                sb.append(((z31) this.c) == z31.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
                sb.append(' ');
                sb.append(this.b);
                String str = (String) this.d;
                if (str != null) {
                    sb.append(' ');
                    sb.append(str);
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public xk(z31 z31Var, int i, String str) {
        this.a = 3;
        this.c = z31Var;
        this.b = i;
        this.d = str;
    }

    public xk(Shader shader, ColorStateList colorStateList, int i) {
        this.a = 0;
        this.c = shader;
        this.d = colorStateList;
        this.b = i;
    }

    public xk(zn znVar) {
        this.a = 1;
        this.d = os.t(150, new ow1(this, 12));
        this.c = znVar;
    }
}
