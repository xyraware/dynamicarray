public class testVector<E> {
    public static void main(String[] args){
        String[] testArrString=new String[]{ "суббота",  "понедельник","воскресенье","ВТОРНИК","среда"};
        int[] testArrValue=new int[]{56,3,90,45678};
        myVector test=new myVector(testArrString,testArrString.length,10);
        System.out.println("\nДинамический массив"+test);
        test.delete(2);
        System.out.println("\nУдаление второго элемента"+test);
        test.add(1,testArrValue[0]);
        System.out.println("\nДобавление первого элемента"+test);
        test.delete(test.currentValue);
        System.out.println("\nУдаление последнего элемента"+test);
        test.add(test.currentValue,testArrValue[2]);
        System.out.println("\nДобавление последнего элемента"+test);
        test.delete(1);
        System.out.println("\nУдаление первого элемента"+test);
        test.add(3,testArrValue[1]);
        System.out.println("\nДобавление третьего элемента"+test);
    }
}
