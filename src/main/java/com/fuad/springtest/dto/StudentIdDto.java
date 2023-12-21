package com.fuad.springtest.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class StudentIdDto {
    private List<Long> students;
}
