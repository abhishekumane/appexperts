package sudoku_checker;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Read_file {

    private String file;
    private List<List> sudoku_list = new ArrayList();

    public Read_file(String file){
        this.file = file;
    }

    public List<List> read(){
        File lines = new File(file);

        try {
            FileReader fr = new FileReader(lines);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null){

                String[] numberArray = line.split(",");
                sudoku_list.add(Arrays.asList(numberArray));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sudoku_list;
    }

}
