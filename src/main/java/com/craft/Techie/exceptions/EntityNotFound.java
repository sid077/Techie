package com.craft.Techie.exceptions;

public class EntityNotFound extends RuntimeException{
    public EntityNotFound(String entityName, String id){
        super("Entity "+entityName+" not found with id "+ id+".");

    }
}
