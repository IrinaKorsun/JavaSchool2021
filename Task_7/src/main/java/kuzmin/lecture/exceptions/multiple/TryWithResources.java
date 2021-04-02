package kuzmin.lecture.exceptions.multiple;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TryWithResources {
    public static void main(String[] args) {
        String s = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }


        System.out.println(s);
    }
}
