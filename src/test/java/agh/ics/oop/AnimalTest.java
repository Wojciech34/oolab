package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void AnimalTesting1() throws Exception {
        String[] s1 = new String[]{"a", "b", "c", "f", "f",
                "b", "f", "3", "!", "ghifrj", "l", "f", "r", "v"};
        ArrayList<World.MoveDirection> test1 = new ArrayList<>();
        test1.add(World.MoveDirection.BACKWARD);
        test1.add(World.MoveDirection.FORWARD);
        test1.add(World.MoveDirection.FORWARD);
        test1.add(World.MoveDirection.BACKWARD);
        test1.add(World.MoveDirection.FORWARD);
        test1.add(World.MoveDirection.LEFT);
        test1.add(World.MoveDirection.FORWARD);
        test1.add(World.MoveDirection.RIGHT);
        assertEquals(test1, OptionsParser.parse(s1));
        Animal animal1 = new Animal();
        for(World.MoveDirection direct : test1){
            animal1.move(direct);
        }
        assertEquals( "Północ,(1,3)",animal1.toString());
    }
    @Test
    public void AnimalTesting2() throws Exception {
        String[] s2 = new String[101];
        for (int i = 0; i < 100; i++) {
            s2[i] = "f";
        }
        s2[100] = "l";
        ArrayList<World.MoveDirection> test2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            test2.add(World.MoveDirection.FORWARD);
        }
        test2.add(World.MoveDirection.LEFT);
        assertEquals(test2, OptionsParser.parse(s2));
        Animal animal2 = new Animal();
        for(World.MoveDirection direct : test2){
            animal2.move(direct);
        }
        assertEquals( "Zachód,(2,4)",animal2.toString());
    }
    @Test
    public void AnimalTesting3() throws Exception {
        String[] s3 = new String[21];
        for(int i=0; i<10; i++){
            s3[2*i] = "l";
            s3[2*i+1] = "m";
        }
        s3[20] = "b";
        ArrayList<World.MoveDirection> test3 = new ArrayList<>();
        for(int i=0; i<10; i++){
            test3.add(World.MoveDirection.LEFT);
        }
        test3.add(World.MoveDirection.BACKWARD);
        assertEquals(test3, OptionsParser.parse(s3));
        Animal animal3 = new Animal();
        for(World.MoveDirection direct : test3){
            animal3.move(direct);
        }
        assertEquals( "Południe,(2,3)",animal3.toString());

    }
}
