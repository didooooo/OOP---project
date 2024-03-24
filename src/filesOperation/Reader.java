package filesOperation;

import java.util.HashMap;
import java.util.Map;

public interface Reader {
    Map<String,String> read(String path);
}
