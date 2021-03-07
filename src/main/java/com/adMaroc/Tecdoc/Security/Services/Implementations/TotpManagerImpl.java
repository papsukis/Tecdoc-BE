package com.adMaroc.Tecdoc.Security.Services.Implementations;

import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import com.adMaroc.Tecdoc.Security.Services.TotpManager;
import dev.samstevens.totp.code.*;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import dev.samstevens.totp.time.NtpTimeProvider;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.Date;

import static dev.samstevens.totp.util.Utils.getDataUriForImage;

@Slf4j
@Service
public class TotpManagerImpl implements TotpManager {


    @Override
    public String generateSecret() {
        SecretGenerator generator = new DefaultSecretGenerator();
        return generator.generate();
    }

    public String getUriForImage(String secret,String username) {
        QrData data = new QrData.Builder()
                .label(username)
                .secret(secret)
                .issuer("AdMaroc")
                .algorithm(HashingAlgorithm.SHA1)
                .digits(6)
                .period(300)
                .build();

        QrGenerator generator = new ZxingPngQrGenerator();
        byte[] imageData = new byte[0];

        try {
            imageData = generator.generate(data);
        } catch (QrGenerationException e) {
        }

        String mimeType = generator.getImageMimeType();

        return getDataUriForImage(imageData, mimeType);
    }

    public boolean verifyCode(String code, String secret) {
        TimeProvider timeProvider = null;
        try {
            timeProvider = new NtpTimeProvider("ma.pool.ntp.org");
        } catch (UnknownHostException e) {
            throw new InternalServerException(e.getMessage());
        }
        ;
        CodeGenerator codeGenerator = new DefaultCodeGenerator();
        DefaultCodeVerifier  verifier = new DefaultCodeVerifier(codeGenerator, timeProvider);
        verifier.setAllowedTimePeriodDiscrepancy(5);
        log.info(new Date(System.currentTimeMillis()).toString());
        return verifier.isValidCode(secret, code);
    }
}
