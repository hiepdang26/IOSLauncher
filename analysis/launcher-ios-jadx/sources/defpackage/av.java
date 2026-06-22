package defpackage;

import android.database.Cursor;
import android.os.Build;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class av {
    public static final /* synthetic */ int a = 0;

    static {
        qg0.k(ka0.r("DiagnosticsWrkr"), "tagWithPrefix(\"DiagnosticsWrkr\")");
    }

    public static final void a(fz1 fz1Var, oz1 oz1Var, ol1 ol1Var, ArrayList arrayList) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("\n Id \t Class Name\t " + (Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id") + "\t State\t Unique Name\t Tags\t");
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            lz1 lz1Var = (lz1) obj;
            nl1 nl1VarI = ol1Var.i(m90.i(lz1Var));
            Integer numValueOf = nl1VarI != null ? Integer.valueOf(nl1VarI.c) : null;
            fz1Var.getClass();
            lc1 lc1VarA = lc1.a(1, "SELECT name FROM workname WHERE work_spec_id=?");
            String str2 = lz1Var.a;
            if (str2 == null) {
                lc1VarA.g(1);
            } else {
                lc1VarA.e(1, str2);
            }
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) fz1Var.h;
            workDatabase_Impl.b();
            Cursor cursorL = workDatabase_Impl.l(lc1VarA);
            try {
                ArrayList arrayList2 = new ArrayList(cursorL.getCount());
                while (cursorL.moveToNext()) {
                    arrayList2.add(cursorL.isNull(0) ? null : cursorL.getString(0));
                }
                cursorL.close();
                lc1VarA.k();
                String strY = wj.y(arrayList2, ",", null, 62);
                String strY2 = wj.y(oz1Var.e(str2), ",", null, 62);
                StringBuilder sbO = uo.o("\n", str2, "\t ");
                sbO.append(lz1Var.c);
                sbO.append("\t ");
                sbO.append(numValueOf);
                sbO.append("\t ");
                switch (lz1Var.b) {
                    case 1:
                        str = "ENQUEUED";
                        break;
                    case 2:
                        str = "RUNNING";
                        break;
                    case 3:
                        str = "SUCCEEDED";
                        break;
                    case 4:
                        str = "FAILED";
                        break;
                    case 5:
                        str = "BLOCKED";
                        break;
                    case 6:
                        str = "CANCELLED";
                        break;
                    default:
                        throw null;
                }
                sbO.append(str);
                sbO.append("\t ");
                sbO.append(strY);
                sbO.append("\t ");
                sbO.append(strY2);
                sbO.append('\t');
                sb.append(sbO.toString());
            } catch (Throwable th) {
                cursorL.close();
                lc1VarA.k();
                throw th;
            }
        }
        qg0.k(sb.toString(), "StringBuilder().apply(builderAction).toString()");
    }
}
