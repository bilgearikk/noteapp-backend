package com.myapp.noteapp.payload;


import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

public class NotesDto {

    private Integer ID;
    private String title;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private UserDto userDto;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
