package defpackage;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class y00 extends m81 implements wh0 {
    public final /* synthetic */ int j;
    public final Object k;
    public final Object l;
    public int m;
    public Object n;
    public boolean o;
    public List p;

    public y00(Context context, int i, boolean z) {
        this.j = i;
        switch (i) {
            case 1:
                this.p = new ArrayList();
                this.m = -1;
                this.k = context;
                this.l = LayoutInflater.from(context);
                this.n = AnimationUtils.loadAnimation(context, R.anim.fade_in);
                this.o = z;
                break;
            default:
                this.p = new ArrayList();
                this.m = -1;
                this.k = context;
                this.l = LayoutInflater.from(context);
                this.n = AnimationUtils.loadAnimation(context, R.anim.fade_in);
                this.o = z;
                break;
        }
    }

    @Override // defpackage.wh0
    public void a(int i) {
        ArrayList arrayList = (ArrayList) this.p;
        try {
            gh0 gh0Var = (gh0) arrayList.get(i);
            nh0 nh0Var = (nh0) this.n;
            if (nh0Var != null) {
                nh0Var.f(gh0Var.a, gh0Var.b, gh0Var.c, gh0Var.d);
            }
            arrayList.remove(i);
            this.g.f(i, 1);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.wh0
    public void b(int i, int i2) {
        ArrayList arrayList = (ArrayList) this.p;
        if (i < i2) {
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                Collections.swap(arrayList, i3, i4);
                i3 = i4;
            }
        } else {
            for (int i5 = i; i5 > i2; i5--) {
                Collections.swap(arrayList, i5, i5 - 1);
            }
        }
        this.g.c(i, i2);
        nh0 nh0Var = (nh0) this.n;
        if (nh0Var != null) {
            nh0Var.b();
        }
    }

    @Override // defpackage.m81
    public final int c() {
        switch (this.j) {
            case 0:
                List list = this.p;
                if (list == null) {
                    return 0;
                }
                return list.size();
            case 1:
                ArrayList arrayList = (ArrayList) this.p;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            default:
                return ((ArrayList) this.p).size();
        }
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        String string;
        int i2 = 1;
        switch (this.j) {
            case 0:
                x00 x00Var = (x00) m91Var;
                List list = this.p;
                if (list != null && i < list.size()) {
                    x00Var.A.setBackgroundColor(((w00) this.p.get(i)).b);
                    String str = ((w00) this.p.get(i)).c;
                    TextView textView = x00Var.B;
                    textView.setText(str);
                    String str2 = ((w00) this.p.get(i)).d;
                    TextView textView2 = x00Var.C;
                    textView2.setText(str2);
                    textView.setTextColor(this.o ? -1 : -16777216);
                    textView2.setTextColor(this.o ? -1 : -16777216);
                    if (i > this.m) {
                        x00Var.g.startAnimation((Animation) this.n);
                        this.m = i;
                    }
                    break;
                }
                break;
            case 1:
                u20 u20Var = (u20) m91Var;
                ArrayList arrayList = (ArrayList) this.p;
                if (arrayList != null && i < arrayList.size()) {
                    u20Var.B.setText(((s20) ((ArrayList) this.p).get(i)).b);
                    u20Var.B.setTextColor(this.o ? -1 : -16777216);
                    Bitmap bitmap = ((s20) ((ArrayList) this.p).get(i)).d;
                    ImageView imageView = u20Var.A;
                    if (bitmap != null) {
                        imageView.setImageBitmap(((s20) ((ArrayList) this.p).get(i)).d);
                    } else if (((s20) ((ArrayList) this.p).get(i)).b != null) {
                        int i3 = cn1.f;
                        bn1 bn1Var = new bn1();
                        string = "";
                        bn1Var.b = "";
                        bn1Var.d = new RectShape();
                        bn1Var.c = Typeface.create("sans-serif-light", 0);
                        bn1Var.a = -1;
                        String[] strArrSplit = ((s20) ((ArrayList) this.p).get(i)).b.split(" ");
                        if (strArrSplit.length > 1) {
                            string = TextUtils.isEmpty(strArrSplit[0]) ? "" : "" + strArrSplit[0].substring(0, 1);
                            if (!TextUtils.isEmpty(strArrSplit[1])) {
                                StringBuilder sbM = uo.m(string);
                                sbM.append(strArrSplit[1].substring(0, 1));
                                string = sbM.toString();
                            }
                        } else if (!TextUtils.isEmpty(strArrSplit[0])) {
                            string = "" + strArrSplit[0].substring(0, 1);
                        }
                        bn1Var.d = new OvalShape();
                        bn1Var.b = string;
                        imageView.setImageDrawable(new cn1(bn1Var));
                    } else {
                        imageView.setImageResource(l51.ic_contact);
                    }
                    if (i > this.m) {
                        u20Var.g.startAnimation((Animation) this.n);
                        this.m = i;
                    }
                    break;
                }
                break;
            default:
                oh0 oh0Var = (oh0) m91Var;
                gh0 gh0Var = (gh0) ((ArrayList) this.p).get(i);
                oh0Var.B.setText(gh0Var.b);
                oh0Var.C.setOnClickListener(new mh0(this, oh0Var));
                oh0Var.E.setOnTouchListener(new tx(this, oh0Var, i2));
                oh0Var.D.setImageBitmap(gh0Var.d);
                if (i > this.m) {
                    View view = oh0Var.g;
                    view.setAlpha(0.0f);
                    view.animate().withLayer().alpha(1.0f).setDuration(200L).start();
                    this.m = i;
                }
                break;
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        switch (this.j) {
            case 0:
                return new x00(this, ((LayoutInflater) this.l).inflate(m61.event_item, viewGroup, false));
            case 1:
                return new u20(this, ((LayoutInflater) this.l).inflate(m61.recycler_starred_contact_item, viewGroup, false));
            default:
                return new oh0(this, LayoutInflater.from(viewGroup.getContext()).inflate(m61.item_delete_adapter, viewGroup, false));
        }
    }

    public y00(bz0 bz0Var, ArrayList arrayList, boolean z) {
        this.j = 2;
        this.k = "ItemChooseAdapter";
        new ArrayList();
        this.m = -1;
        this.o = z;
        this.l = bz0Var;
        this.p = arrayList;
    }
}
