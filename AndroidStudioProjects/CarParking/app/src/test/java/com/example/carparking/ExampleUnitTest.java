package com.example.carparking;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    @Mock
    private register myClass;
    @Test
    public void testMyMethod1() {
        when(myClass.getVehicleNumber()).thenReturn("KA19MA7088");
        assertEquals("KA19MA7088", myClass.getVehicleNumber());
    }
    @Test
    public void testMyMethod2() {
        when(myClass.getVehicleNumber()).thenReturn("KA20MA7088");
        assertEquals("KA20MA7088", myClass.getVehicleNumber());
    }
    @Test
    public void testMyMethod3() {
        when(myClass.getVehicleNumber()).thenReturn("KA20MA7087");
        assertEquals("KA20MA7087", myClass.getVehicleNumber());
    }
    
}
