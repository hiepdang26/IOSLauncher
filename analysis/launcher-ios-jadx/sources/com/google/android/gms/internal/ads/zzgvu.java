package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import com.google.android.gms.internal.ads.zzgvu;
import com.google.android.gms.internal.ads.zzgvv;
import defpackage.uo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgvu<MessageType extends zzgvv<MessageType, BuilderType>, BuilderType extends zzgvu<MessageType, BuilderType>> implements zzgzi {
    private String zza(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size = list.size();
        for (T t : iterable) {
            if (t == null) {
                String strD = uo.d(list.size() - size, "Element at index ", " is null.");
                int size2 = list.size();
                while (true) {
                    size2--;
                    if (size2 < size) {
                        throw new NullPointerException(strD);
                    }
                    list.remove(size2);
                }
            } else {
                list.add(t);
            }
        }
    }

    public static zzhar zzbb(zzgzj zzgzjVar) {
        return new zzhar(zzgzjVar);
    }

    @Deprecated
    public static <T> void zzbc(Iterable<T> iterable, Collection<? super T> collection) {
        zzbd(iterable, (List) collection);
    }

    public static <T> void zzbd(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = zzgyl.zzb;
        iterable.getClass();
        if (!(iterable instanceof zzgyv)) {
            if (iterable instanceof zzgzs) {
                list.addAll((Collection) iterable);
                return;
            } else {
                zzb(iterable, list);
                return;
            }
        }
        List listZza = ((zzgyv) iterable).zza();
        zzgyv zzgyvVar = (zzgyv) list;
        int size = list.size();
        for (Object obj : listZza) {
            if (obj == null) {
                String strD = uo.d(zzgyvVar.size() - size, "Element at index ", " is null.");
                int size2 = zzgyvVar.size();
                while (true) {
                    size2--;
                    if (size2 < size) {
                        throw new NullPointerException(strD);
                    }
                    zzgyvVar.remove(size2);
                }
            } else if (obj instanceof zzgwm) {
                zzgyvVar.zzb();
            } else if (obj instanceof byte[]) {
                byte[] bArr2 = (byte[]) obj;
                zzgwm.zzv(bArr2, 0, bArr2.length);
                zzgyvVar.zzb();
            } else {
                zzgyvVar.add((String) obj);
            }
        }
    }

    @Override // 
    /* JADX INFO: renamed from: zzaC, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract BuilderType zzaP();

    public abstract BuilderType zzaD(MessageType messagetype);

    public BuilderType zzaE(zzgwm zzgwmVar) throws zzgyn {
        try {
            zzgww zzgwwVarZzl = zzgwmVar.zzl();
            zzaR(zzgwwVarZzl);
            zzgwwVarZzl.zzy(0);
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* JADX INFO: renamed from: zzaF, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaR(zzgww zzgwwVar) {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return (BuilderType) zzaW(zzgwwVar, zzgxi.zza);
    }

    /* JADX INFO: renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaS(zzgzj zzgzjVar) {
        if (zzbt().getClass().isInstance(zzgzjVar)) {
            return (BuilderType) zzaD((zzgvv) zzgzjVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public BuilderType zzaH(InputStream inputStream) {
        zzgww zzgwwVarZzG = zzgww.zzG(inputStream, MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
        zzaR(zzgwwVarZzG);
        zzgwwVarZzG.zzy(0);
        return this;
    }

    /* JADX INFO: renamed from: zzaI, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaU(byte[] bArr) {
        return (BuilderType) zzaZ(bArr, 0, bArr.length);
    }

    public BuilderType zzaJ(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        try {
            zzgww zzgwwVarZzl = zzgwmVar.zzl();
            zzaW(zzgwwVarZzl, zzgxiVar);
            zzgwwVarZzl.zzy(0);
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    @Override // 
    /* JADX INFO: renamed from: zzaK, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType zzaW(zzgww zzgwwVar, zzgxi zzgxiVar);

    public BuilderType zzaL(InputStream inputStream, zzgxi zzgxiVar) {
        zzgww zzgwwVarZzG = zzgww.zzG(inputStream, MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
        zzaW(zzgwwVarZzG, zzgxiVar);
        zzgwwVarZzG.zzy(0);
        return this;
    }

    /* JADX INFO: renamed from: zzaM, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaY(byte[] bArr, zzgxi zzgxiVar) {
        return (BuilderType) zzba(bArr, 0, bArr.length, zzgxiVar);
    }

    @Override // 
    /* JADX INFO: renamed from: zzaN, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaZ(byte[] bArr, int i, int i2) throws zzgyn {
        try {
            zzgww zzgwwVarZzH = zzgww.zzH(bArr, i, i2, false);
            zzaR(zzgwwVarZzH);
            zzgwwVarZzH.zzy(0);
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    @Override // 
    /* JADX INFO: renamed from: zzaO, reason: merged with bridge method [inline-methods] */
    public BuilderType zzba(byte[] bArr, int i, int i2, zzgxi zzgxiVar) throws zzgyn {
        try {
            zzgww zzgwwVarZzH = zzgww.zzH(bArr, i, i2, false);
            zzaW(zzgwwVarZzH, zzgxiVar);
            zzgwwVarZzH.zzy(0);
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public /* bridge */ /* synthetic */ zzgzi zzaQ(zzgwm zzgwmVar) throws zzgyn {
        zzaE(zzgwmVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzi zzaT(InputStream inputStream) {
        zzaH(inputStream);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzi zzaV(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        zzaJ(zzgwmVar, zzgxiVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzi zzaX(InputStream inputStream, zzgxi zzgxiVar) {
        zzaL(inputStream, zzgxiVar);
        return this;
    }

    public boolean zzbe(InputStream inputStream) {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return zzbf(inputStream, zzgxi.zza);
    }

    public boolean zzbf(InputStream inputStream, zzgxi zzgxiVar) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            return false;
        }
        zzaL(new zzgvt(inputStream, zzgww.zzE(i, inputStream)), zzgxiVar);
        return true;
    }
}
