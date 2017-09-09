package top.jhechem.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author wuqiang
 * @version 1.0.0
 */
public class SerializeUtils {

    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }
        byte[] result = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream os = new ObjectOutputStream(bos)) {
            os.writeObject(object);
            result = bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize(byte[] in) {
        Object result;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(in);
             ObjectInputStream is = new ObjectInputStream(bis)) {
            result = is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return (T) result;
    }

}
