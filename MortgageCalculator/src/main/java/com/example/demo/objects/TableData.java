package com.example.demo.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableData {
private int year;
private int percentageInterest;
private int percentageCapital;
}
