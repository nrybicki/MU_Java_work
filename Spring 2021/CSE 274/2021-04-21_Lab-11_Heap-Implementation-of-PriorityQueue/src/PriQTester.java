import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PriQTester {

    String[] words = { "bruxes", "myases", "mooing", "flotas", "aflame",
            "rebody", "mizuna", "shrank", "tromps", "miladi", "mustee",
            "arenes", "shifty", "wieldy", "skenes", "binocs", "tunica",
            "cosecs", "dinged", "bollox", "venule", "chyles", "racing",
            "gypsum", "givers", "gadget", "slangs", "malars", "yapper",
            "orrery", "hypoid", "holpen", "tilaks", "kissed", "henley",
            "grisly", "resole", "cocked", "kinema", "ritual", "meanly",
            "sopors", "haoles", "heezed", "silvae", "bolide", "ungual",
            "gnawer", "zibets", "pandan" };

    String[] smallArray = { "bruxes", "myases", "mooing", "flotas", "aflame" };

    @Test
    public void testPriQ() {
        PriQ queue = new PriQ();
        assertEquals(
                "PriQ [heap=[***NOT USED***, null, null, null, null, null, null, null, null, null, null], size=0]",
                queue.toString());
    }

    @Test
    public void testPriQInt() {
        PriQ queue = new PriQ(3);
        assertEquals("PriQ [heap=[***NOT USED***, null, null, null], size=0]",
                queue.toString());
    }

    @Test
    public void testPriQArray() {

        PriQ queue = new PriQ(smallArray);
        assertEquals(
                "PriQ [heap=[***NOT USED***, myases, flotas, mooing, bruxes, aflame], size=5]",
                queue.toString());
    }

    @Test
    public void testAdd() {
        PriQ queue = new PriQ();
        queue.add("bruxes");
        
        assertEquals(
                "PriQ [heap=[***NOT USED***, bruxes, null, null, null, null, null, null, null, null, null], size=1]",
                queue.toString());
        queue.add("myases");
        
        assertEquals(
                "PriQ [heap=[***NOT USED***, myases, bruxes, null, null, null, null, null, null, null, null], size=2]",
                queue.toString());
        queue.add("mooing");
        
        assertEquals(
                "PriQ [heap=[***NOT USED***, myases, bruxes, mooing, null, null, null, null, null, null, null], size=3]",
                queue.toString());
        queue.add("flotas");
        
        assertEquals(
                "PriQ [heap=[***NOT USED***, myases, flotas, mooing, bruxes, null, null, null, null, null, null], size=4]",
                queue.toString());
        queue.add("aflame");
        assertEquals(
                "PriQ [heap=[***NOT USED***, myases, flotas, mooing, bruxes, aflame, null, null, null, null, null], size=5]",
                queue.toString());
    }

    @Test
    public void testCheckCapacity() {
        PriQ queue = new PriQ(3);
        queue.add("bruxes");
        queue.add("myases");
        queue.add("mooing");
        assertEquals(
                "PriQ [heap=[***NOT USED***, myases, bruxes, mooing], size=3]",
                queue.toString());
        queue.add("flotas");
        assertEquals(
                "PriQ [heap=[***NOT USED***, myases, flotas, mooing, bruxes, null, null], size=4]",
                queue.toString());
        queue.add("aflame");
        assertEquals(
                "PriQ [heap=[***NOT USED***, myases, flotas, mooing, bruxes, aflame, null], size=5]",
                queue.toString());
    }

    @Test
    public void testRemove() {
        PriQ queue = new PriQ();
        assertNull(queue.remove());
        
        List<String> sorted = new ArrayList<>();
        
        for (String word : words) {
            queue.add(word);
            sorted.add(word);
        }
        
        Collections.sort(sorted);
        Collections.reverse(sorted);

        for (String word : sorted)
            assertEquals(word, queue.remove());
    }
    
    @Test
    public void testAddRemoveOneItem() {
        PriQ queue = new PriQ(4);
        
        queue.add("bruxes");        
        assertEquals(
                "PriQ [heap=[***NOT USED***, bruxes, null, null, null], size=1]",
                queue.toString());
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals("bruxes", queue.peek());
        
        assertEquals("bruxes", queue.remove());               
        assertEquals(
                "PriQ [heap=[***NOT USED***, null, null, null, null], size=0]",
                queue.toString());        
        assertNull(queue.remove());
        assertNull(queue.peek());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty()); 
    }

    @Test
    public void testPeek() {
        PriQ queue = new PriQ();
        assertNull(queue.peek());
        
        String[] wordsSorted = { "aflame", "bruxes", "flotas", "mooing",
                "myases" };

        for (String word : wordsSorted) {
            queue.add(word);
            assertEquals(word, queue.peek());
        }

        queue.add("aardvark");

        assertEquals("myases", queue.peek());
    }

    @Test
    public void testGetIndexOfFirstLeaf() {
        PriQ queue = new PriQ();
        assertEquals(-1, queue.getIndexOfFirstLeaf());

        for (String word : smallArray) {
            queue.add(word);
        }
        assertEquals(3, queue.getIndexOfFirstLeaf());

        queue = new PriQ();
        for (String word : words) {
            queue.add(word);
        }
        assertEquals(26, queue.getIndexOfFirstLeaf());
    }

    @Test
    public void testSize() {
        PriQ queue = new PriQ();
        for (int i = 0; i < words.length; i++) {
            assertEquals(i, queue.size());
            queue.add(words[i]);
        }

        for (int i = 0; i < words.length; i++) {
            assertEquals(words.length - i, queue.size());
            queue.remove();
        }

    }

}
