package com.doodl6.springboot.client.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DubboDomain implements Serializable {

    private Long id;

    private String name;

}
