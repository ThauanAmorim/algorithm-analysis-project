package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_RESULT")
public class Result {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Long id;
    private String algorithmName;
    private String arrayType;
    private Integer lenght;
    private Integer run;
    private Long comparisonsNumber = 0l;
    private Long registerMovimentNumber = 0l;
    private Long time;

    public void addComparisonsNumber(long number) {
        this.comparisonsNumber += number;
    }

    public void addRegisterMovimentNumber(long number) {
        this.registerMovimentNumber += number;
    }
}
