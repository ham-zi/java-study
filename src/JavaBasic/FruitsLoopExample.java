package JavaBasic;

import java.util.List;

public class FruitsLoopExample {


    public static void printFruits(List<String>list){
        for (String fruit:list){
            System.out.println(fruit);
            if(fruit.equals("apple")){
                System.out.println("found apple");
                break;
            }
        }
    }


    public static void main(String[] args){
        List<String>fruits = List.of("blueberry","watermelon", "lemon", "apple", "mango");
        printFruits(fruits);
    }
}
