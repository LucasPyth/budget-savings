/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  LUCAS
 * Created: 4 de out. de 2023
 */

CREATE TABLE savings(
    id SERIAL PRIMARY KEY,
    month TEXT NOT NULL,
    economy INTEGER NOT NULL
);
