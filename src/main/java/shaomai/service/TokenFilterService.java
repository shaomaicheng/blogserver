package shaomai.service;

public interface TokenFilterService {
    boolean verifToken(String userId,String time, String token);

    String generateToken(String userId, String currentTime);
}
