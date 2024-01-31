import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class UniqueId {
    public static long getUniqueId() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }
}
