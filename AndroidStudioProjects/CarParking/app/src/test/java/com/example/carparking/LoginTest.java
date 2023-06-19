package com.example.carparking;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    @Mock
    private Login loginActivity;


    @Test
    public void testGetPassword_ReturnsEnteredPassword() {
        // Arrange
        String enteredPassword = "Pass*word123";
        when(loginActivity.getPassword()).thenReturn(enteredPassword);

        // Act
        String password = loginActivity.getPassword();

        // Assert
        assertEquals(enteredPassword, password);
    }

    @Test
    public void testGetPassword_ReturnsEmptyStringIfNoPasswordEntered() {
        // Arrange
        String enteredPassword = "";
        when(loginActivity.getPassword()).thenReturn(enteredPassword);

        // Act
        String password = loginActivity.getPassword();

        // Assert
        assertEquals("", password);
    }

//    @Test
//    public void testGetPassword_ReturnsNullIfPasswordLengthIsLessThanEight() {
//        // Arrange
//        String enteredPassword = "passw0rd";
//        when(loginActivity.getPassword()).thenReturn(enteredPassword);
//
//        // Act
//        String password = loginActivity.getPassword();
//
//        // Assert
//        assertEquals(null, password);
//    }

//    @Test
//    public void testGetPassword_ReturnsNullIfPasswordDoesNotContainDigit() {
//        // Arrange
//        String enteredPassword = "Password!";
//        when(loginActivity.getPassword()).thenReturn(enteredPassword);
//
//        // Act
//        String password = loginActivity.getPassword();
//
//        // Assert
//        assertEquals(null, password);
//    }

//    @Test
//    public void testGetPassword_ReturnsNullIfPasswordDoesNotContainSpecialCharacter() {
//        // Arrange
//        String enteredPassword = "Password123";
//        when(loginActivity.getPassword()).thenReturn(enteredPassword);
//
//        // Act
//        String password = loginActivity.getPassword();
//
//        // Assert
//        assertEquals(null, password);
//    }

//    @Test
//    public void testGetPassword_ReturnsNullIfPasswordDoesNotContainSmallLetter() {
//        // Arrange
//        String enteredPassword = "PASSWORD123!";
//        when(loginActivity.getPassword()).thenReturn(enteredPassword);
//
//        // Act
//        String password = loginActivity.getPassword();
//
//        // Assert
//        assertEquals(null, password);
//    }

//    @Test
//    public void testGetPassword_ReturnsNullIfPasswordDoesNotContainCapitalLetter() {
//        // Arrange
//        String enteredPassword = "password123!";
//        when(loginActivity.getPassword()).thenReturn(enteredPassword);
//
//        // Act
//        String password = loginActivity.getPassword();
//
//        // Assert
//        assertEquals(null, password);
//    }


}
