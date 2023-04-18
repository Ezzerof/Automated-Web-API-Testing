package api.jamestests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class PostReqStarter {
  static Map<String, String> map;
  public static Map<String, String> starter(){

    ObjectMapper object = new ObjectMapper();
    String file = "src/test/resources/user.json";

    String json;
    try {
      json = readFileAsString(file);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    try {
      map = object.readValue(json, Map.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

  return map;
  }

  public static String readFileAsString(String file)throws Exception
  {
    return new String(Files.readAllBytes(Paths.get(file)));
  }

}
