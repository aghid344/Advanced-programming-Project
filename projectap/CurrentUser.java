/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectap;


public class CurrentUser {
    private static int userId;

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        CurrentUser.userId = userId;
    }

}
