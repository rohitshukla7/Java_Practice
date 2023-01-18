import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "data.csv";
        String line = "";
        String cvsSplitBy = ",";
        boolean firstLine = true;
        String[] keys = null;
        LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                if (firstLine) {
                    keys = data;
                    firstLine = false;
                    continue;
                }
                // store data in LinkedHashMap
                for(int i = 0; i < data.length; i++){
                    dataMap.put(keys[i], data[i]);
                }
            }
            //print the data stored in map
            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
