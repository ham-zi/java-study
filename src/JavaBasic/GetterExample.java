package JavaBasic;

import java.util.List;

public class GetterExample {

    public static class Fruit{
        String name;
        int stock;


         public boolean outOfStock(){
             return stock == 0;
         }

         public  int getStock(){
             return stock;
         }

         public  boolean isApple(){
             return name.equals("apple");
         }

         public String getName(){
             return  name;
         }

        public  Fruit(String name,int stock) {
            this.name = name;
            this.stock = stock;
        }
    }

    public static void findApple(List<Fruit>list){
        for (Fruit f:list) {
            if (f.name.equals("apple")) {
                if (f.stock > 0) {
                    System.out.println("apple stock is " + f.stock + "EA");
                }else{
                    System.out.println("apple is out of stock");

                }break;
            }
            if (f.stock == 0 ){
                continue;
            }

        }
    }

    public static void main(String[] args){
        List<Fruit>fruits = List.of (
                new Fruit("watermelon",0),
                new Fruit("lemon",3),
                new Fruit("apple",0),
                new Fruit("blueberry",0),
                new Fruit("mango", 11)
        );
        findApple(fruits);
        }
}

