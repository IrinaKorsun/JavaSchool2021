//  Реализация очереди на массивах
//  Сравни скорость реализованного поштучного добавления в массив со ступенчатой имплементацией, посмотр как сделано в arraylist
//  Сравни скорость и исп. памяти при удалении из массива без сокращения его размера

package Filippov;

public class Stack {

    Object[] arr = new Object[0];
    public Stack() {
    }

    public Object top(){
//  Кидать эксепшн при попытке доступа к пустой очереди?
        return arr[0];
    }

    public void enqueue (Object obj) {
        Object[] newArr = new Object[arr.length + 1];
        newArr[arr.length] = obj;
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    public void dequeue () {
//  Кидать эксепшн при попытке удаления из пустой очереди?
        if (arr.length > 0) {
            Object[] newArr = new Object[arr.length - 1];
            System.arraycopy(arr, 1, newArr, 0, arr.length - 1);
            arr = newArr;
        }
    }

    public boolean isEmpty () {
        return arr.length <= 0;
    }


}
