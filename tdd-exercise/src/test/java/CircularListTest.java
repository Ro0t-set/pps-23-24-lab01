import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

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
        assertAll(
            ()->assertEquals(1, circularList.size()),
            ()->assertFalse(circularList.isEmpty())
        );

    }

    @Test
    void addMultipleElements(){
        int maxNumberOfElementAdded = 10;
        for(int numberOfElementAdded = 0; numberOfElementAdded < maxNumberOfElementAdded; numberOfElementAdded++){
            circularList.add(0);
        }
        assertAll(
            ()->assertEquals(maxNumberOfElementAdded, circularList.size()),
            ()->assertFalse(circularList.isEmpty())
        );
    }


    @Test
    void verifiedListForwardIteration(){
        int maxNumberOfElementAdded = 5;
        for(int numberOfElementAdded = 0; numberOfElementAdded < maxNumberOfElementAdded; numberOfElementAdded++){
            circularList.add(numberOfElementAdded);
        }
        
        for(int numberOfElementAdded = 0; numberOfElementAdded < maxNumberOfElementAdded-1; numberOfElementAdded++){
            circularList.next();
        }
        Optional<Integer> lasrElement = circularList.next();

        assertAll(
            ()-> assertTrue(lasrElement.isPresent()),
            ()-> assertEquals(maxNumberOfElementAdded-1, lasrElement.get())
        );
    }

    @Test
    void verifiedListCircolarForwardIteration(){
        int maxNumberOfElementAdded = 5;
        for(int numberOfElementAdded = 0; numberOfElementAdded < maxNumberOfElementAdded; numberOfElementAdded++){
            circularList.add(numberOfElementAdded);
        }
        
        for(int numberOfElementAdded = 0; numberOfElementAdded < (maxNumberOfElementAdded * 2) - 1; numberOfElementAdded++){
            circularList.next();
        }
        Optional<Integer> lasrElement = circularList.next();

        assertAll(
            ()-> assertTrue(lasrElement.isPresent()),
            ()-> assertEquals(maxNumberOfElementAdded-1, lasrElement.get())
        );
        
    }

    @Test
    void verifiedListBackIteration(){
        int maxNumberOfElementAdded = 5;
        for(int numberOfElementAdded = 0; numberOfElementAdded < maxNumberOfElementAdded; numberOfElementAdded++){
            circularList.add(numberOfElementAdded);
        }
        
        for(int numberOfElementAdded = 0; numberOfElementAdded < maxNumberOfElementAdded-1; numberOfElementAdded++){
            circularList.previous();
        }
        Optional<Integer> lasrElement = circularList.previous();

        assertAll(
            ()-> assertTrue(lasrElement.isPresent()),
            ()-> assertEquals(0, lasrElement.get())
        );
    }

    @Test
    void listEmptyAfterReset(){
        int maxNumberOfElementAdded = 5;
        for(int numberOfElementAdded = 0; numberOfElementAdded < maxNumberOfElementAdded; numberOfElementAdded++){
            circularList.add(numberOfElementAdded);
        }
        assertEquals(5, circularList.size());

        circularList.reset();

        assertTrue(circularList.isEmpty());
    }




}
