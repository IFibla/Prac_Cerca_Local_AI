# Cerca Local - Q2 2021-2022

## Enunciat del projecte

<div style="text-align: justify"> 
Disposem d'un tauler de 50 x 50 km. En aquest tauler hi ha hagut un desastre natural. Existeixen C centres de rescat, els quals és troben en els limits del tauler. D'aquests centres sortiran els helicòpters, els quals hauran de rescatar a grups de persones. Tots els grups estan formats per un mínim d'1 persona i un màxim de 12, aquests grups mai es poden dividir. A més a més, depenent de si hi ha ferits o no, se'ls assigna un enter, el qual denota la prioritat 1 ( hi ha algun ferit ), 2 ( no hi ha cap ferit ). Per últim els helicòpter poden recollir com a màxim 15 persones i tenen una velocitat màxima de 100 km/h. Per últim, quan un helicòpter ha arribat a la zona de rescat, trigarà 1 minut a recollir una persona d'un grup de no ferits, o de prioritat 2, i 2 minuts en recollir una persona d'un grup de ferits, o de prioritat 1. 

El càlcul de la distancia recorreguda entre dos punts és realitza mitjançant la distància euclídea entre les seves coordenades.
> La distància euclidiana o mètrica euclidiana és la distància ordinària entre dos punts que es mesuraria amb un regle, i ve donada per la fórmula o teorema de Pitàgores
$$d(P, Q)=$\sqrt{(p_1-q_1)^2+(p_2-q_2)^2+...+(p_n-q_n)^2}$=$\sqrt{$\sum_{i=1}^{n}$(p_i-q_i)^2}$$
</div>

### Criteris de solució

<div style="text-align: justify">
Per obtenir i evaluar la solució utilitzarem els següents criteris i restriccions:

- Una solució ha de rescatar tots els grups
- Un helicopter haurà de rescatar els grups complerts
- En una sortida, un helicopter, no podrà rescatar més de 3 grups. 
- Les solucions hauran de minimitzar un dels següents criteris segons l'experiment:
    - Suma del temps de ús de cada helicopter en rescatar a tots els grups
    - Suma del temps de ús de cada helicopter en rescatar a tots els grups, però minimitzant el temps que es triga en recatar a tots els grups de prioritat 1.
</div>

### Session 3. Planificacion

> ¿Qué elementos intervienen en el problema?
Centros de rescate, helicopteros, personas,

<div style="text-align: justify">

</div>

## Links

[Documentació Desastres](/doc/Desastres/index.html)

[Enunciat](/misc/Enunciat.pdf)

[AIMA Source Files](/src/aima/)
