/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface Repository<T> {
    T create(T t);
    boolean update(T t);
    boolean add(T t);
    boolean delete(T t);
    List<T> getAll(T t);
    T getOne(T t);
}
