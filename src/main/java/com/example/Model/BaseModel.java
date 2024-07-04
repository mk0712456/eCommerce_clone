package com.example.Model;

import lombok.Data;

import java.util.Date;
@Data
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
