/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.si.mathutil.core;

import static com.si.mathutil.core.MathUtil.*; 
//import static là dành riêng cho những hàm static , gọi hàm mà bỏ qua tên class  

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


/**
 *
 * @author tim
 */
public class MathUtilTest { 
    
    // Phiên bản chưa có DDT
//    @Test 
//    public void testGetFactorialGivenRightArgReturnsWell() {
//        assertEquals(24, MathUtil.getFactorial(4));
//    }
    
    // Chơi DDT ( Data Driven Testing) : tách data ra khỏi câu lệnh kiểm thử
    // , tham số hoá data này vào trong câu lệnh kiểm thử
    
    // chuẩn bị bộ Data
    public static Object[][] initData() {
        return new Integer[][] {
                {1, 1},
                {2, 2},
                {5, 120},
                {6, 720}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") // tên hàm cung cấp data , ngầm định thứ tự 
                                  // của các phần tử mảng, map vào tham số hàm.
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    
    
     
    // @Test(expected = tên ngoại lệ.class) :cách cũ của JUnit 4, JUnit 5 ko sài vậy 
    @Test 
    public void testGetFactorialGivenWrongArgThrowException() { // Bắt ngoại lệ khi đưa data cà chớn
        // Sài biểu thức Lambda, hàm nhận tham số thứ 2 là 1 cái Object có code
        // Implement functional interface tên là Executable - có 1 hàm duy nhât ko code tên là Execute()
        
        /* Chơi chậm
        Executable exObject = new Executable(){
            @Override
            public void execute() throws Throwable {
                getFactorial(-5);
            }
        };
        */
        
        //Executable exObject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
        
        
    }
    
}
