

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> fileData = getFileData("src/file");
        System.out.println(fileData);
        for(int i = 0; i<fileData.size();i++){
            int e =0;
            ArrayList<String>temp = fileData;
            while(e<temp.get(i).length()){
                if(temp.get(i).contains(" ")){
                nums.add(Integer.parseInt(fileData.get(i).substring(e,temp.get(i).indexOf(" "))));
                temp.set(i,temp.get(i).substring(temp.get(i).indexOf(" ")+1));
                }else{
                    nums.add(Integer.parseInt(temp.get(i)));
                    e=Integer.MAX_VALUE;
                }
            }
            nums=new ArrayList<>();
            System.out.println(nums);
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
