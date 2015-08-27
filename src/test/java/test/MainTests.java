package test;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;

/**
 * Created by stef on 18.06.2015.
 */
public class MainTests extends TestCase {

    @Test
    public void testMyZeug() {

        File file = new File("src/main/java/example.sam");

        assert file.exists();

    }
}
