/*******************************************************************************
 * COPYRIGHT (C) VITESCO TECHNOLOGIES
 * ALL RIGHTS RESERVED.
 *
 * The reproduction, transmission or use of this document or its
 * contents is not permitted without express written authority.
 * Offenders will be liable for damages. All rights, including rights
 * created by patent grant or registration of a utility model or design,
 * are reserved.
 *******************************************************************************/

#include "BSW/HAL/Proximity_Sensor/proximity_sensor.h"
#include "BSW/HAL/Com/com.h"
#include "esp_event.h"



void PROX_vRequest(void)
{
    GPIO_vSetLevel(HC_SR04_TRIGGER_PIN, LOW_LEVEL);
    ets_delay_us(2);
    GPIO_vSetLevel(HC_SR04_TRIGGER_PIN, HIGH_LEVEL);
    ets_delay_us(10);
    GPIO_vSetLevel(HC_SR04_TRIGGER_PIN, LOW_LEVEL);
}

int16_t PROX_u16Read()
{
    PROX_vRequest();
    uint8_t echo_start=0;
    uint8_t  echo_stop=0;
    uint8_t deltat=0;
    int16_t rezultat;
    while(GPIO_iGetLevel(HC_SR04_ECHO_PIN)==0){}
    
    echo_start = esp_timer_get_time();
    
    while(GPIO_iGetLevel(HC_SR04_ECHO_PIN)==1)

    echo_stop = esp_timer_get_time(); 

    deltat = (echo_stop - echo_start);

    rezultat = (deltat*0.0343)/2;
    
    printf("Distanta: %d   ",rezultat);

    return (int16_t)rezultat;
}