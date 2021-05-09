package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoListDTO {
    private Integer id;
    private String title;
    private boolean status;
}
