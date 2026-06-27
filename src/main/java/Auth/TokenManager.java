package Auth;


public class TokenManager {

     private static ThreadLocal<String> token = new ThreadLocal<>();
    private static ThreadLocal<Long> expiryTime = new ThreadLocal<>();

    public static void setToken(String t, long expiresInSeconds) {

        token.set(t);

        long expiry = System.currentTimeMillis()
                + (expiresInSeconds * 1000);

        expiryTime.set(expiry);
    }

    public static String getToken() {
        return token.get();
    }

    public static boolean isTokenExpired() {

        Long expiry = expiryTime.get();

        if (expiry == null) {
            return true;
        }

        return System.currentTimeMillis() >= expiry;
    }
}

