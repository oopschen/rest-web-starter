package oopschen.archetype.web.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * <p>login utils</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public abstract class LoginUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUtil.class);

    private LoginUtil() {
    }

    /**
     * <p>encode login secret based on sha256(ip+userID+randomNumber)</p>
     *
     * @param remoteIP
     * @param userID
     * @return
     */
    public static final String encodeLoginSecret(String remoteIP, String userID, long random) {
        if (StringUtils.isBlank(remoteIP) || StringUtils.isBlank(userID)) {
            return null;
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] bytes = null;

        try {
            dataOutputStream.writeChars(remoteIP);
            dataOutputStream.writeChars(userID);
            dataOutputStream.writeLong(random);
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            LOGGER.error("encodeLoginSecret io", e);
        } finally {
            try {
                dataOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                LOGGER.error("encodeLoginSecret io close", e);
            }
        }

        return null != bytes && 0 < bytes.length ? DigestUtils.sha256Hex(bytes) : null;
    }
}
