package com.example.carparking;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmailValidation {
    @Mock
    private Login loginActivity;


    @Test
    public void testGetEmail_ReturnsEnteredEmail() {
        String enteredEmail = "test@example.com";
        when(loginActivity.getEmail()).thenReturn(enteredEmail);
        assertEquals(enteredEmail, loginActivity.getEmail());
    }

    @Test
    public void testGetEmail_ReturnsEmptyStringIfNoEmailEntered() {
        String enteredEmail = "";
        when(loginActivity.getEmail()).thenReturn(enteredEmail);
        assertEquals("", loginActivity.getEmail());
    }

    //invalid case
//    @Test
//    public void testGetEmail_ReturnsNullIfEmailFormatIsInvalid() {
//
//        String enteredEmail = "invalid_email";
//        when(loginActivity.getEmail()).thenReturn(enteredEmail);
//        String email = loginActivity.getEmail();
//
//        assertEquals(null, email);
//    }
//

  //invalid case
//    @Test
//    public void testGetEmail_ReturnsNullIfEmailDoesNotContainAtSymbol() {
//
//        String enteredEmail = "testexample.com";
//        when(loginActivity.getEmail()).thenReturn(enteredEmail);
//
//        String email = loginActivity.getEmail();
//        assertEquals(null, email);
//    }

    //invalid case
//      @Test
//      public void testGetEmail_ReturnsNullIfEmailBeginsWithAtSymbol() {
//
//          String enteredEmail = "@testexample.com";
//          when(loginActivity.getEmail()).thenReturn(enteredEmail);
//
//          String email = loginActivity.getEmail();
//
//          assertEquals(null, email);
//      }

//    @Test
//    public void testGetEmail_ReturnsNullIfEmailEndsWithAtSymbol() {
//        String enteredEmail = "testexample.com@";
//        when(loginActivity.getEmail()).thenReturn(enteredEmail);
//        String email = loginActivity.getEmail();
//        assertEquals(null, email);
//    }








}

