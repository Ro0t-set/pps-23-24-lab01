import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CicularListImpl;
import tdd.CircularList;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;



    @BeforeEach
    void circularListCreation(){
        circularList = new CicularListImpl();
    }


    @Test
    void isInitialEmpty(){

        assertTrue(circularList.isEmpty());
        assertEquals(0, circularList.size());
        
    }

    @Test 
    void addElement(){
        circularList.add(0);
        assertEquals(1, circularList.size());
        assertFalse(circularList.isEmpty());

    }



}
