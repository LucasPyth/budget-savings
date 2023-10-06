/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.budget.saving;

/**
 *
 * @author LUCAS
 */
public record SavingResponseDTO(Long id, String month, Integer economy, String image) {
    //record is statc data that will not have getters and setters
    public SavingResponseDTO (Saving saving){
        this(saving.getId(), saving.getMonth(), saving.getEconomy(), saving.getImage());
    }
}
    
