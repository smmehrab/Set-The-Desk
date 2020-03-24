/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.request;

import app.books.Book;

public class BookRequest extends RequestHandler {
    private Book book;
    
    public BookRequest(String userName, String type, Book book){
        super(userName, type);
        this.book=book;
    }
}
