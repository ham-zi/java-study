package GptCodingTest;

import java.util.List;

public class TenOverPrint {

//    public static Integer tenOverList(List<Integer>list){
//        list.stream()
//                .filter(Integer r-> r.get() > 10 )
//    } //생성자 없이 stream()을 사용하려니 getter도 없고 생성자 메서드도 없고 어렵다.


    public static void printTenOverList(List<Integer>list){
        for (Integer i: list){
            if (i > 10) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3,7,12,18,1,25,9);
        printTenOverList(numbers);
    }

}
