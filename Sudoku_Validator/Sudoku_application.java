package sudoku_checker;

import java.util.List;

public class Sudoku_application {

    public static void main(String[] args) {
        System.out.println("test");

        Read_file read_file = new Read_file("sudoku.csv");
        List<List> file = read_file.read();
        Format_check format_check = new Format_check(file);
        Sudoku_logic logic = new Sudoku_logic(file);

        Boolean correct_format = format_check.run();
        if (correct_format){
            logic.run();
        }
    }
}
