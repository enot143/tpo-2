package functions;

import exceptions.FunctionsException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.util.LinkedHashMap;
import java.util.Map;

public class CSVWriter {

    private static Map<String, String> calculate(Function func, double start, double finish, double step) {

        Map<String, String> map = new LinkedHashMap<>();

        map.put("X", "Результат модуля (X)");

        for (double i = start; i <= finish; i += step) {
            try {
                map.put(String.valueOf(i), String.valueOf(func.calc(i)));
            } catch (FunctionsException e) {
                map.put(String.valueOf(i), "NaN");
            }
        }

        return map;
    }

    public static void writeCSV(Function func, double start, double finish, double step) {

        Map<String, String> map = calculate(func, start, finish, step);

        try (Writer writer = new FileWriter("results/" + func.toString() + ".csv")) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue())
                        .append('\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

}
