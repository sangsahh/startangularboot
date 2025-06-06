package ko.spring.start.startangularboot.global.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import ko.spring.start.startangularboot.global.config.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties  jwtProperties;

    public String generateToken(String userId) {
        Claims claims = Jwts.claims().setSubject(userId);
        Date now = new Date();
        Date expiration = new Date(now.getTime() + jwtProperties.getExpiration());

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
            .compact();
    }

    public String getUserId(String token){
        return Jwts.parser().setSigningKey(jwtProperties.getSecret())
            .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
