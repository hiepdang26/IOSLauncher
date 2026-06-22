package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import defpackage.vb1;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
final class GsonResponseBodyConverter<T> implements Converter<vb1, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    @Override // retrofit2.Converter
    public T convert(vb1 vb1Var) {
        JsonReader jsonReaderNewJsonReader = this.gson.newJsonReader(vb1Var.charStream());
        try {
            T t = this.adapter.read2(jsonReaderNewJsonReader);
            if (jsonReaderNewJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return t;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            vb1Var.close();
        }
    }
}
