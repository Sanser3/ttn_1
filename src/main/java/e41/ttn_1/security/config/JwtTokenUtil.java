//package e41.ttn_1.security.config;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtTokenUtil implements Serializable {
//
//    private static final long serialVersionUID = -2550185165626007488L;
//
//    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    //получение имени пользователя из jwt-токена
//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    //получение даты истечения срока действия из jwt-токена
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//    //Для получения любой информации из токена нам потребуется секретный ключ
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//    }
//
//    //проверка истечения срока действия токена
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//
//    //генерировать токен для пользователя
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return doGenerateToken(claims, userDetails.getUsername());
//    }
//
//    //при создании токена -
//    //1. Определите требования к токену, такие как Issuer, Expiration, Subject и ID
//    //2. Подпишите JWT, используя алгоритм HS512 и секретный ключ.
//    //3. Согласно JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
//    // уплотнение JWT до безопасной для URL строки
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    //подтвердить токен
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = getUsernameFromToken(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//}