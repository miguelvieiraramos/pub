import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.List;

public class GsonClient<T> implements SerializerInterface<T> {
    private Gson gson = new Gson();

    public void write(List<T> list, String fileName) {
        String json = this.gson.toJson(list);
        this.writeFile(json, fileName);
    }

    private void writeFile(String json, String fileName) {
        OutputStream byteWriter = null;
        OutputStreamWriter characterWriter = null;
        BufferedWriter wordWriter = null;
        try {
            byteWriter = new FileOutputStream(fileName);
            characterWriter = new OutputStreamWriter(byteWriter);
            wordWriter = new BufferedWriter(characterWriter);
            wordWriter.write(json);
            wordWriter.newLine();
            wordWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (wordWriter != null) {
                    wordWriter.close();
                }
                if (characterWriter != null) {
                    characterWriter.close();
                }
                if (byteWriter != null) {
                    characterWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<T> read(String fileName, Class className) {
        InputStream byteReader = null;
        InputStreamReader characterReader = null;
        BufferedReader wordReader = null;
        try {
            byteReader = new FileInputStream(fileName);
            characterReader = new InputStreamReader(byteReader);
            wordReader = new BufferedReader(characterReader);
            String content = wordReader.readLine();
            return this.gson.fromJson(content, TypeToken.getParameterized(List.class, className).getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (byteReader != null) {
                    byteReader.close();
                }
                if (characterReader != null) {
                    characterReader.close();
                }
                if (wordReader != null) {
                    wordReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
