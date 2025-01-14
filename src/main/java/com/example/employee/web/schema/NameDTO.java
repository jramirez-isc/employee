package com.example.employee.web.schema;

import com.example.employee.domain.Name;

public class NameDTO {

    private final String first;
    private final String last;

    public NameDTO(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public static Name to(NameDTO nameDTO){
        return new Name(nameDTO.getFirst(), nameDTO.getLast());
    }

}
