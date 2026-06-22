package defpackage;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class su extends l00 {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ su(kc1 kc1Var, int i) {
        super(kc1Var);
        this.d = i;
    }

    @Override // defpackage.ig1
    public final String c() {
        switch (this.d) {
            case 0:
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            case 1:
                return "INSERT OR ABORT INTO `LeftPageWidget` (`widgetId`,`layoutId`,`order`,`size`,`type`) VALUES (nullif(?, 0),?,?,?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `LeftPageWidget` (`widgetId`,`layoutId`,`order`,`size`,`type`) VALUES (nullif(?, 0),?,?,?,?)";
            case 3:
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            case 4:
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            case 5:
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            case 6:
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            case 7:
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    @Override // defpackage.l00
    public final void e(z60 z60Var, Object obj) throws Throwable {
        int i;
        int i2;
        byte[] byteArray;
        switch (this.d) {
            case 0:
                qu quVar = (qu) obj;
                z60Var.e(1, quVar.a);
                String str = quVar.b;
                if (str == null) {
                    z60Var.g(2);
                    return;
                } else {
                    z60Var.e(2, str);
                    return;
                }
            case 1:
                hm0 hm0Var = (hm0) obj;
                z60Var.q(1, hm0Var.a);
                z60Var.q(2, hm0Var.b);
                z60Var.q(3, hm0Var.c);
                z60Var.q(4, hm0Var.d);
                z60Var.q(5, hm0Var.e);
                return;
            case 2:
                hm0 hm0Var2 = (hm0) obj;
                z60Var.q(1, hm0Var2.a);
                z60Var.q(2, hm0Var2.b);
                z60Var.q(3, hm0Var2.c);
                z60Var.q(4, hm0Var2.d);
                z60Var.q(5, hm0Var2.e);
                return;
            case 3:
                u21 u21Var = (u21) obj;
                z60Var.e(1, u21Var.a);
                z60Var.q(2, u21Var.b.longValue());
                return;
            case 4:
                String str2 = ((nl1) obj).a;
                if (str2 == null) {
                    z60Var.g(1);
                } else {
                    z60Var.e(1, str2);
                }
                z60Var.q(2, r2.b);
                z60Var.q(3, r2.c);
                return;
            case 5:
                throw null;
            case 6:
                gz1 gz1Var = (gz1) obj;
                String str3 = gz1Var.a;
                if (str3 == null) {
                    z60Var.g(1);
                } else {
                    z60Var.e(1, str3);
                }
                byte[] bArrC = wr.c(gz1Var.b);
                if (bArrC == null) {
                    z60Var.g(2);
                    return;
                } else {
                    z60Var.s(2, bArrC);
                    return;
                }
            case 7:
                lz1 lz1Var = (lz1) obj;
                String str4 = lz1Var.a;
                int i3 = 1;
                if (str4 == null) {
                    z60Var.g(1);
                } else {
                    z60Var.e(1, str4);
                }
                z60Var.q(2, n90.C(lz1Var.b));
                String str5 = lz1Var.c;
                if (str5 == null) {
                    z60Var.g(3);
                } else {
                    z60Var.e(3, str5);
                }
                String str6 = lz1Var.d;
                if (str6 == null) {
                    z60Var.g(4);
                } else {
                    z60Var.e(4, str6);
                }
                byte[] bArrC2 = wr.c(lz1Var.e);
                if (bArrC2 == null) {
                    z60Var.g(5);
                } else {
                    z60Var.s(5, bArrC2);
                }
                byte[] bArrC3 = wr.c(lz1Var.f);
                if (bArrC3 == null) {
                    z60Var.g(6);
                } else {
                    z60Var.s(6, bArrC3);
                }
                z60Var.q(7, lz1Var.g);
                z60Var.q(8, lz1Var.h);
                z60Var.q(9, lz1Var.i);
                z60Var.q(10, lz1Var.k);
                int i4 = lz1Var.l;
                uo.p(i4, "backoffPolicy");
                int iV = uo.v(i4);
                if (iV == 0) {
                    i = 0;
                } else {
                    if (iV != 1) {
                        throw new wk(4);
                    }
                    i = 1;
                }
                z60Var.q(11, i);
                z60Var.q(12, lz1Var.m);
                z60Var.q(13, lz1Var.n);
                z60Var.q(14, lz1Var.o);
                z60Var.q(15, lz1Var.p);
                z60Var.q(16, lz1Var.q ? 1L : 0L);
                int i5 = lz1Var.r;
                uo.p(i5, "policy");
                int iV2 = uo.v(i5);
                if (iV2 == 0) {
                    i2 = 0;
                } else {
                    if (iV2 != 1) {
                        throw new wk(4);
                    }
                    i2 = 1;
                }
                z60Var.q(17, i2);
                z60Var.q(18, lz1Var.s);
                z60Var.q(19, lz1Var.t);
                z60Var.q(20, lz1Var.u);
                z60Var.q(21, lz1Var.v);
                z60Var.q(22, lz1Var.w);
                nn nnVar = lz1Var.j;
                if (nnVar == null) {
                    z60Var.g(23);
                    z60Var.g(24);
                    z60Var.g(25);
                    z60Var.g(26);
                    z60Var.g(27);
                    z60Var.g(28);
                    z60Var.g(29);
                    z60Var.g(30);
                    return;
                }
                int i6 = nnVar.a;
                uo.p(i6, "networkType");
                int iV3 = uo.v(i6);
                if (iV3 == 0) {
                    i3 = 0;
                } else if (iV3 != 1) {
                    if (iV3 == 2) {
                        i3 = 2;
                    } else if (iV3 == 3) {
                        i3 = 3;
                    } else if (iV3 == 4) {
                        i3 = 4;
                    } else {
                        if (Build.VERSION.SDK_INT < 30 || i6 != 6) {
                            throw new IllegalArgumentException("Could not convert " + uo.x(i6) + " to int");
                        }
                        i3 = 5;
                    }
                }
                z60Var.q(23, i3);
                z60Var.q(24, nnVar.b ? 1L : 0L);
                z60Var.q(25, nnVar.c ? 1L : 0L);
                z60Var.q(26, nnVar.d ? 1L : 0L);
                z60Var.q(27, nnVar.e ? 1L : 0L);
                z60Var.q(28, nnVar.f);
                z60Var.q(29, nnVar.g);
                Set<ln> set = nnVar.h;
                qg0.l(set, "triggers");
                if (set.isEmpty()) {
                    byteArray = new byte[0];
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream.writeInt(set.size());
                            for (ln lnVar : set) {
                                objectOutputStream.writeUTF(lnVar.a.toString());
                                objectOutputStream.writeBoolean(lnVar.b);
                                break;
                            }
                            objectOutputStream.close();
                            byteArrayOutputStream.close();
                            byteArray = byteArrayOutputStream.toByteArray();
                            qg0.k(byteArray, "outputStream.toByteArray()");
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            os.a(byteArrayOutputStream, th);
                            throw th2;
                        }
                    }
                }
                z60Var.s(30, byteArray);
                return;
            default:
                nz1 nz1Var = (nz1) obj;
                String str7 = nz1Var.a;
                if (str7 == null) {
                    z60Var.g(1);
                } else {
                    z60Var.e(1, str7);
                }
                z60Var.e(2, nz1Var.b);
                return;
        }
    }
}
