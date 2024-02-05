/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Sofija Nedeljkovic
 */
public enum Operation implements Serializable{
    
    LOGIN,
    CREATE,
    ADD,
    UPDATE,
    DELETE,
    GET,
    GET_ONE, 
    CHECK
}
