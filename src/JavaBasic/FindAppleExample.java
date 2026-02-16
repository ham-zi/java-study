package JavaBasic;

import java.util.List;

public class FindAppleExample {

    public static void findApple(List<GetterExample.Fruit>list){
        for(GetterExample.Fruit f:list){
            if(f.isApple()){
                System.out.println("apple's stock is " + f.getStock() + "EA.");
                return;
            }
            if(f.outOfStock()){
                System.out.println(f.getName() + "is out of stock.");
            }
        }
    }

    public static void main(String[] args){
    List<GetterExample.Fruit>Fruits = List.of(
            new GetterExample.Fruit("mango",3),
            new GetterExample.Fruit("watermelon",2),
            new GetterExample.Fruit("strawberry",7),
            new GetterExample.Fruit("apple",5),
            new GetterExample.Fruit("pumpkin",1)
    );
        findApple(Fruits);
    }

}
