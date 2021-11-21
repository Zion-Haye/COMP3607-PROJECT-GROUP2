package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class StudentTest {

    Student student = new Student("654321", "John Doe", "1234567");

    @Test
    public void testStudentInstatiation() {
        System.out.println("Test: Student Instantiation");
        assertNotNull(student);
    }

    @Test
    public void testIsFoundFalse() {
        System.out.println("Test: IsFound (False)");
        assertFalse(student.isFound());
    }

    @Test
    public void testIsFoundTrue() {
        System.out.println("Test: IsFound (True)");
        student.setFound(true);
        assertTrue(student.isFound());
    }

    @Test
    public void testParticipantIdentifierNumber() {
        System.out.println("Test: Get Participant Identifier Number");
        assertEquals("654321", student.getParticipantIdentifierNum());
    }

    @Test
    public void testIDNumber() {
        System.out.println("Test: Get ID Number");
        assertEquals("1234567", student.getIdNumber());
    }

    @Test
    public void testFullNameArray() {
        System.out.println("Test: Full Name Array");
        ArrayList<String> fullNamesArray = new ArrayList<String>();
        fullNamesArray.add("John");
        fullNamesArray.add("Doe");
        assertEquals(fullNamesArray, student.getFullName());
    }

    @Test
    public void testFullNameString() {
        System.out.println("Test: Full Name String");
        String fullNameString = "John Doe";
        assertEquals(fullNameString, student.getFullNameString());
    }

}
