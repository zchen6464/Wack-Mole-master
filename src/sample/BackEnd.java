package sample;

import java.io.*;
import java.util.ArrayList;


public class BackEnd {
    String temp = "";
    ArrayList<String> stringList = new ArrayList<>();
    public BackEnd() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/sample/scores.txt"))))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[]tempArr = line.split("\\*");
                for (int i = 0; i < tempArr.length; i++)
                {
                    System.out.println(tempArr[i]);
                    stringList.add(tempArr[i]);
                }
            }
            for (int i = 0; i < stringList.size(); i++)
            {
                temp += stringList.get(i) + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write(String temp)
    {
        try {
            FileWriter writer = new FileWriter("src/sample/scores.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < stringList.size(); i++)
            {
                bufferedWriter.write(stringList.get(i) + "*");
            }
            bufferedWriter.write(temp);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
}
