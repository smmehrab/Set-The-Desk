/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.request;

import  app.library.Library;

public class LibaryRequest extends RequestHandler{

    private Library library;
    
    public LibaryRequest(String username, String type, Library libary){
        super(username, type);
        this.library = libary;
    }

    public Library getLibary(){
        return this.library;
    }
}
