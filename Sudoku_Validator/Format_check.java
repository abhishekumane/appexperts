package sudoku_checker;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public class Format_check {

    private Boolean check = true;
    private List<List> sudoku;

    // Constructor passing list
    Format_check(List<List> sudoku){
        this.sudoku = sudoku;
    }

    // Try parse to integer
    private boolean tryParseInt(String value) {

        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Size correct number of numbers
    private void size_check(){

        if(sudoku.size() != 9){
            check = false;
            System.out.println(sudoku.size());
            System.out.println("Incorrect number of numbers");
        }
    }

    // Check each item in list is a number
    private void number_check(){

        for (List<String> list : sudoku){
            for (String number: list){
                if (tryParseInt(number) == false){
                    check = false;
                    System.out.println("Something other than a number found");
                }
            }
        }
    }

    // Check each item in list is a number
    private void number_count_check(){

        Integer counter = 0;
        for (List<String> list : sudoku){
            for (String number: list){
                counter++;
            }
            if (counter != 9){
                System.out.println("Invalid number of rows");
                check = false;
            }
            counter = 0;
        }
    }

    // Check for numbers between 1 and 9
    private void correct_value_check(){

        for (List<String> list : sudoku){
            for (String number: list){
                if (Integer.parseInt(number) < 1 ){
                    check = false;
                    System.out.println("Number less than one found");
                }
                if (Integer.parseInt(number) > 9 ){
                    check = false;
                    System.out.println("Number more than 9 found");
                }
            }
        }
    }

    // run the format checker
    public Boolean run(){

        size_check();
        number_count_check();
        number_check();
        if (check){
            correct_value_check();
        }
        return check;
    }

}
