package org.pvgus.crypto;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RsaCrypto {

    private static final String keyAlgorithm = "RSA";
    public static final String stringKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCLAuCk2C+prKEiT8yqaWPRBpNfi7QZxJJ0sO5u3gEl/vYYqC9JdgaCCEOqElK2HPvMNQ7Jar1VjbrmbR3r075g6vzZileMs+1yysd1/HO/RizSiVnBgU0Tv++CW6Gfg+L+8kh9+sQ9AeFZ6JzzrRACzdq+Wh6WRHGUSRVDv3qX0W3+08EPbs7kURHef6fDMMd8jKfV4MCRmYFscNzdenKQgNhAidaxgapx+d/qCB/+a9MbrJsL9e3OHKoN8GA3P2PRuNOn5EBKIMZwemCbF7anI4zYPwPLAfS+dakgMcepDc8PvSkbrmnGqvUjd2Bh65hHrZ7/9tFfmzyeXH0Kw6b/AgMBAAECggEAVzNz5hRzObW/0r1KPvAjnGDKm9oQHUXxNWA0Aboj8EjS6b6/Aw8VoAY9I/egiPr/fScfYnwhzwQ8ZQW4ClJmj3d5K6Gbr/jCkAriOoIlvavwvBVLB5br2eLCBP0kEuNxxsoHbXecGEUQrwy7QCSk8Y1elaAEpfDDaui5fSklZwwZWZ/fgjxErh03cz8xsvq4lQgIbs+FhRyDyfVy4UcLvwA7h1Cc5rOBB7eDJZI+EreCtpeoGvqC6ZOuxXlb9f5D8J0mCK7Y/hUVBoAgar8cfWAx58warSm1qzKa8EQQHit548lmTj/qStjboPfqtshkR96B9IQ6V+KSRzP0N8qYMQKBgQDjtyo8cVU71JL3rj3PgbD5XlnBkRi/KMEiNBbfCl2tDwkeYQ2VbKkKoOUJWAHr9S6EeU+ccI4icZAhZkloMc7UNa+8IwVCfnNd7VjUb9bqitQbQdjD9QhTlZO47QuLKsDHeJIk7TViMjCu+L3WyNrtvV+dtcMAmiTDFajt/LkReQKBgQCcRx55OkaKXCSQli1tNj6N/+gag7l5ywVDadYcJVWxWTdY+6Y/sQhGedfmsquSI7HOZmtf61nCYa68nlxUKrafMlGFU+iW21aCWdBMLj66fCpJAYK/YfmvxnAB53J6U5LNpW6w9ytE5jAelsEcjtois69Kjp4n1lBO5IFY9+SWNwKBgGDKzZAtmE47OFFBZhKbDO+idEJ7+2nd1+JDA+nAjTrvZi/cjxqRunTDGTfUidSTPjefHQDhMvlfDiW0RcWdTk4Tl+Q/eo/eEgm9xoFeHJtLcYc4gPwiXmyw6r6zO7Hm9VSUYoKBtaxMqzbkkkUG0VA2q7rstLu/yZqGzWyDfOL5AoGAK199sK2g2FO8fjiAARiWAfktZPZ8KrZTDqO4HfWqs98MAnFNcc3jexPj/Q5Hmfa4KY25bVS3g8Byq7zT6TQ1nTds8rEYE45qkyD0M8B9/mnpnnuB2zYJA2Tyv0SKPDMnwlWQxCLFaojsgADdNdzb49e05d9xO6M6hLrcv2GFmr8CgYEAsJmJQKE328GThOEENr6/YvoKpTTvgTMadPCaz+3YiU8nCZFWIUF+898Xf1wUEUK7CUkmewafJydeolPDIId/Fqc/MD8jvxst7y8q4BkxoUc6n4JL/KVMmJjBGcCrTTKGBZUYx5xdbFJ49vLHDFcbcOMUAIC6AQcOkS3H7clSr1M=";

    public static String sign(String str) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        final PrivateKey key = KeyFactory
                .getInstance(keyAlgorithm)
                .generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(stringKey.getBytes(StandardCharsets.UTF_8))));
        String signatureType = "SHA256withRSA";
        Signature signature = Signature.getInstance(signatureType);
        signature.initSign(key);
        signature.update(str.getBytes());
        return new String(Base64.getEncoder().encode(signature.sign()));
    }
}
