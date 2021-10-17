import com.esotericsoftware.kryo.Kryo;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;

@UtilityClass
public class CloneUtil {

    static Kryo kryo = new Kryo();

    static {
        kryo.setRegistrationRequired(false);
    }

    @SneakyThrows
    public static <T> T clone(T old)  {
        return kryo.copy(old);
    }
}
