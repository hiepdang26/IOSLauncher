package defpackage;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.JsonWriter;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class t3 implements nb1, b1, c40, yo1, k4, nb2 {
    public int g;
    public Object h;

    public /* synthetic */ t3(int i, Map map) {
        this.g = i;
        this.h = map;
    }

    @Override // defpackage.nb2
    public void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(this.g);
        jsonWriter.endObject();
        ub2.e(jsonWriter, (Map) this.h);
        jsonWriter.endObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.c40
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.Object r7, defpackage.go r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof defpackage.jk
            if (r0 == 0) goto L13
            r0 = r8
            jk r0 = (defpackage.jk) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            jk r0 = new jk
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.g
            hp r1 = defpackage.hp.g
            int r2 = r0.i
            zp1 r3 = defpackage.zp1.a
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r5) goto L2c
            defpackage.np1.I(r8)
            return r3
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            defpackage.np1.I(r8)
            goto L4f
        L38:
            defpackage.np1.I(r8)
            ff0 r8 = new ff0
            int r2 = r6.g
            r8.<init>(r2, r7)
            r0.i = r4
            java.lang.Object r7 = r6.h
            je r7 = (defpackage.je) r7
            java.lang.Object r7 = r7.d(r8, r0)
            if (r7 != r1) goto L4f
            goto La6
        L4f:
            r0.i = r5
            yo r7 = r0.getContext()
            iy r8 = defpackage.iy.i
            wo r8 = r7.n(r8)
            fi0 r8 = (defpackage.fi0) r8
            if (r8 == 0) goto L6d
            boolean r2 = r8.a()
            if (r2 == 0) goto L66
            goto L6d
        L66:
            xi0 r8 = (defpackage.xi0) r8
            java.util.concurrent.CancellationException r7 = r8.w()
            throw r7
        L6d:
            eo r8 = defpackage.e42.d(r0)
            boolean r0 = r8 instanceof defpackage.yv
            r2 = 0
            if (r0 == 0) goto L79
            r2 = r8
            yv r2 = (defpackage.yv) r2
        L79:
            if (r2 != 0) goto L7d
            r7 = r3
            goto La0
        L7d:
            cp r8 = r2.j
            boolean r0 = r8.B()
            if (r0 == 0) goto L8d
            r2.l = r3
            r2.i = r4
            r8.A(r7, r2)
            goto L9f
        L8d:
            m02 r0 = new m02
            m21 r5 = defpackage.m02.h
            r0.<init>(r5)
            yo r7 = r7.k(r0)
            r2.l = r3
            r2.i = r4
            r8.A(r7, r2)
        L9f:
            r7 = r1
        La0:
            if (r7 != r1) goto La3
            goto La4
        La3:
            r7 = r3
        La4:
            if (r7 != r1) goto La7
        La6:
            return r1
        La7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t3.b(java.lang.Object, go):java.lang.Object");
    }

    @Override // defpackage.yo1
    public wo1 c(int i) {
        if (i == 5) {
            return ox0.g;
        }
        if (((cx) this.h) == null) {
            this.h = new cx(this.g);
        }
        return (cx) this.h;
    }

    public u3 d() {
        ListAdapter r3Var;
        p3 p3Var = (p3) this.h;
        u3 u3Var = new u3(p3Var.a, this.g);
        View view = p3Var.e;
        s3 s3Var = u3Var.i;
        if (view != null) {
            s3Var.w = view;
        } else {
            CharSequence charSequence = p3Var.d;
            if (charSequence != null) {
                s3Var.d = charSequence;
                TextView textView = s3Var.u;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = p3Var.c;
            if (drawable != null) {
                s3Var.s = drawable;
                ImageView imageView = s3Var.t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    s3Var.t.setImageDrawable(drawable);
                }
            }
        }
        CharSequence charSequence2 = p3Var.f;
        if (charSequence2 != null) {
            s3Var.e = charSequence2;
            TextView textView2 = s3Var.v;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = p3Var.g;
        if (charSequence3 != null) {
            s3Var.d(-1, charSequence3, p3Var.h);
        }
        CharSequence charSequence4 = p3Var.i;
        if (charSequence4 != null) {
            s3Var.d(-2, charSequence4, p3Var.j);
        }
        CharSequence charSequence5 = p3Var.k;
        if (charSequence5 != null) {
            s3Var.d(-3, charSequence5, p3Var.l);
        }
        if (p3Var.q != null || p3Var.r != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) p3Var.b.inflate(s3Var.A, (ViewGroup) null);
            boolean z = p3Var.v;
            ContextThemeWrapper contextThemeWrapper = p3Var.a;
            if (z) {
                r3Var = new m3(p3Var, contextThemeWrapper, s3Var.B, p3Var.q, alertController$RecycleListView);
            } else {
                int i = p3Var.w ? s3Var.C : s3Var.D;
                r3Var = p3Var.r;
                if (r3Var == null) {
                    r3Var = new r3(contextThemeWrapper, i, R.id.text1, p3Var.q);
                }
            }
            s3Var.x = r3Var;
            s3Var.y = p3Var.x;
            if (p3Var.s != null) {
                alertController$RecycleListView.setOnItemClickListener(new n3(p3Var, s3Var));
            } else if (p3Var.y != null) {
                alertController$RecycleListView.setOnItemClickListener(new o3(p3Var, alertController$RecycleListView, s3Var));
            }
            if (p3Var.w) {
                alertController$RecycleListView.setChoiceMode(1);
            } else if (p3Var.v) {
                alertController$RecycleListView.setChoiceMode(2);
            }
            s3Var.f = alertController$RecycleListView;
        }
        View view2 = p3Var.t;
        if (view2 != null) {
            s3Var.g = view2;
            s3Var.h = false;
        }
        u3Var.setCancelable(p3Var.m);
        if (p3Var.m) {
            u3Var.setCanceledOnTouchOutside(true);
        }
        u3Var.setOnCancelListener(p3Var.n);
        u3Var.setOnDismissListener(p3Var.o);
        ht0 ht0Var = p3Var.p;
        if (ht0Var != null) {
            u3Var.setOnKeyListener(ht0Var);
        }
        return u3Var;
    }

    public int e() {
        if ((this.g & 128) != 0) {
            return ((int[]) this.h)[7];
        }
        return 65535;
    }

    @Override // defpackage.b1
    public boolean f(View view) {
        ((BottomSheetBehavior) this.h).A(this.g);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // defpackage.k4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(defpackage.l4 r4, defpackage.l4 r5, int r6, int r7, int r8) {
        /*
            r3 = this;
            i4 r4 = r4.c
            int r0 = r4.b
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L9
            goto L36
        L9:
            int r0 = r6 / r7
            int r6 = r6 % r7
            i4 r7 = r5.c
            if (r7 == 0) goto L26
            java.lang.String r4 = r4.d
            java.lang.Object r7 = r3.h
            java.nio.charset.CharsetEncoder r7 = (java.nio.charset.CharsetEncoder) r7
            boolean r4 = r7.canEncode(r4)
            i4 r5 = r5.c
            java.lang.String r5 = r5.d
            boolean r5 = r7.canEncode(r5)
            if (r4 == r5) goto L26
            r4 = 1
            goto L27
        L26:
            r4 = 0
        L27:
            if (r6 <= 0) goto L36
            int r5 = r3.g
            if (r6 >= r5) goto L36
            r5 = 3
            if (r0 >= r5) goto L36
            r5 = 2
            if (r8 >= r5) goto L36
            if (r4 != 0) goto L36
            return r2
        L36:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t3.g(l4, l4, int, int, int):boolean");
    }

    public void h(int i, int i2) {
        if (i >= 0) {
            int[] iArr = (int[]) this.h;
            if (i >= iArr.length) {
                return;
            }
            this.g = (1 << i) | this.g;
            iArr[i] = i2;
        }
    }

    @Override // defpackage.nb1
    public eb1 l(eb1 eb1Var, g01 g01Var) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) eb1Var.get()).compress((Bitmap.CompressFormat) this.h, this.g, byteArrayOutputStream);
        eb1Var.recycle();
        return new a5(byteArrayOutputStream.toByteArray());
    }

    public /* synthetic */ t3(Object obj, int i) {
        this.h = obj;
        this.g = i;
    }

    public /* synthetic */ t3(ArrayList arrayList) {
        this.g = 0;
        this.h = arrayList;
    }

    public t3(int i, boolean z) {
        switch (i) {
            case 6:
                this.g = 1;
                this.h = Collections.singletonList(null);
                break;
            case 7:
            default:
                this.h = Bitmap.CompressFormat.JPEG;
                this.g = 100;
                break;
            case 8:
                this.h = new int[10];
                break;
        }
    }

    public t3(Context context) {
        this(context, u3.c(context, 0));
    }

    public t3(Context context, int i) {
        this.h = new p3(new ContextThemeWrapper(context, u3.c(context, i)));
        this.g = i;
    }
}
